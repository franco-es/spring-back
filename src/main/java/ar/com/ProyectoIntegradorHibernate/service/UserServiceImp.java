package ar.com.ProyectoIntegradorHibernate.service;

import ar.com.ProyectoIntegradorHibernate.dao.UserDAO;
import ar.com.ProyectoIntegradorHibernate.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    UserDAO userD;

    @Override
    public List<User> ListAllUsers() {
        return userD.listAllUsers();
    }

    @Override
    public User addUser(User user){
        return userD.addUser(user);
    }
}
