package pl.edu.agh.toik.twittercrawler.web;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

import pl.edu.agh.toik.twittercrawler.model.Tag;

@RooSerializable
@RooJsfManagedBean(entity = Tag.class, beanName = "entryBean")
public class EntryBean {
}
