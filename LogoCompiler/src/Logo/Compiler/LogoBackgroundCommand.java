package Logo.Compiler;

import javafx.scene.canvas.Canvas;

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
            System.out.println("czyscimy ekran");
        }else if(pen == Token.CLEARSCREEN){
            System.out.println("czyscimy ekran + komenda home");
        }
        return canvas;
    }
}
