package ch06_pjt_01.ems.member.service;

import java.util.List;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService {

    private StudentDao studentDao;

    public StudentAllSelectService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> allSelect() {
        return studentDao.getAllStudents();
    }
}
