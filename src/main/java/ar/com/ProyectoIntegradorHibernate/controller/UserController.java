package ar.com.ProyectoIntegradorHibernate.controller;

import ar.com.ProyectoIntegradorHibernate.data.GroupAssignment;
import ar.com.ProyectoIntegradorHibernate.data.Permission;
import ar.com.ProyectoIntegradorHibernate.data.User;
import ar.com.ProyectoIntegradorHibernate.service.IGroupAssignmentService;
import ar.com.ProyectoIntegradorHibernate.service.IPermissionService;
import ar.com.ProyectoIntegradorHibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    IGroupAssignmentService gaService;
    @Autowired
    IPermissionService permissionService;

    @CrossOrigin("http://localhost:1841/")
    @GetMapping(value = "/")
    public List<User> listAllUsers(){
        return userService.ListAllUsers();
    }

    @CrossOrigin("http://localhost:1841/")
    @GetMapping(value = "/allGa")
    public List<GroupAssignment> listAllGa(@RequestParam String type){
        return gaService.getByType(type);
    }

    @GetMapping(value = "/permission")
    public List<Permission> listByType(@RequestParam String type){
        return permissionService.getByType(type);
    }

    @PostMapping(value = "/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    };
}
