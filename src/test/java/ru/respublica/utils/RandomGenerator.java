package ru.respublica.utils;

import com.github.javafaker.Faker;

import java.util.*;

public class RandomGenerator {
    Faker faker = new Faker(new Locale("ru"));

    public String randomPassword(){
        return faker.internet().password(8,12,true);
    }

    public <String> String randomArticle (List<String> list){
            return list.get(faker.random().nextInt(list.size()));
        }

    public String randomFirstName(){
        return faker.name().firstName();
    }

    public String randomLastName(){
        return faker.name().lastName();
    }

    public String getRandomArticle(Map<String,Integer> hashMap){
        Object[] articles = hashMap.keySet().toArray();
        int rnd = new Random().nextInt(articles.length);
        return articles[rnd].toString();
    }

    public int getRandomQuantity(){
        return faker.random().nextInt(1,5);
    }
    }
