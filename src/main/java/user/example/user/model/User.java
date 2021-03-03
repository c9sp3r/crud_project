package user.example.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class User {

    @Id
    private String id;
    @Indexed(unique=true,name = "meta_url_index_unique")
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(){}


}
