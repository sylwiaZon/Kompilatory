public class LogoHomeCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        return modifiedSituation;
    }

    @Override
    public void draw() {
        //rysuje sie
    }
}
