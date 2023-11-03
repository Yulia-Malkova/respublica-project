package ru.respublica.utils;

import ru.respublica.data.Articles;
import ru.respublica.data.SearchInputs;

public class Variables {
    public RandomGenerator randomGenerator = new RandomGenerator();
    public Articles articles = new Articles();
    public String randomPassword = randomGenerator.randomPassword();
    public String randomFirstName = randomGenerator.randomFirstName();
    public String randomLastName = randomGenerator.randomLastName();
    public String randomArticle = randomGenerator.getRandomArticle(articles.getArticles());
    public Integer articlePrice = articles.getArticles().get(randomArticle);
    public int randomQuantity = randomGenerator.getRandomQuantity();
    RandomEnumGenerator randomEnumGeneratorSearch = new RandomEnumGenerator(SearchInputs.class);
    SearchInputs searchInputs = (SearchInputs) randomEnumGeneratorSearch.randomEnum();
    public String randomSearchInput = searchInputs.getName();
}
