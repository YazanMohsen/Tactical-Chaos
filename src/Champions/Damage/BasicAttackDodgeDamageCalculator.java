package Champions.Damage;

import Champions.Champion;

public class BasicAttackDodgeDamageCalculator extends DamageCalculator{
    private Champion Champion;
    public BasicAttackDodgeDamageCalculator(Champion Champion,DamageCalculator Damage) {
        super(Damage);
        this.Champion=Champion;
    }
    @Override
    public Champion CalaulateIntendedDamage()
{ 
    
    double Armor=Champion.getBuffArmor();
    Champion Attacker=Damage.CalaulateIntendedDamage();
    double AttackDamage= Attacker.getBuffAttackDamage();
    AttackDamage=AttackDamage-AttackDamage*Armor;

    Attacker.setAttackDamage(AttackDamage);
    return Attacker;
    
}
}
