package com.sms.demo.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sms.demo.entity.concretes.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM--dd")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm", timezone = "US")
    private LocalTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm", timezone = "US")
    private LocalTime stopTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User advisoryTeacher;

    @ManyToMany
    @JoinTable(name="meet_student_tab",
    joinColumns = @JoinColumn(name="meet_id"),
    inverseJoinColumns = @JoinColumn(name="student_id")
    ) // many to many de yeni bir table olusturuldugu icin bunun ismi girilir.
    private List<User> studentList;
}
