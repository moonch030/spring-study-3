package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

//학생 정보 삭제 서비스 클래스
public class StudentDeleteService {

 private StudentDao studentDao; // 학생 DAO
 
 // 기본 생성자
 public StudentDeleteService() {
     
 }
 
 // 생성자
 public StudentDeleteService(StudentDao studentDao) {
     this.studentDao = studentDao;
 }
 
 // 주어진 학번에 해당하는 학생 정보를 삭제하는 메서드
 public void delete(String sNum) {
     // verify 메서드를 통해 삭제할 학생 정보가 존재하는지 확인
     if (verify(sNum)) {
         // 삭제할 학생 정보가 존재하면 학생 DAO를 통해 해당 학생 정보를 삭제
         studentDao.delete(sNum);
     } else {
         // 삭제할 학생 정보가 존재하지 않을 경우 메시지 출력
         System.out.println("삭제하고자 하는 학생 없음");
     }
 }
 
 // 주어진 학번에 해당하는 학생 정보가 존재하는지 확인하는 메서드
 public Boolean verify(String sNum) {
     // 학생 DAO를 통해 주어진 학번에 해당하는 학생 정보를 조회
     Student student = studentDao.select(sNum);
     // 조회된 학생 정보가 null이 아니면 true 반환, 그렇지 않으면 false 반환
     return student != null ? true : false;
 }
}
