package org.student.app.dto;

public record StudentResponse(
    Long id,
    String name,
    String email,
    String phone
) {

}
