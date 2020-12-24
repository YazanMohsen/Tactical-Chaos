package Battlefield;

import Champions.*;
import java.util.ArrayList;
import java.util.List;

public class Square {

int x;
int y;

public Square()
{
x=1;
y=1;
}

public Square(int x,int y)
{
   
this.x=x;
this.y=y;
}

public int getx()
{return x;}

public int gety()
{return y;}


public boolean equals(Square Square)
{
if(Square.getx()==this.getx())
    if(Square.gety()==this.gety())
return true;
return false;
}
public void setX(int x)
{this.x=x;}

public void setY(int y)
{this.y=y;}

}
