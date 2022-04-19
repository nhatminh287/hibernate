package dao;

import hibernate.SinhvienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class StudentDAO {
    public static List<SinhvienEntity> gatAllStudent() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhvienEntity> students = null;

        try {
            final String hql = "select st from SinhvienEntity st";
            Query query = session.createQuery(hql);

            students = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return students;
    }
}
