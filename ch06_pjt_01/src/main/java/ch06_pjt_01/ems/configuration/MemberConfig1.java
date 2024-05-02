package ch06_pjt_01.ems.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.dao.StudentDao;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

@Configuration
public class MemberConfig1 {

    /**
     * StudentDao 빈 등록
     *
     * @return StudentDao
     */
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public InitSampleData initSampleData() {
        InitSampleData initSampleData = new InitSampleData();

        initSampleData.setsNums(new String[]{"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"});
        initSampleData.setsIds(new String[]{"rabbit", "hippo", "raccoon", "elephant", "lion"});
        initSampleData.setsPws(new String[]{"p0001", "p0002", "p0003", "p0004", "p0005"});
        initSampleData.setsNames(new String[]{"agatha", "barbara", "chris", "doris", "elva"});
        initSampleData.setsAges(new int[]{19, 22, 20, 27, 19});
        initSampleData.setsGenders(new char[]{'M', 'W', 'W', 'M', 'M'});
        initSampleData.setsMajors(new String[]{
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
     *
     * @return StudentRegisterService
     */
    @Bean
    public StudentRegisterService studentRegisterService() {
        return new StudentRegisterService(studentDao());
    }

    /**
     * StudentModifyService 빈 등록
     *
     * @return StudentModifyService
     */
    @Bean
    public StudentModifyService studentModifyService() {
        return new StudentModifyService(studentDao());
    }

    /**
     * StudentDeleteService 빈 등록
     *
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
     *
     * @return StudentAllSelectService
     */
    @Bean
    public StudentAllSelectService studentAllSelectService() {
        return new StudentAllSelectService(studentDao());
    }

    /**
     * PrintStudentInformationService 빈 등록
     *
     * @return PrintStudentInformationService
     */
    @Bean
    public PrintStudentInformationService printStudentInformationService() {
        return new PrintStudentInformationService(studentAllSelectService());
    }
}