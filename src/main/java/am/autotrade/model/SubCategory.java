package am.autotrade.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SubCategory {

    @ApiModelProperty(readOnly = true)
    private Long id;

    private String name;

    private CategoryInfo category;

    @ApiModelProperty(readOnly = true)
    private List<CarPart> carParts;

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

    public CategoryInfo getCategory() {
        return category;
    }

    public void setCategory(CategoryInfo category) {
        this.category = category;
    }

    public List<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart> carParts) {
        this.carParts = carParts;
    }
}