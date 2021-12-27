package ar.com.ProyectoIntegradorHibernate.service;

import ar.com.ProyectoIntegradorHibernate.data.GroupAssignment;

import java.util.List;

public interface IGroupAssignmentService {

    public List<GroupAssignment> getAllGa();
    public List<GroupAssignment> getByType(String type);
}
