public enum Stop{
  
  BOSTON("Boston", 100, 100),
  NEW_YORK("New York", 200, 200),
  WASHINGTON_DC("Washington D.C.", 300, 300),
  SEATTLE("Seattle", 400, 400);
  
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