package com.sacral.test333.service;

import com.sacral.test333.model.ForgetPasswordServiceImpl;
import com.sacral.test333.repository.ForgetPasswordServiceImplRepository;
import org.springframework.stereotype.Service;

@Service
public class ForgetPasswordServiceImplService {
    
    private final ForgetPasswordServiceImplRepository forgetPasswordServiceImplRepository;

    public ForgetPasswordServiceImplService(ForgetPasswordServiceImplRepository forgetPasswordServiceImplRepository) {
        this.forgetPasswordServiceImplRepository = forgetPasswordServiceImplRepository;
    }

    //Method to find user when user enters username to initiate the password reset process
    public ForgetPasswordServiceImpl findByUsername(String username) {
        return forgetPasswordServiceImplRepository.findByUsername(username);
    }

    //Method to check if the user is found in the system
    public boolean existsByUsername(String username) {
        return forgetPasswordServiceImplRepository.existsByUsername(username);
    }

    //Method to check if the OTP entered is correct
    public boolean existsByOtp(String otp) {
        return forgetPasswordServiceImplRepository.existsByOtp(otp);
    }

    //Method to update user's password
    public int updatePassword(String newPassword, Long id) {
        return forgetPasswordServiceImplRepository.updatePassword(newPassword, id);
    }

}