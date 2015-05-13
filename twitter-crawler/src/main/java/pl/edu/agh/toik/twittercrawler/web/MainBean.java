package pl.edu.agh.toik.twittercrawler.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.web.client.RestTemplate;

import pl.edu.agh.toik.twittercrawler.model.Tweet;

@ManagedBean
@SessionScoped
public class MainBean {
	@Value( "${spring.social.twitter.appId}")
	private String appId;
	@Value( "${spring.social.twitter.appSecret}")
	private String appSecret;
	
	private String appToken = fetchApplicationAccessToken(appId, appSecret);
	
	//private int korwinEntries = 0;
	
    public int getKukizEntries() {
    	return searchTwitter("#kukiz", appToken).size();
	}
	
    public int getDudaEntries() {
    	return searchTwitter("#duda", appToken).size();
	}
	
    public int getKomorowskiEntries() {
    	return searchTwitter("#komorowski", appToken).size();
	}
	
    public int getKorwinEntries() {
    	return searchTwitter("#korwin", appToken).size();
	}

	private static List<Tweet> searchTwitter(String query, String appToken) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + appToken);
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        Map<String, ?> result = rest.exchange("https://api.twitter.com/1.1/search/tweets.json?q={query}", HttpMethod.GET, requestEntity, Map.class, query).getBody();
        List<Map<String, ?>> statuses = (List<Map<String, ?>>) result.get("statuses");
        List<Tweet> tweets = new ArrayList<Tweet>();
        for (Map<String, ?> status : statuses) {
            tweets.add(new Tweet(Long.valueOf(status.get("id").toString()), status.get("text").toString()));
        }
        return tweets;
    }
    
    private static String fetchApplicationAccessToken(String appId, String appSecret) {
        OAuth2Operations oauth = new OAuth2Template("jM5EyDCegfTAMk38I1ea9UkMx", "oQp9kkxIZDw0BXFis2rxtu20Bqc1NRERpp3JirMHX4jPf90n3E", "", "https://api.twitter.com/oauth2/token");
        return oauth.authenticateClient().getAccessToken();
    }

}
