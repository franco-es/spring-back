package ar.com.ProyectoIntegradorHibernate.service;

import ar.com.ProyectoIntegradorHibernate.dao.GroupAssignmentDAO;
import ar.com.ProyectoIntegradorHibernate.data.GroupAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupAssignmentService implements IGroupAssignmentService{

    @Autowired
    GroupAssignmentDAO gaD;

    @Override
    public List<GroupAssignment> getByType(String type) {
        return gaD.listByType(type);
    }

    @Override
    public List<GroupAssignment> getAllGa() {
        return null;
    }
}
