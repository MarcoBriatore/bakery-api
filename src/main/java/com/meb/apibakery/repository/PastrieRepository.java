package com.meb.apibakery.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meb.apibakery.model.Pastrie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PastrieRepository {

    private static final String FILE_NAME = "/pastries.json";

    private final ObjectMapper objectMapper;
    private List<Pastrie> source;

    @PostConstruct
    private void init() throws IOException {
        source = objectMapper.readValue(this.getClass().getResourceAsStream(FILE_NAME), new TypeReference<List<Pastrie>>() {
        });
    }

    public List<Pastrie> getAllPastries() {
        return source;
    }

    public List<Pastrie> getPastries(Integer from, Integer to) {
        return source.subList(from, to);
    }

    public int getTotalPastries() {
        return source.size();
    }

    public Pastrie getPastrieById(Integer id) {
        return source.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
    }
}
