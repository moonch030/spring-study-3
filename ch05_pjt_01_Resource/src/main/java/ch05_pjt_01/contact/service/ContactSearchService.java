package ch05_pjt_01.contact.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactSearchService {
	
     @Resource
     @Qualifier("contactDao")
    private ContactDao contactDao = null; // ContactDao 객체를 참조하기 위한 변수 선언
	
    // 기본 생성자
    public ContactSearchService() {
        System.out.println("ContactSearchService의 default Constructor");
    }
	
    // ContactDao를 파라미터로 받는 생성자
    // 생성자를 통해 ContactDao 객체를 초기화하는 방법 중 하나
    // 주로 의존성 주입을 위해 사용됨
    // @Autowired 어노테이션을 사용할 수도 있음
    public ContactSearchService(ContactDao contactDao) {
        System.out.println("ContactDao 파라미터 하나 가진 ContactSearchService 생성자");
        System.out.println("ContactSearchService에서 contactDao: " + contactDao); // contactDao 출력
        this.contactDao = contactDao; // 인자로 받은 contactDao로 클래스 변수 초기화
    }
	
    // 이름을 이용하여 연락처를 검색하는 메서드
    public ContactSet searchContact(String name) {
        if (verify(name)) {
            return contactDao.select(name); // ContactDao를 통해 연락처 검색
        } else {
            System.out.println("Contact information is not available."); // 연락처 정보를 찾을 수 없는 경우
        }

        return null; // 검색 결과가 없는 경우 null 반환
    }
	
    // 이름을 검증하는 메서드
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name); // ContactDao를 통해 이름으로 연락처 검색
        return contactSet != null ? true : false; // 연락처가 존재하면 true, 그렇지 않으면 false 반환
    }
	
    // ContactDao를 설정하는 메서드
    // 주로 의존성 주입을 위해 사용되는 setter 메서드
//    @Resource
    public void setContactDao(ContactDao contactDao) {
        System.out.println("ContactSearchService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao; // 주입받은 contactDao로 클래스 변수 초기화
    }
}
