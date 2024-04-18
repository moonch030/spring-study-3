package ch06_pjt_01.ems.member;

// 학생 클래스
public class Student {

    private String sNum;     // 학번
    private String sId;      // 학생 ID
    private String sPw;      // 비밀번호
    private String sName;    // 이름
    private int sAge;        // 나이
    private char sGender;    // 성별
    private String sMajor;   // 전공
    
    // 기본 생성자
    public Student() {
        
    }
    
    // 생성자
    public Student(String sNum, String sId, String sPw, 
            String sName, int sAge, 
            char sGender, String sMajor) 
    {
       this.sNum = sNum;
       this.sId = sId;
       this.sPw = sPw;
       this.sName = sName;
       this.sAge = sAge;
       this.sGender = sGender;
       this.sMajor = sMajor;
    }

    // 학번 getter
    public String getsNum() {
        return sNum;
    }

    // 학번 setter
    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    // 학생 ID getter
    public String getsId() {
        return sId;
    }

    // 학생 ID setter
    public void setsId(String sId) {
        this.sId = sId;
    }

    // 비밀번호 getter
    public String getsPw() {
        return sPw;
    }

    // 비밀번호 setter
    public void setsPw(String sPw) {
        this.sPw = sPw;
    }

    // 이름 getter
    public String getsName() {
        return sName;
    }

    // 이름 setter
    public void setsName(String sName) {
        this.sName = sName;
    }

    // 나이 getter
    public int getsAge() {
        return sAge;
    }

    // 나이 setter
    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    // 성별 getter
    public char getsGender() {
        return sGender;
    }

    // 성별 setter
    public void setsGender(char sGender) {
        this.sGender = sGender;
    }

    // 전공 getter
    public String getsMajor() {
        return sMajor;
    }

    // 전공 setter
    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }   
}
