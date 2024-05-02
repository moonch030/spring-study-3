package ch05_pjt_01.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String[] args) {
		// 스프링 애플리케이션 컨텍스트를 appCtx.xml 파일로부터 로드합니다.
		GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:appCtx.xml");

		// 초기 샘플 데이터를 위한 InitSampleData 빈 객체를 가져옵니다.
		InitSampleData init = ac.getBean("initSampleData", InitSampleData.class);

		// 초기화된 샘플 데이터의 이름과 전화번호를 각각의 배열로 가져옵니다.
		String[] names = init.getNames();
		String[] phoneNumbers = init.getPhoneNumbers();

		// 연락처 등록 서비스 빈을 가져옵니다.
		ContactRegisterService registerService = ac.getBean("registerService", ContactRegisterService.class);

		// 초기화된 샘플 데이터를 사용하여 연락처를 등록합니다.
		for (int i = 0; i < names.length; i++) {
			ContactSet registerSet = new ContactSet(names[i], phoneNumbers[i]);
			registerService.register(registerSet);
		}

		// 연락처 검색 서비스 빈을 가져옵니다.
		ContactSearchService searchService = ac.getBean("searchService", ContactSearchService.class);

		// 특정 이름으로 연락처를 검색하고 결과를 출력합니다.
		ContactSet contactSet;

		// "류현진"으로 연락처를 검색합니다.
		contactSet = searchService.searchContact("류현진");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

		// "손흥민"으로 연락처를 검색합니다.
		contactSet = searchService.searchContact("손흥민");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

		// "김연경"으로 연락처를 검색합니다.
		contactSet = searchService.searchContact("김연경");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");
	}
}
