package ch05_pjt_01.contact.service;

import org.springframework.beans.factory.annotation.Autowired;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactSearchService {
	
    @Autowired
    private ContactDao contactDao = null; // ContactDao 객체에 대한 자동 주입을 선언
    
    // 기본 생성자
    public ContactSearchService() {
        System.out.println("ContactSearchService 의 default Constructor");    
    }

    // ContactDao 객체를 파라미터로 받는 생성자
    public ContactSearchService(ContactDao contactDao) {
        System.out.println("ContactDao 파라미터 하나 가진 ContactSearchService 생성자");
        System.out.println("ContactSearchService에서 contactDao: " + contactDao);
        this.contactDao = contactDao;
    }

    // 주어진 이름으로 연락처를 검색하는 메소드
    public ContactSet searchContact(String name) {
        if (verify(name)) { // 검증 메소드를 통해 연락처 존재 여부 확인
            return contactDao.select(name); // 존재하면 해당 연락처 반환
        } else {
            System.out.println("Contact information is not available."); // 존재하지 않으면 경고 메시지 출력
        }
        return null;
    }

    // 연락처 존재 여부를 검증하는 메소드
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name); // 연락처 정보를 조회
        return contactSet != null; // 연락처가 존재하면 true, 그렇지 않으면 false 반환
    }

    // ContactDao 객체를 설정하는 메소드
    public void setContactDao(ContactDao contactDao) {
        System.out.println("ContactSearchService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao; // ContactDao 객체를 설정
    }
}
