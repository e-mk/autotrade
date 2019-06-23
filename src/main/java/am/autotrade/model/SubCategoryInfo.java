package am.autotrade.model;

import io.swagger.annotations.ApiModelProperty;

public class SubCategoryInfo {

    private Long id;

    @ApiModelProperty(readOnly = true)
    private String name;

    @ApiModelProperty(readOnly = true)
    private CategoryInfo category;

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
}
