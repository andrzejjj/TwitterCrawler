package pl.edu.agh.toik.twittercrawler.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import pl.edu.agh.toik.twittercrawler.model.Tweet;
import pl.edu.agh.toik.twittercrawler.repo.TweetRepository;

public class TweetServiceImpl implements TweetService {
	
	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public long findMaxTweetId(String tag){
		tweetRepository.findOne(findMaxId());
		return 0L;
	}
	
	public static Specification<Tweet> findMaxId(){
		  return new Specification<Tweet>() {
		    @Override
		    public Predicate toPredicate(Root<Tweet> root, CriteriaQuery<?> query, CriteriaBuilder builder){
		      Expression<Number> maxExpression = builder.max(root.get("id"));
		    	return null;
		    }
		  };
		}
}
