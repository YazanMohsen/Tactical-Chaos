
package Player;

import Battlefield.Arena;
import Battlefield.Square;
import Champions.Champion;
import MoveFactory.ActivateAatroxAbilityMove;
import MoveFactory.BasicAttackMove;
import MoveFactory.BuyMove;
import MoveFactory.SellMove;
import MoveFactory.WalkMove;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Observer extends AutoPlayer {
    
    String Mode ;
    public Observer(String Mode)
    {
   this.Mode=Mode;
    
    } 
    public void Planning(Arena GameArena, List<Champion> TemporalStore, boolean AfterNinth) {
             
        boolean Repeated=true;
         ChampionsDeath();
                  ChampionsReload();

         SwapCount=0;
         this.GameArena=GameArena;

        while(Repeated)
        {
         if(Mode.equalsIgnoreCase("Console"))
         ShowArenaConsoleMode(GameArena);
            Repeated=setPlane(GameArena,TemporalStore,AfterNinth);
        }
        
    }
    
    private void ShowArenaConsoleMode(Arena GameArena)
    {
        System.out.println();
        System.out.println();

     int x=0;
        for(int i = 0 ; i <  GameArena.getArenaLength() ; i ++){
       
        System.out.println();
    
        for(int j = 0 ; j <  GameArena.getArenaWidth()  ; j ++)
        {
            
           Square Square= GameArena.get().get(x);
           boolean Empty=true;
           String Champions="";
             
            for (int k = 0; k < GameArena.getChampions().size(); k++) 
            {
               Champion champion=GameArena.getChampions().get(k);
                if(Square.equals(champion.getPosition()))
                {
                    Empty=false;
                    Champions=Champions+" "+champion.getName().substring(0,2)+champion.getPlayerNumber()+champion.getLevel()+"  ";
              }
            
            }
            if(Empty)
            System.out.print("  ###  ");
            
            else
             System.out.print(Champions);

    x++;    

        }
    }
    
            System.out.println();
        System.out.println();
        System.out.println();


}

}
