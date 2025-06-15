package com.sms.demo.entity.concretes.users;

import com.sms.demo.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id nin otomatik olarak uretlmesi ve primary key olarak belirlenmesi saglar
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private String roleName;
}
