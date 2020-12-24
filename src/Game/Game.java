package Game;

import Battlefield.*;
import Champions.*;
import MoveFactory.*;
import Player.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
private Player currentPlayers[];
Arena GameArena;
List<Round>Rounds;
int MaximumNumberOfRounds=14;
int PlayersCount;
String []AcceptedClasses;

public void setGameSetting(int Length,int Width,int MaximumTeamSize ,int MaximumNumberOfRounds,int MaximumAllowedSwaps,
        String[] AcceptedClasses)
{
 this.GameArena=new Arena(Length,Width);
  
  this.MaximumNumberOfRounds=MaximumNumberOfRounds;
  
  for (int i = 0; i < PlayersCount; i++) {
 currentPlayers[i].setMaxTeamSize(MaximumTeamSize);
 currentPlayers[i].setMaxAllowedSwaps(MaximumAllowedSwaps);
  }
  this.AcceptedClasses=AcceptedClasses;

    

}

public Game(int PlayersCount,int AutoCount,String GameMode,String ObserverMode)
{
    
    this.PlayersCount=PlayersCount;
    currentPlayers=new Player[PlayersCount+AutoCount];
    
    GameArena=new Arena();
    
    if(GameMode.equalsIgnoreCase("Console"))
    {
    for (int i = 0; i < PlayersCount; i++) 
        currentPlayers[i]=new ConsolePlayer();
    }
    if(GameMode.equalsIgnoreCase("Observer"))
    {
    for (int i = 0; i < PlayersCount; i++) 
        currentPlayers[i]=new Observer(ObserverMode);
    }
    
    for (int i = PlayersCount; i < PlayersCount+AutoCount; i++) 
        currentPlayers[i]=new AutoPlayer();
    

}


public void play()
{
RoundManger RoundManger=new RoundManger();
RoundManger.RunTurn();


}

 class RoundManger{
     
public void RunTurn()
{

for(int i=0;i<MaximumNumberOfRounds;i++)
{
boolean AfterNinth=true;  

if(i<9)AfterNinth=false;
Planning p=new Planning(GameArena,currentPlayers,AfterNinth,AcceptedClasses,5);
p.start();

if(AfterNinth)
{
ExecuteMove E=new ExecuteMove(GameArena,currentPlayers);
E.start();


}
}
}
 
 
 }

}

