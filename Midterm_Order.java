//This program displays menu, asks for user input and customer category
//based on the inputs it calculates and displays final bill

import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
	
	private double total;
	private double subTotal;
	private int[] burgerQuantity = new int[5];
	private static double[] price = {5.25, 5.75, 5.95, 5.95, 5.95};
	private static String[] burgerType= {"De Anza Burger" , " Bacon Cheese Burger ", "Mushrrom Swiss Burger", "Western Burger", "Don Cali Burger"};
	private double tax;
	private static final double staffTax=0.09;
	private int customerType=0;
	private int choice=0;
	private int inputQuantity=0;
	
	
	public Order()
	
	{
		burgerQuantity = new int[5];
		
		for(int i=0; i < burgerQuantity.length; i++)
			burgerQuantity[i]=0;
		subTotal= total = tax= customerType= 0;
		
    }
	
 /* Display menu method
  * Shows menu items, their price and exit option
  */
	public void displayMenu() {
		
 System.out.println("           @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n") ;
 System.out.println("                Welcome to De Anza College Food Court\n ") ;
 System.out.println("           @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n") ;
 System.out.println("Menu\n\n"+ "\n~~~~~");
        
 System.out.println("\n\t 1. De Anza Burger:   ---------------------  $ 5.25");
 System.out.println ("\n\t 2. Bacon Cheese:     ---------------------  $ 5.75");
 System.out.println("\n\t 3. Mushroom Swiss:   ---------------------  $ 5.95");
 System.out.println ("\n\t 4. Western Burger:   ---------------------  $ 5.95");
 System.out.println ( "\n\t 5. Don Cali Burger:  ---------------------  $ 5.95");
 System.out.println ("\n\t 6. Quit from the menu." );
 System.out.println ("\n\n~~~~~");
  
}
	
	/* Get Inputs method
	 * Asks for the choice of burger and quantity
	 * Also checks for the validity of inputs
	 */	
	
	private int getInt(String question) {
		Scanner input = new  Scanner(System.in);
		int given;
		while (true) {
			try {
				System.out.print(question);
				given = input.nextInt();
				break;
			} catch (InputMismatchException ex) {
	            System.out.println("Try again. (Incorrect input: an integer is required)");
			}
	        input.nextLine();
		}
	    return given;
	}
	
	public void getInputs() {
		Scanner input = new  Scanner(System.in);
		
		//loop menu and questions until exit is chosen 
		displayMenu();
		do 
		{  
			choice = getInt("Which burger would you like to have?: ");
			
			if (choice ==6 && inputQuantity == 0) {
				System.out.println("You did not order anything today");
				return;
			}
			//Validate choice
			while(choice < 1 || choice > 6)
			{
				System.out.println("Please enter a valid value between 1 and 6");
				displayMenu();
				choice = getInt("Which burger would you like to have?: ");
			}
						
			//quantity of burgers
			if (choice!=6)
			{
				inputQuantity = getInt("How many burgers do you want?: ");
				
				//validate quantity
				while (inputQuantity <= 0)
				{
					System.out.println("Sorry, we only accept whole number of burgers!");
					inputQuantity = getInt("How many burgers do you want?: ");
				}
				
				// store the quantities in the array
				burgerQuantity[choice - 1] += inputQuantity;
				
			}
			
			
		 }while (choice!=6);
		
		
        //asking user customer category
		
		customerType = getInt("Are you a student or a staff?(Student: enter 1 and Staff: enter 2): ");
		
			// validate customer category
			while (customerType != 1 && customerType != 2)
			{
				System.out.print("Invalid! Please re-enter your identity: ");
				customerType = getInt("Are you a student or a staff?: ");
			}
  }

		
		/*Calculate method
		 * based on user input calculates total and subtotal
		 */

		public void calculate()
		
		{
			for(int i=0; i<burgerQuantity.length; i++)
				subTotal += (burgerQuantity[i]*price[i]);
		
			switch(customerType){
			case 1 :
				tax=0;
				total=subTotal;
				break;
			case 2:
				tax= staffTax*subTotal;
				total=tax+subTotal;
				break;
			default:
				tax=0;	
		 }
		}	
		/*Print Bill method
		 * Prints the choice, total before and after tax and tax applied
		 * based on users input
		 */
		
		public void printBill() {
		if (subTotal !=0 ){	
		System.out.println("\n\t\tDeAnza Food Court");
		System.out.printf("\n%20s %10s %15s", "Food Iten" , "Quantity", "Price per item");
		
		for(int i=0; i <burgerQuantity.length; i++)
		{
			
			if(burgerQuantity[i] > 0)
			{
			System.out.printf("\n%20s %10d %15.2f",burgerType[i], burgerQuantity[i], price[i]);
			
			}
			
		}
		
		System.out.printf("\n%20s : $%-10.2f","SubTotal", subTotal);
		System.out.printf("\n%20s : $%-10.2f","TAX", tax);
		System.out.printf("\n%20s : $%-10.2f","Total", total);
		System.out.println("\nThanks for stopping by!! Have a good day");
		}			
	}
	
}
