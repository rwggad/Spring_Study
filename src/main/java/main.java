import battery.ChargeBattery;
import battery.NormalBattery;
import toy.ElectronicCarToy;
import toy.ElectronicRadioToy;
import toy.ElectronicRobotToy;

public class main {
    /**
     * 의존성 주입 DI에 관한 예제
     *
     * CarTor -> 일반적인 자바 프로그래밍 어떠한 객체(의존성객체)를 사용하고자 하는 클래스 내부에서 new로 객체 선언
     * RadioToy -> 생성자, setter를 이용해서 의존성 객체를 주입 받아서 사용하는 예제
     * RobotToy -> setter를 이용해서 의존성 객체를 주입
     *
     * */
    public static void main(String[] argc){

        ElectronicCarToy electronicCarToy = new ElectronicCarToy();

        ElectronicRobotToy electronicRobotToy = new ElectronicRobotToy();
        electronicRobotToy.setBattery(new ChargeBattery());

        ElectronicRadioToy electronicRadioToy = new ElectronicRadioToy(new NormalBattery());
        electronicRadioToy.setBattery(new ChargeBattery());
    }
}
