package flags;

public class Bool extends Flag<Boolean>{
	
	public Bool(String name, boolean bool){
		setName(name);
		setValue(bool);
		setDefault(bool);
	}
}
