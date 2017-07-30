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

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "is_old")
    private boolean isOld;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public boolean isOld() {
        return isOld;
    }

    public void setOld(boolean old) {
        isOld = old;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propertytype_id", nullable = false)
    private PropertyType type;


    public ComputerProperty() {
        setOld(false);
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public PropertyType getPropertyType() {
        return type;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.type = propertyType;
    }


    @Override
    public int hashCode() {
        int cc = 17;
        int result = 37;

        result = cc * result + value.hashCode();
        result = cc * result + type.getName().hashCode();

        return result;
    }

    public boolean hasSameTypeAs(ComputerProperty computerProperty){
        return this.getPropertyType().getName().equals(computerProperty.getPropertyType().getName());
    }

    public boolean equals(ComputerProperty obj) {
        return this.hashCode() == obj.hashCode();
    }
}
