package Champions.Damage;

import Champions.Champion;
import java.util.Random;

public class BasicAttackDamageCalculator extends DamageCalculator{

    public BasicAttackDamageCalculator(DamageCalculator Damage) {super(Damage);}
    
    public Champion CalaulateIntendedDamage()
{
    Random R=new Random();
    Champion Champion=Damage.CalaulateIntendedDamage();
    int Chance=Champion.getBuffCriticalStrikeChance();
    
    int Event=0;
    Event=R.nextInt(100);
    double AttackDamage=Champion.getBuffAttackDamage();
 
    if(Event<Chance)
     AttackDamage=AttackDamage+AttackDamage*Champion.getBuffCriticalStrikeDamage();
     
    Champion.setBuffAttackDamage(AttackDamage);
return Champion;

}
   
}
