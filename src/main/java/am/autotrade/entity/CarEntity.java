package am.autotrade.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="year", nullable=false)
    private Integer year;

    @Column(name="brand", nullable=false)
    private String brand;

    @Column(name="model", nullable=false)
    private String model;

    @Column(name="modification", nullable=false)
    private String modification;

    public CarEntity() {
    }

    public CarEntity(Integer year, String brand) {
        this.year = year;
        this.brand = brand;
    }

    public CarEntity(Integer date, String brand, String model, String modification) {
        this.year = date;
        this.brand = brand;
        this.model = model;
        this.modification = modification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", modification='" + modification + '\'' +
                '}';
    }
}
