package com.example.todolist

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tasks")
class TaskController {

    @GetMapping("")
    fun index(): String {
        val tasks = listOf(
            Task(1, "hoge", false),
            Task(2, "fuga", true)
        )
        return tasks.toString()
    }
}