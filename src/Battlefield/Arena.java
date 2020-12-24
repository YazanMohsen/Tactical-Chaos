package Battlefield;
import Champions.Champion;
import java.util.*;

public class Arena {
List <Champion>Champions;
List< Square> Squares;
int Length;
int Width;
    public Arena(){

        Champions=new ArrayList<>();
        Squares=new ArrayList<>();
        Length=20;
        Width=20;
        for (int y= 0; y<Length; y++)
          for (int x = 0; x <Width; x++)
            Squares.add(new Square(x,y));
    }
    public Arena(int Length,int Width){

        Squares=new ArrayList<>();
        Champions=new ArrayList<>();
        this.Length=Length;
        this.Width=Width;
        for (int y= 0; y <this.Length; y++)
          for (int x = 0; x <this.Width; x++)
            Squares.add(new Square(x,y));
    }
    
    
    public void PutChampion(Champion Champion) {
    
        Champions.add(Champion);
        
    }
    
     public void DeleteChampion(Champion Champion) {
    
        Champions.remove(Champion);
        
    }
    
    public List< Square> get()
{
    return Squares;

}   public List<Champion> getChampions()
{
    return Champions;

}
    
    public List<Champion>getEnemy(Champion Champion,double tempRange)
    {
     
    List<Champion>temp =new ArrayList<>();
    
    Square tempPosition=Champion.getPosition();
    
    for (int i=0;i<Champions.size();i++)
    {     
   if(!Champion.equals(Champions.get(i)) )
   {
    if(Champion.getPlayerNumber()!=Champions.get(i).getPlayerNumber()&&Math.abs(tempPosition.getx()-Champions.get(i).getPosition().getx())<=tempRange)
    {      

        if(Math.abs(tempPosition.gety()-Champions.get(i).getPosition().gety())<=tempRange)

         temp.add(Champions.get(i));
    }
   }
    }
        return temp;
    
    }
    public int getArenaWidth(){return this.Width; }
    public int getArenaLength(){return this.Length; }
    public int CheckWinner()
    {
        int WinnerID=0;
        boolean alone =true;
        
        for (int i = 0; i < Champions.size(); i++) 
        { 
            WinnerID = Champions.get(i).getPlayerNumber();
              
        for (int j = 0; j < Champions.size(); j++) 
 
        if(WinnerID!=Champions.get(j).getPlayerNumber())
                    alone =false;
                }
        if(alone)
            return WinnerID;
    return 0;
    }   
}


