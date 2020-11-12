package pl.system.Task.DaoImpl;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.system.Task.Dao.UsersDao;
import pl.system.Task.Entity.Users;
import pl.system.Task.Utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class UsersDaoImpl implements UsersDao {

    @Override
    public void save(Users users) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(users);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Users findById(Integer id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        Users users = null;
        try {
            users = (Users) session
                    .createQuery("from Users where Users.id=: id")
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException e) {}

        return users;
    }

    @Override
    public Users findByName(String name) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        Users users = null;
        try {
            users = (Users) session
                    .createQuery("from Users where name=:name")
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (NoResultException e) {}

        return users;
    }

    @Override
    public Users findBySurname(String surname) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        Users users = null;
        try {
            users = (Users) session
                    .createQuery("from Users where surname=:surname")
                    .setParameter("surname", surname)
                    .getSingleResult();
        }catch (NoResultException e) {}

        return users;
    }

    @Override
    public Users findByLogin(String login) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        Users users = null;
        try {
            users = (Users) session
                    .createQuery("from Users where login=:login")
                    .setParameter("login", login)
                    .getSingleResult();
        }catch (NoResultException e) {}

        return users;
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<User> list = session
                .createQuery("from Users")
                .list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete Users where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
