package toy;

import battery.Battery;

/**
 * DI 주입3*/
public class ElectronicRadioToy {
    private Battery battery;

    public ElectronicRadioToy(Battery battery){
        this.battery = battery;
    }
    public void setBattery(Battery battery){
        this.battery = battery;
    }
}
