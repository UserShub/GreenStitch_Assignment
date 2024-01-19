package com.example.GreenStitch.payloads;

import com.example.GreenStitch.constants.AppConstants;
import com.example.GreenStitch.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class RegisterRequest {
    @Size(min = 4, message = AppConstants.NAME_VALIDATION)
    @NotNull
    private String name;

    @Email(message = AppConstants.EMAIL_VALIDATION)
    @NotNull
    private String email;

    @Size(min = 8, message = AppConstants.PASSWORD_VALIDATION)
    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = AppConstants.ROLE_VALIDATION)
    private Role role;
}
