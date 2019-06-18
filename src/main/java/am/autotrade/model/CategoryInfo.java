package am.autotrade.model;

import am.autotrade.enumeration.ParentCategory;
import io.swagger.annotations.ApiModelProperty;

public class CategoryInfo {

    private Long id;
    private String name;
    private ParentCategory parentCategory;

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

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public CategoryInfo() {
    }

    public CategoryInfo(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.parentCategory = category.getParentCategory();
    }
}
