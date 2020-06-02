public class LogoBackgroundCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token pen;
    int num;

    public LogoBackgroundCommand(NumberRecord numberRecord, Token pen) {
        this.pen = pen;
        this.num = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        if(pen == Token.SETBACKGROUND) {
            modifiedSituation.backgroundColor = num;
        }
        return modifiedSituation;
    }

    @Override
    public void draw() {

    }
}
