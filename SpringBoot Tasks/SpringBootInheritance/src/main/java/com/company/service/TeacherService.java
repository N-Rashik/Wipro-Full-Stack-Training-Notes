package com.company.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.company.controller.dto.TeacherDTO.TeacherRecord;
import com.company.entity.Teacher;
import com.company.repo.TeacherRepo;

@Service
public class TeacherService {

    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepo.findAll();
    }

    public List<TeacherRecord> getAllTeacherDTOs() {
        return teacherRepo.findAllTeachers().stream()
                .map(t -> new TeacherRecord(
                        t.getId(),
                        t.getName(),
                        t.getAddress() != null ? t.getAddress().getCity() : null,
                        t.getSubject()
                ))
                .collect(Collectors.toList());
    }
}
