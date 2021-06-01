
import java.util.*;

public class Elevator {
    public static final int MAX_PASSENGERS = 4;
    public static final int NUM_FLOORS = 10;
    public static final int DOOR_TIME = 5;
    public static final int TRAVEL_TIME = 10;
    public static LinkedList<Person> passengers = new LinkedList<Person>();
    public static int currFloor = 1;
    public static int totalTime = 0;
    public static LinkedList<Person> passengersWaiting = new LinkedList<Person>();

    public static void main(String[] args) {
        loadPassengers();
        while (true) {
            if(passengersWaiting.isEmpty() && passengers.isEmpty()){
                break;
            }
            LinkedList<Person> pWaitingCopy = new LinkedList<Person>(passengersWaiting);
            LinkedList<Person> pCopy = new LinkedList<Person>(passengers);
            boolean door = false;
            for (Person p : passengers) {
                if (currFloor == p.desFloor) {
                    pCopy.remove(p);
                    System.out.println("Passenger getting off");
                    door = true;

                }
            }
            passengers = pCopy;
            for (Person p : passengersWaiting) {
                if (passengers.size() == 4) {
                    break;
                }
                if (p.currentFloor == currFloor) {
                    System.out.println("Passenger getting on");
                    pWaitingCopy.remove(p);
                    passengers.add(p);
                    door = true;
                }
            }
            passengersWaiting = pWaitingCopy;
            if (door == true) {
                totalTime += DOOR_TIME;
            }
            if (currFloor < NUM_FLOORS) {
                currFloor++;
                totalTime += TRAVEL_TIME;
            } else {
                currFloor--;
                totalTime += TRAVEL_TIME;
            }

        }

        System.out.println("Total Elevator Operation Time: " + totalTime);
    }

    public static void initialLoad(){
        boolean door = false;
        LinkedList<Person> pCopy = new LinkedList<Person>(passengersWaiting);
        for(Person p: passengersWaiting){
            if(passengers.size() ==4){
                break;
            }else{
                if(p.currentFloor == currFloor){
                    door = true;
                    pCopy.remove(p);
                    passengers.add(p);
                }
            }
        }
        if(door == true){
            totalTime += DOOR_TIME;
        }
        passengersWaiting = pCopy;
    }
    public static void loadPassengers() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String passenger = "p" + count;
        System.out.println("Enter a floor for each passenger, followed by a '.'");
        while (sc.hasNextInt()) {
            int input = sc.nextInt();
            passengersWaiting.add(new Person(input));
            // System.out.println("INT: " + input);

        }
    }

}