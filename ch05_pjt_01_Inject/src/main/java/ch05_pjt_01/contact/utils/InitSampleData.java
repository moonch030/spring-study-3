package ch05_pjt_01.contact.utils;

public class InitSampleData {

     // 이름을 저장하는 문자열 배열
     private String[] names;
     // 전화번호를 저장하는 문자열 배열
     private String[] phoneNumbers;

     // 기본 생성자: 객체 생성 시 콘솔에 메시지를 출력합니다.
     public InitSampleData() {
         System.out.println("InitSampleData.InitSampleData");
     }

     // 이름 배열을 반환하는 getter 메서드
     public String[] getNames() {
         return names;
     }

     // 이름 배열을 설정하는 setter 메서드
     public void setNames(String[] names) {
         this.names = names;
     }

     // 전화번호 배열을 반환하는 getter 메서드
     public String[] getPhoneNumbers() {
         return phoneNumbers;
     }

     // 전화번호 배열을 설정하는 setter 메서드
     public void setPhoneNumbers(String[] phoneNumbers) {
         this.phoneNumbers = phoneNumbers;
     }
}
