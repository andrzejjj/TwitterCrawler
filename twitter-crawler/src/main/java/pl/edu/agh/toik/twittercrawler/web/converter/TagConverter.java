package pl.edu.agh.toik.twittercrawler.web.converter;
import javax.faces.convert.Converter;

import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

import pl.edu.agh.toik.twittercrawler.model.Tag;

@RooJsfConverter(entity = Tag.class)
public class TagConverter implements Converter {
}
