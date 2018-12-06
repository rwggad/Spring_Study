package scope.ex;

/**
 * InjectionBean에 의존하는 객체*/
public class DependencyBean {

	private InjectionBean injectionBean;

	/**
	 * 생서자를 통한 주입, Bean이 생성될 때 마다 log 생성*/
	public DependencyBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean : constructor");
		this.injectionBean = injectionBean;
	}

	/**
	 * setter를 통한 주입, Bean이 생성될 때 마다 log 생성**/
	public void setInjectionBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean : setter");
		this.injectionBean = injectionBean;
	}
	
}