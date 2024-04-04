package ch04_pjt_02.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:applicationContext.xml");

		DependencyBean dependencyBean_01 = 
			ctx.getBean("dependencyBean", DependencyBean.class);
		DependencyBean dependencyBean_02 = 
			ctx.getBean("dependencyBean", DependencyBean.class);

		/*
		 * if (dependencyBean_01.equals(dependencyBean_02)) {
		 * System.out.println("dependencyBean_01과 dependencyBean_02가 똑같다");
		 * 
		 * } else { System.out.println("dependencyBean_01 != dependencyBean_02");
		 * 
		 * }
		 */
		
		if (dependencyBean_01 == dependencyBean_02 ) {
	         System.out.println(
	            "dependencyBean_01과 dependencyBean_02 가 똑같다");
	         System.out.println("dependencyBean_01 =" + 
	               dependencyBean_01 );
	         System.out.println("dependencyBean_02 =" + 
	               dependencyBean_02 );

	      } else {
	         System.out.println(
	            "dependencyBean_01 != dependencyBean_02");
	         System.out.println("dependencyBean_01 =" + 
	               dependencyBean_01 );
	         System.out.println("dependencyBean_02 =" + 
	               dependencyBean_02 );
	      }

		ctx.close();

	}

}