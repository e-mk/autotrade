package am.autotrade.model.pojo;

public class YearAndBrands {

    private Integer year;
    private String brand;

    public YearAndBrands() {
    }

    public YearAndBrands(Integer year, String brand) {
        this.year = year;
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
