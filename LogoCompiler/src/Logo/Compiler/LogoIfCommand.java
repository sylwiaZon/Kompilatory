package Logo.Compiler;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;


public class LogoIfCommand implements LogoCommandInterface {
    public ArrayList<LogoCommandInterface> commands;
    TurtleSituation modifiedSituation;
    Canvas canvas;
    Token symbol;
    NumberRecord leftSide;
    NumberRecord rightSide;


    public LogoIfCommand(NumberRecord numberRecord, NumberRecord numberRecord2, Token symbol_, ArrayList<LogoCommandInterface> command) {
        commands = command;
        symbol = symbol_;
        leftSide = numberRecord;
        rightSide = numberRecord2;
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        boolean result;
        switch(symbol){
            case EQUAL:
                result = leftSide.getNumber() == rightSide.getNumber();
                break;
            case GREATER:
                result = leftSide.getNumber() > rightSide.getNumber();
                break;
            case GREATEREQ:
                result = leftSide.getNumber() >= rightSide.getNumber();
                break;
            case LESS:
                result = leftSide.getNumber() < rightSide.getNumber();
                break;
            case LESSEQ:
                result = leftSide.getNumber() <= rightSide.getNumber();
                break;
            default:
                result = false;
        }
        if (result) {
            for (LogoCommandInterface command : commands) {
                modifiedSituation = command.calculateSituation(modifiedSituation);
                canvas = command.draw(canvas);
            }
        }
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        this.canvas = canvas;
        return canvas;
    }
}
