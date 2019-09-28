package com.meb.apibakery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pastrie {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("description")
    private String description;

    public Integer getId() {
        return id;
    }
}
