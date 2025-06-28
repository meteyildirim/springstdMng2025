package com.sms.demo.repository.user;


import com.sms.demo.entity.concretes.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsBySsn(String ssn);
    boolean existsByPhoneNumber(String phoneNumber);

}
