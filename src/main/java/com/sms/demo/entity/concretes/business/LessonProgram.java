package com.sms.demo.entity.concretes.business;

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

    private Day day;


    private LocalDate startTime;

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
    @ManyToMany(mappedBy = "lessonProgramSet", fetch = FetchType.EAGER)
    private Set<User> users;

    private void removeLessonsFromUser(){

    }

}
