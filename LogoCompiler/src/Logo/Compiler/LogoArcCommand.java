package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public class LogoArcCommand implements LogoCommandInterface {
    public int radius;
    public int arc;
    TurtleSituation modifiedSituation;


    public LogoArcCommand(NumberRecord numberRecordA, NumberRecord numberRecordR) {
        radius = numberRecordR.getNumber();
        arc = numberRecordA.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        //draw??
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        //rysuje sie
        return canvas;
    }
}
