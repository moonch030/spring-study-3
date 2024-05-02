package ch06_pjt_01.ems.configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import org.springframework.context.annotation.Bean;

public class MemberConfig2 {
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
}
