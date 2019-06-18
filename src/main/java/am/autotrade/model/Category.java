package am.autotrade.model;

import am.autotrade.enumeration.ParentCategory;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

public class Category {

    @ApiModelProperty(hidden = true)
    private Long id;
    private String name;
    private ParentCategory parentCategory;

    @ApiModelProperty(hidden = true)
    private Set<SubCategory> subCategories;

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

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
