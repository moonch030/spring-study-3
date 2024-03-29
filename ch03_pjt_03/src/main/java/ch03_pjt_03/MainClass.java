package ch03_pjt_03;

import org.springframework.context.support.GenericXmlApplicationContext;

// 계산기 프로그램을 DI 방식으로 변경하기
public class MainClass {
    public static void main(String[] args) {
        // 생성자 호출 대신 Spring의 ApplicationContext를 사용하여 빈을 가져옴
//      new CalAssembler(); // 생성자 호출

        // Spring의 ApplicationContext를 생성하고 applicationContext.xml 파일을 기반으로 설정을 로드
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        // applicationContext.xml에서 "calAssembler" 빈을 가져와서 CalAssembler 객체로 사용
        CalAssembler calAssembler = ctx.getBean("calAssembler", CalAssembler.class);
        
        // CalAssembler 객체의 assemble() 메서드를 호출하여 계산기를 조립
        calAssembler.assemble();
        
        // ApplicationContext를 닫음
        ctx.close();
    }
}
