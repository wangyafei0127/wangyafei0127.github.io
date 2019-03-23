package com.chukyotech.server.user;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private Integer id;

    private String userName;

    private Integer userAge;

    private String userPhone;

    private String userAddres;

    private String userLanguage;

    private String userEmail;
}