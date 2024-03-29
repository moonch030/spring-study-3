package ch03_pjt_02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		TransportationWalk tw = new TransportationWalk();
//		tw.move();
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk obtw = ctx.getBean("tw",TransportationWalk.class);
		
		obtw.move();
		ctx.close();
	}

}
