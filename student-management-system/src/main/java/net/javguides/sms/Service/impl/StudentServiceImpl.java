package net.javguides.sms.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javguides.sms.Entity.Student;
import net.javguides.sms.Service.StudentService;
import net.javguides.sms.dto.StudentDto;
import net.javguides.sms.mapper.StudentMapper;
import net.javguides.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long studentId) {
        // TODO Auto-generated method stub
        studentRepository.deleteById(studentId);

    }

}
