package pl.edu.agh.toik.twittercrawler.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.menu.MenuModel;
import org.springframework.roo.addon.jsf.application.RooJsfApplicationBean;

@ManagedBean
@RequestScoped
@RooJsfApplicationBean
public class ApplicationBean {

    public String getColumnName(String column) {
        if (column == null || column.length() == 0) {
            return column;
        }
        final Pattern p = Pattern.compile("[A-Z][^A-Z]*");
        final Matcher m = p.matcher(Character.toUpperCase(column.charAt(0)) + column.substring(1));
        final StringBuilder builder = new StringBuilder();
        while (m.find()) {
            builder.append(m.group()).append(" ");
        }
        return builder.toString().trim();
    }

	private MenuModel menuModel;

	@PostConstruct
    public void init() {
        //FacesContext facesContext = FacesContext.getCurrentInstance();
        //Application application = facesContext.getApplication();
       // ExpressionFactory expressionFactory = application.getExpressionFactory();
      //  ELContext elContext = facesContext.getELContext();
        
    }

	public MenuModel getMenuModel() {
        return menuModel;
    }

	public String getAppName() {
        return "Twitter-crawler";
    }
}