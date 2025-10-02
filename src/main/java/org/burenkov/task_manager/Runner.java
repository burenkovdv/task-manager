package org.burenkov.task_manager;

import lombok.extern.slf4j.Slf4j;
import org.burenkov.task_manager.user.model.User;
import org.burenkov.task_manager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            userRepository.save(
                    User.builder()
                            .email("test@taskforge.com")
                            .password("123456")
                            .name("Test User")
                            .createdAt(LocalDateTime.now())
                            .build()
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        userRepository.findByEmail("test@taskforge.com")
                .ifPresent(u -> log.info(String.valueOf(u)));
    }
}
