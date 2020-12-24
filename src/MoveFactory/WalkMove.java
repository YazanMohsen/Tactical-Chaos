/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveFactory;

import Battlefield.Square;
import Champions.Champion;

/**
 *
 * @author DELL
 */
public class WalkMove extends Move{

    Champion Champion;
    
   boolean Left;
   boolean Right;
   boolean Up;
   boolean Down;
    public WalkMove(Champion Champion)
       {
    Left=false;
    Right=false;
    Up=false;
    Down=false;
           
       this.Champion=Champion;
       }
       
       
    @Override
    public void performMove() 
    {
    if(Up)Champion.MoveUp();
    if(Down)Champion.MoveDown();
    if(Right)Champion.MoveRight();
    if(Left)Champion.MoveLeft();
                      
    }
    public void Left()
    {
    Left=true;
    }
    public void Right()
    {
    Right=true;
    }
    public void Up()
    {
    Up=true;
    }
    public void Down()
    {
    Down=true;
    }
    
}
