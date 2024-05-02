package ch05_pjt_01.contact;

public class ContactSet {
    private String name; // 이름
    private String phoneNumber; // 전화번호

    // 이름과 전화번호를 인자로 받는 생성자
    public ContactSet(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // 이름을 반환하는 메서드
    public String getName() {
        return name;
    }

    // 이름을 설정하는 메서드
    public void setName(String name) {
        this.name = name;
    }

    // 전화번호를 반환하는 메서드
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // 전화번호를 설정하는 메서드
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }  
}
