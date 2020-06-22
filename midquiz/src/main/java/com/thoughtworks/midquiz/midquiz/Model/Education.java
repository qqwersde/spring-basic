package com.thoughtworks.midquiz.midquiz.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private long userId;
    private long year;
    private String title;
    private String description;
}
