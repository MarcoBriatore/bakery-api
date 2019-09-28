package com.meb.apibakery.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meb.apibakery.model.Cake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CakeRepository {
    private static final String FILE_NAME = "/cakes.json";

    private final ObjectMapper objectMapper;
    private List<Cake> source;

    @PostConstruct
    private void init() throws IOException {
        source = objectMapper.readValue(this.getClass().getResourceAsStream(FILE_NAME), new TypeReference<List<Cake>>() {
        });
    }

    public List<Cake> getAllCakes() {
        return source;
    }

    public List<Cake> getCakes(Integer from, Integer to) {
        return source.subList(from, to);
    }

    public int getTotalCakes() {
        return source.size();
    }

    public Cake getCakesById(Integer id) {
        return source.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
    }


}
