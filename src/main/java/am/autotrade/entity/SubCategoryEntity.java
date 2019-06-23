package am.autotrade.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sub_categories")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "subCategory", fetch = FetchType.LAZY)
    private Set<CarPartEntity> carParts;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<CarPartEntity> getCarParts() {
        return carParts;
    }

    public void setCarParts(Set<CarPartEntity> carParts) {
        this.carParts = carParts;
    }
}
