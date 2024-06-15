package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentRegisterService {

    private StudentDao studentDao;

    // StudentDao 객체를 주입받는 생성자
    public StudentRegisterService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    

    // 학생을 등록하는 메서드
    public void register(Student student) {
        // 이미 등록된 학생인지 검증
        if (verify(student.getsNum())) {
            // 등록되지 않은 경우, 학생 정보를 데이터베이스에 삽입
            studentDao.insert(student);
        } else {
            // 이미 등록된 학생인 경우, 메시지 출력
            System.out.println("이미 등록된 학생입니다.");
        }
    }

    // 학번을 기준으로 학생 정보가 존재하는지 확인하는 메서드
    public boolean verify(String sNum) {
        Student student = studentDao.select(sNum);
        return student == null;
    }
}
