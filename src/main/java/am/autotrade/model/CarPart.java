package am.autotrade.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

public class CarPart {

    @ApiModelProperty(readOnly = true)
    private Long id;
    private String number;
    private String name;
    private String description;
    private Integer price;
    private String image;
    private Integer count;
    private SubCategoryInfo subCategory;
    private Set<CarInfo> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public SubCategoryInfo getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryInfo subCategory) {
        this.subCategory = subCategory;
    }

    public Set<CarInfo> getCars() {
        return cars;
    }

    public void setCars(Set<CarInfo> cars) {
        this.cars = cars;
    }
}
