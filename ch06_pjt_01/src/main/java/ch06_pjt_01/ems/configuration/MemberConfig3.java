package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.dao.StudentDao;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

// applicationContext.xml 설정파일 처럼 스프링 빈 설정 파일을 만들 때 붙히는 어노테이션
@Configuration
public class MemberConfig3 {
	
	@Autowired
	DBConnectionInfo dev_DBConnectionInfoDev;
	@Autowired
	DBConnectionInfo real_DBConnectionInfo;
    /**
     * StudentDao 빈 등록
     * @return StudentDao
     */
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public InitSampleData initSampleData() {
        InitSampleData initSampleData = new InitSampleData();

        initSampleData.setsNums(new String[] {"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"});
        initSampleData.setsIds(new String[] {"rabbit", "hippo", "raccoon", "elephant", "lion"});
        initSampleData.setsPws(new String[] {"p0001", "p0002", "p0003", "p0004", "p0005"});
        initSampleData.setsNames(new String[] {"agatha", "barbara", "chris", "doris", "elva"});
        initSampleData.setsAges(new int[] {19, 22, 20, 27, 19});
        initSampleData.setsGenders(new char[] {'M', 'W', 'W', 'M', 'M'});
        initSampleData.setsMajors(new String[] {
                "English Literature",
                "Korean Language and Literature",
                "French Language and Literature",
                "Philosophy",
                "History"
        });

        return initSampleData;
    }

    /**
     * StudentRegisterService 빈 등록
     * @return StudentRegisterService
     */
    @Bean
    public StudentRegisterService studentRegisterService() {
        return new StudentRegisterService(studentDao());
    }

    /**
     * StudentModifyService 빈 등록
     * @return StudentModifyService
     */
    @Bean
    public StudentModifyService studentModifyService() {
        return new StudentModifyService(studentDao());
    }

    /**
     * StudentDeleteService 빈 등록
     * @return StudentDeleteService
     */
    @Bean
    public StudentDeleteService studentDeleteService() {
        return new StudentDeleteService(studentDao());
    }

    @Bean
    public StudentSelectService studentSelectService() {
        return new StudentSelectService(studentDao());
    }
    /**
     * StudentAllSelectService 빈 등록
     * @return StudentAllSelectService
     */
    @Bean
    public StudentAllSelectService studentAllSelectService() {
        return new StudentAllSelectService(studentDao());
    }

    /**
     * PrintStudentInformationService 빈 등록
     * @return PrintStudentInformationService
     */
    @Bean
    public PrintStudentInformationService printStudentInformationService() {
        return new PrintStudentInformationService(studentAllSelectService());
    }

    /**
     * dev_DBConnectionInfoDev 빈 등록
     * @return dbConnectionInfo
     */
    @Bean
    public DBConnectionInfo dev_DBConnectionInfoDev() {
        DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
        dbConnectionInfo.setUrl("000.000.000.000");
        dbConnectionInfo.setUserId("admin");
        dbConnectionInfo.setUserPw("0000");

        return dbConnectionInfo;
    }

    /**
     * real_DBConnectionInfo 빈 등록
     * @return dbConnectionInfo
     */
    @Bean
    public DBConnectionInfo real_DBConnectionInfo() {
        DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
        dbConnectionInfo.setUrl("111.111.111.111");
        dbConnectionInfo.setUserId("master");
        dbConnectionInfo.setUserPw("1111");

        return dbConnectionInfo;
    }

    /**
     * emsInformationService 빈 등록
     * @return emsInformationService
     */
    @Bean
    public EMSInformationService emsInformationService() {
        EMSInformationService emsInformationService = new EMSInformationService();
        emsInformationService.setInfo("Education Management System program was developed in 2022.");
        emsInformationService.setCopyRight("COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
        emsInformationService.setVer("The version is 1.0");
        emsInformationService.seteYear(2022);
        emsInformationService.seteMonth(4);
        emsInformationService.seteDay(30);

        List<String> developers = new ArrayList<>();
        developers.add("Cheney.");
        developers.add("Eloy.");
        developers.add("Jasper.");
        developers.add("Dillon.");
        developers.add("Kian.");
        emsInformationService.setDevelopers(developers);

        Map<String, String> administrators = new HashMap<>();
        administrators.put("Cheney", "cheney@springPjt.org");
        administrators.put("Jasper", "jasper@springPjt.org");
        emsInformationService.setAdministrators(administrators);

        Map<String, DBConnectionInfo> dbInfos = new HashMap<>();
        dbInfos.put("dev", dev_DBConnectionInfoDev);
        dbInfos.put("real", real_DBConnectionInfo);
        emsInformationService.setDbInfos(dbInfos);

        return emsInformationService;
    }
}
