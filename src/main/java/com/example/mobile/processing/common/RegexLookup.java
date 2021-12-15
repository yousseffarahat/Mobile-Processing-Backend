package com.example.mobile.processing.common;

import com.example.mobile.processing.common.models.Regex;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Component
public class RegexLookup {

    public static List<Regex> countryCodeList;

    @Value("${lookups.list}")
    private String defaultListLookupsPath;

    /*
        Load our regex with their respective country name and code from a json file stored in out resources folder

        Note: Initial thought was to use a hashmap with the name linked to its regex but decided on using a List of
        a custom object so that i can also link the country code to return it along with the response
    */
    @PostConstruct
    void constructRegexLookupMap() throws IOException{
        ObjectMapper jsonMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream(defaultListLookupsPath);

        countryCodeList = jsonMapper.readValue(inputStream, new TypeReference<>() {});
    }
}
