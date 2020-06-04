package Logo.Compiler;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;


public class LogoRepeatCommand implements LogoCommandInterface {
    public ArrayList<LogoCommandInterface> commandsToRepeat;
    TurtleSituation modifiedSituation;
    public int repeatCounter;


    public LogoRepeatCommand(NumberRecord numberRecord, ArrayList<LogoCommandInterface> commands) {
        repeatCounter = numberRecord.getNumber();
        commandsToRepeat = commands;
    }
    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        for(int i = 0; i < repeatCounter; i++){
            for(LogoCommandInterface command: commandsToRepeat) {
                modifiedSituation = command.calculateSituation(modifiedSituation);
            }
        }
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        //rysuje sie
        return canvas;
    }
}