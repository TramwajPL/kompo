package logic;

import java.util.ArrayList;
import java.util.Collections;

public class Distance {

    ArrayList<Integer> speeds = new ArrayList<>();

    public Distance(){}

    public void saveSpeed(int speed){
        speeds.add(speed);
        System.out.println(speed);
    }

    public String toStringSpeeds() {
        String s = "";
        for(Integer i: speeds){
            s += speeds + "\n";
        }
        return s;
    }
}
