import java.util.*;

public class Person {
    Random rand = new Random();
    public int currentFloor = rand.nextInt(10);
    public int desFloor; 
    public int waitTime;
    public boolean direction; // True if up, false if down

    public Person(int desFloor){
        this.desFloor = desFloor;
        // this.direction = direction;
        this.waitTime = 0;
    }

    private int getFloor(){
        return desFloor;
    }

    private int getWait(){
        return waitTime;
    }

    private void addWait(int x){
        this.waitTime += x;
    }
}
