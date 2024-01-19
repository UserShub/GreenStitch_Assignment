package com.example.GreenStitch.payloads;

import com.example.GreenStitch.constants.AppConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    @Email(message = AppConstants.EMAIL_VALIDATION)
    private String email;
    @NotNull
    @Size(min = 8, message = AppConstants.PASSWORD_VALIDATION)
    private String password;
}
