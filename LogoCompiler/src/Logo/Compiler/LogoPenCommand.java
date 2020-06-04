package Logo.Compiler;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

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
            modifiedSituation.penColor = getColorToSet(num);
            System.out.println(modifiedSituation.penColor);
        } else if(pen == Token.SETPENSIZE) {
            modifiedSituation.penSize = num;
        }else if(pen == Token.PENPAINT){
            modifiedSituation.penColor = Color.BLACK;
        }else if(pen == Token.PENERASE){
            modifiedSituation.penColor = modifiedSituation.backgroundColor;
        }else if(pen == Token.PENREVERSE){
            if(currentSituation.penColor == currentSituation.backgroundColor){
                modifiedSituation.penColor = Color.BLACK;
            } else {
                modifiedSituation.penColor = modifiedSituation.backgroundColor;
            }
        }
        return modifiedSituation;
    }

    private Color getColorToSet(int num){
        switch(num) {
            case 0:
                return Color.BLACK;
            case 1:
                return Color.PINK;
            case 2:
                return Color.AZURE;
            case 3:
                return Color.RED;
            case 4:
                return Color.SALMON;
            case 5:
                return Color.GREENYELLOW;
            case 6:
                return Color.LAVENDER;
            case 7:
                return Color.CORNFLOWERBLUE;
            case 8:
                return Color.ROYALBLUE;
            case 9:
                return Color.GAINSBORO;
            default:
                return Color.BLACK;
        }
    }

    @Override
    public Canvas draw(Canvas canvas) {

        return canvas;
    }
}
