package ch04_pjt_01.ems.member;

// 데이터베이스 연결 정보 클래스
public class DBConnectionInfo {
    
    private String url;     // 데이터베이스 URL
    private String userId;  // 사용자 ID
    private String userPw;  // 사용자 비밀번호
    
    // 기본 생성자
    public DBConnectionInfo() {
        
    }
    
    // URL getter
    public String getUrl() {
        return url;
    }
    
    // URL setter
    public void setUrl(String url) {
        this.url = url;
    }
    
    // 사용자 ID getter
    public String getUserId() {
        return userId;
    }
    
    // 사용자 ID setter
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    // 사용자 비밀번호 getter
    public String getUserPw() {
        return userPw;
    }
    
    // 사용자 비밀번호 setter
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }   
}
