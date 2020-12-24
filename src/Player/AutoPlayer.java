package Player;

import Battlefield.Arena;
import Battlefield.Square;
import Champions.Champion;
import MoveFactory.ActivateAatroxAbilityMove;
import MoveFactory.BasicAttackMove;
import MoveFactory.BuyMove;
import MoveFactory.SellMove;
import MoveFactory.WalkMove;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AutoPlayer extends Player{
    
    
    
       @Override
    public void Planning(Arena GameArena, List<Champion> TemporalStore, boolean AfterNinth) {
             
        boolean Repeated=true;
         ChampionsDeath();
         ChampionsReload();
         SwapCount=0;
         this.GameArena=GameArena;

        while(Repeated)
         Repeated=setPlane(GameArena,TemporalStore,AfterNinth);
        
        
    }
        
    
    @Override
    
    public boolean setPlane(Arena GameArena, List<Champion> TemporalStore, boolean AfterNinth) 
    {
         Random Order=new Random();
         
     //Choose Order
     int input=Order.nextInt(6);

     if(input ==0 && benchCount<MaxBenchCount  && BuyCount<=MaxBuyCount)//Buy
     {
         BuyCount++;
         //choose champion
        int TemporalStoreCount=TemporalStore.size();
            int ChampionNumber=Order.nextInt(TemporalStoreCount);  

            Champion newChampion=TemporalStore.get(ChampionNumber);
            TemporalStore.remove(ChampionNumber);
            if(newChampion.getGoldCost()<=Money)
            {
                new BuyMove(newChampion,this).PerformeMove();
                CalCulateLevel(newChampion,1); 

            }
    }
     
     if(input==1&&benchCount>0)//Sell
     {
         //choose champion

            int ChampionNumber=Order.nextInt(benchCount);  

            Champion Champion=bench[ChampionNumber];
           
            new SellMove(Champion,this).PerformeMove();
     }
      
    
     if(input ==2&&benchCount>0&&currentChampionsCount<MaxcurrentChampions)//Place on Arena
     {  //choose champion
         

            int ChampionNumber=Order.nextInt(benchCount);  

            Champion Champion=bench[ChampionNumber];
           
            int x=Order.nextInt(GameArena.getArenaWidth());  

            int y=Order.nextInt(GameArena.getArenaLength()); 

            DeleteFromBench(Champion);
            addTocurrentChampions(Champion);
            Champion.setPosition(new Square(x,y));
            GameArena.PutChampion(Champion); 
}
           
    if(input==3&& AfterNinth &&currentChampionsCount>0)//Actions
      {
   //choose champion

          int ChampionNumber=Order.nextInt(currentChampionsCount);  

           //choose Action
            Champion Champion=currentChampions[ChampionNumber];
            int choose=1;//Order.nextInt(3);  
            if(choose==0)//Attack
            {                                          
            List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getAttackRange());
           
            int VictimNumber=Order.nextInt(Victims.size());  
             
            Moves.add(new BasicAttackMove(Champion,Victims.get(VictimNumber)));
           
            }
            if(choose==1)//Walk
            {                  
            int Direction= Order.nextInt(8);
            WalkMove Move=new WalkMove(Champion);
            
            if(Direction==0&&Champion.getPosition().gety()-Champion.getMovementSpeed()>=0)Move.Up();
            if(Direction==1&&Champion.getPosition().gety()+Champion.getMovementSpeed()<=GameArena.getArenaLength())Move.Down();
            if(Direction==2&&Champion.getPosition().getx()+Champion.getMovementSpeed()<=GameArena.getArenaWidth())Move.Right();
            if(Direction==3&&Champion.getPosition().getx()-Champion.getMovementSpeed()>=0)Move.Left();
            
            if(Direction==4&&Champion.getPosition().gety()-Champion.getMovementSpeed()>=0&&Champion.getPosition().getx()+
            Champion.getMovementSpeed()<=GameArena.getArenaWidth()){Move.Up();Move.Right();}
          
            if(Direction==5&&Champion.getPosition().gety()+Champion.getMovementSpeed()<=GameArena.getArenaLength()&&
           Champion.getPosition().getx()+Champion.getMovementSpeed()<=GameArena.getArenaWidth()){Move.Up();Move.Left();}
           
            if(Direction==6&&Champion.getPosition().gety()-Champion.getMovementSpeed()>=0&&
          Champion.getPosition().getx()-Champion.getMovementSpeed()>=0){Move.Down();Move.Right();}
            
            if(Direction==7&&Champion.getPosition().gety()+Champion.getMovementSpeed()>=GameArena.getArenaLength()&&   
        Champion.getPosition().getx()-Champion.getMovementSpeed()>=0){Move.Down();Move.Left();}
            Moves.add(Move);
            }
       if(choose==2)//Ability
            {                                                   
           if(Champion.getName().equals("Aatrox"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,25);
            Moves.add(new ActivateAatroxAbilityMove(Champion,Victims));
           }

            
            }
    //Swap
       if(input==4&& benchCount>0&&SwapCount<MaxAllowedSwaps &&currentChampionsCount>0)
       { 

            int benchChampionNumber=Order.nextInt(benchCount);  
            Champion benchChampion=bench[benchChampionNumber];
            
            int currentChampionNumber=Order.nextInt(currentChampionsCount);  
            Champion currentChampionsChampion=currentChampions[currentChampionNumber];
            
            Swap(GameArena,benchChampion, currentChampionsChampion);
         
            
            
       }
    
    
    }
     if(input ==5)//Exit
     
       return false;  
       return true;  
    }
   }

 
