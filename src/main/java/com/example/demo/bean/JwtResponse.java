package com.example.demo.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class JwtResponse {
    private String jwtToken;
    private String userName;
}
