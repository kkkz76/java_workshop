package A2;
import java.util.*;
import java.io.*;


public class Admin extends User {
    private ArrayList<Player>players;
    private final String PLAYERS_FILENAME ="players.bin";
    private final String ADMIN_FILENAME = "admin.txt";
    

    public Admin(String username,String password){
        super(username, password);
        players = new ArrayList<Player>();
        loadPlayers();
        loadAdmin();
    }

   public ArrayList<Player> getPlayerArray(){
    return this.players;
   }
    public void loadPlayers(){
        try {
            FileInputStream file = new FileInputStream(PLAYERS_FILENAME);
            ObjectInputStream output = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                
                try {
                    Player player = (Player)output.readObject();
                    players.add(player);
                
                } catch (EOFException e) {
                    endOfFile = true;
                    // TODO: handle exception
                }
            }
            output.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Players Information loaded");
    }

    public void displayPlayer(){
        if(players.isEmpty()){
            System.out.println("\nThere is no player to display\n");
        }else{
            for(Player player:players){
                System.out.println();
                System.out.println("Username : "+player.getUsername());
                System.out.println("Password : "+player.getHashPassword());
                System.out.println("Chips    : "+player.getChips());
             }
        }
        
    }
    private void updateChips(){
        displayPlayer();
        String updateName = Keyboard.readString("\nEnter Name to add Chips:");
        for(int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if(player.getUsername().equals(updateName)){
                int newChips = Keyboard.readInt("Enter Chips Amount:");
                player.addChips(newChips);
                System.out.println(newChips +" chips have been added to "+player.getUsername());
                System.out.println(player.getUsername()+" now has "+player.getChips()+" chips");
                saveToPlayerBin();
            }else if(i == players.size() - 1){
                System.out.println("No user found");
            }
        }
        }
    
    private void createNewPlayer(){
        boolean check = true;
        String name = "";
        while(check){
            name = Keyboard.readString("Enter Name:");
            if(players.isEmpty()){
                check = false;
                break;
            }else{
                for(int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    if(player.getUsername().equals(name)){
                        System.out.println("Username already exists");
                        break;
                    }else if(i == players.size() - 1){
                        check = false;
                        break;
                    }
                }
            }
            
        }
            String password = Keyboard.readString("Enter Password:");
            Player player = new Player(name, password, 100, 0);
            players.add(player);
            saveToPlayerBin();
            System.out.println("Player created successfully\n\nUsername : " + player.getUsername()+"\nPassword :"+player.getHashPassword());
        
    }

    private void deletePlayer(){
        displayPlayer();
        String deleteName = Keyboard.readString("Enter Player name to delete:");
        for(int i =0; i < players.size(); i++){
            Player delPlayer = players.get(i);
            if(delPlayer.getUsername().equals(deleteName)){
                System.out.println("Player : "+delPlayer.getUsername()+" is deleted successfully");
                players.remove(delPlayer);
                saveToPlayerBin();
                break;
            }else if(i == players.size()-1){
                System.out.println("No Player found");
            }
        }
    }

    private void resetPassword(){
        String name = Keyboard.readString("Enter Player name to reset password:");
        for(int i =0; i < players.size(); i++){
            Player player = players.get(i);
            if(player.getUsername().equals(name)){
                String password = Keyboard.readString("Enter a new Password:");
                player.setPassword(password);
                System.out.println("Password is updated successfully");
                saveToPlayerBin();
                break;
            }else if(i == players.size()-1){
                System.out.println("No Player found");
            }
        }
    }
    private void resetAdminPassword(){
        String name = Keyboard.readString("Enter Admin name to reset password:");
        if(this.getUsername().equals(name)){
            String password = Keyboard.readString("Enter a new Password:");
            this.setPassword(password);
            System.out.println("Password is updated successfully");
            saveToAdminText();
            
        }else{
            System.out.println("No User found");
        }
    }



    public void saveToPlayerBin(){
        try {
            FileOutputStream file = new FileOutputStream(PLAYERS_FILENAME);
            ObjectOutputStream opStream = new ObjectOutputStream(file);
            for(Player player : players){
                opStream.writeObject(player);
            }
            opStream.close();
            System.out.println("\nInformation saved successfully");
        } catch (IOException e) {
            System.out.println("Error Encountered");
            System.out.println("An IO exception occurred: " + e.getMessage());
           
        }
    }

    public void saveToAdminText(){
        try {
            PrintWriter pw = new PrintWriter(ADMIN_FILENAME);
            pw.write(this.getHashPassword());
            pw.close();
          
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void loadAdmin(){
        try {
            File file = new File(ADMIN_FILENAME);
            Scanner reader = new Scanner(file);
          
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                this.setAdminPassword(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No admin data created/use dafault password");
            // TODO: handle exception
          
        }
        System.out.println("Admin password is loaded\n");
    }
  
    public void run(){
       displayPlayer();
       createNewPlayer();
        saveToPlayerBin();
        displayPlayer();
 
    
    }

    public void menu(){
        boolean menuloop = true;
        String title = "Admin Panel";
        String [] menu = {"Create Player","Delete Player","View All Players","Issue more chips to a player","Reset player's password","Reset Administrator's password","Log Out"};
        while(menuloop){
            int option = Keyboard.getUserOption(title, menu);
            
            switch(option){
                case 1:
                    createNewPlayer();
                    break;
                case 2:
                    deletePlayer();
                    break;
                case 3:
                    displayPlayer();
                    break;
                case 4:
                    updateChips();
                    break;
                case 5:
                    resetPassword();
                    break;
                case 6:
                    resetAdminPassword();
                    break;
                case 7:
                    return;
            }
        }
        
        }

    public static void main(String[] args) {
        Admin admin = new Admin("admin","admin");
       
        admin.run();
        System.out.println(admin.getUsername()); 
        System.out.println(admin.getHashPassword()); 
       
    }
    
}
