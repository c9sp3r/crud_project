package user.example.user.service;



import org.springframework.beans.factory.annotation.Autowired;
import user.example.user.dao.UserDAO;
import user.example.user.model.User;

import javax.swing.*;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserDAO mongo;
    public void create_user(String name, String password)throws Exception {
    if(mongo.findByName(name)==null)
        mongo.save(new User(name,password));
    }

    public User get_user(String name)throws Exception {
        return (mongo.findByName(name));
    }

    public void remove_user(String name)throws Exception {
        User s = mongo.findByName(name);
        if(s !=null){
            mongo.deleteById(s.getId());
        }
    }

    public void update_user (String name, String password)throws Exception {
        User s = mongo.findByName(name);
        if(s !=null){

            mongo.save(new User (s.getId(),name,password));
        }
    }


    public List<User> findAll(){
        return(mongo.findAll());
    }




}