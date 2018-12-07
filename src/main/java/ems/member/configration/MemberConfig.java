package ems.member.configration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml 스프링 컨테이너를 java 소스로 작성
 * applicationContext.xml -> MemberConfig.class*/

@Configuration // MemberConfig이 스프링설정파일으로써 스프링 컨테이너를 생성하겠다는 annotation
public class MemberConfig {

	// <bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
	@Bean // 이것을 Bean으로 사용하겠다.
	public StudentDao studentDao(){ // 반환형은 StudentDao, 함수명은 id 값
		return new StudentDao(); // 반환 할 때 새로운 객체 return
	}

	/*
	<bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	*/
	@Bean
	public StudentRegisterService registerService(){
		return new StudentRegisterService(studentDao()); // 생성자로 studentDao를 넘겨준다.
	}

	@Bean
	public StudentModifyService modifyService(){
		return new StudentModifyService(studentDao()); // 생성자로 studentDao를 넘겨준다.
	}

	@Bean
	public StudentDeleteService deleteService(){
		return new StudentDeleteService(studentDao()); // 생성자로 studentDao를 넘겨준다.
	}

	@Bean
	public StudentSelectService selectService(){
		return new StudentSelectService(studentDao()); // 생성자로 studentDao를 넘겨준다.
	}

	@Bean
	public StudentAllSelectService allSelectService(){
		return new StudentAllSelectService(studentDao()); // 생성자로 studentDao를 넘겨준다.
	}

	/*
	-----------------------------------------------------------------------------------------------
	 <bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	 </bean>
	*/
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev(){
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("scott");
		infoDev.setUserPw("tiger");
		return infoDev;
	}


	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal(){
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoReal.setUserId("masterid");
		infoReal.setUserPw("masterpw");
		return infoReal;
	}

	@Bean
	public EMSInformationService informationService(){
		EMSInformationService emsInformationService = new EMSInformationService();
		emsInformationService.setInfo("Education Management System program was developed in 2015.");
		emsInformationService.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		emsInformationService.setVer("The version is 1.0");
		emsInformationService.setsYear(2015);
		emsInformationService.setsMonth(1);
		emsInformationService.setsDay(1);
		emsInformationService.seteYear(2015);
		emsInformationService.seteMonth(2);
		emsInformationService.seteDay(28);

		List<String> developers = new ArrayList<>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian,");
		emsInformationService.setDevelopers(developers);

		Map<String, String> administrators = new HashMap<>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		emsInformationService.setAdministrators(administrators);

		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<>();
		dbInfos.put("dev",dataBaseConnectionInfoDev());
		dbInfos.put("real",dataBaseConnectionInfoReal());
		emsInformationService.setDbInfos(dbInfos);

		return emsInformationService;

	}
}