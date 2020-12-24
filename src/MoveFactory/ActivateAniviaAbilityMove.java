package MoveFactory;

import Champions.Champion;
import java.util.List;

public class ActivateAniviaAbilityMove extends Move{
        
     Champion Source;
     List<Champion> Target;
             
    
    public ActivateAniviaAbilityMove(Champion Source, List<Champion> Target)
    {
    this.Source=Source;
    this.Target=Target;
    }

    @Override
    public void performMove() 
    {
               if(Source!=null){
        Source.setBuffAttackDamage(250);
         for (int i = 0; i < Target.size(); i++) {
        if(Target.get(i)!=null){
          Target.get(i).setStunned(2);
          Target.get(i).AcceptDamage(Source.GetIntededDamgae());
   
          }
    }
    }
     }
}
