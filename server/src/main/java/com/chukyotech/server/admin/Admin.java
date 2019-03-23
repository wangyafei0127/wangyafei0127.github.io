package com.chukyotech.server.admin;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Admin implements Serializable {

    private Integer id;
    private String adminName;
    private String adminPass;
}