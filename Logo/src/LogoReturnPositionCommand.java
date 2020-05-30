public class LogoReturnPositionCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token positionToReturn;

    public LogoReturnPositionCommand(Token pos) {
        positionToReturn = pos;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        return null;
    }

    @Override
    public void draw() {

    }
}
