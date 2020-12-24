package Player;

import Battlefield.*;
import Champions.*;

import MoveFactory.*;
import java.util.*;

public class ConsolePlayer extends Player{
    
     public void Planning(Arena GameArena,List<Champion>TemporalStore,boolean AfterNinth)
     {
         boolean Repeated=true;
         this.BuyCount=0;
         ChampionsDeath();
         ChampionsReload();
         ChampionsStunned();
         SwapCount=0;
         this.GameArena=GameArena;

         while(Repeated)
      {        
         System.out.print("Player: "+id);
         System.out.println("    Money: "+Money);
         
        
         System.out.println();
         System.out.println();
         ShowArena(GameArena,AfterNinth);
         System.out.println();
         System.out.println("Store: ");
         for (int i = 0; i <TemporalStore.size(); i++) 
         System.out.print(TemporalStore.get(i).getName()+" "+TemporalStore.get(i).getGoldCost()+"      ");
         System.out.println();
 
         for (int i = 1; i <=  TemporalStore.size(); i++) 
         System.out.print(i+"              ");
                
         System.out.println();
         System.out.println();
     
         
         System.out.println("Bench: ");      
          for(int i=0;i<benchCount;i++)
             System.out.print(bench[i].getName()+"   ");

           System.out.println();

         System.out.println();
         System.out.println("Ties: ");      
         ShowCurrentChampions();
         
          System.out.println();
         Repeated=setPlane(GameArena,TemporalStore,AfterNinth); 
      }
     }
    
    public boolean setPlane(Arena GameArena,List<Champion> TemporalStore,boolean AfterNinth) 
    {

         Scanner scan=new Scanner(System.in); 
         System.out.println("Choose Order:");
            System.out.println();

        
         if(benchCount<MaxBenchCount  && BuyCount<=MaxBuyCount)
          System.out.println("B)Buy");
   
         if(benchCount>0)
         System.out.println("S)Sell");
     
     
         if(!AfterNinth&&benchCount>0&&currentChampionsCount<MaxcurrentChampions)
         System.out.println("P)Place Champion");
         
         if(benchCount>0&&SwapCount<MaxAllowedSwaps&&currentChampionsCount>0)
         System.out.println("R)Replace");
   
         if(AfterNinth&&currentChampionsCount>0)
         System.out.println("A)Actions");
       
     
         System.out.println("E)END");
         System.out.println();

   
   
//Choose Order
     String input=scan.next();
     
     if(input.equalsIgnoreCase("B")&& MaxBuyCount>BuyCount && benchCount< MaxBenchCount)//Buy
     {
         //choose champion
         System.out.println("Choose champion: ");
         int ChampionNumber=50;

         try{         

         ChampionNumber =scan.nextInt()-1;  
     }
     catch(Exception Ex)
     {
         System.err.println("Your Input Invalid");
     }
     if(ChampionNumber<=TemporalStore.size()){
     Champion newChampion=TemporalStore.get(ChampionNumber);
            if(newChampion.getGoldCost()<=Money)
            {            BuyCount++;

                new BuyMove(newChampion,this).PerformeMove();
                CalCulateLevel(newChampion,1);
              TemporalStore.remove(ChampionNumber);

            }
            else if(newChampion.getGoldCost()>Money)
            System.out.println("You Can't Buy This Champion");
     }
     }
     
     if(input.equalsIgnoreCase("S")&&benchCount>0)//Sell
     {
         //choose champion
         System.out.println("Choose Champion");
         
            int ChampionNumber=scan.nextInt()-1;  
            
            Champion Champion=bench[ChampionNumber];
           
            new SellMove(Champion,this).PerformeMove();
     }
      
     if(input .equalsIgnoreCase("P")&&!AfterNinth&&benchCount>0&&currentChampionsCount<MaxcurrentChampions)//Place on Arena
     {
     //choose champion
         ShowBench();
           for(int i=1;i<=benchCount;i++)
            System.out.print(i+"                       ");
            
            System.out.println();
            System.out.println("Choose Champion: ");

            int ChampionNumber=scan.nextInt()-1;  
            Champion Champion=bench[ChampionNumber];
           int x=0;
           int y=0;
           
            do{ 
                System.out.print("x = ");
         
                 x=scan.nextInt()-1;  
            
            }
            while(x>GameArena.getArenaWidth()-1);
            do{ 
                System.out.print("y = ");
            
                 y=scan.nextInt()-1;  
               }
            while(y>GameArena.getArenaLength()-1);
        
            
            DeleteFromBench(Champion);
            addTocurrentChampions(Champion);
            Champion.setPosition(new Square(x,y));
            GameArena.PutChampion(Champion); 
      }
               //Swap

       if(input.equalsIgnoreCase("R")&&benchCount>0 &&SwapCount<MaxAllowedSwaps&&currentChampionsCount>0)
       { 
           
     for(int i=0;i<benchCount;i++)
            System.out.print(bench[i].getName()+"           ");
            System.out.println();

         for(int i=1;i<=benchCount;i++)
            System.out.print(i+"                       ");
            
            System.out.println();
       
            System.out.println("Choose Champion: ");
            int benchChampionNumber=scan.nextInt()-1;  
            
            Champion benchChampion=bench[benchChampionNumber];
            
            System.out.println();
            System.out.println();

            for(int i=0;i<currentChampionsCount;i++)
            System.out.print(currentChampions[i].getName()+"      ");
                        System.out.println();

            for(int i=1;i<=currentChampionsCount;i++)
            System.out.print(i+"                       ");
            
            System.out.println();
       
            System.out.println("Choose Champion: ");
            int currentChampionsNumber=scan.nextInt()-1;  
            Champion currentChampion=currentChampions[currentChampionsNumber];
            Swap(GameArena,benchChampion, currentChampion);
         
            
       }
             
     
     
    if(input.equalsIgnoreCase("A")&& AfterNinth &&currentChampionsCount>0)//Actions
   //choose champion
      {
         ShowCurrentChampions();
         System.out.println();

          for(int i=1;i<=currentChampionsCount;i++)
            System.out.print(i+"                       ");    
          
          System.out.println();

          System.out.println("Choose Champion: ");

          int ChampionNumber=scan.nextInt()-1;  
   
           //choose Action
            Champion Champion=currentChampions[ChampionNumber];
            if(currentChampions[ChampionNumber].getStunned()>0)
            {
                System.out.println("This Champion is Stunned");
            return true;
            }    
            System.out.println("A)Attack");
            
            System.out.println("W)Walk");
            
            System.out.println("U)Use Ability");

            String Choose=scan.next();  
            if(Choose.equalsIgnoreCase("A"))//Attack
            {
            List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getAttackRange());
           
            for(int i=0;i<Victims.size();i++)
            System.out.print(Victims.get(i).getName()+"     ");
             
            System.out.println();
             
            for(int i=1;i<=Victims.size();i++)
            System.out.print(i+"        ");
            
            System.out.println();

            System.out.println("Choose The Champion You Want To Attack: ");
            int VictimNumber=scan.nextInt()-1;  
            Moves.add(new BasicAttackMove(Champion,Victims.get(VictimNumber)));
           
            }
            if(Choose.equalsIgnoreCase("W"))//Walk
            {
           System.out.println("Choose The Direction: ");
            if(Champion.getPosition().gety()-Champion.getMovementSpeed()>=0)

                
if(Champion.getPosition().gety()-Champion.getMovementSpeed()>=0)
System.out.print("Up -> U");


if(Champion.getPosition().gety()+Champion.getMovementSpeed()<=GameArena.getArenaLength())
System.out.println("Down ->D");


if(Champion.getPosition().getx()+Champion.getMovementSpeed()<=GameArena.getArenaWidth())
System.out.println("Right ->R");

if(Champion.getPosition().getx()-Champion.getMovementSpeed()>=0)
System.out.println("Left ->L ");


if(Champion.getPosition().gety()-Champion.getMovementSpeed()>=0&&Champion.getPosition().getx()+
        Champion.getMovementSpeed()<=GameArena.getArenaWidth())
System.out.println("Up Right ->UR ");

if(Champion.getPosition().gety()+Champion.getMovementSpeed()<=GameArena.getArenaLength()&&
        Champion.getPosition().getx()+Champion.getMovementSpeed()<=GameArena.getArenaWidth())
System.out.println("Down Right ->DR");


if(Champion.getPosition().gety()-Champion.getMovementSpeed()>=0&&
        Champion.getPosition().getx()-Champion.getMovementSpeed()>=0)
System.out.println("Up Left -> UL");


if(Champion.getPosition().gety()+Champion.getMovementSpeed()>=GameArena.getArenaLength()&&   
        Champion.getPosition().getx()-Champion.getMovementSpeed()>=0)
System.out.println("Down Left-> DL ");
             
            String Direction= scan.next();
            WalkMove Move=new WalkMove(Champion);
            if(Direction.equalsIgnoreCase("U"))Move.Up();
            if(Direction.equalsIgnoreCase("D"))Move.Down();
            if(Direction.equalsIgnoreCase("R")) Move.Right();
            if(Direction.equalsIgnoreCase("L"))Move.Left();
            if(Direction.equalsIgnoreCase("UR")){Move.Up();Move.Right();}
            if(Direction.equalsIgnoreCase("DR")){Move.Down();Move.Right();}
            if(Direction.equalsIgnoreCase("UL")) {Move.Up();Move.Left();}
            if(Direction.equalsIgnoreCase("DL")){Move.Down();Move.Left();}
            Moves.add(Move);
            
            }
       if(Choose.equalsIgnoreCase("U"))//Ability
            {
           if(Champion.getName().equals("Aatrox"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,25);
            Moves.add(new ActivateAatroxAbilityMove(Champion,Victims));
           }
           if(Champion.getName().equals("Leona"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getVisionRange());
            Moves.add(new ActivateLeonaAbilityMove(Champion,Victims));
           }
            if(Champion.getName().equals("Yasou"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getVisionRange());
            Moves.add(new ActivateYasouAbilityMove(Champion,Victims.get(0)));
           }
            if(Champion.getName().equals("Veiger"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getVisionRange());
            Moves.add(new ActivateVeigerAbilityMove(Champion,Victims.get(0)));
           }
            if(Champion.getName().equals("Varus"))
           { 
            Moves.add(new ActivateVarusAbilityMove(Champion));
           }
            if(Champion.getName().equals("Swain"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getVisionRange());
           Moves.add(new ActivateSwainAbilityMove(Champion,Victims));
           }
            if(Champion.getName().equals("Talon"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,Champion.getVisionRange());
            Moves.add(new ActivateTalonAbilityMove(Champion));
           }
            if(Champion.getName().equals("Anivia"))
           { 
           List<Champion>Victims=GameArena.getEnemy(Champion,30);
            Moves.add(new ActivateAniviaAbilityMove(Champion,Victims));
           }
            
            }
      }
     if(input.equalsIgnoreCase("E"))//Exit
       return false;      
       return true;      
    
    }
    
    private void ShowArena(Arena GameArena,boolean AfterNinth)
    {
      List< Champion> Print=new ArrayList<>();       

     for( int counter=0;counter<currentChampionsCount;counter++)
     {
         Print.add(currentChampions[counter]);
         if(AfterNinth){
         for(int i=0;i<GameArena.getEnemy(currentChampions[counter],currentChampions[counter].getVisionRange()).size();i++)
         {    
             Champion Enemy=GameArena.getEnemy(currentChampions[counter],currentChampions[counter].getVisionRange()).get(i);
             boolean NewEnemy=true;  
             for( int j=0;j<Print.size();j++)
               {
               if(Print.get(j).equals(Enemy))
                NewEnemy=false;   
               }
             if(NewEnemy)
             Print.add(Enemy);
         } 
         }
     }

     int x=0;
        for(int i = 0 ; i <  GameArena.getArenaLength() ; i ++){
       
        System.out.println();
    
        for(int j = 0 ; j <  GameArena.getArenaWidth()  ; j ++)
        {
            Square Square=GameArena.get().get(x);
            String Champions="";
            boolean Empty=true;
            for( int counter=0;counter<Print.size();counter++)
            {  
                Champion champion=Print.get(counter);
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
        
    }
  
    private void ShowBench()
    {
             for(int i=0;i<benchCount;i++)
             System.out.print(bench[i].getName()+"                ");
                        
            System.out.println();

            
    }

    private void ShowCurrentChampions()
    {
    
     for(int i=0;i<currentChampionsCount;i++)
     {     System.out.print(currentChampions[i].getName()+"   ");

         System.out.print(currentChampions[i].getHealth()+"   ");
     
          for(int j=0;j<currentChampions[i].getActivedClasseslength();j++)
          {
              if(currentChampions[i].getActivedClasses()[j]!=null)
              System.out.print(currentChampions[i].getActivedClasses()[j]+"   ");
          } 
     }             
            System.out.println();

    }
   
    public void Win()
    {
    System.out.println("Player "+ id+ " Win!!");
    }
}
