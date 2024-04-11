package ch04_pjt_02.scope;

public class DependencyBean {
    
	 // InjectionBean 타입의 변수 injectionBean을 선언. 이 변수는 DependencyBean 객체가 의존하는 객체를 참조하기 위해 사용
    InjectionBean injectionBean;
    
    // DependencyBean 클래스의 생성자. 이 생성자는 InjectionBean 타입의 객체를 매개변수로 받아,
    // 클래스 내부의 injectionBean 변수에 할당. 이 과정을 통해 의존성 주입이 이루어짐.
    public DependencyBean(InjectionBean injectionBean) {
        
        // this 키워드를 사용하여 클래스 내부의 injectionBean 변수를 가리키며,
        // 매개변수로 받은 injectionBean 객체를 내부 변수에 할당.
        this.injectionBean = injectionBean;
    }
}