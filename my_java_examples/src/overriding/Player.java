package overriding;

public class Player {
	private int id;
	private String name;
	
	public Player() {
		
	}
	
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//toString method belongs to the Object class and returns the memory address of an object
	//Object class is the super class to all classes, so to have the toString method print the 
	//id and name of a player object, it needs to be overridden
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

	
	//equals method also belongs to the Object class and checks to see if two objects are equal
	//however the method checks to see if the memory addresses are the same
	//we must override this method so that we can find if two players are the same
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		Player p2 = (Player) obj;
		if (this.id == p2.id) {
			b = true;
		}
		return b;
	}
}
