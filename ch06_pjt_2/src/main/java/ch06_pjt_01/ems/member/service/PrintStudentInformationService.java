package ch06_pjt_01.ems.member.service;

import java.util.List;

import ch06_pjt_01.ems.member.Student;

public class PrintStudentInformationService {

    StudentAllSelectService allSelectService;

    public PrintStudentInformationService(StudentAllSelectService allSelectService) {
        this.allSelectService = allSelectService;
    }

    public void printStudentsInfo() {
        List<Student> allStudents = allSelectService.allSelect();
        System.out.println("------------- 전체 학생 리스트 출력 -------------");
        for (Student student : allStudents) {
            System.out.print("sNum:" + student.getsNum() + "\t");
            System.out.print("|sId:" + student.getsId() + "\t");
            System.out.print("|sPw:" + student.getsPw() + "\t");
            System.out.print("|sName:" + student.getsName() + "\t");
            System.out.print("|sAge:" + student.getsAge() + "\t");
            System.out.print("|sGender:" + student.getsGender() + "\t");
            System.out.println("|sMajor:" + student.getsMajor() + "\t");
        }
        System.out.println("----------------------------------------");
    }

}
