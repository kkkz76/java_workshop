package A2;
import java.io.Serializable;
abstract class User implements Serializable{
    private String username;
    private String hashPassword;

    public User(String username, String password) {
        this.username = username;
        this.hashPassword = Utility.getHash(password);
    }

    public String getUsername() {
        return username;
    }
    public String getHashPassword() {
        return this.hashPassword;
    }
   
    public boolean checkPassword(String password){
        if(Utility.getHash(password).equals(this.hashPassword)){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkUsername(String username){
        if(username.equals(this.username)){
            return true;
        }else{
            return false;
        }
    }
    public void display(){
        System.out.println(getUsername());
        System.out.println(getHashPassword());
    }

    
    
}
