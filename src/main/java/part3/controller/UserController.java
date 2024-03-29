package part3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/student")
    public String studentDashboard() {
        return "student";
    }

    @GetMapping("/teacher")
    public String teacherDashboard() {
        return "teacher";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin";
    }
}