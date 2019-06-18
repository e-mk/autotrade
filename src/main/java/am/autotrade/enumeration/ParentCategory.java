package am.autotrade.enumeration;

public enum ParentCategory {

    ENGINE("Двигатель"),

    BRAKE_SYSTEM("Тормозная Система"),

    CHASSIS("Рулевое Управление / Ходовая Часть"),

    IGNITATION_SYSTEM("Система Зажигания"),

    COOLING_HEATING("Охлаждение / Отопление"),

    TRANSMISSION("Трансмиссия / Коробка Передач"),

    LIGHT_MIRRORS("Освещение / Стекла / Зеркала"),

    FUEL_SYSTEM("Топливная Система"),

    ELECTRONICS("Электрика"),

    FILTERS("Фильтры"),

    EXHOUST_SYSTEM("Система Выпуска ОГ"),

    BODY_INTERIOR("Кузов / Внутренняя отделка");

    private String name;

    ParentCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
