package challenge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    Page<Quote> findByActor(String actor, Pageable pageable);

    Page<Quote> findAll(Pageable pageable);

}
