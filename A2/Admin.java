package A2;
import java.util.*;
import java.io.*;

public class Admin {
    private ArrayList<Player>players;
    private final String PLAYERS_FILENAME = "players.bin";

    public Admin(){
        players = new ArrayList<Player>();
        loadPlayers();
    }
    public void loadPlayers(){
        try {
            FileInputStream file = new FileInputStream(PLAYERS_FILENAME);
            ObjectInputStream IpStream = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    Player player = (Player)IpStream.readObject();
                    players.add(player);
                } catch (EOFException e) {
                    endOfFile = true;
                    // TODO: handle exception
                }
            }
            IpStream.close();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }
        
        System.out.println("Players Information loaded");
    }

    private  void displayPlayer(){
        for(Player player:players){
           System.out.println(player.getUsername());
           System.out.println(player.getHashPassword());
        }
    }
    private void updatePlayer(){
        for(Player player : players){
            player.addChips(100);
        }
    }
    public void run(){
        displayPlayer();
    
    }
    public static void main(String[] args) {
        Admin ad = new Admin();
        for(Player player:ad.players){
            System.out.println(player.getUsername());
            System.out.println(player.getHashPassword());
         }
       
    }
    
}
