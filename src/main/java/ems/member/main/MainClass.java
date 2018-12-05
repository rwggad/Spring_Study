package ems.member.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ems.member.Student;
import ems.member.assembler.StudentAssembler;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class MainClass {

	public static void main(String[] args) {
		/**
		 * Java를 이용한 DI프로그래밍
		 *
		 * 스프링을 사용하지 않고 실행하는 main*/

		/**
		 * 데이터 베이스 대신 임시 데이터로 사용한다. */
		String[] sNums = {"H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", 
						  "H39lkmn754fghia7", "H39plo865cuy8k92", "H39mnbviiaed89q1", 
						  "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", 
						  "H39lesvj7544vf89"};
		
		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion", 
					    "tiger", "pig", "horse", "bird", "deer"};
		
		String[] sPws = {"96539", "94875", "15284", "48765", "28661", 
						"60915", "30028", "29801", "28645", "28465"};
		
		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva", 
						  "fiona", "holly", "jasmin", "lena", "melissa"};
		
		int[] sAges = {19, 22, 20, 27, 19, 21, 19, 25, 22, 24};
		String[] sGenders = {"M", "W", "W", "M", "M", "M", "W", "M", "W", "W"};
		String[] sMajors = {"English Literature", "Korean Language and Literature", 
				"French Language and Literature", "Philosophy", "History", 
				"Law", "Statistics", "Computer", "Economics", "Public Administration"};

		/**
		 * assembler 객체 생성
		 *
		 * 이 객체를 가지고 각각의 서비스들을 이용한다.
		 *
		 * Register, Delete Select.. 등의 서비스들은 모두 assembler에 의존하고 있다.
		 *
		 * 만약 각각의 서비스를 사용할 때 마다 Dao 객체를 생성해준다면 학생 정보 서비스를 이용할 수 있기때문에
		 *
		 * assembler 객체를 한번 만들고 이 객체를 모든 서비스에 주입해준다.
		 * */
		StudentAssembler assembler = new StudentAssembler();

		/**
		 * 위에 입력된 데이터를 assembler에 등록한다.*/
		StudentRegisterService registerService = assembler.getRegisterService();
		for (int j = 0; j < sNums.length; j++) {
			Student student = new Student(sNums[j], sIds[j], sPws[j], sNames[j], 
					sAges[j], sGenders[j], sMajors[j]);
			registerService.register(student);
		}

		/**
		 * assembler (DB) 를 가지고 modifyService 객체 생성 후 학생 정보를 수정한다.*/
		StudentModifyService modifyService = assembler.getModifyService();
		modifyService.modify(new Student("H39lesvj7544vf89", "deer", "00000", "melissa", 
				26, "W", "Vocal Music"));

		/**
		 * assembler (DB) 를 가지고 modifyService 객체 생성 후 학생정보를 가져온다.*/
		StudentSelectService selectService = assembler.getSelectService();
		Student modifiedStudent = selectService.select("H39lesvj7544vf89");
		System.out.print("sNum:" + modifiedStudent.getsNum() + "\t");
		System.out.print("|sId:" + modifiedStudent.getsId() + "\t");
		System.out.print("|sPw:" + modifiedStudent.getsPw() + "\t");
		System.out.print("|sName:" + modifiedStudent.getsName() + "\t");
		System.out.print("|sAge:" + modifiedStudent.getsAge() + "\t");
		System.out.print("|sGender:" + modifiedStudent.getsGender() + "\t");
		System.out.print("|sMajor:" + modifiedStudent.getsMajor() + "\n\n");

		/**
		 * assembler (DB) 를 가지고 modifyService 객체 생성 후 모든 학생정보를 가져 온다.*/
		StudentAllSelectService allSelectService = assembler.getAllSelectService();
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("sNum:" + student.getsNum() + "\t");
			System.out.print("|sId:" + student.getsId() + "\t");
			System.out.print("|sPw:" + student.getsPw() + "\t");
			System.out.print("|sName:" + student.getsName() + "\t");
			System.out.print("|sAge:" + student.getsAge() + "\t");
			System.out.print("|sGender:" + student.getsGender() + "\t");
			System.out.println("|sMajor:" + student.getsMajor() + "\t");
			
		}


		/**
		 * 프로그램의 시작.
		 */
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String str = "";
			
			System.out.println("\n==================================================================="
					+ "==============================================================================");
			System.out.println("Select number.");
			System.out.println("1. Check student information");
			System.out.println("2. Exit");
			
			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Bye~~");
				break;
			} else {
				System.out.println("Please input your class number.");
				
				str = scanner.next();
				Student student = selectService.select(str);
				System.out.print("sNum:" + student.getsNum() + "\t");
				System.out.print("|sId:" + student.getsId() + "\t");
				System.out.print("|sPw:" + student.getsPw() + "\t");
				System.out.print("|sName:" + student.getsName() + "\t");
				System.out.print("|sAge:" + student.getsAge() + "\t");
				System.out.print("|sGender:" + student.getsGender() + "\t");
				System.out.println("|sMajor:" + student.getsMajor() + "\t");
			}
			
		}
		
		
	}

}
