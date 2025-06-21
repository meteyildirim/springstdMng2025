package com.sms.demo.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sms.demo.entity.concretes.users.User;
import com.sms.demo.entity.enums.Day;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Day day;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm", timezone = "US")
    private LocalDate startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm", timezone = "US")
    private LocalDate stopTime;

    @ManyToMany
    @JoinTable(
            name="lesson_program_lesson",
            joinColumns = @JoinColumn(name="lessonprogram_id"),
            inverseJoinColumns = @JoinColumn(name="lesson_id")
    )
    private Set<Lesson> lessons;

    @ManyToOne
    private  EducationTerm educationTerm;

    @JsonIgnore
    @ManyToMany(mappedBy = "lessonProgramList", fetch = FetchType.EAGER)
    private Set<User> users;

    @PreRemove
    private void removeLessonsFromUser(){
        users.forEach( user -> user.getLessonProgramList().remove(this));

    }

}
