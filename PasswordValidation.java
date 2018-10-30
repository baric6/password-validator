/*Joe_Hollon
 * Cis_2212_tuseday_class
 * October-20-2018
 * String Class
 * */

package chap10StringClass;

//used to import GUI swing 
import javax.swing.JOptionPane;

public class PasswordValidation 
{
	public static void main(String[] args)
	{
		//main input
		String password = JOptionPane.showInputDialog("Please enter a password\n"
									+ "It has to be at least 8 charaters(only letters and numbers)\n"
									+ "It must have at least 2 numbers\n");
		//main cancel
		cancelClick(password);
		
		//password validation
		validatePassword(password);
		
		//so it closes after each time i had, a few programs running at once
		//this closes the program after each run
		System.exit(0);
		
	}//end main
	
	//method to validate password
	public static void validatePassword(String password)
	{
		//set valid to false
		boolean valid = false;
		
		//using while loop to keep the pop-ups till you enter the correct kind of password
		while(valid == false)
		{
			//validate if the password is less then 7 characters, if not will prompt you 
			//to enter a new password
			if(password.length() < 7)
			{
				//length error message 
				JOptionPane.showMessageDialog(null, "Your password " + password + " is not valid\n"
											+ "It must be at least 8 characters");
				
				//length reenter password
				password = JOptionPane.showInputDialog("Please enter a password\n"
						+ "It has to be at least 8 charaters(only letters and numbers)\n"
						+ "It must have at least 2 numbers\n");
				
				//main cancel
				cancelClick(password);
				
			}//end length validation
			
			//for-loop to go threw each letter of the password
			for(int i = 0; i < password.length(); i++)
			{
				//uses is letter or digit to validate if there are no symbols entered
				if(!Character.isLetterOrDigit(password.charAt(i)))
				{
					//is letter or digit error
					JOptionPane.showMessageDialog(null, "Your password " + password +  " is not valid\n"
												+ "It must be Only characters & digits");
					
					//is letter or digit input
					password = JOptionPane.showInputDialog("Please enter a password\n"
							+ "It has to be at least 8 charaters(only letters and numbers)\n"
							+ "It must have at least 2 numbers\n");
					
					//main cancel
					cancelClick(password);
					
				}
			}//end isletter or isdigit 
			
			//value to count the digits
			int number = 0;
			
			//to traversed the string 
			for(int i = 0; i < password.length();i++)
			{	
				//if it reads a number then count it 
				if(Character.isDigit(password.charAt(i)))
					
				//increments the number if it reads	a digit
				number++;
			}
			
			//if number is less then 2 then prompt them for re-entry of password
			if(number < 2)
			{
				//error for isdigit less then 2
				JOptionPane.showMessageDialog(null, "Your password " + password + " is not valid\n"
											+ "It must have at least 2 digits");
				
				//isdigit re-entry input
				password = JOptionPane.showInputDialog("Please enter a password\n"
						+ "It has to be at least 8 charaters(only letters and numbers)\n"
						+ "It must have at least 2 numbers\n");
				
				//main cancel
				cancelClick(password);
			}
			
			else
			{
				//if passes all the if-statements then set valid to true and exits the while-loop
				valid = true;
				System.out.println("is valid");
				
				//prompts the user that his password is correct
				JOptionPane.showMessageDialog(null, "Password is Valid");
				
			}
		}//end while-loop
	}//end method
	
	//need this because it gives me a null pointer error when user hits cancel
	public static void cancelClick(String password)
	{
		if(password == null)
		{	
			//exit out put
			JOptionPane.showMessageDialog(null, "Program will now exit");
			System.exit(0);
		}
	}//end cancel click*

}//end class