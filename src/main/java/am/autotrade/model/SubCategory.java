package am.autotrade.model;

import io.swagger.annotations.ApiModelProperty;

public class SubCategory {

    @ApiModelProperty(hidden = true)
    private Long id;
    private String name;
    private CategoryInfo categoryInfo;

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

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }
}
