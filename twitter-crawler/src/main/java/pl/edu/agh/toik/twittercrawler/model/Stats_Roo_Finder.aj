// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.edu.agh.toik.twittercrawler.model;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import pl.edu.agh.toik.twittercrawler.model.Stats;

privileged aspect Stats_Roo_Finder {
    
    public static Long Stats.countFindStatsesByCreationDateGreaterThanEquals(Date creationDate) {
        if (creationDate == null) throw new IllegalArgumentException("The creationDate argument is required");
        EntityManager em = Stats.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Stats AS o WHERE o.creationDate >= :creationDate", Long.class);
        q.setParameter("creationDate", creationDate);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<Stats> Stats.findStatsesByCreationDateGreaterThanEquals(Date creationDate) {
        if (creationDate == null) throw new IllegalArgumentException("The creationDate argument is required");
        EntityManager em = Stats.entityManager();
        TypedQuery<Stats> q = em.createQuery("SELECT o FROM Stats AS o WHERE o.creationDate >= :creationDate", Stats.class);
        q.setParameter("creationDate", creationDate);
        return q;
    }
    
    public static TypedQuery<Stats> Stats.findStatsesByCreationDateGreaterThanEquals(Date creationDate, String sortFieldName, String sortOrder) {
        if (creationDate == null) throw new IllegalArgumentException("The creationDate argument is required");
        EntityManager em = Stats.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM Stats AS o WHERE o.creationDate >= :creationDate");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<Stats> q = em.createQuery(queryBuilder.toString(), Stats.class);
        q.setParameter("creationDate", creationDate);
        return q;
    }
    
}