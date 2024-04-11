package ch04_pjt_02.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/*
		 * if (dependencyBean_01.equals(dependencyBean_02)) {
		 * System.out.println("dependencyBean_01과 dependencyBean_02가 똑같다");
		 * 
		 * } else { System.out.println("dependencyBean_01 != dependencyBean_02");
		 * 
		 * }
		 */

	        // Spring 설정 파일을 로딩하여 애플리케이션 컨텍스트를 초기화. 설정 파일은 'applicationContext.xml'.
			GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");

	        // applicationContext.xml 파일에 정의된 'dependencyBean' 이름을 가진 Bean을 가져옴.
	        // 가져온 Bean은 DependencyBean 타입으로 캐스팅.
			DependencyBean dependencyBean_01 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
			DependencyBean dependencyBean_02 = 
				ctx.getBean("dependencyBean", DependencyBean.class);

	        // dependencyBean_01과 dependencyBean_02가 실제로 같은 객체인지 비교
	        // '==' 연산자를 사용하여 두 객체의 참조가 같은지 확인.
			if (dependencyBean_01 == dependencyBean_02 ) {
		        System.out.println("dependencyBean_01과 dependencyBean_02 가 똑같다");
		        System.out.println("dependencyBean_01 =" + 
		               dependencyBean_01 );
		        System.out.println("dependencyBean_02 =" + 
		               dependencyBean_02 );

		    } else {
		        System.out.println("dependencyBean_01 != dependencyBean_02");
		        System.out.println("dependencyBean_01 =" + 
		               dependencyBean_01 );
		        System.out.println("dependencyBean_02 =" + 
		               dependencyBean_02 );
		    }

	        // 애플리케이션 컨텍스트를 닫음. 이로써 리소스를 정리하고 종료.
			ctx.close();

	}

}