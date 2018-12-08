package ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ems.member.dao.StudentDao;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration
@Import({MemberConfig2.class, MemberConfig3.class})
public class MemberConfigImport {

	/**
	 * xml 파일이 아닌 java 파일로 작성한 스프링컨테이너로 작성
	 *
	 * xml 파일로 import 하는 것 처럼 class로 만드는 스프링 컨테이너도 import 해서 사용 할 수 있다.
	 *
	 * @import annotation을 사용한다.
	 *
	 * 밑의 예제는 Dao, 서비스에 대한 Bean을 선언한 상태이고, 나머지 DB 연결, 개발자 정보에 대한 Bean들은 import 해서 사용한다.
	 * */
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
}