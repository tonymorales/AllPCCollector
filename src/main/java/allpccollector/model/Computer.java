package allpccollector.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "computers")
public class Computer implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "sku")
    private String sku;

    @Column(name = "cpuid", nullable = false)
    @NaturalId
    private String cpuId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private Set<ComputerProperty> computerProperties;

    @JsonIgnore
    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private Set<LoginEvent> loginEvents;

    public Computer() { //for JPA only
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCpuId() {
        return cpuId;
    }

    public void setCpuId(String cpuId) {
        this.cpuId = cpuId;
    }

    public Set<ComputerProperty> getComputerProperties() {
        return computerProperties;
    }

    public void setComputerProperties(Set<ComputerProperty> computerProperties) {
        this.computerProperties = computerProperties;
    }
}
