package com.company.controller.dto;

public class TeacherDTO {

    public record TeacherRecord(
            Long id,
            String name,
            String city,
            String subject
    ) {}
}
