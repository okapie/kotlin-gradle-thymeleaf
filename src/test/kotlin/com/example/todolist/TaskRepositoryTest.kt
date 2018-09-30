package com.example.todolist

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringRunner

@RunWith(value = SpringRunner::class)
@SpringBootTest
@Sql(statements = arrayOf("DELETE FROM task"))
class TaskRepositoryTest {

    @Autowired
    private lateinit var sut: JdbcTaskRepository

    @Test
    fun testFindAll() {
        val got = sut.findAll()
        assertThat(got).isEmpty()
    }

    @Test
    fun testFindById() {
        val task = sut.create("TEST")
        val got = sut.findById(task.id)
        assertThat(got).isEqualTo(task)
    }
}
