import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import sun.net.www.content.text.Generic;

public class main {
    public static void main(String[] argc){

        /**
         * 일반적으로 자바에서 객체를 사용할때.. 모듈을 사용 x */
        //TranspotationWalk transpotationWalk = new TranspotationWalk();
        //transpotationWalk.move();

        /**
         * Spring에서 applicationContext에서 로딩 시켜놓은 Bean으로 사용 */
        // 일단 Spring Container에 접근한다
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        // applicationContext.xml 에서 지정한 Bean을 가져온다. (id 이름, 데이터 타입)
        TranspotationWalk transpotationWalk;
        transpotationWalk = context.getBean("tWalk", TranspotationWalk.class);
        transpotationWalk.move();
        // 리소스 반환
        context.close();
    }
}
