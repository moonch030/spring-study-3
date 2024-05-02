package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01.contact.ContactSet;

public class ContactDao {

    private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>(); // 연락처를 저장하기 위한 Map

    // 연락처를 추가하는 메서드
    public void insert(ContactSet contactSet) {
        contactDB.put(contactSet.getName(), contactSet); // 이름을 키로 하여 연락처를 저장
    }

    // 이름을 기준으로 연락처를 검색하는 메서드
    public ContactSet select(String name) {
        return contactDB.get(name); // 이름을 키로 하여 연락처를 검색하여 반환
    }

    // 연락처 Map을 반환하는 메서드
    public Map<String, ContactSet> getContactDB() {
        return contactDB; // 연락처 Map 반환
    }
}
