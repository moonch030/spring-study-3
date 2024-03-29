package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

//학생 정보 수정 서비스 클래스
public class StudentModifyService {   
 
 private StudentDao studentDao; // 학생 DAO
 
 // 기본 생성자
 public StudentModifyService() {
     
 }
 
 // 생성자
 public StudentModifyService(StudentDao studentDao){
     this.studentDao = studentDao;
 }
 
 // 주어진 학생 정보를 수정하는 메서드
 public void modify(Student student) {
     // verify 메서드를 통해 수정할 학생 정보가 존재하는지 확인
     if (verify(student.getsNum())) {
         // 수정할 학생 정보가 존재하면 학생 DAO를 통해 해당 학생 정보를 수정
         studentDao.update(student);
     } else {
         // 수정할 학생 정보가 존재하지 않을 경우 메시지 출력
         System.out.println("수정하고자 하는 학생이 없음");
     }
 }
 
 // 주어진 학번에 해당하는 학생 정보가 존재하는지 확인하는 메서드
 public Boolean verify(String sNum) { 
     // 학생 DAO를 통해 주어진 학번에 해당하는 학생 정보를 조회
     Student student = studentDao.select(sNum);
     // 조회된 학생 정보가 null이 아니면 true 반환, 그렇지 않으면 false 반환
     return student != null?true:false;
 }
}
