package allpccollector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pc_config_changes")
public class PcConfigChange {

    @Id
    @GeneratedValue
    Long id;

    Computer computer;
    String paramName;
    String from;
    String to;


}
