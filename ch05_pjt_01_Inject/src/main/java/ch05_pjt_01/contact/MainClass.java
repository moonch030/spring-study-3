package ch05_pjt_01.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:appCtx.xml");

        InitSampleData init = ac.getBean("initSampleData", InitSampleData.class); // 빈 객체로 생성해둔 initSampleData 호출

        String[] names = init.getNames(); // init에 있는 샘플데이터의 값을 string 배열에 할당함
        String[] phoneNumbers = init.getPhoneNumbers(); // init에 있는 샘플데이터의 값을 string 배열에 할당함

        ContactRegisterService registerService = ac.getBean("registerService", ContactRegisterService.class); // 빈 객체로 생성해둔 저장 서비스 빈 호출

        for (int i = 0; i < names.length; i++) { // 샘플데이터의 값을 저장한 배열 길이만큼
            ContactSet registerSet = new ContactSet(names[i], phoneNumbers[i]); // ContactSet 에 배열 길이 만큼 값 넣기
            registerService.register(registerSet); // 저장된 set 객체 저장
        }

        ContactSet contactSet;

        ContactSearchService searchService = ac.getBean("searchService", ContactSearchService.class); // 빈 객체로 생성해둔 조회 서비스 빈 호출

        contactSet = searchService.searchContact("류현진"); // 조회할 이름("류현진")을 파라미터로 넘겨서 조회함
        System.out.println("name: " + contactSet.getName());
        System.out.println("phone number: " + contactSet.getPhoneNumber());
        System.out.println("------------------------------");

        contactSet = searchService.searchContact("손흥민"); // 조회할 이름("류현진")을 파라미터로 넘겨서 조회함
        System.out.println("name: " + contactSet.getName());
        System.out.println("phone number: " + contactSet.getPhoneNumber());
        System.out.println("------------------------------");

        contactSet = searchService.searchContact("김연경"); // 조회할 이름("류현진")을 파라미터로 넘겨서 조회함
        System.out.println("name: " + contactSet.getName());
        System.out.println("phone number: " + contactSet.getPhoneNumber());
        System.out.println("------------------------------");

    }
}
