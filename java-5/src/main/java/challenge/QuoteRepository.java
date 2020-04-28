package challenge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    long count();

    // Page<Quote> findByActor(String actor, Pageable pageable);

    Page<Quote> findAll(Pageable pageable);

    // List<Quote> findAllByActor(String actor, Pageable pageable);

    List<Quote> findByActor(String actor);

}
