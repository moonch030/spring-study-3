package ch05_pjt_01.contact.utils;

public class InitSampleData {

    private String[] names; // 이름 배열
    private String[] phoneNumbers; // 전화번호 배열

    // 기본 생성자
    public InitSampleData() {
        System.out.println("InitSampleData의 기본 생성자");
    }

    // 이름 배열을 반환하는 메서드
    public String[] getNames() {
        return names;
    }

    // 이름 배열을 설정하는 메서드
    public void setNames(String[] names) {
        this.names = names;
    }

    // 전화번호 배열을 반환하는 메서드
    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    // 전화번호 배열을 설정하는 메서드
    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
