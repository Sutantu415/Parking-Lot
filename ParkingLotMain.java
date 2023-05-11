import java.util.*;

public class ParkingLotMain {
    public static void main(String[] args) {
        //Scanner to get user input
        Scanner scan = new Scanner(System.in);
        //Constructs a parking lot
        ParkingLot lotOne = new ParkingLot();
        //Initialize an empty string to be used to store the user input
        String answer = "";

        do {
            //Asks the user if they want to park, unpark or exit and stores the input in answer
            System.out.print("Would you like to park, unpark, or exit? ");
            answer = scan.next().toLowerCase();
            //Checks the input and either parks, unparks, or repeats the question until valid answer is provided
            //If the user types exit to quit then after checking all the if statements it will exit
            if(answer.equals("park")) {
                System.out.print("Which spot would you like to park at (Enter a number between 1 and 10): ");
                int spot = scan.nextInt();
                while(spot<1 || spot > 10) {
                    System.out.print("Invalid spot, please enter a number between 1 and 10: ");
                    spot = scan.nextInt();
                }
                lotOne.park(spot);
            } else if(answer.equals("unpark")) {
                System.out.print("Enter the spot number you parked at (Number between 1 and 10): ");
                int spot = scan.nextInt();
                while(spot<1 || spot > 10) {
                    System.out.print("Invalid spot, please enter a number between 1 and 10: ");
                    spot = scan.nextInt();
                }
                lotOne.unpark(spot);
            } else if(!answer.equals("exit")) {
                //Prints invalid option and then prints question again at the top so no need to type it again
                System.out.print("Invalid option! ");
                //Clears the scanner by moving it to the next line in case someone types multiple words as an input
                scan.nextLine();
            }
        } while(!answer.equals("exit"));
        //Closes the scanner
        scan.close();
    }
}