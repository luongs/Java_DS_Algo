package Factory_Design_Pattern;

public class MazeRunner {

	public static void main(String[] args) {
		MazeFactory factory = new MazeFactory();
		
		Room ordinaryRoom= factory.makeRoom("Ordinary");
		Room magicRoom = factory.makeRoom("Magic");
		
		System.out.println(magicRoom.getSize());
		System.out.println(ordinaryRoom.getSize());

	}

}
