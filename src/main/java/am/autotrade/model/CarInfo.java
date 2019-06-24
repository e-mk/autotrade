package am.autotrade.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

public class CarInfo {

    private Long id;

    @ApiModelProperty(readOnly = true)
    private Integer year;

    @ApiModelProperty(readOnly = true)
    private String brand;

    @ApiModelProperty(readOnly = true)
    private String model;

    @ApiModelProperty(readOnly = true)
    private String modification;

    @ApiModelProperty(readOnly = true)
    private Set<CarPart> carParts;

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

    public Set<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(Set<CarPart> carParts) {
        this.carParts = carParts;
    }
}
