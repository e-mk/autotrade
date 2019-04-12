package am.autotrade.service;

import am.autotrade.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarServiceTest {

    @Autowired
    private CarService carService;

    public void generateTestData() {
        carService.saveCar(new Car(2010, "BMW", "AAA", "AAA1"));
        carService.saveCar(new Car(2010, "BMW", "AAA", "AAA2"));
        carService.saveCar(new Car(2010, "BMW", "AAM", "AAM1"));
        carService.saveCar(new Car(2011, "Mini", "BBB", "BBB1"));
        carService.saveCar(new Car(2011, "Mercedes", "CCC", "CCC1"));
    }

    @Test
    public void getAllDistinctYearsTest() {

        generateTestData();

        Set<Integer> distinctYears = carService.getAllDistinctYears();

        assertThat(distinctYears, hasItem(2010));
        assertThat(distinctYears, hasItem(2011));

    }

    @Test
    public void getAllDistinctBrandsByYearTest() {

        generateTestData();

        Set<String> distinctBrands = carService.getAllDistinctBrandsByYear(2011);

        assertThat(distinctBrands, hasItem("Mini"));
        assertThat(distinctBrands, hasItem("Mercedes"));
    }

    @Test
    public void getAllDistinctModelsByBrandAndYearTest() {

        generateTestData();

        Set<String> distinctModels = carService.getAllDistinctModelsByYearAndBrand(2010, "BMW");

        assertThat(distinctModels, hasItem("AAA"));
        assertThat(distinctModels, hasItem("AAM"));
    }

    @Test
    public void getAllModificationByBrandsAndYearAndModelTest() {

        generateTestData();

        Set<String> distinctModifications = carService.getAllDistinctModificationsByYearAndBrandAndModel(2010, "BMW", "AAA");

        assertThat(distinctModifications, hasItem("AAA1"));
        assertThat(distinctModifications, hasItem("AAA2"));
    }
}