package pl.edu.agh.toik.twittercrawler.web;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	private Date dateSince;
	private boolean showZeroes = false;
	private String newTag = null;
	//private List<Tag> tags;
	
    public String getNewTag() {
		return newTag;
	}

	public void setNewTag(String newTag) {
		this.newTag = newTag;
	}

	public List<Tag> getTags() {
		return tagRepository.findAll();
	}

	public boolean isShowZeroes() {
		return showZeroes;
	}

	public void setShowZeroes(boolean showZeroes) {
		this.showZeroes = showZeroes;
	}

	public Date getDateSince() {
		return dateSince;
	}

	public void setDateSince(Date dateSince) {
		this.dateSince = dateSince;
	}

	@PostConstruct
    public void init() {
        //createPieModel();
    }

    public LineChartModel getLineChartModel() {
    	//if (lineChartModel == null ){
    		initLineChart();
    	//}
    	return lineChartModel;
	}

	private void initLineChart() {
    	LineChartModel model = new LineChartModel();
   	 
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Pobrane tweety");
        int i =0;
        for (Stats stats : dateSince == null ? Stats.findAllStatses() : Stats.findStatsesByCreationDateGreaterThanEquals(dateSince).getResultList()){
        	int records = stats.getRecordsInserted();
        	if (records > 0 || (records == 0 && showZeroes)){
        		series.set(i++, records);
        	}
        }
        model.setAnimate(true);
        model.setLegendPosition("se");
        model.addSeries(series);
        this.lineChartModel = model;
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
	
	@Transactional
	public void insert(){
		Tag tg = new Tag();
		tg.setAuthor("User");
		tg.setContent(newTag);
		tagRepository.saveAndFlush(tg);
		addMessage(tg, " created.");
	}
	
	public void delete(Tag tag){
		try{
			tagRepository.delete(tag);
			addMessage(tag, " removed.");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private void addMessage(Tag tag, String additional) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tag " + tag.getContent() + additional,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
