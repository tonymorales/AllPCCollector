package allpccollector.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "login_events")
public class LoginEvent {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    DomainUser user;

    @OneToOne
    @PrimaryKeyJoinColumn
    Computer computer;


    String time;

    public LoginEvent(DomainUser user, Computer computer, String time) {
        this.user = user;
        this.computer = computer;
        this.time = time;
    }


    public LoginEvent() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public DomainUser getUser() {
        return user;
    }

    public void setUser(DomainUser user) {
        this.user = user;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
