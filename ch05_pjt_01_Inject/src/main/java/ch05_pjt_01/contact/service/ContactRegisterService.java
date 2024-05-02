package ch05_pjt_01.contact.service;

import javax.inject.Inject;
import javax.inject.Named;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {

    // 의존 관계 자동 주입을 위한 어노테이션 추가
//    @Inject
//    @Named("contactDao3")
    private ContactDao contactDao; // ContactDao 객체를 참조하기 위한 변수 선언

    // 기본 생성자
    public ContactRegisterService() {
        System.out.println("ContactRegisterService의 default Constructor"); // 기본 생성자 출력
    }

    // ContactDao를 파라미터로 받는 생성자
    // 생성자를 통해 ContactDao 객체를 초기화하는 방법 중 하나
    @Inject
    @Named("contactDao3")
    public ContactRegisterService(ContactDao contactDao) {
        System.out.println("ContactDao 파라미터 하나 가진 ContactRegisterService 생성자");
        System.out.println("ContactRegisterService에서 contactDao: " + contactDao); // contactDao 출력
        this.contactDao = contactDao; // 인자로 받은 contactDao로 클래스 변수 초기화
    }

    // 연락처를 등록하는 메서드
    public void register(ContactSet contactSet) {
        String name = contactSet.getName();

        if (verify(name)) {
            contactDao.insert(contactSet); // ContactDao를 통해 연락처 등록
        } else {
            System.out.println("The name has already registered."); // 이미 등록된 이름인 경우 메시지 출력
        }
    }

    // 이름을 검증하는 메서드
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name); // ContactDao를 통해 이름으로 연락처 검색
        return contactSet == null ? true : false; // 연락처가 존재하지 않으면 true, 그렇지 않으면 false 반환
    }

    // ContactDao를 설정하는 메서드
//    @Inject
    public void setContactDao(ContactDao contactDao) {
        System.out.println("ContactRegisterService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao; // 주입받은 contactDao로 클래스 변수 초기화
    }

    // ContactDao를 설정하는 메서드
//    @Inject
    public void setWordDao(ContactDao contactDao) {
        System.out.println("ContactRegisterService의 setWordDao 메서드 호출됨.");
        this.contactDao = contactDao; // 주입받은 contactDao로 클래스 변수 초기화
    }
}
