package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;
import ch05_pjt_01.contact.ContactSet;

public class ContactDao {

    // 연락처 정보를 저장하는 HashMap. 키는 연락처의 이름, 값은 ContactSet 객체입니다.
    private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();

    // 연락처 정보를 추가하는 메서드. 연락처 이름을 키로 하여 ContactSet 객체를 저장합니다.
    public void insert(ContactSet contactSet) {
        contactDB.put(contactSet.getName(), contactSet);
    }

    // 주어진 이름에 해당하는 연락처 정보를 조회하는 메서드. 이름을 키로 사용하여 ContactSet 객체를 반환합니다.
    public ContactSet select(String name) {
        return contactDB.get(name);
    }

    // 전체 연락처 데이터베이스를 반환하는 메서드. 외부에서 연락처 데이터 전체에 접근할 때 사용할 수 있습니다.
    public Map<String, ContactSet> getContactDB() {
        return contactDB;
    }
}
