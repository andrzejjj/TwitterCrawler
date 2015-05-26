package pl.edu.agh.toik.twittercrawler.task;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.toik.twittercrawler.model.Tag;
import pl.edu.agh.toik.twittercrawler.model.Tweet;
import pl.edu.agh.toik.twittercrawler.repo.TagRepository;
import pl.edu.agh.toik.twittercrawler.service.TweetService;
import pl.edu.agh.toik.twittercrawler.twitter.TwitterUtil;

public class CrawlRunnable implements Runnable {

	@Autowired
	TweetService tweetService;
	
	@Autowired
	TagRepository tagRepository;
	
	private static final Logger LOGGER = Logger.getLogger(CrawlRunnable.class.getCanonicalName());
	
	@Override
	public void run() {
		for (Tag tag : tagRepository.findAll()){
			LOGGER.info("Crawling tag: " + tag);
			List<Tweet> results = TwitterUtil.searchTwitter(tag.getContent(), tweetService.findMaxTweetId(tag.getContent()));
			for (Tweet t : results){
				Set<Tag> tags = t.getTags();
				tags.add(tag);
				t.setTags(tags);
				tweetService.saveTweet(t);
			}
			LOGGER.info("Saved " + results.size() + " results.");
		}

	}

}
