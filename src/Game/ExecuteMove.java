package Game;

import Battlefield.Arena;
import MoveFactory.Move;
import Player.Player;
import java.util.List;
import java.util.Random;


public class ExecuteMove extends Round{
        Arena GameArena; 
        Player[] Players;
    public ExecuteMove(Arena GameArena,Player[]Players)
    {
    this.GameArena=GameArena;
        this.Players=Players;
    }
    @Override
   public void start() {
  Random Player=new Random();
      int x=0;
   int []taken=new int[Players.length];
        
         for(int j=0;j<taken.length;j++)
           taken[j]=-1;
   
  
   while(x!=Players.length)
   { 
   boolean NotTaken=true;
   int i=Player.nextInt(Players.length);
   for(int j=0;j<taken.length;j++)
   {
       if(taken[j]==i)
           NotTaken=false;
   }
   if(NotTaken)
   {
   taken[x]=i;
   List<Move>PlayerPlane=Players[i].getPlane();
   for(int j=0;j<PlayerPlane.size();j++)
   { 
   PlayerPlane.get(j).performMove();
   PlayerPlane.remove(j);
   }
   x++;
   }
   }
   
   
   }
    
}