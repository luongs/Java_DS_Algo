package Factory_Design_Pattern;

public class MazeFactory{

	protected Room makeRoom(String rmType) {
		
		if (rmType.equals("Magic"))
			return new MagicRoom(99999999);
		
		return new OrdinaryRoom(5);
	}

}
