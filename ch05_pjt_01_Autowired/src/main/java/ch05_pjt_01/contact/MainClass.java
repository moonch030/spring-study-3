package ch05_pjt_01.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String[] args) {
	    // 스프링 컨텍스트를 초기화하고, XML 설정 파일을 로드합니다.
	    GenericXmlApplicationContext ctx = 
	    		  new GenericXmlApplicationContext("classpath:appCtx.xml");
	      
	    // 초기 샘플 데이터 로드
	    InitSampleData initob =
	    		  ctx.getBean("initSampleData", InitSampleData.class);
	    String[] names = initob.getNames();
	    String[] phoneNumbers = initob.getPhoneNumbers();
	      
	    // 연락처 등록 서비스 객체를 가져옵니다.
	    ContactRegisterService obregis =
	    		  ctx.getBean("registerService", ContactRegisterService.class);
	      
	    // 초기 데이터로 연락처 정보를 등록합니다.
	    for(int i = 0; i < names.length; ++i) {
	    	  ContactSet cs = new ContactSet(names[i], phoneNumbers[i]);
	    	  obregis.register(cs);
	    }
	      
	    // 연락처 검색 서비스 객체를 가져옵니다.
	    ContactSearchService obcss =
	    		  ctx.getBean("searchService", ContactSearchService.class);
	      
	    // "류현진"에 해당하는 연락처를 검색하고 출력합니다.
	    ContactSet contactSet = obcss.searchContact("류현진");
	    System.out.println("name: " + contactSet.getName());
	    System.out.println("phone number: " + contactSet.getPhoneNumber());
	    System.out.println("------------------------------");
	        
	    // "김연경"에 해당하는 연락처를 검색하고 출력합니다.
	    contactSet = obcss.searchContact("김연경");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");
		  
		// "손흥민"에 해당하는 연락처를 검색하고 출력합니다.
		contactSet = obcss.searchContact("손흥민");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");
	}
}
