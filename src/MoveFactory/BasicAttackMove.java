
package MoveFactory;

import Champions.Champion;

public class BasicAttackMove extends Move{
    Champion Source;
    Champion Target;
    
    public BasicAttackMove(Champion Source,Champion Target)
    {
        this.Source=Source;
        this.Target=Target;
    }

    @Override
    public void performMove() {
       if(Target != null)
       {
           Target.AcceptDamage(Source.GetIntededDamgae());}
    }
    
}
