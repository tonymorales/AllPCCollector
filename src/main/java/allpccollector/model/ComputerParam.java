package allpccollector.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "computer_params")
public class ComputerParam implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "computer_params_id")
    private Long computerParamsId;

    @Column(name = "computer_params_name")
    private String computerParamsName;

    @Column(name = "computer_params_title")
    private String computerParamsTitle;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "paramtype_id", nullable = false)
    private ParamType type;


    public ComputerParam() {
    }

    public Long getComputerParamsId() {
        return computerParamsId;
    }

    public void setComputerParamsId(Long computerParamsId) {
        this.computerParamsId = computerParamsId;
    }

    public String getComputerParamsName() {
        return computerParamsName;
    }

    public void setComputerParamsName(String computerParamsName) {
        this.computerParamsName = computerParamsName;
    }

    public String getComputerParamsTitle() {
        return computerParamsTitle;
    }

    public void setComputerParamsTitle(String computerParamsTitle) {
        this.computerParamsTitle = computerParamsTitle;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public ParamType getParamType() {
        return type;
    }

    public void setParamType(ParamType paramType) {
        this.type = paramType;
    }

    @Entity
    @Table(name = "param_types")
    public static class ParamType {


        @Id
        @GeneratedValue
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "title")
        private String title;

        @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
        private Set<ComputerParam> computerParam;

        public ParamType() {
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

        public Set<ComputerParam> getComputerParam() {
            return computerParam;
        }

        public void setComputerParam(Set<ComputerParam> computerParams) {
            this.computerParam = computerParam;
        }
    }
}
