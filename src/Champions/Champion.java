package Champions;

import Battlefield.Square;
import Champions.Damage.BasicAttackDamageCalculator;
import Champions.Damage.BasicAttackDodgeDamageCalculator;
import Champions.Damage.DamageCalculator;
import MoveFactory.Move;
import java.util.List;

public class Champion
{
  
    private ChampionsClass ActivedClasses[];
    private ChampionAttributes Attributes ;
                  
    
    public Champion(){}
    public  Champion(String name,int GoldCost,double Health,double Armor,double MagicResist,double VisionRange,
            double AttackRange, double AttackDamage,int MovementSpeed,int CriticalStrikeChance,
            double CriticalStrikeDamage,double ManaStart,double ManaCost,ChampionsClass ActivedClasses[])
    {
        Attributes=new ChampionAttributes(name,GoldCost,Health,Armor,MagicResist,VisionRange,AttackRange,AttackDamage,
        MovementSpeed,CriticalStrikeChance,CriticalStrikeDamage,ManaStart,ManaCost);
       this.ActivedClasses=ActivedClasses;
    }
 
    public int getActivedClasseslength(){return ActivedClasses.length;}
    
    public ChampionsClass[] getActivedClasses() {
        return ActivedClasses;
    }

    public void setActivedClasses(ChampionsClass[] ActivedClasses) {
       this.ActivedClasses = ActivedClasses;
    }

    public int getPlayerNumber() {
        return Attributes.getPlayerNumber();
    }

    public void setPlayerNumber(int PlayerNumber) {
       Attributes.setPlayerNumber(PlayerNumber);
    }

    public int getLevel() {
        return Attributes.getLevel();
    }

   public void setLevel(int Level) {
   Attributes.setLevel(Level);
   }

    public void Promote() {
      Attributes.IncreaseLevel();
    }

    public Square getPosition() {
        return Attributes.getPosition();
    }

    public void setPosition(Square Position) {
        Attributes.setPosition(Position);
    }

    public String getName() {
        return Attributes.getName();
    }

    public void setName(String name) {
       Attributes.setName (name);
    }

    public int getGoldCost() {
        return Attributes.getGoldCost();
    }

    public void setGoldCost(int GoldCost) {
      Attributes.setGoldCost(GoldCost);
    }

    public double getHealth() {
        return Attributes.getHealth();
    }

    public double getMaxHealth() {
        return Attributes.getMaxHealth();
    }
    public void setHealth(double Health) {
       Attributes.setHealth (Health);
    }
    public void setMaxHealth(double MaxHealth) {
       Attributes.setMaxHealth (MaxHealth);
    }

    public double getArmor() {
        return Attributes.getArmor();
    }

    public void setArmor(double Armor) {
       Attributes.setArmor (Armor);
    }

    public double getMagicResist() {
        return Attributes.getMagicResist();
    }

    public void setMagicResist(double MagicResist) {
        Attributes.setMagicResist( MagicResist);
    }

    public double getVisionRange() {
        return Attributes.getVisionRange();
    }

    public void setVisionRange(double VisionRange) {
      Attributes.setVisionRange ( VisionRange);
    }

    public double getAttackRange() {
        return Attributes.getAttackRange();
    }

    public void setAttackRange(double AttackRange) {
       Attributes.setAttackRange(AttackRange);
    }

    public double getAttackDamage() {
        return Attributes.getAttackDamage();
    }

    public void setAttackDamage(double AttackDamage) {
      Attributes.setAttackDamage(AttackDamage);
    }

    public int getMovementSpeed() {
        return Attributes.getMovementSpeed();
    }

    public void setMovementSpeed(int MovementSpeed) {
      Attributes.setMovementSpeed(MovementSpeed);
    }

    public int getCriticalStrikeChance() {
        return Attributes.getCriticalStrikeChance();
    }

    public void setCriticalStrikeChance(int CriticalStrikeChance) {
        Attributes.setCriticalStrikeChance(CriticalStrikeChance);
    }

    public double getCriticalStrikeDamage() {
        return Attributes.getCriticalStrikeDamage();
    }

    public void setCriticalStrikeDamage(double CriticalStrikeDamage) {
     Attributes.setCriticalStrikeDamage ( CriticalStrikeDamage);
    }

    public double getMana() {
        return Attributes.getMana();
    }

    public void setMana(double Mana) {
        Attributes.setMana (Mana);
    }

    public double getManaCost() {
        return Attributes.getManaCost();
    }

    public void setManaCost(double ManaCost) {
       Attributes.setManaCost (ManaCost);
    }

    public int getStunned() {
            return Attributes.getStunned();
    }

    public void setStunned(int Stunned) {
        Attributes.setStunned(Stunned);
        }
    public void DecreaseStunned() {
        Attributes.DecreaseStunned();
        }
    
    public boolean CheckDeath(){
    
        if(Attributes.getHealth()<=0)
             return true;
        return false;
    }
    public void AcceptDamage(DamageCalculator DamageCalculator)
    {
        double Attack=new BasicAttackDodgeDamageCalculator(this,DamageCalculator).CalaulateIntendedDamage().getBuffAttackDamage();
        setHealth(getHealth()-Attack);
        Attributes.IncreaceMana();
    }
    public DamageCalculator GetIntededDamgae()
    {
       return new BasicAttackDamageCalculator(new DamageCalculator(this));
        
    }
    public void setBuffAttackDamage(double BuffAttackDamage)
   {
   this.Attributes.setBuffAttackDamage(BuffAttackDamage);
   }
   
   public double getBuffAttackDamage()
   {
   return this.Attributes.getBuffAttackDamage();
   }
    public void setBuffArmor(double BuffArmor)
   {
   this.Attributes.setBuffArmor(BuffArmor);}
   
   public double getBuffArmor()
   {
   return this.Attributes.getBuffArmor();
   }
   public void setBuffCriticalStrikeChance(int BuffCriticalStrikeChance)
   {
   this.Attributes.setBuffCriticalStrikeChance(BuffCriticalStrikeChance);
   }
   
   public int getBuffCriticalStrikeChance()
   {
   return this.Attributes.getBuffCriticalStrikeChance();
   }
   public void setBuffCriticalStrikeDamage(double BuffCriticalStrikeDamage)
   {
   this.Attributes.setBuffCriticalStrikeDamage(BuffCriticalStrikeDamage);
   }
   
   public double getBuffCriticalStrikeDamage()
   {
   return this.Attributes.getBuffCriticalStrikeDamage();
   }
   
   
   public void  Reload()
   {
   Attributes.Reload();
   }
   public void MoveUp()
    {
        
        Square CurrentPosition=this.getPosition();
       
        int y=CurrentPosition.gety()-this.getMovementSpeed();
        int x=CurrentPosition.getx();
        this.setPosition(new Square(x,y));
       
        }
   
    public void MoveDown()
    {
        
        Square CurrentPosition=this.getPosition();
        
        int y=CurrentPosition.gety()+this.getMovementSpeed();
        int x=CurrentPosition.getx();
        
       this.setPosition(new Square(x,y));
       
        }
       
    public void MoveRight()
    {
        
        Square CurrentPosition=this.getPosition();
        
        int x=CurrentPosition.getx()+this.getMovementSpeed();
        int y=CurrentPosition.gety();
         this.setPosition(new Square(x,y));
      
        }
    
    public void MoveLeft()
    {
        
        Square CurrentPosition=this.getPosition();
        
        int x=CurrentPosition.getx()-this.getMovementSpeed();
        int y=CurrentPosition.gety();
         this.setPosition(new Square(x,y));
        }
    
    class ChampionAttributes
            {

        
        
    ChampionAttributes(){ManaStart=0;}
    private int PlayerNumber=0;
    private int Level=1;
    private Square Position=new Square();
    private String name;
    private  int GoldCost;
    private  double Health;
    private  double MaxHealth;
    private double Armor;
    private double MagicResist;
    private double VisionRange;
    private double AttackRange;
    private double AttackDamage;
    private int MovementSpeed;
    private int CriticalStrikeChance;
    private double CriticalStrikeDamage;
    private final double ManaStart;
    private  double Mana;
    private double ManaCost;
    private int Stunned=0;
      
          
    private double BuffAttackDamage;
    private double BuffArmor;
    private int BuffCriticalStrikeChance;
    private double BuffCriticalStrikeDamage;

    
    public ChampionAttributes(String name, int GoldCost, double Health, double Armor,
                double MagicResist, double VisionRange, double AttackRange, double AttackDamage, int MovementSpeed,
                int CriticalStrikeChance, double CriticalStrikeDamage, double ManaStart, double ManaCost) 
        {
           
            this.name = name;
            this.GoldCost = GoldCost;
            this.Health = Health;
            this.MaxHealth = Health;
            this.Armor = Armor;
            this.MagicResist = MagicResist;
            this.VisionRange = VisionRange;
            this.AttackRange = AttackRange;
            this.AttackDamage = AttackDamage;
            this.MovementSpeed = MovementSpeed;
            this.CriticalStrikeChance = CriticalStrikeChance;
            this.CriticalStrikeDamage = CriticalStrikeDamage;
            this.ManaStart = ManaStart;
            this.Mana = ManaStart;
            this.ManaCost = ManaCost;
            
            
            this.BuffAttackDamage=AttackDamage;
            this.BuffArmor=Armor;
            this.BuffCriticalStrikeChance=CriticalStrikeChance;
            this.BuffCriticalStrikeDamage=CriticalStrikeDamage;
            
        }
    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public void setPlayerNumber(int PlayerNumber) {
       this.PlayerNumber = PlayerNumber;
    }

    public void setLevel(int Level) {
     this.Level= Level;
   }
    public int getLevel() {
        return Level;
    }

    public void IncreaseLevel() {
     this.Level++;
    }

    public Square getPosition() {
        return Position;
    }

    public void setPosition(Square Position) {
        this.Position = Position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public int getGoldCost() {
        return GoldCost;
    }

    public void setGoldCost(int GoldCost) {
      this.GoldCost = GoldCost;
    }

    public double getHealth() {
        return Health;
    }
    
    
    public void setHealth(double Health) {
       this.Health = Health;
    }
    public double getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(double MaxHealth) {
       this.MaxHealth = MaxHealth;
    }

    
    public double getArmor() {
        return Armor;
    }

    public void setArmor(double Armor) {
       this.Armor = Armor;
    }

    public double getMagicResist() {
        return MagicResist;
    }

    public void setMagicResist(double MagicResist) {
        this.MagicResist = MagicResist;
    }

    public double getVisionRange() {
        return VisionRange;
    }

    public void setVisionRange(double VisionRange) {
      this.VisionRange = VisionRange;
    }

    public double getAttackRange() {
        return AttackRange;
    }

    public void setAttackRange(double AttackRange) {
       this.AttackRange = AttackRange;
    }

    public double getAttackDamage() {
        return AttackDamage;
    }

    public void setAttackDamage(double AttackDamage) {
      this.AttackDamage = AttackDamage;
    }

    public int getMovementSpeed() {
        return MovementSpeed;
    }

    public void setMovementSpeed(int MovementSpeed) {
        Attributes.setMovementSpeed (MovementSpeed);
    }

    public int getCriticalStrikeChance() {
        return CriticalStrikeChance;
    }

    public void setCriticalStrikeChance(int CriticalStrikeChance) {
        this.CriticalStrikeChance = CriticalStrikeChance;
    }

    public double getCriticalStrikeDamage() {
        return CriticalStrikeDamage;
    }

    public void setCriticalStrikeDamage(double CriticalStrikeDamage) {
     this.CriticalStrikeDamage = CriticalStrikeDamage;
    }

    public double getMana() {
        return Mana;
    }

    public void setMana(double Mana) {
        this.Mana = Mana;
    }

    public double getManaCost() {
        return ManaCost;
    }

    public void setManaCost(double ManaCost) {
      this. ManaCost = ManaCost;
    }
   public void IncreaceMana()
   {
       Mana++;
   }
   
   public void setBuffAttackDamage(double BuffAttackDamage)
   {
   this.BuffAttackDamage=BuffAttackDamage;
   }
   
   public double getBuffAttackDamage()
   {
   return this.BuffAttackDamage;
   }
   public void setBuffArmor(double BuffArmor)
   {
   this.BuffArmor=BuffArmor;
   }
   
   public double getBuffArmor()
   {
   return this.BuffArmor;
   }
   public void setBuffCriticalStrikeChance(int BuffCriticalStrikeChance)
   {
   this.BuffCriticalStrikeChance=BuffCriticalStrikeChance;
   }
   
   public int getBuffCriticalStrikeChance()
   {
   return this.BuffCriticalStrikeChance;
   }
   public void setBuffCriticalStrikeDamage(double BuffCriticalStrikeDamage)
   {
   this.BuffCriticalStrikeDamage=BuffCriticalStrikeDamage;
   }
   
   public double getBuffCriticalStrikeDamage()
   {
   return this.BuffCriticalStrikeDamage;
   }
    public int getStunned() {
            return Stunned;
        }

    public void setStunned(int Stunned) {
            this.Stunned = Stunned;
        }
        public void DecreaseStunned() {
        this.Stunned--;
        }
        
        public void Reload()
        {
        
        this.BuffAttackDamage=this.AttackDamage;
        this.BuffArmor=this.Armor;
        this.BuffCriticalStrikeChance=this.CriticalStrikeChance;
        this.BuffCriticalStrikeDamage=this.CriticalStrikeDamage;
        }
   
       
            
  }
    
    
}

