package com.example.todolistapp.models

import com.example.todolistapp.enums.PrioritiesEnum
import com.google.gson.annotations.SerializedName

data class TodoResponse(
    val data: List<TodoModel>
)

data class TodoModel(
    val id: Int = 0,
    val title: String = "",
    val status: String = "",
    val priority: String = "",
    val description: String = "",

    @SerializedName("due_date")
    val dueDate: String = ""
)

data class TodoRequest(
    val title: String = "",
    val status: String = "",
    val priority: String = "",
    val description: String = "",

    @SerializedName("due_date")
    val dueDate: String = ""
)