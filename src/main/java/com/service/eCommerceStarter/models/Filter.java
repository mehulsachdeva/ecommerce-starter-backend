package com.service.eCommerceStarter.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Filter {
    private String name;
    private int min;
    private int max;
    private int page;
}
