package spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Part;

@Repository
public class PartDAOImpl implements PartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPart(Part part) {
        sessionFactory.getCurrentSession().saveOrUpdate(part);
    }

    @SuppressWarnings("unchecked")
    public List<Part> getAllParts() {
        return sessionFactory.getCurrentSession().createQuery("from Part", Part.class).list();
    }

    @SuppressWarnings("unchecked")
    public List<Part> getNeededParts() {
        return sessionFactory.getCurrentSession().createQuery("from Part where mandatory = 1").list();
    }

    @SuppressWarnings("unchecked")
    public List<Part> getUnneededParts() {
        return sessionFactory.getCurrentSession().createQuery("from Part where mandatory = 0").list();
    }

    @Override
    public void deletePart(Integer id) {
        Part part = (Part) sessionFactory.getCurrentSession().load(Part.class, id);
        if (null != part) {
            this.sessionFactory.getCurrentSession().delete(part);
        }
    }

    public Part getPart(Integer id) {
        return (Part) sessionFactory.getCurrentSession().get(Part.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Part> getPartByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Part where part_name = :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    public Part updatePart(Part part) {
        sessionFactory.getCurrentSession().update(part);
        return part;
    }
}
