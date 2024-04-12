package ch05_pjt_01.contact.service;

import org.springframework.beans.factory.annotation.Autowired;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {

    @Autowired
    private ContactDao contactDao = null; // ContactDao 객체에 대한 의존성 주입

    // 기본 생성자: 객체 생성 시 로그를 출력
    public ContactRegisterService() {
        System.out.println("ContactRegisterService의 default Constructor");
    }

    // ContactDao 파라미터를 받는 생성자: 의존성 주입을 통해 ContactDao 객체를 설정
    public ContactRegisterService(ContactDao contactDao) {
        System.out.println("ContactDao 파라미터 하나 가진 ContactRegisterService 생성자");
        System.out.println("ContactRegisterService에서 contactDao: " + contactDao);
        this.contactDao = contactDao;
    }

    // 연락처 정보를 등록하는 메소드
    public void register(ContactSet contactSet) {
        String name = contactSet.getName();
        if (verify(name)) { // 연락처 이름이 중복되지 않는 경우
            contactDao.insert(contactSet); // ContactDao를 통해 연락처 정보 저장
        } else {
            System.out.println("The name has already registered.");
        }
    }

    // 연락처 이름의 중복 여부를 검사하는 메소드
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name); // 이름으로 연락처 정보 조회
        return contactSet == null; // 조회 결과가 null이면 중복 없음(true), 그렇지 않으면 중복 있음(false)
    }

    // ContactDao 객체를 설정하는 메소드
    public void setContactDao(ContactDao contactDao) {
        System.out.println("ContactRegisterService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao;
    }

    // 중복된 기능을 하는 또 다른 ContactDao 설정 메서드
    public void setWordDao(ContactDao contactDao) {
        System.out.println("ContactRegisterService의 setWordDao 메서드 호출됨.");
        this.contactDao = contactDao;
    }
}
