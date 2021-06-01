package etude05;

public class Person {
    private int desFloor;
    private int waitTime;
    public boolean direction;

    public Person(int desFloor, boolean direction){
        this.desFloor = desFloor;
        this.direction = direction;
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
