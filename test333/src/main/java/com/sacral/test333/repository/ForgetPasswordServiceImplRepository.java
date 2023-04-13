@Repository
package com.sacral.test333.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sacral.test333.model.ForgetPasswordServiceImpl;

public interface ForgetPasswordServiceImplRepository extends JpaRepository<ForgetPasswordServiceImpl, Long> {
    
    //Method to find user when user enters username to initiate the password reset process
    ForgetPasswordServiceImpl findByUsername(String username);

    //Method to check if the user is found in the system
    boolean existsByUsername(String username);

    //Method to check if the OTP entered is correct
    boolean existsByOtp(String otp);

    //Method to update user's password
    int updatePassword(String newPassword, Long id);

}