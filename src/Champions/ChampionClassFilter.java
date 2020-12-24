package Champions;

import Battlefield.Square;
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
import java.util.ArrayList;
import java.util.List;

public class ChampionClassFilter extends StoreFilter{
    
    
    ChampionsClass[] AcceptedClasses;
    
    public ChampionClassFilter(StoreFilter SotreFilter) {
        super(SotreFilter);
    }
 private ChampionsClass[] SettingActivedClasses(String[] AcceptedClasses)
    {       

        ChampionsClass[] ActivedClasses=new ChampionsClass[AcceptedClasses.length];
      int j=0;
      for(int i=0;i<AcceptedClasses.length;i++){
         
      switch(AcceptedClasses[i])
      {
          
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
 
 public ChampionClassFilter(String[] AcceptedClasses,StoreFilter decoratedSotreFilter)
  {
      this.decoratedSotreFilter=decoratedSotreFilter;
      this.AcceptedClasses=SettingActivedClasses(AcceptedClasses);
  }

   public List<Champion>getChampionList()
  {
      List<Champion> Wanted=new ArrayList<>();
      List<Champion>GetList=decoratedSotreFilter.getChampionList();
         
      for(int i=0;i<GetList.size();i++)
      {
          if(GetList.get(i).getPlayerNumber()==0)
          {
          boolean isIn=false;
          for(int j=0;j<AcceptedClasses.length;j++)
           for(int x=0;x<GetList.get(i).getActivedClasses().length;x++)
              if(AcceptedClasses[j]==GetList.get(i).getActivedClasses()[x])
              {
                  isIn=true;
                  break;
              }
      if(isIn)
      Wanted.add(GetList.get(i));
      }
          else
             continue ;
      }
     
      
      return Wanted;
  

}
public void print()
    {
        
    decoratedSotreFilter.print();
    }

}