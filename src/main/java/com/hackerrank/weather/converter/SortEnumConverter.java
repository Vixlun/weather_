package com.hackerrank.weather.converter;

import org.springframework.core.convert.converter.Converter;

public class SortEnumConverter implements Converter<String, SortEnum> {
    @Override
    public SortEnum convert(String source) {
        try {
            return SortEnum.fromString(source);
        } catch(Exception e) {
            return null;
        }
    }
}
