public class Driver {

	public static void main(String[] args) {
		
		Order order1= new Order();
		
		//Display food menu
		
		//Taking Order from user
		order1.getInputs();
				
		//Compute Bill
		order1.calculate();
				
		//Display final bill
		order1.printBill();
	}

}
