package scope.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/**
		 * 스프링 컨테이너 생성*/
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");

		/**
		 * injectionBean 가져오기 */
		InjectionBean injectionBean = 
				ctx.getBean("injectionBean", InjectionBean.class);

		/**
		 * DependencyBean 가져오기
		 *
		 * applicationContext에서 dependencyBean 객체(Bean)을 생성해줄 때 따로 Scope 속성으로 prototype 속성값을 주지 않았기 때문에
		 * dependencyBean01 과 dependencyBean02는 같은 객체를 참조 하고 있기 때문에 같다고 출력된다 (싱글톤 예제)
		 * (Bean이 생성될때 나오는 log는 딱 한번만 나옴)
		 *
		 *
		 * 만약 applicationContext.xml파일에서 dependencyBean 객체를 생성하는 코드값에
		 * Scope = "prototype"을 명시 해주면 getBean을 할 떄 마다 새로운 객체(Bean)을 생성해주기 때문에
		 * dependencyBean01과 dependencyBean02는 다르다는 결과가 나오게된다.
		 * (Bean이 생성될때 나오는 log는 두번이 나오게된다.)
		 *
		 * */
		DependencyBean dependencyBean01 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		DependencyBean dependencyBean02 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		if(dependencyBean01.equals(dependencyBean02)) {
			System.out.println("dependencyBean01 == dependencyBean02");
		} else {
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		
		
		ctx.close();
		
	}
	
}
