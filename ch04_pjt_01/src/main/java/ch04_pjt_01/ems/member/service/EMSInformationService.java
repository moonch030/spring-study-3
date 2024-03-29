package ch04_pjt_01.ems.member.service;

import java.util.List;
import java.util.Map;

import ch04_pjt_01.ems.member.DBConnectionInfo;

// EMS 정보 제공 서비스 클래스
public class EMSInformationService {

    private String info;                     // EMS 정보
    private String copyRight;                // 저작권 정보
    private String ver;                      // 버전 정보
    private int sYear;                       // 개발 시작 연도
    private int sMonth;                      // 개발 시작 월
    private int sDay;                        // 개발 시작 일
    private int eYear;                       // 개발 종료 연도
    private int eMonth;                      // 개발 종료 월
    private int eDay;                        // 개발 종료 일
    private List<String> developers;         // 개발자 목록
    private Map<String, String> administrators;  // 관리자 목록
    private Map<String, DBConnectionInfo> dbInfos;  // DB 연결 정보 목록
    
    // EMS 정보 출력 메서드
    public void printEMSInformation() {
        System.out.println("EMS INFORMATION START ----------");
        String devPeriod = sYear + "/" + sMonth + "/" + sDay + " ~ " + eYear + "/" + eMonth + "/" + eDay;
        System.out.println(info + "(" + devPeriod + ")");
        System.out.println(copyRight);
        System.out.println(ver);
        System.out.println("Developers: " + developers);
        System.out.println("Administrator: " + administrators);
//      printDBInfo(); // 나중에 추가
        System.out.println("END ----------------------------");
    }
}
