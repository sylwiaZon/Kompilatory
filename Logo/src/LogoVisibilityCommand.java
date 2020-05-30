public class LogoVisibilityCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token visibility;

    public LogoVisibilityCommand(Token visibility) {
        this.visibility = visibility;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        if(visibility == Token.HIDETURTLE){
            modifiedSituation.turtleShowed = false;
        } else if( visibility == Token.SHOWTURTLE) {
            modifiedSituation.turtleShowed = true;
        }
        return modifiedSituation;
    }

    @Override
    public void draw() {

    }
}
