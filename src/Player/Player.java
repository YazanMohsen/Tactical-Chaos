package Player;

import Battlefield.*;
import Champions.*;
import MoveFactory.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {

    protected int id=0;
    protected  int MaxTeamSize=17;
    protected  int MaxcurrentChampions=MaxTeamSize/2;
    protected  int MaxBenchCount=MaxTeamSize/2;

    protected Champion currentChampions[]=new Champion[MaxTeamSize/2+1] ;

    protected int currentChampionsCount=0;
    protected int benchCount=0;
    
    protected Champion bench[]=new Champion[MaxTeamSize/2] ;

    protected int Money=0; 
    protected int SwapCount=0;
    protected Arena GameArena;
    protected List<Move>Moves=new ArrayList<>();
    

    protected  int MaxBuyCount=3;
    protected  int BuyCount;
    protected  int MaxAllowedSwaps=2;
    public Player(){ 
        if(MaxTeamSize%2==1)
        MaxcurrentChampions++;
    }
     public abstract void Planning(Arena GameArena,List<Champion>TemporalStore,boolean AfterNinth);
  public abstract   boolean setPlane(Arena GameArena,List<Champion> TemporalStore,boolean AfterNinth);
  public List<Move>getPlane(){return Moves;}
  
  public void DeleteFromBench(Champion Champion)
    {
    
       Champion [] temp=new Champion[8];
         int j=0;
            for(int i=0;i<benchCount;i++)
                if(!bench[i].equals(Champion))
                { temp[j]=bench[i];j++;}
            benchCount--;
           bench= temp;
        
     
    }
  public void DeleteFromCurrentChampions(Champion Champion)
    {
    
       Champion []temp=new Champion[8];
        int j=0;
       for(int i=0;i<currentChampionsCount;i++)
                if(!currentChampions[i].equals(Champion))
                {  temp[j]=currentChampions[i];j++;}
            currentChampionsCount--;
       currentChampions= temp;
         }
  public void addTocurrentChampions(Champion Champion){currentChampions[currentChampionsCount]=Champion; currentChampionsCount++;}
  public void addToBench(Champion Champion){bench[benchCount]=Champion;  benchCount++;}

  public void Swap(Arena GameArena,Champion benchChampion,Champion ArenaChampion)
    {
        if(SwapCount==MaxAllowedSwaps)return ;
        SwapCount++;
        int x=ArenaChampion.getPosition().getx();
        int y=ArenaChampion.getPosition().gety();
        
        benchChampion.setPosition(new Square(x,y)); 
        DeleteFromBench(benchChampion);
        DeleteFromCurrentChampions(ArenaChampion);
        addToBench(ArenaChampion);
        addTocurrentChampions(benchChampion);
        GameArena.PutChampion(benchChampion);
        GameArena.DeleteChampion(ArenaChampion);
    }

  public void setMoney(int ChampionPrice,boolean paid)
    {
     if(paid==true)
    Money=Money-ChampionPrice;
    else
    Money=Money+ChampionPrice;
    }
  public int getMoney(){return Money;}
  public void increaseMoney(){Money+=2;}
    
  public void SetId(int id){this .id=id;}
  public int getId(){return id;}
    
  public void setMaxAllowedSwaps(int MaxAllowedSwaps) {this.MaxAllowedSwaps=MaxAllowedSwaps;}
  public void setMaxTeamSize(int MaxTeamSize) {  this.MaxTeamSize=MaxTeamSize;}

  public void ChampionsDeath()
  {
  for(int i=0;i<currentChampionsCount;i++)
  {
     if(currentChampions[i].CheckDeath())
     {
         DeleteFromCurrentChampions(currentChampions[i]);
     currentChampions[i]=null;
         MaxBenchCount--;
     }
  }
  }
  public void ChampionsReload()
  {
  for(int i=0;i<currentChampionsCount;i++)
  currentChampions[i].Reload();
  }
  
 public void ChampionsStunned()
 {
 
  for(int i=0;i<currentChampionsCount;i++)
  currentChampions[i].setStunned(currentChampions[i].getStunned()-1);
  
 
 
 }

  
  protected void CalCulateLevel(Champion Champion,int Level)
  {
        if(Level>=3)
        return;
     int ChampionCount=1;
     Champion First=null;
     Champion Second=null;
     for (int i = 0; i < currentChampionsCount; i++)
      {
       if((Champion.getName()).equals(currentChampions[i].getName())&&Champion.getLevel()==Level)   
       {
           ChampionCount++; 
          if(First==null)
           First=currentChampions[i];      
          else
          Second=currentChampions[i];

       } 
      }
       for (int i = 0; i <benchCount; i++)
        {
           if((Champion.getName()).equals(bench[i].getName())&&Champion.getLevel()==Level)   
       {
           ChampionCount++; 
          if(First==null)
           First=bench[i];      
          else
          Second=bench[i];

       }
      }
  if(Champion.getLevel()==2){
      Champion.setAttackDamage(Champion.getAttackDamage()*0.1+Champion.getAttackDamage());
      Champion.setHealth(Champion.getHealth()*0.2+Champion.getHealth());
            Champion.setArmor(Champion.getArmor()*0.2+Champion.getArmor());
      Champion.setMagicResist(Champion.getMagicResist()*0.2+Champion.getMagicResist());
  
  
  }
  if(Champion.getLevel()==3){
      Champion.setAttackDamage(Champion.getAttackDamage()*0.15+Champion.getAttackDamage()*0.1);
      Champion.setArmor(Champion.getArmor()*0.25+Champion.getArmor());
      Champion.setHealth(Champion.getHealth()*0.25+Champion.getHealth());
      Champion.setMagicResist(Champion.getMagicResist()*0.25+Champion.getMagicResist());
  }
  if(ChampionCount==3)
  {
  Champion.Promote();
  First=null;
  Second=null;
  
  CalCulateLevel(Champion,Level+1);
  }
  
  
  }

  public void ClassesBuff()
  {
     int [] ChampionsClassCount=new int[ChampionsClass.values().length];
      for (int i = 0; i < currentChampionsCount; i++)    
      for (int j = 0; j < currentChampions[i].getActivedClasses().length; j++) 
      {  
       if(currentChampions[i].getActivedClasses()[j]!=null)
       ChampionsClassCount[ currentChampions[i].getActivedClasses()[j].ordinal()]++;
      }
      
      //Imperial
      if(ChampionsClassCount[ChampionsClass.Imperial.ordinal()]>=1)
      {      
      List <Champion> temp = new ArrayList<>();     
      temp=getClassesChampions(ChampionsClass.Imperial);
      for(int i=0;i<temp.size();i++)
      { 
      Champion Champion =temp.get(i);
      Champion.setBuffAttackDamage(Champion.getBuffAttackDamage()*2);
      
      }
      
      }
      //Noble   
     if(ChampionsClassCount[ChampionsClass.Noble.ordinal()]>=3)
      {
          if(ChampionsClassCount[ChampionsClass.Noble.ordinal()]==6)
           for (int i = 0; i < currentChampionsCount; i++) {
               {
                   Champion Champion=   currentChampions[i];
                   Champion.setArmor(Champion.getArmor()+20);
           }
       if(ChampionsClassCount[ChampionsClass.Noble.ordinal()]==3){
          Champion Champion= currentChampions[new Random().nextInt(currentChampionsCount)];
               Champion.setArmor( Champion.getArmor()+20);
       }
      }
      }
     //Ninja
     if(ChampionsClassCount[ChampionsClass.Ninja.ordinal()]>=1)
      {
            List <Champion> temp = new ArrayList<>();     
 
          if(ChampionsClassCount[ChampionsClass.Ninja.ordinal()]==1)
          { 
          temp=getClassesChampions(ChampionsClass.Ninja);
          Champion Champion=temp.get(0);
          Champion.setCriticalStrikeChance(50);
          Champion.setCriticalStrikeDamage(0.2);
          }
       else
         { 
          temp=getClassesChampions(ChampionsClass.Ninja);
             for (int i = 0; i < temp.size(); i++) {
              Champion Champion=temp.get(i);
          Champion.setCriticalStrikeChance(75);
          Champion.setCriticalStrikeDamage(0.3);}
          }
      }
      //Pirate
      if(ChampionsClassCount[ChampionsClass.Pirate.ordinal()]==3)
      increaseMoney();
      
      //Brawler
      if(ChampionsClassCount[ChampionsClass.Brawler.ordinal()]>=2)
      {      
      int Extra=0;
      List <Champion> temp = new ArrayList<>();     
      temp=getClassesChampions(ChampionsClass.Brawler);
      for(int i=0;i<temp.size();i++)
      { 
      Champion Champion =temp.get(i);
      if(ChampionsClassCount[ChampionsClass.Brawler.ordinal()]==2)
      Extra=250;
      if(ChampionsClassCount[ChampionsClass.Brawler.ordinal()]==4)
      Extra=500;
      if(ChampionsClassCount[ChampionsClass.Brawler.ordinal()]==6)
      Extra=1000; 
      Champion.setHealth(Champion.getHealth()+Extra);
      }
      }
      
      //Elementalist
      if(ChampionsClassCount[ChampionsClass.Elementalist.ordinal()]>=2)
      {      
      int Extra=0;
      List <Champion> temp = new ArrayList<>();     
      temp=getClassesChampions(ChampionsClass.Elementalist);
      for(int i=0;i<temp.size();i++)
      { 
      Champion Champion =temp.get(i);
      if(ChampionsClassCount[ChampionsClass.Elementalist.ordinal()]==2)
         Champion.setMana(Champion.getMana()*2);
      if(ChampionsClassCount[ChampionsClass.Elementalist.ordinal()]==4)
      { 
          Champion.setMana(Champion.getMana()*2);
      }
      
      }
      }
      
      
     if(ChampionsClassCount[ChampionsClass.Ranger.ordinal()]>=3)
      {      
      List <Champion> temp = new ArrayList<>();     
      temp=getClassesChampions(ChampionsClass.Ranger);
      for(int i=0;i<temp.size();i++)
      { 
          Champion Champion =temp.get(i);
          Champion.setAttackRange(Champion.getAttackRange()*2);
          Champion.setVisionRange(Champion.getVisionRange()*2);
      
      }
      }
       if(ChampionsClassCount[ChampionsClass.Shapeshifter.ordinal()]>=3)
      {      
      List <Champion> temp = new ArrayList<>();     
      temp=getClassesChampions(ChampionsClass.Shapeshifter);
      for(int i=0;i<temp.size();i++)
      { 
          Champion Champion =temp.get(i);
          if(ChampionsClassCount[ChampionsClass.Shapeshifter.ordinal()]==3)
          Champion.setHealth(Champion.getHealth()*0.4+Champion.getHealth());
                
          if(ChampionsClassCount[ChampionsClass.Shapeshifter.ordinal()]==6)
          Champion.setHealth(Champion.getHealth()*2);

      
      }
      }
      
      
      
        
  }

  
  protected List<Champion> getClassesChampions(ChampionsClass championsClass)
  {
  List<Champion> temp=new ArrayList<>();
      for (int i = 0; i < currentChampionsCount; i++)
      {
      for (int j = 0; j < currentChampions[i].getActivedClasses().length; j++)
     if(currentChampions[i].getActivedClasses()[j].equals(championsClass))
          {
       temp.add(currentChampions[i]);
          }
      }
  return temp;
  }
public void Win()
{


}
  

}