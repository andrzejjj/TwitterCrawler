// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.edu.agh.toik.twittercrawler.model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import pl.edu.agh.toik.twittercrawler.model.Tag;

privileged aspect Tag_Roo_Finder {
    
    public static Long Tag.countFindTagsByContentEquals(String content) {
        if (content == null || content.length() == 0) throw new IllegalArgumentException("The content argument is required");
        EntityManager em = Tag.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Tag AS o WHERE o.content = :content", Long.class);
        q.setParameter("content", content);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<Tag> Tag.findTagsByContentEquals(String content) {
        if (content == null || content.length() == 0) throw new IllegalArgumentException("The content argument is required");
        EntityManager em = Tag.entityManager();
        TypedQuery<Tag> q = em.createQuery("SELECT o FROM Tag AS o WHERE o.content = :content", Tag.class);
        q.setParameter("content", content);
        return q;
    }
    
    public static TypedQuery<Tag> Tag.findTagsByContentEquals(String content, String sortFieldName, String sortOrder) {
        if (content == null || content.length() == 0) throw new IllegalArgumentException("The content argument is required");
        EntityManager em = Tag.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM Tag AS o WHERE o.content = :content");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<Tag> q = em.createQuery(queryBuilder.toString(), Tag.class);
        q.setParameter("content", content);
        return q;
    }
    
}
