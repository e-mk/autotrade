package am.autotrade.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_parts")
public class CarPartEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategoryEntity subCategoryEntity;

}
