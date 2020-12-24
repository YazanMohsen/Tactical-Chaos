package MoveFactory;

import Battlefield.Square;
import Champions.Champion;
import Player.Player;

public class BuyMove {
 
    Champion Champion;
    Player Player;
 public BuyMove(Champion Champion,Player Player)
 {
     this.Champion=Champion;
     this.Player=Player;
 }
 public void PerformeMove()
 {
 Champion.setPlayerNumber(Player.getId());
 Player.setMoney(Champion.getGoldCost(),true);
 Player.addToBench(Champion);
 
 }


}
