package ar.com.ProyectoIntegradorHibernate.service;

import ar.com.ProyectoIntegradorHibernate.dao.PermissionDAO;
import ar.com.ProyectoIntegradorHibernate.data.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImp implements IPermissionService{

    @Autowired
    PermissionDAO permissionDao;

    @Override
    public List<Permission> getByType(String type) {
        return permissionDao.getByType(type);
    }
}
