package ar.com.ProyectoIntegradorHibernate.dao;

import ar.com.ProyectoIntegradorHibernate.data.GroupAssignment;
import ar.com.ProyectoIntegradorHibernate.data.Operation;
import ar.com.ProyectoIntegradorHibernate.data.Permission;
import ar.com.ProyectoIntegradorHibernate.data.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GroupAssignmentDAO {

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
    public List<GroupAssignment> listAllGa(){
        return session().createCriteria(GroupAssignment.class).list();
    }

    @Transactional
    public List<GroupAssignment> listByType(String type){
        DetachedCriteria groupsId = DetachedCriteria.forClass(Permission.class)
                .setProjection(Projections.property("group.id"))
                .createCriteria("operation")
                .add(Restrictions.like("type", type));

        /**
         * query principal
         */
        Criteria c = session().createCriteria(GroupAssignment.class)
                .add(Subqueries.propertiesIn(new String[]{"group.id"}, groupsId));

      return c.list();
    }
}
