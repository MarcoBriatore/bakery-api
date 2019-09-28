package com.meb.apibakery.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meb.apibakery.model.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CookieRepository {

    private static final String FILE_NAME = "/cookies.json";

    private final ObjectMapper objectMapper;
    private List<Cookie> source;

    @PostConstruct
    private void init() throws IOException {
        source = objectMapper.readValue(this.getClass().getResourceAsStream(FILE_NAME), new TypeReference<List<Cookie>>() {
        });
    }

    public List<Cookie> getAllCookies() {
        return source;
    }

    public List<Cookie> getCookies(Integer from, Integer to) {
        return source.subList(from, to);
    }

    public int getTotalCookies() {
        return source.size();
    }

    public Cookie getCookieById(Integer id) {
        return source.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
    }
}
