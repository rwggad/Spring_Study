import battery.ChargeBattery;
import battery.NormalBattery;
import toy.ElectronicCarToy;
import toy.ElectronicRadioToy;
import toy.ElectronicRobotToy;

public class main {
    public static void main(String[] argc){

        ElectronicCarToy electronicCarToy = new ElectronicCarToy();

        ElectronicRobotToy electronicRobotToy = new ElectronicRobotToy();
        electronicRobotToy.setBattery(new ChargeBattery());

        ElectronicRadioToy electronicRadioToy = new ElectronicRadioToy(new NormalBattery());
        electronicRadioToy.setBattery(new ChargeBattery());
    }
}
