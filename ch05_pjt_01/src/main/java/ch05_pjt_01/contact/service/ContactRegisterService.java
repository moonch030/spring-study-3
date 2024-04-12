package ch05_pjt_01.contact.service;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {

	private ContactDao contactDao; // ContactDao 객체를 저장할 변수 선언
    
    // 기본 생성자: 객체가 생성될 때 호출됩니다.
    public ContactRegisterService() {
       System.out.println("ContactRegisterService의 default Constructor");    
    }
    
    // ContactDao를 파라미터로 받는 생성자: 외부에서 ContactDao 객체를 주입받습니다.
    public ContactRegisterService(ContactDao contactDao) {
       System.out.println("ContactDao 파라미터 하나 가진 ContactRegisterService 생성자");
       System.out.println("ContactRegisterService에서 contactDao: " + contactDao); // contactDao 객체 출력
        this.contactDao = contactDao; // 멤버 변수에 ContactDao 객체 할당
    }

    // 연락처를 등록하는 메서드
    public void register(ContactSet contactSet) {
        String name = contactSet.getName();
        if (verify(name)) { // 연락처 이름이 중복되지 않는 경우
            contactDao.insert(contactSet); // ContactDao를 통해 연락처 정보 저장
        } else { // 이미 등록된 이름인 경우
            System.out.println("The name has already registered.");
        }
    }

    // 연락처 이름의 중복 여부를 검사하는 메서드
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name); // 이름으로 연락처 정보 조회
        return contactSet == null ? true : false; // 조회 결과가 null이면 중복 없음(true), 그렇지 않으면 중복 있음(false)
    }
    

    // ContactDao 객체를 설정하는 메서드
    public void setContactDao(ContactDao contactDao) {
       System.out.println("ContactRegisterService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao; // 멤버 변수에 ContactDao 객체 할당
    }

    // 중복된 기능을 하는 또 다른 ContactDao 설정 메서드
    public void setWordDao(ContactDao contactDao) {
       System.out.println("ContactRegisterService의 setWordDao 메서드 호출됨.");
        this.contactDao = contactDao; // 멤버 변수에 ContactDao 객체 할당
    }
}
