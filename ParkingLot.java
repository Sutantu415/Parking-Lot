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
     *If the spot isn't valid then it throws an exception giving the valid options
     *@param parkingLotSpot is the parking spot that you are getting the status on
     *@throws ParkingLotException will throw an exception if an invalid parking spot was entered
     *@return returns false if the slot is full/car is parked there or true for empty/car is not parked there
     **/
    private boolean getStatus(int parkingLotSpot) throws ParkingLotException {
        //check for bounds of parkingLotSpot
        if(parkingLotSpot <= 0 || parkingLotSpot > this.parkingLotSpaces) {
            throw new ParkingLotException(String.format("No such parking spot. Please pick a number between 1 and %s", this.parkingLotSpaces), parkingLotSpot);
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
     *indicating you have parked successfully, else throws exception for an invalid value
     *@param parkingSpotToPark is the parking spot that they are trying to park at
     *@throws ParkingLotException will throw an exception if an invalid parking spot was entered
     **/
    public void park(int parkingSpotToPark) throws ParkingLotException {
        /*if(this.getStatus(parkingSpotToPark)) {
            throw new ParkingLotException("This parking spot is already filled.", parkingSpotToPark);
        }
        else {
            parkingLot.put(parkingSpotToPark, true);
            System.out.println("You have successfully parked!");
        }*/
        this.parkOrUnPark(parkingSpotToPark, "park");
    }

    /**
     *Unparks the car and prints a message indicating you unparked
     *Else it throws an exception due to an invalid value
     *@param parkingSpotToUnPark is the parking spot that they are trying to unpark at
     *@throws ParkingLotException will throw an exception if an invalid parking spot was entered
     **/
    public void unPark(int parkingSpotToUnPark) throws ParkingLotException {
        /*if(!this.getStatus(parkingSpotToUnPark)) {
            throw new ParkingLotException("This parking spot is empty.", parkingSpotToUnPark);
        } else {
            parkingLot.put(parkingSpotToUnPark, false);
            System.out.println("You have successfully unparked!");
        }*/
        this.parkOrUnPark(parkingSpotToUnPark, "unpark");
    }

    /**
     * This method is an extraction method that parks or unparks based on the user input
     * @param parkingSpot is the spot that to park/unpark at
     * @param action is what specifies whether you are parking on parking
     * @throws ParkingLotException will throw an exception if an invalid parking spot was entered
     */
    public void parkOrUnPark(int parkingSpot, String action) throws ParkingLotException {
        boolean park = action.equals("park");
        if(park) {
            if(this.getStatus(parkingSpot)) {
                throw new ParkingLotException("This parking spot is empty.", parkingSpot);
            }
        } else {
            if(!this.getStatus(parkingSpot)) {
                throw new ParkingLotException("This parking spot is full.", parkingSpot);
            }
        }
        parkingLot.put(parkingSpot, park);
        System.out.println("Success!");
    }
}