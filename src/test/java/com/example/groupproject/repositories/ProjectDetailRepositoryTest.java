package com.example.groupproject.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class ProjectDetailRepositoryTest {

    @Test
    void findProjectDetailByDetailId() {
    }

    @Test
    void findProjectDetailByProject() {
    }
}