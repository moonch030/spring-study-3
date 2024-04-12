package ch05_pjt_01.contact.service;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactSearchService {
    private ContactDao contactDao = null; // ContactDao 참조를 위한 필드
    
    // 기본 생성자
    public ContactSearchService() {
        System.out.println("ContactSearchService의 default Constructor");
    }

    // ContactDao를 파라미터로 받는 생성자, 의존성 주입을 통해 초기화
    public ContactSearchService(ContactDao contactDao) {
        System.out.println("ContactDao 파라미터 하나 가진 ContactSearchService 생성자");
        System.out.println("ContactSearchService에서 contactDao: " + contactDao);
        this.contactDao = contactDao;
    }

    // 이름을 기준으로 연락처 정보를 검색하는 메소드
    public ContactSet searchContact(String name) {
        if (verify(name)) { // 연락처 정보가 존재하는지 확인
            return contactDao.select(name); // 존재한다면 해당 정보 반환
        } else {
            System.out.println("Contact information is not available."); // 존재하지 않는 경우 메시지 출력
        }
        return null;
    }

    // 연락처 정보 존재 여부를 검증하는 메소드
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name); // 이름으로 연락처 정보 조회
        return contactSet != null; // 정보가 있으면 true, 없으면 false 반환
    }

    // ContactDao 객체를 설정하는 메소드
    public void setContactDao(ContactDao contactDao) {
        System.out.println("ContactSearchService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao; // 멤버 변수에 ContactDao 객체 할당
    }
}
