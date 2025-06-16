package br.com.davisoares.apilogin.controller;

import br.com.davisoares.apilogin.model.LoginRequest;
import br.com.davisoares.apilogin.model.LoginResponse;
import br.com.davisoares.apilogin.security.JwtIssuer;
import br.com.davisoares.apilogin.security.UserPrincipal;
import br.com.davisoares.apilogin.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }
}
