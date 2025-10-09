package org.burenkov.task_manager.user.controller;

import org.burenkov.task_manager.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.SqlMergeMode.MergeMode.MERGE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(statements = "TRUNCATE TABLE users RESTART IDENTITY", executionPhase = AFTER_TEST_METHOD)
@SqlMergeMode(MERGE)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql(scripts = "classpath:scripts/fill_users_table.sql")
    void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*].email").value(hasItems(
                        "ivan.ivanov@example.com",
                        "maria.petrova@example.com",
                        "alexey.smirnov@example.com",
                        "olga.kuznetsova@example.com",
                        "dmitry.popov@example.com",
                        "anna.vasileva@example.com",
                        "sergey.novikov@example.com",
                        "ekaterina.morozova@example.com",
                        "pavel.lebedev@example.com",
                        "natalya.orlova@example.com"
                )));
    }

    @Test
    @Sql(scripts = "classpath:scripts/fill_users_table.sql")
    void getUserByIdTest() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("ivan.ivanov@example.com"))
                .andExpect(jsonPath("$.name").value("Иван Иванов"));
    }

    @Test
    @Sql(scripts = "classpath:scripts/fill_users_table.sql")
    void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/api/users/2"))
                .andDo(print())
                .andExpect(status().isOk());

        assertTrue(userRepository.findByEmail("maria.petrova@example.com").isEmpty());
    }
}