package Factory_Design_Pattern;

public class Room {
	private int size;
	private Room connected;
	
	public Room(int size){
		this.size = size;
	}
	
	public void connect(Room rm){
		connected = rm;
	}

	public int getSize() {
		return size;
	}

	public Room getConnected() {
		return connected;
	}

}
