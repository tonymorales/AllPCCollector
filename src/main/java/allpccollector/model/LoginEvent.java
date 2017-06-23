package allpccollector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "login_events")
public class LoginEvent {

    @Id
    @GeneratedValue
    Long id;

    DomainUser user;
    Calendar time;
}
