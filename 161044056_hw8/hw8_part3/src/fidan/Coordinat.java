package fidan;

public class Coordinat {
    private int x;
    private int y;
    private int coordinatVertexNum;

    public Coordinat(int x,int y,int coordinatVertexNum){
        this.x = x;
        this.y = y;
        this.coordinatVertexNum = coordinatVertexNum;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCoordinatVertexNum() {
        return coordinatVertexNum;
    }
}
