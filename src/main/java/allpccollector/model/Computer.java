package allpccollector.model;



import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "computers")
public class Computer implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "computer_id")
    private long computerId;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "sku")
    private String sku;

    @Column(name = "cpuid", nullable = false)
    @NaturalId
    private String cpuId;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private Set<ComputerParam> computerParams;

    //private int computersIdUindex;

    //private int computersCpuIDUindex;

    //private int computersSkuUindex;

    public Computer() { //for JPA only
    }

    public long getComputerId() {
        return computerId;
    }

    public void setComputerId(long computerId) {
        this.computerId = computerId;
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

    public Set<ComputerParam> getComputerParams() {
        return computerParams;
    }

    public void setComputerParams(Set<ComputerParam> computerParams) {
        this.computerParams = computerParams;
    }
}
