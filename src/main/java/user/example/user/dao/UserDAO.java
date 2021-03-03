package user.example.user.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import user.example.user.model.User;

import java.util.List;

@Repository
public interface UserDAO extends MongoRepository<User, String> {
    public User findByName(String name);
    public List<User> findAll();


}