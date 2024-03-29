package part3.service;

import part3.entity.Grade;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface GradeService {

    public void assignGradeToStudent(Long userId, Long courseId, Double grade);
    public List<Grade> getGradesByStudent(Long userId);
    OptionalDouble calculateAverageGrade(Long studentId);
    Optional<Grade> findHighestGrade(Long studentId);
    Optional<Grade> findLowestGrade(Long studentId);

}