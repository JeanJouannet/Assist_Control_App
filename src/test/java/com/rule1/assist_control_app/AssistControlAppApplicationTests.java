package com.rule1.assist_control_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class AssistControlAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void JunitMethod() {
        System.out.print("Executing Junit Test Cases");
    }

}
