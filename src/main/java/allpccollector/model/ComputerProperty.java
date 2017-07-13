package allpccollector.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "computer_property")
public class ComputerProperty implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "computer_property_id")
    private Long computerPropertyId;

    @Column(name = "computer_property_value")
    private String value;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
   // @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "propertytype_id", nullable = false)
    private PropertyType type;


    public ComputerProperty() {
    }

    public Long getComputerPropertyId() {
        return computerPropertyId;
    }

    public void setComputerPropertyId(Long computerPropertyId) {
        this.computerPropertyId = computerPropertyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
//
//    public String getComputerParamsTitle() {
//        return computerParamsTitle;
//    }
//
//    public void setComputerParamsTitle(String computerParamsTitle) {
//        this.computerParamsTitle = computerParamsTitle;
//    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public PropertyType getParamType() {
        return type;
    }

    public void setParamType(PropertyType propertyType) {
        this.type = propertyType;
    }

}
