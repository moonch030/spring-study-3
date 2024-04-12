package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01.contact.ContactSet;

public class ContactDao {

	private Map<String, ContactSet> contactDB = 
		      new HashMap<String, ContactSet>(); // 연락처 정보를 저장할 HashMap 객체 생성

	// 연락처 정보를 HashMap에 저장하는 메소드
	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}

	// 주어진 이름에 해당하는 연락처 정보를 HashMap에서 검색하여 반환하는 메소드
	public ContactSet select(String name) {
		return contactDB.get(name);
	}

	// 현재 저장된 모든 연락처 정보를 반환하는 메소드
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
	}
}
