public class ParkingLotTestCases {
    public static void main(String[] args) {
        //Make parking lot with a size of 2
        int parkingLotSize = 2;
        ParkingLot lotOne = new ParkingLot(parkingLotSize);

        //Test
        //Needs test conditions for parking in an available spot, unparking at a parked spot
        //parking in an unavailable spot, and unparking at a free spot
        try {
            //Test Case 1
            System.out.print("Test Case 1 (Park in empty spot): ");
            lotOne.park(1);
            //Test Case 2
            try {
                System.out.print("Test Case 2 (Park in an occupied spot): ");
                lotOne.park(1);
            } catch(ParkingLotException e) {
                System.out.println("Success! Exception was caught.");
            }
            //Test Case 3
            try {
                System.out.print("Test Case 3 (Unpark from an empty spot): ");
                lotOne.unPark(2);
            } catch(ParkingLotException e) {
                System.out.println("Success! Exception was caught.");
            }
            //Test Case 4
            System.out.print("Test Case 4 (Unpark from a parked spot): ");
            lotOne.unPark(1);
            //Test Case 5
            try {
                System.out.print("Test Case 5 (Park in a nonexistent spot): ");
                lotOne.park(4);
            } catch(Exception e) {
                System.out.println("Success! Exception was caught.");
            }
            //Test Case 6
            try {
                System.out.print("Test Case 6 (unpark from a nonexistent spot): ");
                lotOne.park(4);
            } catch(Exception e) {
                System.out.println("Success! Exception was caught.");
            }
        } catch(ParkingLotException e) {
            System.out.println("Failed.");
        }
    }
}
