import java.util.*;

public class Person {
    Random rand = new Random();
    public int currentFloor = rand.nextInt(10)+1;
    public int desFloor; 
    public int waitTime;
    public int travelTime;
    public boolean direction; // True if up, false if down

    public Person(int desFloor){
        this.desFloor = desFloor;
        // this.direction = direction;
        this.waitTime = 0;
    }

    public int getFloor(){
        return desFloor;
    }

    public int getWait(){
        return waitTime;
    }

    public int getTravel(){
        return travelTime;
    }

    public void addWait(int x){
        this.waitTime += x;
    }
    public void addTravel(int x){
        this.travelTime += x;
    }

}
