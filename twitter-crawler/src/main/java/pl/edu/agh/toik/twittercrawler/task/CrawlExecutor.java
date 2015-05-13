package pl.edu.agh.toik.twittercrawler.task;

import org.springframework.stereotype.Component;

@Component
public class CrawlExecutor {
	
    public void crawl() {
        new CrawlRunnable().run();
    }

}
