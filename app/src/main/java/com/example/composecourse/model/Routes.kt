package com.example.composecourse.model

sealed class Routes(val route: String) {
    data object Screen1:Routes("S1")
    data object Screen2:Routes("S2")
    data object Screen3:Routes("S3")
    data object Screen4:Routes("S4/{age}") {
        fun createRoute(age: Int) = "S4/$age"
    }
    data object Screen5:Routes("S5?name={name}") {
        fun createRoute(name: String) = "S5?name=$name"
    }
}