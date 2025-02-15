package com.rauldev.api.digoAlgoForo.domain.topic;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.rauldev.api.digoAlgoForo.domain.response.Response;
import com.rauldev.api.digoAlgoForo.domain.topic.DTO.CourseDataUpdate;
import com.rauldev.api.digoAlgoForo.domain.topic.DTO.TopicDataUpdate;
import com.rauldev.api.digoAlgoForo.domain.topic.DTO.TopicRegistrationData;
import com.rauldev.api.digoAlgoForo.domain.user.User;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserRegistrationData;

@Table(name="topics")
@Entity(name="Topic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;


    private LocalDateTime creationDate;

    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Response> responses;

    public Topic(@Valid TopicRegistrationData topicRegistrationData) {
        this.active = true;
        this.title =  topicRegistrationData.title();
        this.message = topicRegistrationData.message();
        this.creationDate = topicRegistrationData.creationDate();
        this.author = topicRegistrationData.author();
        this.course = topicRegistrationData.course();
        this.responses = topicRegistrationData.responses();
    }

    public void updateData(TopicDataUpdate topicDataUpdate) {
        if (topicDataUpdate.title() != null) {
            this.title = topicDataUpdate.title();
        }
        if (topicDataUpdate.message() != null) {
            this.message = topicDataUpdate.message();
        }
        if(topicDataUpdate.creationDate() != null){
            this.creationDate = topicDataUpdate.creationDate();
        }
        if(topicDataUpdate.author() != null){
            this.author = topicDataUpdate.author();
        }
        if(topicDataUpdate.course() != null){
            this.course = topicDataUpdate.course();
        }
        if(topicDataUpdate.responses() != null){
            this.responses  = topicDataUpdate.responses();
        }
    }

    public void turnOffActive() {
        this.active = false;
    }

}
