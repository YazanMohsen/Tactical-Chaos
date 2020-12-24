
package MoveFactory;

import Champions.Champion;

public class ActivateYasouAbilityMove extends Move{
    
     Champion Source;
     Champion Target;
             
    
    public ActivateYasouAbilityMove(Champion Source, Champion Target)
    {
    this.Source=Source;
    this.Target=Target;
    }

    @Override
    public void performMove() 
    {
               if(Source!=null){
        Source.setBuffAttackDamage(150);
         if(Target!=null){
          Target.setStunned(2);
          Target.AcceptDamage(Source.GetIntededDamgae());
   
          }
    }
    }

    
    
}
