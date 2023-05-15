import java.util.Hashtable;

public class ParkingLot {
    // constants
    private final int MAX_PARKING_SPACES_SUPPORTED = 100;
    //Fields
    private Hashtable<Integer, Boolean> parkingLot = new Hashtable<>();
    private int parkingLotSpaces;

    //Constructor to make a parking lot

    /**Makes a parking lot with the amount of spaces that the user puts in
    *@param parkingLotSize is the amount of parking spaces to make if its in bounds
    *if it isn't in bounds then it makes a default of 100 parking spaces 
    **/
    public ParkingLot(int parkingLotSize) {
        //Puts 10 spots in the hashtable to make an empty parking lot with 10 available spaces
        if(parkingLotSize <=0 || parkingLotSize > 100) {
            this.parkingLotSpaces =  MAX_PARKING_SPACES_SUPPORTED;
        }
        else {
            this.parkingLotSpaces = parkingLotSize;
        }
        for(int i = 1; i <= this.parkingLotSpaces; i++) {
            this.parkingLot.put(i, false);
        }
    }

    //Accessors

    /**
     *Checks the status of a parking spot to see if there is a car there or not
     *If the spot isn't valid then it throws an exception saying what values
     *@param parkingLotSpot is the parking spot that you are getting the status on
     *@return returns false if the slot is full/car is parked there or true for empty/car is not parked there
     **/
    public boolean getStatus(int parkingLotSpot) throws Exception {
        //check for bounds of parkingLotSpot
        if(parkingLotSpot <= 0 || parkingLotSpot > this.parkingLotSpaces) {
            throw new Exception(String.format("No such parking spot. Please pick a number between 1 and %s", this.parkingLotSpaces));
        } else {
            return this.parkingLot.get(parkingLotSpot);
        }
    }

    /**Returns the total count of parking lot spaces
    *@return returns the total amount of parking spots in the parking lot
    **/
    public int getTotalParkingSpaces() {
        return this.parkingLotSpaces;
    }

    //Methods
    //True and False boolean values will be used to determine if a parking lot is full or empty

    /**
     *Parks at the requested slot if it is empty and prints a message
     *indicating you have parked successfully, else throws exception
     *@param parkingSpotToPark is the parking spot that they are trying to park at
     **/
    public void park(int parkingSpotToPark) throws Exception {
        if(this.getStatus(parkingSpotToPark)) {
            throw new Exception("This parking spot is already filled.");
        }
        else {
            parkingLot.put(parkingSpotToPark, true);
            System.out.println("You have successfully parked!");
        }
    }

    /**
     *Unparks the car and prints a message indicating you unnparked
     *Else it throws an exception
     *@param parkingSpotToUnPark is the parking spot that they are trying to unpark at
     **/
    public void unPark(int parkingSpotToUnPark) throws Exception {
        if(!this.getStatus(parkingSpotToUnPark)) {
            throw new Exception("This parking spot is empty.");
        } else {
            parkingLot.put(parkingSpotToUnPark, false);
            System.out.println("You have successfully unparked!");
        }
    }
}