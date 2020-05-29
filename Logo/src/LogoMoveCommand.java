public class LogoMoveCommand implements LogoCommandInterface {
    public int move;
    TurtleSituation modifiedSituation;

    public LogoMoveCommand(NumberRecord numberRecord) {
        this.move = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.x = 0;
        modifiedSituation.y = 0;
        return modifiedSituation;
    }

    @Override
    public void draw() {
        //rysuje sie
    }
}
