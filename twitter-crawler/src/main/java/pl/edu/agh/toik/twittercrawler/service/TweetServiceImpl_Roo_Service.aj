// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.edu.agh.toik.twittercrawler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.toik.twittercrawler.model.Tweet;
import pl.edu.agh.toik.twittercrawler.repo.TweetRepository;
import pl.edu.agh.toik.twittercrawler.service.TweetServiceImpl;

privileged aspect TweetServiceImpl_Roo_Service {
    
    declare @type: TweetServiceImpl: @Service;
    
    declare @type: TweetServiceImpl: @Transactional;
    
    @Autowired
    TweetRepository TweetServiceImpl.tweetRepository;
    
    public long TweetServiceImpl.countAllTweets() {
        return tweetRepository.count();
    }
    
    public void TweetServiceImpl.deleteTweet(Tweet tweet) {
        tweetRepository.delete(tweet);
    }
    
    public Tweet TweetServiceImpl.findTweet(Long id) {
        return tweetRepository.findOne(id);
    }
    
    public List<Tweet> TweetServiceImpl.findAllTweets() {
        return tweetRepository.findAll();
    }
    
    public List<Tweet> TweetServiceImpl.findTweetEntries(int firstResult, int maxResults) {
        return tweetRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void TweetServiceImpl.saveTweet(Tweet tweet) {
        tweetRepository.save(tweet);
    }
    
    public Tweet TweetServiceImpl.updateTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
    
}
