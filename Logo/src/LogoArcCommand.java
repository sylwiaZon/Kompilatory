public class LogoArcCommand implements LogoCommandInterface {
    public int radius;
    public int arc;
    TurtleSituation modifiedSituation;


    public LogoArcCommand(NumberRecord numberRecordA, NumberRecord numberRecordR) {
        radius = numberRecordR.getNumber();
        arc = numberRecordA.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        //draw??
        return modifiedSituation;
    }

    @Override
    public void draw() {
        //rysuje sie
    }
}
