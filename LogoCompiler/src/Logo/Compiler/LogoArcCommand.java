package Logo.Compiler;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

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
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(modifiedSituation.penColor);
        gc.setLineWidth(modifiedSituation.penSize);
        gc.strokeArc(modifiedSituation.position.x-this.radius/2,modifiedSituation.position.y-this.radius/2,this.radius,this.radius, modifiedSituation.angle-90, this.arc, ArcType.OPEN);
        return canvas;
    }
}
