package part3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import part3.entity.Grade;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Find all grades for a specific student.html by their user ID
    List<Grade> findByStudentId(Long studentId);

    // You can add more custom query methods here as needed, for example:
    // Find all grades for a specific course
    List<Grade> findByCourseId(Long courseId);

    // Find a specific grade for a student.html in a specific course
    Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
}