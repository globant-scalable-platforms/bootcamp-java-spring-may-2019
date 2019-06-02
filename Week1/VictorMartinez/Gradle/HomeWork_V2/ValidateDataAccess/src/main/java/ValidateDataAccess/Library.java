/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ValidateDataAccess;

import BasicProject.*;
import AccessUserPermission.*;




 
public class Library {

   private basicFunctions userdata;
   private String username;
   private String password;
	public Library() {
		
	//Get Basic Functions from AccessUserPermission Object 
	//Set Home page
	AccessUserPermission.Library.Intro();
	//Ask for data of the user
	AccessUserPermission.Library.askUserName();
	AccessUserPermission.Library.askPassWord();
	System.out.println(" ");
	System.out.println(" -------- - --------- ");
	System.out.println(" ");
	
	try {
		extractUserDataObject();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("User data non available");
	}
	
	AccessUserPermission.Library.showUserName(this.username);
	AccessUserPermission.Library.showPassWord(this.password);
	

		
	}
	
	public void extractUserDataObject() throws Exception {
		userdata = new BasicProject.basicFunctions();
		
		System.out.println("Extracting User Data ||_ _ _ _ _ _ _ _||");
		Thread.sleep(500);
		System.out.println("Extracting User Data ||> _ _ _ _ _ _ _||");
		Thread.sleep(500);
		System.out.println("Extracting User Data ||> > _ _ _ _ _ _||");
		Thread.sleep(500);
		System.out.println("Extracting User Data ||> > > _ _ _ _ _||");
		Thread.sleep(500);
		System.out.println("Extracting User Data ||> > > > > > _ _||");
		Thread.sleep(500);
		System.out.println("Extracting User Data ||> > > > > > > >||");
		this.username = userdata.getUserName();
		this.password = userdata.getPassword();
		System.out.println("User data Extracted");
	}
	
	
	
	public void settingIntroView() {
		System.out.println("Setting view");
	}
	
	public String getName() {return this.username;}
	public String getPassWord() {return this.password;}
	
		public void main(String [] args) {
			System.out.println("");
		}
	
}
