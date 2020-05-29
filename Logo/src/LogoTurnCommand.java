public class LogoTurnCommand implements LogoCommandInterface {
    public int angle;
    TurtleSituation modifiedSituation;

    public LogoTurnCommand(NumberRecord numberRecord) {
        this.angle = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.angle = angle;
        return modifiedSituation;
    }

    @Override
    public void draw() {
        //rysuje sie
    }
}
