package am.autotrade.model;

public class Car {

    private Long id;
    private Integer year;
    private String brand;
    private String model;
    private String modification;

    public Car() { }

    public Car(Integer date, String brand, String model, String modification) {
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
