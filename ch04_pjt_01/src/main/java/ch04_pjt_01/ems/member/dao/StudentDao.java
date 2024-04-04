package ch04_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ch04_pjt_01.ems.member.Student;

// 학생 DAO 클래스
public class StudentDao {
    
    // 학생 정보를 저장할 Map
    private Map<String, Student> studentDB = new HashMap<String, Student>();
    
    // 기본 생성자
    public StudentDao() {
     System.out.println("StudentDao 기본 생성자 호출");   
    }
    
    // 학생 정보 등록 메서드
    public void insert(Student student) {
        studentDB.put(student.getsNum(), student);
    }

    // 학생 정보 검색 메서드
    public Student select(String sNum) {
        return studentDB.get(sNum);
    }

    // 학생 정보 수정 메서드
    public void update(Student student) {
        studentDB.put(student.getsNum(), student);
    }

    // 학생 정보 삭제 메서드
    public void delete(String sNum) {
        studentDB.remove(sNum);
    }

    // 모든 학생 정보를 담고 있는 Map 반환 메서드
    public Map<String, Student> getStudentDB() {
        return studentDB;
    }
    
    // 학생 id로 정보 검색 메서드
    public Student findById(String sId) {
        for (Student student : studentDB.values()) {
            if (student.getsId().equals(sId)) {
                return student;
            }
        }
        return null; // 일치하는 sId를 가진 학생이 없을 경우
    }

}
