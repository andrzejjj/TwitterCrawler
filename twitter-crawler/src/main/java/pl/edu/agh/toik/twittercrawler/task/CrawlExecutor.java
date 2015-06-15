package pl.edu.agh.toik.twittercrawler.task;

import org.springframework.stereotype.Component;

import pl.edu.agh.toik.twittercrawler.repo.TagRepository;
import pl.edu.agh.toik.twittercrawler.service.TweetService;

@Component
public class CrawlExecutor {

	private TweetService tweetService;

	private TagRepository tagRepository;

	public CrawlExecutor(TweetService tweetService, TagRepository tagRepository) {
		this.tweetService = tweetService;
		this.tagRepository = tagRepository;
	}

	public void crawl() {
		new CrawlRunnable(tweetService, tagRepository).run();
	}

}
