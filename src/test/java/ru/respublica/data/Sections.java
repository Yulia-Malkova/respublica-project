package ru.respublica.data;

public enum Sections {
    КНИГИ("knigi"),
    МУЗЫКА_НА_ВИНИЛЕ("muzyka-na-vinile"),
    КАНЦЕЛЯРИЯ("kantselyariya"),
    ВИДЕОИГРЫ_И_ЭЛЕКТРОНИКА("elektronika"),
    ДОМ_И_САД("dom"),
    ОДЕЖДА("odezhda"),
    АКСЕССУАРЫ("aksessuary"),
    ХОББИ_И_ТВОРЧЕСТВО("hobbi-i-tvorchestvo"),
    ДЕТЯМ("detyam"),
    ЕДА("eda"),
    КРАСОТА_И_ЗДОРОВЬЕ("krasota");

    private final String name;

    Sections(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
