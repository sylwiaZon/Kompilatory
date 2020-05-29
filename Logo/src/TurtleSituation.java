public class TurtleSituation {
    public int angle;
    public int turnAngle;
    public Position position;
    public int color;

    public TurtleSituation(int angle, int turnAngle, int x, int y) {
        this.angle = angle;
        this.turnAngle = turnAngle;
        position = new Position(x, y);
    }
    public TurtleSituation(){
        setDefaultSituation();
    }

    public TurtleSituation(TurtleSituation ts){
        this.angle = ts.angle;
        this.turnAngle = ts.turnAngle;
        position = new Position(ts.position.x, ts.position.y);
    }

    public class Position{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void setDefaultSituation() {
        color = 0; //czarne
        angle = 0;
        turnAngle = 0;
        position = new Position(0, 0);
    }
}
