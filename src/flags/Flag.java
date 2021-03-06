package flags;

public abstract class Flag<T> {
	private String name;
	private T value;
	private T defaultVal;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setValue(T value){
		this.value = value;
	}
	public T getValue(){
		return value;
	}
	public void setDefault(T value){
		this.value = value;
	}
	public T getDefault(){
		return defaultVal;
	}
	/*
	 * Max Players
	 * Min Players
	 * Max Score
	 * Min Score
	 * Late Join
	 * Use Loadouts
	 * Use Timer
	 * Death Drops
	 * Teams
	 * Break Blocks
	 * Guns Break Blocks
	 * Can Spectate
	 * 
	 */
}
