package org.student.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

public record StudentRequest(
    Long id,
    @NotNull(message = "Student name cannot be null")
    String name,
    @Email(message = "Invalid email format")
    String email,
    @NotNull(message = "Student phone cannot be null")
    String phone
) {

}
