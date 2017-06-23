package allpccollector.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PcInfoRequest {

    private String name;
    private String ipAddress;
    private String macaddress;
    private String username;
    private String osVersion;
    private String cpu;
    private String cpuId;
    private String ram;
    private String gpu;
    private String logonTime;
//    private String motherBoard;



    public PcInfoRequest(String name, String ipAddress, String macaddress, String username, String osVersion, String cpu, String cpuId, String ram, String gpu, String logonTime) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.macaddress = macaddress;
        this.username = username;
        this.osVersion = osVersion;
        this.cpu = cpu;
        this.cpuId = cpuId;
        this.ram = ram;
        this.gpu = gpu;
        this.logonTime = logonTime;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(String logonTime) {
        this.logonTime = logonTime;
    }
}

