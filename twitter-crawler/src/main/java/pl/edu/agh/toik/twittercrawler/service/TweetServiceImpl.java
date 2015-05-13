package pl.edu.agh.toik.twittercrawler.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import pl.edu.agh.toik.twittercrawler.model.Tweet;

public class TweetServiceImpl implements TweetService {
	
	@Override
	public long findMaxTweetId(String tag){
//		this.tweetRepository.
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Tweet> query = builder.createQuery(Tweet.class);
//		Root<Tweet> root = query.from(Tweet.class);
		return 0L;
	}
}
