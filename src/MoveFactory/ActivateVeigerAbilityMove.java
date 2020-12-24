/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveFactory;

import Champions.Champion;


public class ActivateVeigerAbilityMove extends Move{
    Champion Source;
    Champion  Target;
    public ActivateVeigerAbilityMove(Champion Source,Champion Target)
    {
    
 this.Source=Source;
 this.Target=Target;
}

    @Override
    public void performMove() {
       
       if(Source!=null){
       if(Target!=null)
    Target.setHealth(0);}
    }
    
}
