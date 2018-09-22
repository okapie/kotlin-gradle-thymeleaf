package com.example.todolist

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@RequestMapping("tasks")
class TaskController {

    @GetMapping("")
    fun index(model: Model): String {
        val tasks = listOf(
            Task(1, "hoge", false),
            Task(2, "fuga", true)
        )
        model.addAttribute("tasks", tasks)
        // Specify html file.
        return "tasks/index"
    }

    @GetMapping("new")
    fun new(form: TaskCreateForm): String {
        return "tasks/new"
    }
}