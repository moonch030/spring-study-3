package ch05_pjt_01.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String[] args) {
	      GenericXmlApplicationContext ctx = 
	    		  new GenericXmlApplicationContext("classpath:appCtx.xml");
	      
	      InitSampleData initob =
	    		  ctx.getBean("initSampleData",InitSampleData.class);
	      String[] names = initob.getNames();
	      String[] phoneNumbers = initob.getPhoneNumbers();
	      
	      ContactRegisterService obregis =
	    		  ctx.getBean("registerService",ContactRegisterService.class);
	      
	      for(int i=0;i<names.length;++i) {
	    	  ContactSet cs = new ContactSet(names[i],phoneNumbers[i]);
	    	  obregis.register(cs);
	      }
	      
	      ContactSearchService obcss =
	    		  ctx.getBean("searchService",ContactSearchService.class);
	      ContactSet contactSet = obcss.searchContact("류현진");
	      
	      System.out.println("name: " + contactSet.getName());
	      System.out.println("phone number: " + contactSet.getPhoneNumber());
	      System.out.println("------------------------------");
	        
	      contactSet = obcss.searchContact("김연경");
		  System.out.println("name: " + contactSet.getName());
		  System.out.println("phone number: " + contactSet.getPhoneNumber());
		  System.out.println("------------------------------");
		  
		  contactSet = obcss.searchContact("손흥민");
		  System.out.println("name: " + contactSet.getName());
		  System.out.println("phone number: " + contactSet.getPhoneNumber());
		  System.out.println("------------------------------");
	      	      
	   }
}
