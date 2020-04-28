package challenge;

import java.util.Optional;

public interface QuoteService {

	Optional<Quote> getQuote();
	
	Optional<Quote> getQuoteByActor(String actor);

}
