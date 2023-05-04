package A2;
import java.util.*;
import java.io.*;


public class Admin extends User {
    private ArrayList<Player>players;
    private final String PLAYERS_FILENAME ="players.bin";

    public Admin(String username,String password){
        super(username, password);
        players = new ArrayList<Player>();
        loadPlayers();
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
            // TODO: handle exception
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }
        
        System.out.println("Players Information loaded");
    }

    private  void displayPlayer(){
        for(Player player:players){
           System.out.println();
           System.out.println("Username : "+player.getUsername());
           System.out.println("Password : "+player.getHashPassword());
           System.out.println("Chips    : "+player.getChips());
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
        int playernum = players.size()+1;
        Player player = new Player("player"+playernum, "password"+playernum, 100, 0);
        players.add(player);
        saveToPlayerBin();
        System.out.println("Player created successfully\nUserName : "+player.getUsername()+"\nPassword : "+player.getHashPassword());
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
    private void saveToPlayerBin(){
        try {
            FileOutputStream file = new FileOutputStream(PLAYERS_FILENAME);
            ObjectOutputStream opStream = new ObjectOutputStream(file);
            for(Player player : players){
                opStream.writeObject(player);
            }
            opStream.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
  
    public void run(){
       displayPlayer();
       createNewPlayer();
        saveToPlayerBin();
        displayPlayer();
    
    }

    public void menu(){
        boolean menu = true;
        while(menu){
            System.out.println("\nAdmin Mangement Control Panel\nEnter 1 to Create a new player\nEnter 2 to Delete a player\nEnter 3 to View all players\nEnter 4 to Issue more chips to a player\nEnter 5 to reset player's password\nEnter 6 to Change Administrator's password\nEnter 7 to Logout\n");
            int option = Keyboard.readInt("Choose option:");
            
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
