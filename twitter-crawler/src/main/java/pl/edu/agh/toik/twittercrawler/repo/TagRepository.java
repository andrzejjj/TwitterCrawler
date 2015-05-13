package pl.edu.agh.toik.twittercrawler.repo;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import pl.edu.agh.toik.twittercrawler.model.Tag;

@RooJpaRepository(domainType = Tag.class)
public interface TagRepository {
}
