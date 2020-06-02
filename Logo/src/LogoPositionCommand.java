public class LogoPositionCommand implements LogoCommandInterface {
    public int pos;
    public TurtleSituation.Position position;
    TurtleSituation modifiedSituation;
    Token command;

    public LogoPositionCommand(NumberRecord numberRecord, Token set) {
        this.pos = numberRecord.getNumber();
        command = set;
    }

    public LogoPositionCommand(NumberRecord numberRecordX, NumberRecord numberRecordY, Token set) {
        this.position = new TurtleSituation.Position(numberRecordX.getNumber(), numberRecordY.getNumber());
        command = set;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        if(command == Token.SETX){
            modifiedSituation.position.x = pos;
        } else if(command == Token.SETY){
            modifiedSituation.position.x = pos;
        } else if(command == Token.SETPOS){
            modifiedSituation.position.x = position.x;
            modifiedSituation.position.y = position.y;
        } else if(command == Token.SETHEADING){
            modifiedSituation.angle = pos;
        }
        return modifiedSituation;
    }

    @Override
    public void draw() {
        //rysuje sie
    }
}
