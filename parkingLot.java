import java.util.Hashtable;

public class parkingLot {
    //Fields
    private Hashtable<Integer, Boolean> parkingLot = new Hashtable<>();

    //Constructor to make a parking lot
    public parkingLot() {
        for(int i = 1; i <= 10; i++) {
            parkingLot.put(i, false);
        }
    }

    //Accessors

    /**
     *Checks the status of a parking spot to see if there is a car there or not
     *@param x is the parking spot that you are getting the status on
     *@return returns false if the slot is full/car is parked there or true for empty/car is not parked there
     **/
    public boolean status(int x) {
        return parkingLot.get(x);
    }

    //Methods
    //True and False boolean values will be used to determine if a parking lot is full or empty

    /**
     *Parks at the requested slot if it is empty and prints a message
     *indicating you have parked successfully, else prints a message that says the parking spot is full
     *@param x is the parking spot that they are trying to park at
     **/
    public void park(int x) {
        //If status(x) is true then there is already a car parked
        if(status(x)) {
            System.out.println("This parking spot is filled!");
        } else {
            parkingLot.put(x, true);
            System.out.println("You have successfully parked!");
        }
    }

    /**
     *Checks the requested slot to see if it is full
     *If it is, then it will unnpark the car and prints a message indicating that
     *you have successfully unparked, else prints a message that says the parking spot is empty
     *@param x is the parking spot that they are trying to unpark at
     **/
    public void unpark(int x) {
        //If status(x) is false then there is no car to be unparked
        if(!status(x)) {
            System.out.println("There is no car parked here!");
        } else {
            parkingLot.put(x, false);
            System.out.println("You have successfully unparked!");
        }
    }
}