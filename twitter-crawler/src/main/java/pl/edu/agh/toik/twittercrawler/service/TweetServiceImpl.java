package pl.edu.agh.toik.twittercrawler.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.toik.twittercrawler.repo.TweetRepository;

public class TweetServiceImpl implements TweetService {
	
	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public long findMaxTweetId(String tag){
		return tweetRepository.selectMaxId(tag);
	}
	
}
