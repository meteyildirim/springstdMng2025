package com.sms.demo.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sms.demo.entity.concretes.users.User;
import com.sms.demo.entity.enums.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer absentee;

    private Double midtermExam;

    private Double finalExam;

    private  String infoMore;

    private Double examAverage;

    @Enumerated(EnumType.STRING)
    private Note letterGrade;

    @ManyToOne
    @JsonIgnore()
    private User teacher;

    @ManyToOne
    @JsonIgnore()
    private User student;

    @ManyToOne
    private Lesson lesson;

    @OneToOne
    private EducationTerm educationTerm;

}
