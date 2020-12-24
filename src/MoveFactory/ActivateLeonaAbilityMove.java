package MoveFactory;

import Champions.Champion;
import java.util.List;

public class ActivateLeonaAbilityMove extends Move{

List<Champion> Target;
Champion Source;
public ActivateLeonaAbilityMove(Champion Source,List<Champion> Target)
{
    this.Source=Source;
this.Target=Target;
}

    @Override
    public void performMove() 
    {
        //Stun For 2 Rounds
                       if(Source!=null){

        for (int i = 0; i < Target.size(); i++) {
            
       if(Target.get(i)!=null)
       Target.get(i).setStunned(2);
    
        }
    }
    }
    


}
