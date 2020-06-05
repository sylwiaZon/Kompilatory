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
        if(this.arc<modifiedSituation.angle){
            gc.strokeArc(modifiedSituation.position.x,modifiedSituation.position.y,this.radius,this.radius, this.arc,modifiedSituation.angle, ArcType.OPEN);

        }else{
            gc.strokeArc(modifiedSituation.position.x,modifiedSituation.position.y,this.radius,this.radius,modifiedSituation.angle, this.arc, ArcType.OPEN);

        }
         return canvas;
    }
}
