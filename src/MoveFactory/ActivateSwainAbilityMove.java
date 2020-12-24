package MoveFactory;

import Champions.Champion;
import java.util.List;

public class ActivateSwainAbilityMove extends Move{
  Champion Source;
    List<Champion> Target;
    
   public ActivateSwainAbilityMove(Champion Source, List<Champion> Target)
    {
    this.Source=Source;
    this.Target=Target;
    }
   
    @Override
    public void performMove() {
    
    if(Source!=null){
    Source.setBuffAttackDamage(50);
    Source.setHealth(Source.getHealth()+50);
        for (int i = 0; i < Target.size(); i++) {
            Target.get(i).AcceptDamage(Source.GetIntededDamgae());
        }
    }
    }    
}
