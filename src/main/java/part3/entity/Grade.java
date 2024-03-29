package part3.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Student (User) - Many-to-one relationship
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private User student;

    // Course - Many-to-one relationship
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(nullable = false)
    private Double mark; // The grade received


}
