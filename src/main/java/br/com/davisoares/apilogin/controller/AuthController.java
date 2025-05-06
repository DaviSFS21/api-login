package br.com.davisoares.apilogin.controller;

import br.com.davisoares.apilogin.model.LoginRequest;
import br.com.davisoares.apilogin.model.LoginResponse;
import br.com.davisoares.apilogin.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        var token = jwtIssuer.issue(1L, request.getEmail(), List.of("USER"));
        return LoginResponse
                .builder()
                .accessToken(token)
                .build();
    }
}
