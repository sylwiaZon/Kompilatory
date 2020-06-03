package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public class LogoReturnPositionCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token positionToReturn;

    public LogoReturnPositionCommand(Token pos) {
        positionToReturn = pos;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) { modifiedSituation = currentSituation;return null; }

    @Override
    public Canvas draw(Canvas canvas) {
        if(positionToReturn == Token.POS){
            System.out.println(modifiedSituation.position);
        }else if(positionToReturn == Token.HEADING){
            System.out.println(modifiedSituation.angle);
        }else if(positionToReturn == Token.SHOWNP){
            System.out.println(modifiedSituation.turtleShowed);
        }

        return canvas;
    }
}
