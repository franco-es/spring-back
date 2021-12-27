package ar.com.ProyectoIntegradorHibernate.service;

import ar.com.ProyectoIntegradorHibernate.data.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> getByType(String type);
}
