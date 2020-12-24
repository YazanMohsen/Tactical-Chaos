package Game;

import Battlefield.Arena;
import Battlefield.Square;
import Champions.*;
import MoveFactory.Move;
import Player.ConsolePlayer;
import Player.Player;
import java.util.ArrayList;
import java.util.List;

public class Planning extends Round{
 
    List<Champion>TemporalStore;
    Player[] players;
    boolean AfterNinth;
    String []AcceptedClasses;
    int ChampionCount;
    Arena GameArena;
    StoreFilter sf;

    public Planning(Arena GameArena,Player[] players,boolean AfterNinth,String[]AcceptedClasses,int ChampionCount)
    {
    this.players=players;
    this.AfterNinth=AfterNinth;
    this.GameArena=GameArena;
    this.AcceptedClasses=AcceptedClasses;
    this.ChampionCount=ChampionCount;
    }
    
 
    
    public void start()
    {
       for(int i=0; i<players.length; i++)
       { 
           
           players[i].SetId(i+1);
           players[i].increaseMoney();
           GetTemporalList();
           players[i].Planning(GameArena,TemporalStore,AfterNinth);
           players[i].ClassesBuff();
     }
        
           
       }
    
    
        
    
    
public void GetTemporalList()
{
    if(AcceptedClasses==null)
    
    sf=new TemporalStoreFilter(ChampionCount,new StoreFilter()); 

    else
     sf=new TemporalStoreFilter(ChampionCount,new ChampionClassFilter(AcceptedClasses,new StoreFilter())); 
    
    TemporalStore=sf.getChampionList();


}

    
}