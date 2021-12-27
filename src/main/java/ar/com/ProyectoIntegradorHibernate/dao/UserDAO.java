package ar.com.ProyectoIntegradorHibernate.dao;

import ar.com.ProyectoIntegradorHibernate.data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory factory;

    public Session session() {
        Session session = factory.getCurrentSession();
        if(session == null) {
            session = factory.openSession();
        }
        return session;
    }

    @Transactional
    public List<User> listAllUsers(){
        return session().createCriteria(User.class).list();
    }

    @Transactional
    public User addUser(User user) {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        user.setDefaultGroupId(1);
        user.setLastLogin(formattedDate);
        session().persist(user);
        return user;
    }




}
