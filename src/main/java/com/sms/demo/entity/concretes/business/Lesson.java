package com.sms.demo.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lessonName;

    private  Integer creditScore;

    private Boolean isCompulsory;

    @JsonIgnore // bu onemli. olmayinca sonsuz donguye girer. cunku
    @ManyToMany(mappedBy = "lessons")
    private Set<LessonProgram> lessonPrograms;
}
