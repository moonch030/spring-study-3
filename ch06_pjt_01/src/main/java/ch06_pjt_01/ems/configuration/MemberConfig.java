package ch06_pjt_01.ems.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.dao.StudentDao;

@Configuration
public class MemberConfig {
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
}
