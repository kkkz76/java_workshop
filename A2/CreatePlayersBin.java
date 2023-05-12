package A2;
import java.io.*;
public class CreatePlayersBin {
    public static void main(String[] args) {
        // Player player1 = new Player("IcePeak","password",100,0);
        // Player player2 = new Player("player2","password2",100,0);
        // Player player3 = new Player("player3","password3",100,0);
        try {
            FileOutputStream file = new FileOutputStream("players.bin");
            ObjectOutputStream opStream = new ObjectOutputStream(file);
            // opStream.writeObject(player1); 
            // opStream.writeObject(player2); 
            // opStream.writeObject(player3);
            opStream.close(); 
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
