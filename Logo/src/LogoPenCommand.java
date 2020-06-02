public class LogoPenCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token pen;
    int num;

    public LogoPenCommand(Token pen) {
        this.pen = pen;
    }

    public LogoPenCommand(NumberRecord numberRecord, Token pen) {
        this.pen = pen;
        this.num = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        if(pen == Token.PENDOWN) {
            modifiedSituation.penDown = true;
        } else if(pen == Token.PENUP) {
            modifiedSituation.penDown = false;
        } else if(pen == Token.SETPENCOLOR) {
            modifiedSituation.penColor = num;
        } else if(pen == Token.SETPENSIZE) {
            modifiedSituation.penSize = num;
        }else if(pen == Token.PENPAINT){
            modifiedSituation.penColor = 1;
        }else if(pen == Token.PENERASE){
            modifiedSituation.penColor = modifiedSituation.backgroundColor;
        }
        return modifiedSituation;
    }

    @Override
    public void draw() {

    }
}
