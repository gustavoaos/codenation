package challenge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "scripts")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private Integer episode;

	@NotBlank
	@Column(name = "episode_name", nullable = false)
	private String episodeName;

	@NotBlank
	private String segment;

	@NotBlank
	private String type;

	@NotBlank
	private String actor;

	@NotBlank
	private String character;

	@NotBlank
	@Column(name = "detail", nullable = false)
	private String quote;

	@NotNull
	@Column(name = "record_date", nullable = false)
	LocalDateTime recordDate;

	@NotBlank
	private String series;

	@NotNull
	@Column(name = "transmission_date", nullable = false)
	LocalDateTime transmissionDate;

	public Quote() {
	}

	public Quote(String actor) {
		this.actor = actor;
	}

	public Quote(Integer id, Integer episode, String episodeName, String segment, String type, String actor, String character, String quote, LocalDateTime recordDate, String series, LocalDateTime transmissionDate) {
		this.id = id;
		this.episode = episode;
		this.episodeName = episodeName;
		this.segment = segment;
		this.type = type;
		this.actor = actor;
		this.character = character;
		this.quote = quote;
		this.recordDate = recordDate;
		this.series = series;
		this.transmissionDate = transmissionDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEpisode() {
		return this.episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getEpisodeName() {
		return this.episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getQuote() {
		return this.quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public LocalDateTime getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}

	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public LocalDateTime getTransmissionDate() {
		return this.transmissionDate;
	}

	public void setTransmissionDate(LocalDateTime transmissionDate) {
		this.transmissionDate = transmissionDate;
	}

}
