package Champions.Damage;

import Champions.Champion;

public  class DamageCalculator {
protected DamageCalculator Damage;
private Champion Champion;

protected  DamageCalculator(DamageCalculator Damage){

    this.Damage=Damage;
}
public DamageCalculator(Champion Champion){
this.Champion=Champion;
}
public Champion CalaulateIntendedDamage(){return Champion;}
}


