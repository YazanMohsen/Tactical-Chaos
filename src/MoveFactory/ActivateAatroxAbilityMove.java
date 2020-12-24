
package MoveFactory;

import Champions.*;
import Champions.Damage.*;
import java.util.List;

public class ActivateAatroxAbilityMove extends Move{
    Champion Source;
    List<Champion> Targets;
    public ActivateAatroxAbilityMove(Champion Source,List<Champion> Targets)
    {
     this.Source= Source;
    this.Targets=Targets;
    }

    @Override
    public void performMove() {
                    
        if(Source!=null)
        {
        Source.setBuffAttackDamage(250);
        for (int i = 0; i < Targets.size(); i++) {
        Targets.get(i).AcceptDamage(new DamageCalculator(Source));
        }
    }
    }
    
}
