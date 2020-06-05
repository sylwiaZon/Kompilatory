package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public class LogoTurnCommand implements LogoCommandInterface {
    public int angle;
    TurtleSituation modifiedSituation;

    public LogoTurnCommand(NumberRecord numberRecord) {
        this.angle = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.angle += angle;

        if(modifiedSituation.angle<0){
            modifiedSituation.angle=360+modifiedSituation.angle;
        }
        modifiedSituation.angle = modifiedSituation.angle%360;
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        System.out.println(modifiedSituation.angle);
        return canvas;
    }
}
