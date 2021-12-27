package ar.com.ProyectoIntegradorHibernate.service;

import ar.com.ProyectoIntegradorHibernate.data.User;

import java.util.List;

public interface IUserService {

    public List<User> ListAllUsers();

    public User addUser(User user);
}
