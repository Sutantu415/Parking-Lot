public class ParkingLotException extends Exception {
    //Fields
    private int illegalValue;

    //Constructor
    /**Makes an exception specifically for the ParkingLot class with a message and stores the illegal value that triggered the exception
    *@param message is the error message
    *@param illegalValue is the illegal value that triggered the ParkingLotException 
    **/
    public ParkingLotException(String message, int illegalValue) {
        super(message);
        this.illegalValue = illegalValue;
    }

    //Accessor
    /**
     * Accessor method to retreive the illegal value that caused a ParkingLotException
     * @return returns the illegal value
     **/
    public int getIllegalValue() {
        return this.illegalValue;
    }
}
