import java.util.*;

public class ParkingLotMain {
    public static void main(String[] args) {
        //Scanner to get user input
        Scanner scan = new Scanner(System.in);
        //Constructs a parking lot
        int parkingLotSize = 15;
        ParkingLot lotOne = new ParkingLot(parkingLotSize);
        //Initialize an empty string to be used to store the user input
        String answer = "";

        do {
            //Asks the user if they want to park, unpark or exit and stores the input in answer
            System.out.print("Would you like to park, unpark, or exit? ");
            answer = scan.next().toLowerCase();
            //Checks the input and either parks, unparks, or repeats the question until valid answer is provided
            //If the user types exit to quit then after checking all the if statements it will exit
            if(answer.equals("exit")) {
                break;
            }

            boolean isParking = answer.equals("park");
            boolean isUnParking = answer.equals("unpark");
            if(!isParking && !isUnParking) {
                continue;
            }

            System.out.printf("Enter parking spot between 1 and %s: ", parkingLotSize);
            int spot = scan.nextInt();

            try {
                if(isParking) {
                    lotOne.park(spot);
                 } else {
                    lotOne.unPark(spot);
                 }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(true);
        
        //Closes the scanner
        scan.close();
    }
}