package br.com.davisoares.apilogin.service;

import br.com.davisoares.apilogin.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String ANOTHER_EMAIL = "admin@test.com";

    public Optional<User> findByEmail(String email) {
        // TODO: Implement a real database lookup here.

        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            User user = User
                    .builder()
                    .id(21L)
                    .email(EXISTING_EMAIL)
                    .password("$2a$12$ImSgVu9a535JwrK6X9ASqeWj7ppzZY/RaklcUZs7KXat.LD81v1ne")
                    .role("ROLE_USER")
                    .build();

            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
            User user = User
                    .builder()
                    .id(22L)
                    .email(ANOTHER_EMAIL)
                    .password("$2a$12$ImSgVu9a535JwrK6X9ASqeWj7ppzZY/RaklcUZs7KXat.LD81v1ne")
                    .role("ROLE_ADMIN")
                    .build();

            return Optional.of(user);
        }

        System.out.println("UserService.findByEmail: User not found for email: " + email);
        return Optional.empty();
    }
}
