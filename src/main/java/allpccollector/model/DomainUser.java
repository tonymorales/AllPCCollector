package allpccollector.model;

import javax.persistence.*;
//import javax.persistence.OneToMany;

@Entity
public class DomainUser {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    public DomainUser() { //JPA only
    }

    public DomainUser(String name){
        this.username = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
