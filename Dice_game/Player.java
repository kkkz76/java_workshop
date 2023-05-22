
public class Player {

	private String id;
	private String password;
	
	public Player(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public boolean authenticate(String password) {
		return this.password.equals(password);
	}
}
