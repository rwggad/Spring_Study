package toy;

import battery.Battery;

/**
 * DI 주입2*/
public class ElectronicRobotToy {
    private Battery battery;

    public ElectronicRobotToy(){

    }
    public void setBattery(Battery battery){
        this.battery = battery;
    }
}
