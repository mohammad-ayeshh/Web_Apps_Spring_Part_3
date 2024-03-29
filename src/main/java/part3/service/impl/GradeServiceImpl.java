package part3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import part3.entity.Grade;
import part3.repository.GradeRepository;
import part3.repository.UserRepository;
import part3.service.GradeService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class GradeServiceImpl implements GradeService {


    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void assignGradeToStudent(Long userId, Long courseId, Double grade) {

    }

    public List<Grade> getGradesByStudent(Long userId) {
        return gradeRepository.findByStudentId(userId);
    }
    @Override
    public OptionalDouble calculateAverageGrade(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        return grades.stream()
                .mapToDouble(Grade::getMark)
                .average();
    }

    @Override
    public Optional<Grade> findHighestGrade(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        return grades.stream()
                .max(Comparator.comparingDouble(Grade::getMark));
    }

    @Override
    public Optional<Grade> findLowestGrade(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        return grades.stream()
                .min(Comparator.comparingDouble(Grade::getMark));
    }
}
