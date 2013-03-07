package cargame;

public enum Stop{
  
  A("Boston", 100, 100),
  B("New York", 200, 200),
  C("Washington D.C.", 300, 300),
  D("Seattle", 400, 400);
  
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