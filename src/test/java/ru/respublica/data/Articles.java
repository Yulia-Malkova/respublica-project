package ru.respublica.data;

import lombok.Data;

import java.util.AbstractMap;
import java.util.Map;

@Data
public class Articles {

    private Map<String, Integer> articles = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Integer>("349748", 768),
            new AbstractMap.SimpleEntry<String, Integer>("341239", 1034),
            new AbstractMap.SimpleEntry<String, Integer>("553006", 4320),
            new AbstractMap.SimpleEntry<String, Integer>("552741", 990),
            new AbstractMap.SimpleEntry<String, Integer>("553063", 490),
            new AbstractMap.SimpleEntry<String, Integer>("553062", 990),
            new AbstractMap.SimpleEntry<String, Integer>("262485", 750),
            new AbstractMap.SimpleEntry<String, Integer>("551428", 8750),
            new AbstractMap.SimpleEntry<String, Integer>("116500", 890),
            new AbstractMap.SimpleEntry<String, Integer>("522471", 4119)
    );
}
