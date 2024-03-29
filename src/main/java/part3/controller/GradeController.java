package part3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import part3.entity.Grade;
import part3.service.GradeService;
import part3.service.UserService;

import java.util.Optional;
import java.util.OptionalDouble;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private UserService userService;

    private Long getCurrentStudentId() {
        return userService.getCurrentStudentId();
    }

    @GetMapping("/grades/all")
    public String showAllGrades(Model model) {
        Long studentId = getCurrentStudentId();
        model.addAttribute("grades", gradeService.getGradesByStudent(studentId));
        return "grades-all";
    }

    @GetMapping("/grades/course")
    public String showGradesAtt( Model model) {
        Long studentId = getCurrentStudentId();
        OptionalDouble averageOpt = gradeService.calculateAverageGrade(studentId);
        Optional<Grade> highestOpt = gradeService.findHighestGrade(studentId);
        Optional<Grade> lowestOpt = gradeService.findLowestGrade(studentId);

        if (averageOpt.isPresent()) {
            model.addAttribute("average", averageOpt.getAsDouble());
        } else {
            model.addAttribute("average", null);
        }

        model.addAttribute("highest", highestOpt.map(Grade::getMark).orElse(null));
        model.addAttribute("lowest", lowestOpt.map(Grade::getMark).orElse(null));

        model.addAttribute("hasGrades", averageOpt.isPresent() || highestOpt.isPresent() || lowestOpt.isPresent());

        return "grades-course";
    }

}
