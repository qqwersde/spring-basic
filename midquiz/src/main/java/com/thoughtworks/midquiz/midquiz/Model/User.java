package com.thoughtworks.midquiz.midquiz.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @NotNull(message = "id must not be null")
    private long id;
    private String name;
    private long age;
    private String avatar;
    private String description;
}
