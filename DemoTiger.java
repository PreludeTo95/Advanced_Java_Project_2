import java.util.Scanner;
import java.util.ArrayList;

public class DemoTiger
{
    public static void main (String[]args)
    {
        Scanner userInput = new Scanner(System.in); //create scanner object
        ArrayList<Bill> billArrayList = new ArrayList<Bill>(); //create ArrayList for bill objects

        String willToGoOn = "n"; //this could be a char but java is throwing a type mismatch error
        String customerName = "Unassigned";
        String subscriptionType = "Unassigned";
        int activeDuration = 0;
        String billID = "N/A";
        double sumOfAllBills = 0;

        //create and store bill objects based on user input
        do
        {
            //prompt user for customer name and save it
            System.out.print("Enter the customer's name (first and last): ");
            customerName = userInput.nextLine();

            //prompt user for subscription type and capture user input using a menu to avoid typos
            System.out.println("\t1. Basic Channels Package");
            System.out.println("\t2. Sports Channels Package");
            System.out.println("\t3. Movie Channels Package");
            System.out.println("\t4. Ultra Package (includes Basic, Sports, and Movies)");
            System.out.print("Select a subscription from the menu above: ");
            //userInput.nextInt(); //clear the buffer to capture new data type
            int menuChoice = userInput.nextInt();

            //reject invalid input
            while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3 && menuChoice != 4)
            {
                System.out.println("\nInvalid menu choice!");
                System.out.println("\t1. Basic Channels Package");
                System.out.println("\t2. Sports Channels Package");
                System.out.println("\t3. Movie Channels Package");
                System.out.println("\t4. Ultra Package (includes Basic, Sports, and Movies)");
                System.out.print("Select a subscription from the menu above: ");
                menuChoice = userInput.nextInt();
            }

            //assign a subscription type based on the validated input
            switch (menuChoice)
            {
                case 1:
                    subscriptionType = "Basic Channels Package";
                    break;
                case 2:
                    subscriptionType = "Sports Channels Package";
                    break;
                case 3:
                    subscriptionType = "Movie Channels Package";
                    break;
                case 4:
                    subscriptionType = "Ultra Package";
                    break;
                default:
                    System.out.println("I honestly don't know how you broke this...");
                    break;
            }

            //prompt user for duration of active subscription
            System.out.print("Enter the length of time (in months) that account has been active: ");
            //userInput.nextDouble(); //clear the buffer to capture new data type
            activeDuration = userInput.nextInt();

            //reject invalid input
            while (activeDuration < 0)
            {
                System.out.println("\nActive time cannot be less than zero!");
                System.out.print("Enter the length of time (in months) that account has been active: ");
                activeDuration = userInput.nextInt();
            }

            //prompt use for the bill's ID
            System.out.print("Enter an ID for the bill: ");
            userInput.nextLine(); //clear the buffer to capture new data type
            billID = userInput.nextLine(); 

            //create class objects based on info from the user
            Account a = new Account(customerName, subscriptionType, activeDuration);
            Bill b = new Bill(billID, a);

            //calculate the value of the current object's bill and add it to a running total
            sumOfAllBills += b.calculateBill(); 
            
            //add the current bill object to the array list
            billArrayList.add(b);

            //question the user's willpower
            System.out.print("\nDo you want to enter information for another bill (Y/N)? ");
            willToGoOn = userInput.nextLine();
            
            while (!(willToGoOn.equalsIgnoreCase("y")) && !(willToGoOn.equalsIgnoreCase("n")))
            {
               System.out.println("\nInput error!");
               System.out.print("Do you want to enter information for another bill (Y/N)? ");
               willToGoOn = userInput.nextLine();
            }
            
            System.out.println();

        } while (willToGoOn.equalsIgnoreCase("y"));
        
        System.out.println("Subscription Bill Report");
        System.out.println();
        
        //access every object in the array list
        for (int i = 0; i < billArrayList.size(); i++)
        {
            System.out.println(billArrayList.get(i)); //implicitly call toString() method from the Bill class
            System.out.println("Bill Cost: " + billArrayList.get(i).calculateBill());
            System.out.println();
        }

        //calculate average bill cost
        System.out.printf("The average cost of a bill is: $%.2f", (sumOfAllBills / billArrayList.size()));
    }
}