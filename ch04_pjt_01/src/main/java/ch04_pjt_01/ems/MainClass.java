package ch04_pjt_01.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.service.EMSInformationService;
import ch04_pjt_01.ems.member.service.PrintStudentInformationService;
import ch04_pjt_01.ems.member.service.StudentDeleteService;
import ch04_pjt_01.ems.member.service.StudentModifyService;
import ch04_pjt_01.ems.member.service.StudentRegisterService;
import ch04_pjt_01.ems.member.service.StudentSelectService;
import ch04_pjt_01.ems.utils.InitSampleData;

public class MainClass {
    
    public static void main(String[] args) {   
//        // classpath:applicationContext.xml에서 자바 빈 객체를 가져옴 
//        GenericXmlApplicationContext ctx =  
//                 new GenericXmlApplicationContext("classpath:applicationContext.xml");
    	
        
		/*
		 * GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
		 * "classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml");
		 */
        
        String appCtxs[] = {
        	 "classpath:appCtx1.xml", 
       		 "classpath:appCtx2.xml", 
       		 "classpath:appCtx3.xml"};
        
      // classpath:applicationContext.xml에서 자바 빈 객체를 가져옴 
      GenericXmlApplicationContext ctx =  
               new GenericXmlApplicationContext("classpath:appCtxImport.xml");
  	
        
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);
        
        // 샘플 데이터 초기화 객체
        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        
        // 샘플 데이터
        String[] sNums = initSampleData.getsNums();
        String[] sIds = initSampleData.getsIds();
        String[] sPws = initSampleData.getsPws();
        String[] sNames = initSampleData.getsNames();
        int[] sAges = initSampleData.getsAges();
        char[] sGenders = initSampleData.getsGenders();
        String[] sMajors = initSampleData.getsMajors();
        
        // 데이터베이스에 샘플 데이터 등록
        StudentRegisterService registerService = ctx.getBean("studentRegisterService", 
                  StudentRegisterService.class);
        
        for (int i = 0; i < sNums.length; i++) {
            registerService.register(new Student(sNums[i], sIds[i], 
                     sPws[i], sNames[i], sAges[i], 
                     sGenders[i], sMajors[i]));
        }
        
        PrintStudentInformationService psi = 
        ctx.getBean("printStudentInformationService",
        		PrintStudentInformationService.class);
        
        
        //학생 등록
        registerService = ctx.getBean("studentRegisterService",
        		StudentRegisterService.class);
        registerService.register(new Student("hbs006","dear","p006","melissa",26,'W',"Music"));
        
        psi.printStudentInfo(); //학생 리스트를 전부 출력
        
        
        //특정 학번에 해당하는 학생 한명만 조회
        StudentSelectService studentSelectService = 
        		ctx.getBean("studentSelectService",
        				StudentSelectService.class);
       
        
        Student selectedstudent = studentSelectService.selectBySId("dear");

        System.out.println("STUDENT START ------------------------------------------------------------------------------------------------------------");
        System.out.print("sNum:" + selectedstudent.getsNum() + "\t");
        System.out.print("|sId:" + selectedstudent.getsId() + "\t");
        System.out.print("|sPw:" + selectedstudent.getsPw() + "\t");
        System.out.print("|sName:" + selectedstudent.getsName() + "\t");
        System.out.print("|sAge:" + selectedstudent.getsAge() + "\t");
        System.out.print("|sGender:" + selectedstudent.getsGender() + "\t");
        System.out.println("|sMajor:" + selectedstudent.getsMajor());
        System.out.println("END ----------------------------------------------------------------------------------------------------------------------");
        
        //특정 학번에 해당하는 학생의 정보를 수정하고 출력
        StudentModifyService modifyService = 
        		ctx.getBean("studentModifyService",StudentModifyService.class);
        
        modifyService.modify(new Student("hbs006","pig","p0066","melisa",27,'W',"Computer"));
        
        psi.printStudentInfo(); //학생 리스트를 전부 출력
        
        //특정 학번에 해당하는 학생을 삭제하고 출력
        StudentDeleteService deleteService =
        		ctx.getBean("studentDeleteService",StudentDeleteService.class);
        deleteService.delete("hbs005");
        psi.printStudentInfo(); //학생 리스트를 전부 출력
        
        //EMS 시스템 정보 출력
        EMSInformationService obems =ctx.getBean("eMSInformationService",EMSInformationService.class);
        obems.printEMSInformation();
                
        // 'sId'로 검색할 학생 ID 설정
        String searchSId = "pig"; // 검색할 학생 ID
        Student studentById = studentSelectService.selectBySId(searchSId);

        if (studentById != null) {
            System.out.println("학생 ID로 검색한 결과 -------------------------------------------------------------------------------------------------");
            System.out.print("sNum:" + studentById.getsNum() + "\t");
            System.out.print("|sId:" + studentById.getsId() + "\t");
            System.out.print("|sPw:" + studentById.getsPw() + "\t");
            System.out.print("|sName:" + studentById.getsName() + "\t");
            System.out.print("|sAge:" + studentById.getsAge() + "\t");
            System.out.print("|sGender:" + studentById.getsGender() + "\t");
            System.out.println("|sMajor:" + studentById.getsMajor());
            System.out.println("END ------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("해당 학생 ID로 검색된 학생 정보가 없습니다.");
        }
        
        ctx.close();
    } //end of main()

}
