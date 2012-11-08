package birdsquare.helper;

import birdsquare.model.Bird;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BirdSquareSession {

    private Session session = null;

    public BirdSquareSession() {
        initSession();
    }

    public Object get(Class clazz, long id) {
        return session.get(clazz, id);
    }

    public List getAll(Class clazz) {
        return session.createCriteria(clazz).list();
    }

    public void save(Object object) {
        startTransaction();
        session.save(object);
        commit();
    }

    public void saveOrUpdate(Object object) {
        startTransaction();
        session.saveOrUpdate(object);
        commit();
    }

    public void delete(Object object) {
        startTransaction();
        session.delete(object);
        commit();
    }

    public void close() {
        session.close();
        session = null;
    }

    private void startTransaction() {
        if (session == null)
            initSession();
        session.beginTransaction();
    }

    private void commit() {
        session.getTransaction().commit();
    }

    private void initSession() {
        this.session = BirdSquareSessionFactory.getInstance().createSession();
    }
}
