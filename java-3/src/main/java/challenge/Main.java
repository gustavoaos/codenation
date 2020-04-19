package challenge;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

	private final String resourceFileName = "data.csv";
	List<SoccerPlayer> soccerPlayers = this.getSoccerPlayersList(this.getFileFromResources(resourceFileName));

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return 0;
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return 0;
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return null;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return null;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}

	// get file from classpath, resources folder
    private File getFileFromResources(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);

        return new File(resource.getFile());
	}

	// Get List from file
	private List<SoccerPlayer> getSoccerPlayersList(File file) {
		List<SoccerPlayer> soccerPlayers = Collections.emptyList();

		try {
			HeaderColumnNameMappingStrategy<SoccerPlayer> strategy = new HeaderColumnNameMappingStrategy<>();
			strategy.setType(SoccerPlayer.class);
			
			CSVReader reader = new CSVReader(new FileReader(file));
			CsvToBean<SoccerPlayer> csvToBean = new CsvToBeanBuilder<SoccerPlayer>(reader)
					.withType(SoccerPlayer.class)
					.withMappingStrategy(strategy)
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			soccerPlayers = csvToBean.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return soccerPlayers;
	}

}
