package allpccollector.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
//import javax.persistence.OneToMany;

@Entity
public class DomainUser {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_event_id")
    private List<LoginEvent> loginEvents;

    public DomainUser() { //JPA only
    }

    public DomainUser(String name){
        this.username = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
