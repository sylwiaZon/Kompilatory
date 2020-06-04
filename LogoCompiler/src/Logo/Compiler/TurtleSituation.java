package Logo.Compiler;

import javafx.scene.paint.Color;

public class TurtleSituation {
    public int angle;
    public int turnAngle;
    public Position position;
    public Color penColor;
    public int penSize;
    public boolean turtleShowed;
    public boolean penDown;
    public Color backgroundColor;
    public int icon;

    public TurtleSituation(int angle, int turnAngle, int x, int y, boolean turtle, boolean pen) {
        this.angle = angle;
        this.turnAngle = turnAngle;
        position = new Position(x, y);
        turtleShowed = turtle;
        penDown = pen;
    }
    public TurtleSituation(){
        setDefaultSituation();
    }

    public TurtleSituation(TurtleSituation ts){
        penColor = ts.penColor; //czarne
        penSize = ts.penSize; //cokolwiek
        angle = ts.angle;
        turnAngle = ts.turnAngle;
        position = ts.position;
        turtleShowed = ts.turtleShowed;
        penDown = ts.penDown;
        backgroundColor = ts.backgroundColor; //białe
        icon = ts.icon;
    }

    public static class Position{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void setDefaultSituation() {
        penColor = Color.BLACK; //czarne
        penSize = 1; //cokolwiek
        angle = 0;
        turnAngle = 0;
        position = new Position(400, 240);
        turtleShowed = true;
        penDown = true;
        backgroundColor = Color.WHITE; //białe
        icon = 0;
    }
    public void centerTurtle() {
        angle = 0;
        turnAngle = 0;
        position = new Position(400, 240);
        turtleShowed = true;
        penDown = true;
    }
}
