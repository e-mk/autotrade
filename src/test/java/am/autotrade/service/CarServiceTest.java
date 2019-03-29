package am.autotrade.service;

import am.autotrade.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @BeforeAll
    public void generateTestData() {
        carService.saveCar(new Car(2010, "BMW", "AAA", "AAA"));
        carService.saveCar(new Car(2011, "Mini", "BBB", "BBB"));
        carService.saveCar(new Car(2011, "Mercedes", "CCC", "CCC"));
    }

    @Test
    public void getAllDistinctYearsTest() {

        Set<Integer> distinctYears = carService.getAllDistinctYears();

        assertThat(distinctYears, hasItem(2010));
        assertThat(distinctYears, hasItem(2011));

    }

    @Test
    public void getAllDistinctBrandsByYearTest() {

        Set<String> distinctBrands = carService.getAllDistinctBrandsByYear(2011);

        assertThat(distinctBrands, hasItem("Mini"));
        assertThat(distinctBrands, hasItem("Mercedes"));
    }
}