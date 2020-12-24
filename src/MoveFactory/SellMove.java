package MoveFactory;

import Champions.Champion;
import Player.Player;

public class SellMove {

Player Player;
Champion Champion;
public SellMove(Champion Champion, Player Player)
{
this.Champion=Champion;
  this.Player=Player;
}

public void PerformeMove(){
            Champion.setPlayerNumber(0);
            Player.DeleteFromBench(Champion);
            Player.setMoney(Champion.getGoldCost(),false);
            }
}
