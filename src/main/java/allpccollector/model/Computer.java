package allpccollector.model;



import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue

    private long id;

    private String name;
    private String ipAddress;
    private String macaddress;

    //private int domainUserid;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "username")
//    private DomainUser username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<LoginEvent> loginEvents;

    private String osVersion;
    private String cpu;

    private String cpuId; //This is motherboard id
    private String ram;
    private String gpu;
//    private String date;
//    private String motherBoard;

    public Computer() { //for JPA only
    }

    public Computer(String name, String ipAddress, String macaddress, String osVersion, String cpu, String cpuId, String ram, String gpu/*, String date, String motherBoard*/) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.macaddress = macaddress;
        this.osVersion = osVersion;
        this.cpu = cpu;
        this.cpuId = cpuId;
        this.ram = ram;
        this.gpu = gpu;
//        this.date = date;
//        this.motherBoard = motherBoard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

//    public DomainUser getUsername() {
//        return username;
//    }
//
//    public void setUsername(DomainUser username) {
//
//        this.username = username;
//    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuId() {
        return cpuId;
    }

    public void setCpuId(String cpuId) {
        this.cpuId = cpuId;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

//    public String getMotherBoard() {
//        return motherBoard;
//    }
//
//    public void setMotherBoard(String motherBoard) {
//        this.motherBoard = motherBoard;
//    }
}
