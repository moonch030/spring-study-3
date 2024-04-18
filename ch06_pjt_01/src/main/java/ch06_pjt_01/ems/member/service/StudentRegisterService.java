package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentRegisterService {
    private StudentDao studentDao;

    public StudentRegisterService() {

    }

    public StudentRegisterService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 학생 등록 메서드
     * @param student
     */
    public void register(Student student) {
        if (verify(student.getsNum())) { // 중복 등록 방지를 위해 학번 검증
            studentDao.insert(student);
        }
    }

    /**
     * 학번 검증 메서드
     * @param sNum
     * @return
     */
    public boolean verify(String sNum) {
        Student student = studentDao.select(sNum); // 해당 학번을 조회해서 Student 객체로 반환
        return student == null ? true : false; // 삼항연산자로 학번이 null(해당 학번이 studentDao에 존재하지 않을때) true, 학번이 존재할때 false)
    }
}
