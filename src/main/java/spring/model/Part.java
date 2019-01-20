package spring.model;

import org.hibernate.annotations.Type;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 */

@Entity
@Table(name="part")
public class Part {

    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "part_name")
    private String partName;
    @Column
    private Boolean mandatory;
    @Column
    private Integer quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String name) {
        this.partName = name;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", mandatory=" + mandatory +
                ", quantity=" + quantity +
                '}';
    }
}
