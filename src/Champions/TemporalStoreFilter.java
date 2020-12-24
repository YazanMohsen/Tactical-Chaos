package Champions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TemporalStoreFilter  extends StoreFilter{ 
   int ChampNumber;
   
    public TemporalStoreFilter(int ChampNumber,StoreFilter SotreFilter) {
        super(SotreFilter);
    this. ChampNumber=ChampNumber;
    }

    public List<Champion> getChampionList()
{
     List<Champion>Temp=new ArrayList<>();
     Random r=new Random(); 
     int random=0;

     
     List<Champion>GetList=decoratedSotreFilter.getChampionList();
     for (int i = 0; i < ChampNumber; i++) 
     {
         boolean Repeated=false;
         
         random=r.nextInt(GetList.size());
         Champion Champion =GetList.get(random);
       
         if(Champion.getPlayerNumber()==0)
         {
         for(int j=0;i<Temp.size();i++)
             if(Temp.get(j).getName().equals(Champion.getName()))
                Repeated=true;
       
             if(Repeated==false)
                Temp.add(Champion);
         }
         else
             i--;
     }
     
return Temp;
    }
    public void print()
    {
        
    decoratedSotreFilter.print();
    }

}