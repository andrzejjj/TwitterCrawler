package pl.edu.agh.toik.twittercrawler.service;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { pl.edu.agh.toik.twittercrawler.model.Tweet.class })
public interface TweetService {
	public long findMaxTweetId(String tag);
}
