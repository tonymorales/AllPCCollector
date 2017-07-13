package allpccollector.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "property_types")
public class PropertyType {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

//    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
//    private Set<ComputerParam> computerParam;

    public PropertyType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Set<ComputerParam> getComputerParam() {
//        return computerParam;
//    }
//
//    public void setComputerParam(Set<ComputerParam> computerParams) {
//        this.computerParam = computerParam;
//    }
}
