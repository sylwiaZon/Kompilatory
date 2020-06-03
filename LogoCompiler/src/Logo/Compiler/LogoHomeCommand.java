package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public class LogoHomeCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.centerTurtle();
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        //rysuje sie
        return canvas;
    }
}
