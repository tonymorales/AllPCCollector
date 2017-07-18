package allpccollector.model;

import javax.persistence.*;

@Entity
@Table(name = "login_events")
public class LoginEvent {

    @Id
    @GeneratedValue
    @Column(name = "login_event_id")
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    DomainUser user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id")
    Computer computer;

    @Column(name = "datetime")
    String datetime;

    public LoginEvent(DomainUser user, Computer computer, String datetime) {
        this.user = user;
        this.computer = computer;
        this.datetime = datetime;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
