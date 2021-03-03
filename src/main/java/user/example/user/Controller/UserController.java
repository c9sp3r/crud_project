package user.example.user.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import user.example.user.dao.UserDAO;
import user.example.user.dto.UserDTO;
import user.example.user.model.User;
import user.example.user.service.Service;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    Service service;

    @PostMapping("/create/{name}/{password}")
    public void  create(@PathVariable String name, @PathVariable String password) {
        try {
            service.create_user(name,password);

            System.out.println("user has been saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/read")
    public List<User> read() {
        return service.findAll();
    }

    @GetMapping("/read/{name}")
    public User read(@PathVariable String name) throws Exception {
        User de = service.get_user(name);
        if (de != null)
            return de;
        else
            return null;
    }

    @PutMapping("/update")
    @Transactional
    public void update(@RequestBody UserDTO user) throws Exception {
        service.update_user(user.getName(),user.getPassword());
        System.out.println(user.getName() + " has been successfully updated");
    }

    @DeleteMapping("/delete/{name}")
    @Transactional
    public String delete(@PathVariable String name) throws Exception {
        User de = service.get_user(name);
        if (de != null) {

            service.remove_user(name);
            return " deleted with name " + name;
        } else {
            throw new RuntimeException("user not found for name " + name);
        }
    }
}