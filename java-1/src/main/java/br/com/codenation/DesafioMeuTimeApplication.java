package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private final List<Team> teams = new ArrayList<>();
	private final List<Player> players = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) throws IdentificadorUtilizadoException {
		if (this.teams.stream().filter(team -> team.getId().equals(id)).findAny().isPresent()) {
			throw new IdentificadorUtilizadoException();
		}

		Team newTeam = new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		teams.add(newTeam);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) throws TimeNaoEncontradoException, IdentificadorUtilizadoException {
		Team team = this.getTeamById(idTime);
		
		if (this.players.stream().filter(player -> player.getId().equals(id)).findAny().isPresent()) {
			throw new IdentificadorUtilizadoException();
		}

		Player newPlayer = new Player(id, team.getId(), nome, dataNascimento, nivelHabilidade, salario);
		players.add(newPlayer);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) throws JogadorNaoEncontradoException {
		Player newCaptain = this.getPlayerById(idJogador);

		// Search on the player's team if there war a previous captain
		// If so, set him to a regular player
		this.players.stream()
			.filter(player -> player.getTeamId().equals(newCaptain.getTeamId()) && player.getIsCaptain().equals(true))
			.findAny()
			.ifPresent(player -> player.setIsCaptain(false));

		// Set new captain
		newCaptain.setIsCaptain(true);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) throws TimeNaoEncontradoException, CapitaoNaoInformadoException {
		Team team = this.getTeamById(idTime);

		Optional<Player> playerRes = this.players.stream()
			.filter(player -> player.getTeamId().equals(team.getId()) && player.getIsCaptain().equals(true))
			.findAny();

		if (!playerRes.isPresent()) {
			throw new CapitaoNaoInformadoException();
		}

		return playerRes.get().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) throws JogadorNaoEncontradoException {
		Player player = this.getPlayerById(idJogador);

		return player.getName();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) throws TimeNaoEncontradoException {
		Team team = this.getTeamById(idTime);

		return team.getName();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) throws TimeNaoEncontradoException {
		Team team = this.getTeamById(idTime);

		return this.players.stream()
			.filter(player -> player.getTeamId().equals(team.getId()))
			.sorted(Comparator.comparing(Player::getId))
			.map(Player::getId)
			.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) throws TimeNaoEncontradoException {
		Team team = this.getTeamById(idTime);

		return this.players.stream()
			.filter(player -> player.getTeamId().equals(team.getId()))
			.max(Comparator.comparing(Player::getAbilityLevel))
			.get()
			.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) throws TimeNaoEncontradoException {
		Team team = this.getTeamById(idTime);

		return this.players.stream()
			.filter(player -> player.getTeamId().equals(team.getId()))
			.min(Comparator.comparing(Player::getBirthdate))
			.get()
			.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return this.teams.stream()
			.sorted(Comparator.comparing(Team::getId))
			.map(Team::getId)
			.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) throws TimeNaoEncontradoException {
		Team team = this.getTeamById(idTime);

		return this.players.stream()
			.filter(player -> player.getTeamId().equals(team.getId()))
			.max(Comparator.comparing(Player::getSalary))
			.get()
			.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) throws JogadorNaoEncontradoException {
		Player player = this.getPlayerById(idJogador);

		return player.getSalary();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		Comparator<Player> comparingPlayers = Comparator.comparing(Player::getAbilityLevel).reversed()
														.thenComparing(Player::getId);

		return this.players.stream()
			.sorted(comparingPlayers)
			.limit(top)
			.map(Player::getId)
			.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) throws TimeNaoEncontradoException {
		Team homeTeam = this.getTeamById(timeDaCasa);
		Team awayTeam = this.getTeamById(timeDeFora);

		return homeTeam.getMainUniformColor().equals(awayTeam.getMainUniformColor()) ?
			awayTeam.getSecondaryUniformColor() : awayTeam.getMainUniformColor();
	}

	private Team getTeamById(Long teamId) throws TimeNaoEncontradoException {
		Optional<Team> result = this.teams.stream()
			.filter(team -> team.getId().equals(teamId))
			.findAny();

		if (result.isPresent() == false) {
			throw new TimeNaoEncontradoException();
		}

		return result.get();
	}

	private Player getPlayerById(Long playerId) throws JogadorNaoEncontradoException {
		Optional<Player> result = this.players.stream()
			.filter(player -> player.getId().equals(playerId))
			.findAny();

		if (result.isPresent() == false) {
			throw new JogadorNaoEncontradoException();
		}

		return result.get();
	}

}
