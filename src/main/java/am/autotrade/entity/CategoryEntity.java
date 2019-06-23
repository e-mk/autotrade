package am.autotrade.entity;

import am.autotrade.enumeration.ParentCategory;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parentCategory", nullable = false)
    private ParentCategory parentCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<SubCategoryEntity> subCategories;

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

    public Set<SubCategoryEntity> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategoryEntity> subCategories) {
        this.subCategories = subCategories;
    }
}
