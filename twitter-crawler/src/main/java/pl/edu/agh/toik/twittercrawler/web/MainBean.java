package pl.edu.agh.toik.twittercrawler.web;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.toik.twittercrawler.model.Stats;
import pl.edu.agh.toik.twittercrawler.model.Tag;
import pl.edu.agh.toik.twittercrawler.repo.TagRepository;

@ManagedBean
@SessionScoped
public class MainBean {
	public MainBean(TagRepository tagRepository){
		this.tagRepository = tagRepository;
	}
	
	TagRepository tagRepository;

	private PieChartModel pieModel;
	private LineChartModel lineChartModel;
	
    @PostConstruct
    public void init() {
        //createPieModel();
    }

    public LineChartModel getLineChartModel() {
    	if (lineChartModel == null ){
    		initLineChart();
    	}
    	return lineChartModel;
	}

	private void initLineChart() {
    	LineChartModel model = new LineChartModel();
   	 
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Pobrane tweety");
        for (Stats stats : Stats.findAllStatses()){
        	series.set(stats.getCreationDate(), stats.getRecordsInserted());
        }
        series.set(new Date(), 123);
        series.set(new Date(), 100);
        //model.setAnimate(true);
        model.setLegendPosition("se");
        model.addSeries(series);
        lineChartModel = model;
	}

	@Transactional
	public PieChartModel getPieModel() {
		pieModel = new PieChartModel();
		pieModel.setTitle("Rozklad tweetow");
		pieModel.setLegendPosition("w");
		pieModel.setShowDataLabels(true);
		for (Tag tag : tagRepository.findAll()){
			pieModel.set(tag.getContent(), tag.getTweets().size());
		}
		return pieModel;
	}

}
