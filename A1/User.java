package A1;

abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
   
    public boolean checkPassword(String password){
        if(password.equals(this.password)){
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

    
    
}
