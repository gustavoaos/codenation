package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	// https://stackoverflow.com/questions/24279186/fetch-random-records-using-spring-data-jpa/25149491
	@Override
	public Quote getQuote() {
		int idx = this.generateRandomIdx(this.repository.count());

		Page<Quote> page = this.repository.findAll(PageRequest.of(idx, 1));
		Quote randomQuote = page.hasContent() ? page.getContent().get(0) : null;

		return randomQuote;
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		int idx = this.generateRandomIdx(this.repository.count(Example.of(new Quote(actor))));

		Page<Quote> page = this.repository.findByActor(actor, PageRequest.of(idx, 1));
		Quote randomQuote = page.hasContent() ? page.getContent().get(0) : null;

		return randomQuote;
	}

	private int generateRandomIdx(long upperLimit) {
		return (int) (Math.random() * upperLimit);
	}

}