package com.chukyotech.server.user;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Serializable {
    private String name;
    private int age;
    private String language;
    private String phone;
}
