package com.hackerrank.weather.converter;

public enum SortEnum {
    asc("date"),
    desc("-date");

    private String name;
    
    SortEnum(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static SortEnum fromString(String name) {
        for (SortEnum sort : SortEnum.values()) {
            if (sort.getName().equalsIgnoreCase(name)) {
                return sort;
            }
        }
        return null;
    }
}
