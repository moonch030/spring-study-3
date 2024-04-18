package ch06_pjt_01.ems.member.service;

import java.util.Map;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

// 학생 전체 조회 서비스 클래스
public class StudentAllSelectService {

    private StudentDao studentDao; // 학생 DAO
    
    // 기본 생성자
    public StudentAllSelectService() {
        
    }
    
    // 생성자
    public StudentAllSelectService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    // 모든 학생 정보를 조회하여 Map으로 반환하는 메서드
    public Map<String, Student> allSelect() {
        return studentDao.getStudentDB();
    }   
}
