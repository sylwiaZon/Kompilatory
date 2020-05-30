public class LogoPenCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token pen;

    public LogoPenCommand(Token pen) {
        this.pen = pen;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        if(pen == Token.PENDOWN) {
            modifiedSituation.penDown = true;
        } else if(pen == Token.PENUP) {
            modifiedSituation.penDown = false;
        }
        return modifiedSituation;
    }

    @Override
    public void draw() {

    }
}
