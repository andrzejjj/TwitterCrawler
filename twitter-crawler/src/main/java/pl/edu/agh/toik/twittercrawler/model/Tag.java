package pl.edu.agh.toik.twittercrawler.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findTagsByContentEquals" })
public class Tag {

    /**
     */
    @NotNull
    private String author;

    /**
     */
    @NotNull
    private String content;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private Set<Tweet> tweets = new HashSet<Tweet>();
}
