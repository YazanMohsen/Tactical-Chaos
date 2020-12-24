package Champions;

import Champions.*;
import static Champions.ChampionsClass.Assassin;
import static Champions.ChampionsClass.Blade_Master;
import static Champions.ChampionsClass.Brawler;
import static Champions.ChampionsClass.Demon;
import static Champions.ChampionsClass.Dragons;
import static Champions.ChampionsClass.Elementalist;
import static Champions.ChampionsClass.Glacial;
import static Champions.ChampionsClass.Gunslinger;
import static Champions.ChampionsClass.Imperial;
import static Champions.ChampionsClass.Knight;
import static Champions.ChampionsClass.Ninja;
import static Champions.ChampionsClass.Noble;
import static Champions.ChampionsClass.Pirate;
import static Champions.ChampionsClass.Ranger;
import static Champions.ChampionsClass.Shapeshifter;
import static Champions.ChampionsClass.Sorcerer;
import static Champions.ChampionsClass.Void;
import static Champions.ChampionsClass.Wild;
import static Champions.ChampionsClass.Yordle;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.util.Pair;




public class InGameStore {
    
    private static InGameStore Object;
    File ChampionsFile;
    Scanner scan=null;
    List<Champion>StoreChampions;
  
    private ChampionsClass[] SettingActivedClasses()
    {
        String [] Actived_Classes=new String [3];
        ChampionsClass[] ActivedClasses=new ChampionsClass[3];
      int j=0;
      for(int i=0;i<3;i++){
      Actived_Classes[i]=scan.next();
      switch(Actived_Classes[i]){
          
          case "-": 
 break;
         
          case "Demon":
       ActivedClasses[j]=Demon;
      j++;
      break;
       
          case "Dragons":
       ActivedClasses[j]=Dragons;
      j++;
      break;
       
       
       case "Glacial":
       ActivedClasses[j]=Glacial;
      j++;
      break;
       
       case "Imperial":
       ActivedClasses[j]=Imperial;
      j++;
      break;
       
       case "Noble":
       ActivedClasses[j]=Noble;
      j++;
      break;
       
       case "Ninja":
       ActivedClasses[j]=Ninja;
      j++;
      break;
       
       case "Pirate":
       ActivedClasses[j]=Pirate;
      j++;
      break;
       
       case "Wild":
       ActivedClasses[j]=Wild;
      j++;
      break;
      
       
       case "Void":
       ActivedClasses[j]=Void;
      j++;
      break;
       
       
       case "Yordle":
       ActivedClasses[j]=Yordle;
      j++;
      break;
       
       case "Assassin":
       ActivedClasses[j]=Assassin;
      j++;
      break;
       
       case "BladeMaster":
       ActivedClasses[j]=Blade_Master;
      j++;
      break;
       
       case "Brawler":
       ActivedClasses[j]=Brawler;
      j++;
      break;
       
       
       case "Elementalist":
       ActivedClasses[j]=Elementalist;
      j++;
      break;
       
       
       case "Gunslinger":
       ActivedClasses[j]=Gunslinger;
      j++;
      break;
       
       
       case "Knight":
       ActivedClasses[j]=Knight;
      j++;
      break;
      
      case "Ranger":
       ActivedClasses[j]=Ranger;
      j++;
      break;
      
      
      case "Shapeshifter":
       ActivedClasses[j]=Shapeshifter;
      j++;
      break;
      
      case "Sorcerer":
       ActivedClasses[j]=Sorcerer;
      j++;
      break;
      }
      }
      return ActivedClasses;
    }
    
    public List<Champion> getChampions()
   {
   return StoreChampions;
   }
   
    public void print()
    {
       
        for (int i = 0; i < StoreChampions.size(); i++) {
            System.out.println(StoreChampions.get(i).getName()+" "+ StoreChampions.get(i).getPlayerNumber());
        }
    }
    
    
    public static InGameStore getObject()
    {if(Object==null)
        Object=new InGameStore();
        return Object;}
  private  InGameStore()
   {

       ChampionsFile=new File("Appendix1.txt");
    
       try{ 
           scan=new Scanner(ChampionsFile); 
       }
       catch(Exception ex)
       {
       System.out.println(ex);
       }
       StoreChampions=new ArrayList<>();
     

       while (scan.hasNext())
       {
 
    String name =scan.next(); 

     
    ChampionsClass[]ActivedClasses=SettingActivedClasses();
    int ChampionCopyCount=scan.nextInt();
    
    Champion[] Champion=new Champion[ChampionCopyCount];
     
           int GoldCost=scan.nextInt();
           double Health=scan.nextDouble();
           double Armor=scan.nextDouble();
           double MagicResist=scan.nextDouble();
           double VisionRange=scan.nextDouble();
           double AttackRange=scan.nextDouble();
           double AttackDamage=scan.nextDouble();
           int MovementSpeed=scan.nextInt();

           int CriticalStrikeChance=scan.nextInt();

           double CriticalStrikeDamage=scan.nextDouble();
           int ManaStart=scan.nextInt();
           double ManaCost=scan.nextDouble();

           for(int i=0;i<ChampionCopyCount;i++)
    {              
       Champion[i]=new Champion(name,GoldCost,Health,Armor
               ,MagicResist,VisionRange,AttackRange,AttackDamage,MovementSpeed,CriticalStrikeChance,
               CriticalStrikeDamage,ManaStart,ManaCost,ActivedClasses);
   StoreChampions.add(Champion[i]);

    }
           
}
 
}
}
