package ch06_pjt_01.ems;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch06_pjt_01.ems.configuration.MemberConfig1;
import ch06_pjt_01.ems.configuration.MemberConfig2;
import ch06_pjt_01.ems.configuration.MemberConfig3;
import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;


public class MainClassUseConfigs {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        		MemberConfig1.class,
        		MemberConfig2.class,
        		MemberConfig3.class);
        InitSampleData initSampleData = ac.getBean("initSampleData", InitSampleData.class); // 빈에 등록된 initSampleData 객체를 가져옴

        String[] sNums = initSampleData.getsNums();
        String[] sIds = initSampleData.getsIds();
        String[] sPws = initSampleData.getsPws();
        String[] sNames = initSampleData.getsNames();
        int[] sAges = initSampleData.getsAges();
        char[] sGenders = initSampleData.getsGenders();
        String[] sMajors = initSampleData.getsMajors();

        // 데이터베이스에 샘플 데이터 등록
        StudentRegisterService registerService = ac.getBean("studentRegisterService", StudentRegisterService.class);

        // 데이터의 길이(sNum.length)만큼 반복을 하여 student 객체를 생성해서 registerService.register(키, 값)작업을 하게 됨
        for (int i = 0; i < sNums.length; i++) {
            registerService.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
        }

        PrintStudentInformationService printStudentInformationService = ac.getBean("printStudentInformationService", PrintStudentInformationService.class);
        printStudentInformationService.printStudentInfo(); // 학생 리스트 전부 출력

        // 학생 등록
        registerService.register(new Student("hbs006", "dear", "p0006", "melissa", 25, 'W', "Music"));
        printStudentInformationService.printStudentInfo(); // 학생 리스트 전부 출력

        StudentSelectService studentSelectService = ac.getBean("studentSelectService", StudentSelectService.class); // 1명의 학생만 뽑아오는 빈 객체 가져오기
        Student selectedStudent = studentSelectService.select("hbs001"); // hbs001만 조회하기
        System.out.println("STUDENT START ------------------");
        System.out.print("sNum:" + selectedStudent.getsNum() + "\t");
        System.out.print("|sId:" + selectedStudent.getsId() + "\t");
        System.out.print("|sPw:" + selectedStudent.getsPw() + "\t");
        System.out.print("|sName:" + selectedStudent.getsName() + "\t");
        System.out.print("|sAge:" + selectedStudent.getsAge() + "\t");
        System.out.print("|sGender:" + selectedStudent.getsGender() + "\t");
        System.out.println("|sMajor:" + selectedStudent.getsMajor());
        System.out.println("END ----------------------------");

        // 학생 아이디로 검색하기
        Student findStudent = studentSelectService.selectBySId("lion"); // rabbit 이라는 아이디를 가진 학생 조회하기
        System.out.println("SELECT BY STUDENT_ID ------------------");
        System.out.print("sNum:" + findStudent.getsNum() + "\t");
        System.out.print("|sId:" + findStudent.getsId() + "\t");
        System.out.print("|sPw:" + findStudent.getsPw() + "\t");
        System.out.print("|sName:" + findStudent.getsName() + "\t");
        System.out.print("|sAge:" + findStudent.getsAge() + "\t");
        System.out.print("|sGender:" + findStudent.getsGender() + "\t");
        System.out.println("|sMajor:" + findStudent.getsMajor());
        System.out.println("END ----------------------------");

        // 특정 학번 정보 수정
        StudentModifyService studentModifyService = ac.getBean("studentModifyService", StudentModifyService.class); // 수정 빈 객체 가져오기
        studentModifyService.modify(new Student("hbs006", "dear", "p0006", "melissa", 25, 'M', "Computer")); // 수정
        printStudentInformationService.printStudentInfo();  // 학생 정보 출력

        // 학생 삭제
        StudentDeleteService studentDeleteService = ac.getBean("studentDeleteService", StudentDeleteService.class); // 삭제 빈 객체 가져오기
        studentDeleteService.delete("hbs006"); // hbs006 삭제
        printStudentInformationService.printStudentInfo(); // 학생 정보 출력

        //EMS 시스템 정보 출력
        EMSInformationService emsInformationService = ac.getBean("emsInformationService", EMSInformationService.class);
        emsInformationService.printEMSInformation();
    }
}