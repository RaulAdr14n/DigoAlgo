package com.rauldev.api.digoAlgoForo.domain.topic;

import com.rauldev.api.digoAlgoForo.domain.topic.DTO.CourseDataUpdate;
import com.rauldev.api.digoAlgoForo.domain.topic.DTO.CourseRegistrationData;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserRegistrationData;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name= "courses")
@Entity(name= "Course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    private Boolean active;

    public Course(@Valid CourseRegistrationData courseRegistrationData) {
        this.active = true;
        this.name =  courseRegistrationData.name();
        this.category = courseRegistrationData.category();
    }

    public void updateData(CourseDataUpdate courseDataUpdate) {
        if (courseDataUpdate.name() != null) {
            this.name = courseDataUpdate.name();
        }
        if (courseDataUpdate.category() != null) {
            this.category = courseDataUpdate.category();
        }
    }

    public void turnOffActive() {
        this.active = false;
    }
}
