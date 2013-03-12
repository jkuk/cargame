package cargame;

public enum Stop{
  
  A("Boston", 400, 0),
  B("New York", 400, 400),
  C("Washington D.C.", 0, 0),
  D("Seattle", 0, 400);
  
  private final String NAME;
  private final int X, Y;
  
  Stop(String aName, int anX, int aY){
    NAME = aName;
    X = anX;
    Y = aY;
  }
  
  public String toString(){
    return NAME;
  }
  
  public int getX(){
    return X;
  }
  
  public int getY(){
    return Y;
  }
}