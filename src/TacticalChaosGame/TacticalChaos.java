
package TacticalChaosGame;

import Battlefield.Arena;
import Champions.*;
import Champions.StoreFilter;
import Game.Game;
import Player.ConsolePlayer;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class TacticalChaos {
Game Game=null;
 public void SetGameMode(){

     Scanner Scan =new Scanner(System.in);

           System.out.println("P)Playing");
           System.out.println("O)Observer");

           String PlayerMode=Scan.next();
           
           System.out.println("Players Count: ");
           int PlayersCount=Scan.nextInt();

           if(PlayerMode.equalsIgnoreCase("P"))
           {
           System.out.println("Auto Player Count: ");
           int AutoPlayersCount=Scan.nextInt();
           Game  =new Game(PlayersCount,AutoPlayersCount,"Console",null);
           }
           else
           {
           Game =new Game(PlayersCount,0,"Observer","Console");
           }
 }
 public void SetGameSetting()
 {
      Scanner Scan =new Scanner(System.in);
     

     
        System.out.println("Set Arena Size: ");
        System.out.println("Arena Length: ");
        int ArenaLength=Scan.nextInt();
        
        System.out.println("Arena Width: ");
        int ArenaWidth=Scan.nextInt();
        
        System.out.println("Maximum Number Of Rounds: ");
        int MaximumNumberOfRounds=Scan.nextInt();
        
        System.out.println("Team Size: ");
        int TeamSize=Scan.nextInt();
        
        System.out.println("Maximum Allowed Swaps : ");
        int MaximumAllowedSwaps=Scan.nextInt();
        
        System.out.println("Accepted Class : ");
        System.out.println("How Many Accepted Class : ");
         int size= Scan.nextInt();

        String [] AcceptedClasses=new String[size];
        for(int i=0;i<AcceptedClasses.length;i++)
        {
         System.out.println("N)New Accepted Class");
         System.out.println("S)Stop");
         String Choise= Scan.next();
        if(Choise.equalsIgnoreCase("N"))
         AcceptedClasses[i]= Scan.next();
        if(Choise.equalsIgnoreCase("s"))
         break;
        }
    Game.setGameSetting(ArenaLength, ArenaWidth, TeamSize, MaximumNumberOfRounds, MaximumAllowedSwaps,AcceptedClasses);

    
 }
 
 public void play(){Game.play();}
    public static void main(String[] args) {
       Scanner Scan =new Scanner(System.in);

       TacticalChaos  TacticalChaos=new TacticalChaos();
     
       TacticalChaos.SetGameMode();
       System.out.println("S)Game Setting ");
       System.out.println("P)Play ");
       String C=Scan.next();
        if(C.equalsIgnoreCase("s"))
        TacticalChaos.SetGameSetting();

        TacticalChaos.play();
        
        
        
        
    }
}
