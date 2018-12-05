package ems.member.assembler;

import ems.member.dao.StudentDao;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class StudentAssembler {

	private StudentDao studentDao;
	private StudentRegisterService registerService;
	private StudentModifyService modifyService;
	private StudentDeleteService deleteService;
	private StudentSelectService selectService;
	private StudentAllSelectService allSelectService;
	
	public StudentAssembler() {
		/**
		 * studentDao 인스턴스를 만들어서 의존성 주입을 해줬기 때문에
		 *
		 * 각각의 다른 서비스에서도 한번 등록했던 데이터들을 공통으로 사용할 수 있다.
		 *
		 * 만약 밑에 있는 서비스들에 지금처럼이 아니라 DI 프로그래밍이 아닌 각 서비스 마다 DAO 클래스 인스턴스를 만들어주면
		 *
		 * DB 서비스를 이용할 수 없다. (왜냐면 각 서비스를 불러올때마다 새로운 객체가 생성되기 때문에..)
		 */
		studentDao = new StudentDao(); // StudentAssembler 인스턴스를 만들때 StudentDao 인스턴스 를 일단 만들어줌
		/**
		 * 여기서 생성자를 통한 의존성 주입을 하고 있다. DI(studentDao)
		 *
		 * studentDao 변수는 레퍼런스 변수 (참조 변수, 객체) 이기 때문에 값이 수정되면 밑의 서비스들 에게도 적용이 된다.
		 * */
		registerService = new StudentRegisterService(studentDao); // 각각의 서비스에 Dao 정보를 의존성 주입을 해줌
		modifyService = new StudentModifyService(studentDao);
		deleteService = new StudentDeleteService(studentDao);
		selectService = new StudentSelectService(studentDao);
		allSelectService = new StudentAllSelectService(studentDao);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public StudentRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(StudentRegisterService registerService) {
		this.registerService = registerService;
	}

	public StudentModifyService getModifyService() {
		return modifyService;
	}

	public void setModifyService(StudentModifyService modifyService) {
		this.modifyService = modifyService;
	}

	public StudentDeleteService getDeleteService() {
		return deleteService;
	}

	public void setDeleteService(StudentDeleteService deleteService) {
		this.deleteService = deleteService;
	}

	public StudentSelectService getSelectService() {
		return selectService;
	}

	public void setSelectService(StudentSelectService selectService) {
		this.selectService = selectService;
	}

	public StudentAllSelectService getAllSelectService() {
		return allSelectService;
	}

	public void setAllSelectService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

	
}
