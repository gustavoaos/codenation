package challenge;

public class QuoteDTO {

    private int id;
    private String quote;
    private String actor;

    public QuoteDTO() {
    }

    public QuoteDTO(int id, String quote, String actor) {
        this.id = id;
        this.quote = quote;
        this.actor = actor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getActor() {
        return this.actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

}