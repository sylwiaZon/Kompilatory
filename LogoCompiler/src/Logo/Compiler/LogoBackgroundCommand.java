package Logo.Compiler;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LogoBackgroundCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    Token pen;
    int num;


    public LogoBackgroundCommand(NumberRecord numberRecord, Token pen) {
        this.pen = pen;
        this.num = numberRecord.getNumber();
    }
    public LogoBackgroundCommand(Token pen) {
        this.pen = pen;
    }
    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        if(pen == Token.SETBACKGROUND) {
            modifiedSituation.backgroundColor = num;
        }else if(pen == Token.CLEARSCREEN){
            modifiedSituation.centerTurtle();
        }
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        if(pen== Token.CLEAN){
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }else if(pen == Token.CLEARSCREEN){
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        return canvas;
    }
}
