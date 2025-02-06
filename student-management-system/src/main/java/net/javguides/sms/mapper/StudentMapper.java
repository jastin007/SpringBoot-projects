package net.javguides.sms.mapper;

import net.javguides.sms.Entity.Student;
import net.javguides.sms.dto.StudentDto;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail());
        return student;
    }
}
