import java.util.Scanner;
import java.io.*;
import ui.UI;


public class source {

	public static void userPrompt() {
		String inp = null;
		int choice = -1;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Choose an action from the following list:");
			System.out.println(" 1. add book from file");
			System.out.println(" 2. add book from input");
			System.out.println(" 3. add borrower from file");
			System.out.println(" 4. add borrower from input");
			System.out.println(" 5. borrow book");
			System.out.println(" 6. return book");
			System.out.println(" 7. print book info");
			System.out.println(" 8. print borrower info");
			System.out.println(" 9. modify book info");
			System.out.println("10. modify borrower info");
			System.out.println("11. get books list");
			System.out.println("12. get borrowers list");
			System.out.println(" q. quit");
			
	        System.out.println("Select an action from above:");
	        inp = scan.nextLine();

	        if(inp.equals("q")) {
				System.out.println("user quit");
		        scan.close();
	        	return;
	        }
	        
	        try {
				choice = Integer.parseInt(inp);
				if((choice < 1) || (choice > 12)) {
					System.out.println("invalid choice: "+inp);
			        continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("invalid choice: "+inp);
		        continue;
			}
	        	        
	        UI.selectAction(choice, scan);
		}
	}
	
	public static void main(String[] args) {
		userPrompt();
	}
}
