package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public class LogoReturnPositionCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token positionToReturn;

    public LogoReturnPositionCommand(Token pos) {
        positionToReturn = pos;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = currentSituation;
        switch(positionToReturn){
            case POS:
                modifiedSituation.info += " Positon ->  x: " + modifiedSituation.position.x + "   y: " + modifiedSituation.position.y+"\n";
                break;
            case XCOR:
                modifiedSituation.info += " Positon x: " + modifiedSituation.position.x + "\n" ;
                break;
            case YCOR:
                modifiedSituation.info += " Positon y: " + modifiedSituation.position.y + "\n";
                break;
            case HEADING:
                modifiedSituation.info += " Angle : " + modifiedSituation.angle + "\n";
                break;
            case SHOWNP:
                modifiedSituation.info += " Icon's visible : " + modifiedSituation.turtleShowed+"\n";
                break;
            default:
                modifiedSituation.info += "";
        }

        return modifiedSituation; }

    @Override
    public Canvas draw(Canvas canvas) {
        return canvas;
    }

}
