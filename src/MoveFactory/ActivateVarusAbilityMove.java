/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveFactory;

import Champions.Champion;

/**
 *
 * @author DELL3567
 */
public class ActivateVarusAbilityMove extends Move{

    Champion Source;
   public ActivateVarusAbilityMove(Champion Source)
    {
    this.Source=Source;
    }
    @Override
    public void performMove() {
    
    if(Source!=null)
    Source.setBuffCriticalStrikeChance(Source.getBuffCriticalStrikeChance()*4);
    
    }
    
}
