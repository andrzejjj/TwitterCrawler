package pl.edu.agh.toik.twittercrawler.task;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.toik.twittercrawler.model.Stats;
import pl.edu.agh.toik.twittercrawler.model.Tag;
import pl.edu.agh.toik.twittercrawler.model.Tweet;
import pl.edu.agh.toik.twittercrawler.repo.TagRepository;
import pl.edu.agh.toik.twittercrawler.service.TweetService;
import pl.edu.agh.toik.twittercrawler.twitter.TwitterUtil;

public class CrawlRunnable implements Runnable {

	private TweetService tweetService;
	
	private TagRepository tagRepository;
	
	public CrawlRunnable(TweetService tweetService, TagRepository tagRepository) {
		this.tweetService = tweetService;
		this.tagRepository = tagRepository;
	}

	private static final Logger LOGGER = Logger.getLogger(CrawlRunnable.class.getCanonicalName());
	
	@Override
	@Transactional
	public void run() {
		int totalInserted = 0;
		for (Tag tag : tagRepository.findAll()){
			LOGGER.info("Crawling tag: " + tag);
			List<Tweet> results = TwitterUtil.searchTwitter(tag.getContent(), tweetService.findMaxTweetId(tag.getContent()));
			for (Tweet t : results){
				Set<Tag> tags = t.getTags();
				tags.add(tag);
				t.setTags(tags);
				tweetService.saveTweet(t);
			}
			totalInserted += results.size();
		}
		Stats stats = new Stats();
		stats.setCreationDate(new Date());
		stats.setRecordsInserted(totalInserted);
		stats.persist();
	}

	public void setTweetService(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

}
