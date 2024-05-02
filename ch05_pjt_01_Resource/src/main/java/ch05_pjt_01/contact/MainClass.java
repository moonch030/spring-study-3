package ch05_pjt_01.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String[] args) {
		// Spring Framework에서 제공하는 XML 기반의 애플리케이션 컨텍스트를 로드합니다. 이 컨텍스트는 의존성 주입과 빈(bean) 관리를 수행합니다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		// 'initSampleData' 빈을 가져옵니다. 이 객체는 초기 연락처 데이터를 제공합니다.
		InitSampleData initob = ctx.getBean("initSampleData", InitSampleData.class);

		// InitSampleData 객체에서 이름 배열을 가져옵니다.
		String[] names = initob.getNames();

		// InitSampleData 객체에서 전화번호 배열을 가져옵니다.
		String[] phoneNumbers = initob.getPhoneNumbers();

		// 'registerService' 빈을 가져옵니다. 이 서비스는 연락처 데이터를 등록하는 기능을 수행합니다.
		ContactRegisterService obregis = ctx.getBean("registerService", ContactRegisterService.class);

		// 이름과 전화번호 배열을 반복하며 각 연락처를 등록합니다.
		for(int i=0; i<names.length; ++i) {
		    ContactSet cs = new ContactSet(names[i], phoneNumbers[i]);
		    obregis.register(cs);
		}

		// 'searchService' 빈을 가져옵니다. 이 서비스는 주어진 이름으로 연락처를 검색하는 기능을 수행합니다.
		ContactSearchService obcss = ctx.getBean("searchService", ContactSearchService.class);

		// 이름 '류현진'으로 연락처를 검색하고 결과를 출력합니다.
		ContactSet contactSet = obcss.searchContact("류현진");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

		// 이름 '김연경'으로 연락처를 검색하고 결과를 출력합니다.
		contactSet = obcss.searchContact("김연경");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

		// 이름 '손흥민'으로 연락처를 검색하고 결과를 출력합니다.
		contactSet = obcss.searchContact("손흥민");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

	      	      
	   }
}
