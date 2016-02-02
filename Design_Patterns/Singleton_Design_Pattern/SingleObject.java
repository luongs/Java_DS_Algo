package Singleton_Design_Pattern;

public class SingleObject {
	
	// Create a static instance of SingleObject
	private static SingleObject instance = new SingleObject();
	private static int counter = 0;
	
	// Make constructor private to prevent new instance 
	// of object being created 
	private SingleObject(){	}
	
	
	// Return only one possible instance of object
	public static SingleObject getInstance(){
		return instance;
	}
	
	// Counter increments each time showMessage is called
	public void showMessage(){
		System.out.println("Counter value "+counter++);
	}
	
	public static void main(String[] args){
		SingleObject singleton = SingleObject.getInstance();
		SingleObject singleton2 = SingleObject.getInstance();
		SingleObject singleton3 = SingleObject.getInstance();
		
		// Counter increases since all instances are from the same singleton 
		singleton.showMessage();
		singleton2.showMessage();
		singleton3.showMessage();
	}

}
