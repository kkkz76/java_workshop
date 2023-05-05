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
    public String getLoginUser(String username,Admin admin,Player player){
        if(username.equals(admin.getUsername())){
            return "admin";
        }else if(username.equals(player.getUsername())){
            return "player";
        }else{
            return "error";
        }
    }
    public void setPassword(String password){
        this.hashPassword = Utility.getHash(password);
    }
    
    public void setAdminPassword(String password){
        this.hashPassword = password;
    }
    

    
    
}
