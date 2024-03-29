package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

// 학생 정보 조회 서비스 클래스
public class StudentSelectService {
    private StudentDao studentDao;

    public StudentSelectService() {
    }

    public StudentSelectService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student select(String sNum) {
        if (verify(sNum)) {
            return studentDao.select(sNum);
        } else {
            System.out.println("검색된 학생이 없음.");
            return null;
        }
    }

    public boolean verify(String sNum) {
        Student student = studentDao.select(sNum); // 해당 학번을 조회해서 Student 객체로 반환
        return student != null ? true : false; // 삼항연산자로 학번이 null(해당 학번이 studentDao에 존재하지 않을때) true, 학번이 존재할때 false)
    }
}
