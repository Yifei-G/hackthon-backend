package com.schwarz.matrixapi.infrastructure.service;

import com.schwarz.matrixapi.infrastructure.model.User;
import com.schwarz.matrixapi.infrastructure.repository.UserRepository;
import com.schwarz.matrixapi.infrastructure.security.PasswordEncoderImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoderImpl passwordEncoder;

    public void createFirstAdminUser() {
        boolean exist = userRepository.findByLogin("admin").isPresent();
        if (exist) {
            log.info("First admin user already exist");
            return;
        }
        log.info("Creating first admin user");
        userRepository.save(User.builder()
                        .name("administrator")
                        .login("admin")
                        .system("schwarz")
                        .passwordHash(passwordEncoder.encode("admin"))
                        .environment("ALL")
                        .activated(true)
                .build());
    }


}
