package pl.edu.agh.toik.twittercrawler.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import pl.edu.agh.toik.twittercrawler.model.Tweet;

@RooJpaRepository(domainType = Tweet.class)
public interface TweetRepository {
	@Query("select max(t.id_) from Tweet as t where t.email = :tag")
	long selectMaxId(@Param("tag") String email);
}
