package toy;

import battery.Battery;
import battery.NormalBattery;

/**
 * DI 주입1*/
public class ElectronicCarToy {
    private Battery battery;

    public ElectronicCarToy(){
        this.battery = new NormalBattery();
    }
}
