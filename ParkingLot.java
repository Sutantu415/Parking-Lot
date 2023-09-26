import java.util.Hashtable;

public class ParkingLot {
    // constants
    private final int MAX_PARKING_SPACES_SUPPORTED = 100;
    private final String PARK_WORD = "park";
    private final String UN_PARK_WORD = "unpark";
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
     *If there is a car in the spot then it returns true, if there isn't a car then it returns false
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

    /**
     * This method is an extraction method that parks or unparks based on the user input
     * If you are parking it checks to see if a car is already parked in the requested spot by getting the status
     * In the case its true then you can't park at a full spot and throws an error for parking at a full spot
     * If unparking then it checks to see if the parking spot requested is empty and checks if the get status returns false
     * if it returns false that means the parking space was empty to begin with and throws an error for unparking at an empty spot 
     * @param parkingSpot is the spot that to park/unpark at
     * @param action is what specifies whether you are parking or unparking
     * @throws ParkingLotException will throw an exception if an invalid parking spot was entered
     */
    private void parkOrUnPark(int parkingSpot, String action) throws ParkingLotException {
        boolean park = action.equals(PARK_WORD);
        if(park) {
            if(this.getStatus(parkingSpot)) {
                throw new ParkingLotException("This parking spot is full.", parkingSpot);
            }
        } else {
            if(!this.getStatus(parkingSpot)) {
                throw new ParkingLotException("This parking spot is empty.", parkingSpot);
            }
        }
        parkingLot.put(parkingSpot, park);
        System.out.println("Success!");
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
        this.parkOrUnPark(parkingSpotToPark, PARK_WORD);
    }

    /**
     *Unparks the car and prints a message indicating you unparked
     *Else it throws an exception due to an invalid value
     *@param parkingSpotToUnPark is the parking spot that they are trying to unpark at
     *@throws ParkingLotException will throw an exception if an invalid parking spot was entered
     **/
    public void unPark(int parkingSpotToUnPark) throws ParkingLotException {
        this.parkOrUnPark(parkingSpotToUnPark, UN_PARK_WORD);
    }
}