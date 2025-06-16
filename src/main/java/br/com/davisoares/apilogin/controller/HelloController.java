package br.com.davisoares.apilogin.controller;

import br.com.davisoares.apilogin.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {
    @GetMapping
    public String greeting() {
        return "Hello, World!";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "you're authenticated as " + principal.getEmail()
                + "\nUser ID: " + principal.getUserId()
                + "\nAuthorities: " + principal.getAuthorities();
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "Admin access granted for user: " + principal.getEmail()
                + "\nUser ID: " + principal.getUserId()
                + "\nAuthorities: " + principal.getAuthorities();
    }
}
