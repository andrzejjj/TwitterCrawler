// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.edu.agh.toik.twittercrawler.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.toik.twittercrawler.model.Tag;
import pl.edu.agh.toik.twittercrawler.repo.TagRepository;

privileged aspect TagConverter_Roo_Converter {
    
    declare @type: TagConverter: @FacesConverter("pl.edu.agh.toik.twittercrawler.web.converter.TagConverter");
    
    @Autowired
    TagRepository TagConverter.tagRepository;
    
    public Object TagConverter.getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        Long id = Long.parseLong(value);
        return tagRepository.findOne(id);
    }
    
    public String TagConverter.getAsString(FacesContext context, UIComponent component, Object value) {
        return value instanceof Tag ? ((Tag) value).getId().toString() : "";
    }
    
}