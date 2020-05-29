public class LogoRepeatCommand implements LogoCommandInterface {
    public LogoCommandInterface commandToRepeat;
    TurtleSituation modifiedSituation;
    public int repeatCounter;

    public LogoRepeatCommand(NumberRecord numberRecord) {
        repeatCounter = numberRecord.getNumber();
    }
    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        for(int i = 0; i < repeatCounter; i++){
            modifiedSituation = commandToRepeat.calculateSituation(modifiedSituation);
        }
        return modifiedSituation;
    }

    @Override
    public void draw() {
        //rysuje sie
    }
}