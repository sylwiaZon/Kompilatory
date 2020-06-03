package Logo.Compiler;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LogoHomeCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    TurtleSituation currentSituation;
    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        this.currentSituation=currentSituation;
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.centerTurtle();
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(5);
        gc.strokeLine(currentSituation.position.x, currentSituation.position.y, modifiedSituation.position.x, modifiedSituation.position.y);
        return canvas;
    }
}
