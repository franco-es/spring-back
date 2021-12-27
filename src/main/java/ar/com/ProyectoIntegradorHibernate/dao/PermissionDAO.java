package ar.com.ProyectoIntegradorHibernate.dao;

import ar.com.ProyectoIntegradorHibernate.data.Permission;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class PermissionDAO {

  @Autowired
  private SessionFactory factory;

  public Session session() {
    Session session = factory.getCurrentSession();
    if (session == null) {
      session = factory.openSession();
    }
    return session;
  }

  @Transactional
  public List<Permission> getByType(String type){



    /**
     * Selecciona los grupos que tienen X permiso
     */
//    Criteria c = session().createCriteria(Permission.class);
//    Criteria opC = c.createCriteria("operation");
//    opC.add(Restrictions.like("type", type));
//    Criteria gpC = c.createCriteria("group");
//    gpC.setProjection(Projections.property("groupId"));
//    c.setProjection(Projections.property("group.id"));
    Criteria c = session().createCriteria(Permission.class)
                  .setProjection(Projections.property("group.id"))
                  .createCriteria("operation")
                    .add(Restrictions.like("type", type));


    return c.list();
  }
}
