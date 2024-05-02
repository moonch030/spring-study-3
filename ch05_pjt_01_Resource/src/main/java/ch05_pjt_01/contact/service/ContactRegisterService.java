package ch05_pjt_01.contact.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {

    // ContactDao 객체에 대한 참조입니다. @Resource 애너테이션은 의존성 주입을 위해 사용됩니다.
	@Resource
	@Qualifier("contactDao")
    private ContactDao contactDao = null;
    
    // 클래스의 기본 생성자입니다. 생성자 호출 시 콘솔에 메시지를 출력합니다.
    public ContactRegisterService() {
        System.out.println("ContactRegisterService의 default Constructor");
    }
    
    // ContactDao 객체를 파라미터로 받는 생성자입니다. 객체 생성 시, ContactDao 객체에 대한 참조를 저장합니다.
    public ContactRegisterService(ContactDao contactDao) {
        System.out.println("ContactDao 파라미터 하나 가진 ContactRegisterService 생성자");
        System.out.println("ContactRegisterService에서 contactDao: " + contactDao);
        this.contactDao = contactDao;
    }

    // 연락처 정보를 등록하는 메서드입니다. 이름이 이미 등록되어 있지 않으면 연락처를 등록합니다.
    public void register(ContactSet contactSet) {
        String name = contactSet.getName();
        if (verify(name)) {
            contactDao.insert(contactSet);
        } else {
            System.out.println("The name has already registered.");
        }
    }

    // 주어진 이름의 연락처가 이미 등록되어 있는지 확인합니다. 등록되지 않았다면 true를 반환합니다.
    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet == null ? true : false;
    }
    
    // ContactDao의 setter 메서드입니다. 의존성 주입을 위해 @Resource 애너테이션을 사용합니다.
//    @Resource
    public void setContactDao(ContactDao contactDao) {
        System.out.println("ContactRegisterService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao;
    }

    // setWordDao라는 메서드는 이름이 잘못 지정되어 있습니다. 이는 ContactDao 객체의 setter로 동작합니다.
//    @Resource
    public void setWordDao(ContactDao contactDao) {
        System.out.println("ContactRegisterService의 setWordDao 메서드 호출됨.");
        this.contactDao = contactDao;
    }
}
