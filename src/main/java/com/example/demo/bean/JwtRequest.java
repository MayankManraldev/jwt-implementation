package com.example.demo.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class JwtRequest {

    private String email;
    private String userName;

    private String password;



}
