package ru.respublica.data;

public enum SearchInputs {
    PUSHKIN("Пушкин"),
    DOST("Достоевский"),
    HUGO("Гюго"),
    ZOLA("Золя"),
    SHAKESPEARE("Шекспир"),
    CREAM("Крем"),
    NOTEBOOK("Тетрадь"),
    BAG("Сумка"),
    TOY("Игрушка"),
    CUP("Чашка"),
    HEADPHONES("Наушники"),
    POSTER("Постер");

    private final String name;

    SearchInputs(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
