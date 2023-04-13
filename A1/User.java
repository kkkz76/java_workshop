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
        if(password == this.password){
            return true;
        }else{
            return false;
        }
    }
    
}
