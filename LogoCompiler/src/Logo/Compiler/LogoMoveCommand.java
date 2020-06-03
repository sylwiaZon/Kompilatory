package Logo.Compiler;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class LogoMoveCommand implements LogoCommandInterface {
    public int move;
    TurtleSituation modifiedSituation;
    TurtleSituation curentSituation;

    public LogoMoveCommand(NumberRecord numberRecord) {
        this.move = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        this.curentSituation = currentSituation;
        modifiedSituation = new TurtleSituation(currentSituation);
        int x=0 ;
        int y=0;
        int angle = modifiedSituation.angle;
        if(move<0){
          angle+=180;
          angle=angle%360;
        };
        if(angle==0 || angle ==360 ){
            y = move;
            x = 0;
        }else if(angle == 90){
            x = move;
            y = 0;
        }
        else if(angle==180){
            y = -move;
            x = 0;

        }else if(angle == 270){
            x = -move;
            y = 0;
        }
        else if(angle>0 && angle<90){
            x = (int) (move*Math.sin(angle));
            y = (int) (move*Math.cos(angle));

        }else if(angle>90 && angle <180){
            angle=180-angle;
            x = (int) (move*Math.sin(angle));
            y = -(int) (move*Math.cos(angle));


        }else if(angle>180 && angle<270){
            angle=270-angle;
            x = -(int) (move*Math.cos(angle));
            y = -(int) (move*Math.sin(angle));

        }else if(angle>270 && angle<360){
            angle=360-angle;
            x = -(int) (move*Math.sin(angle));
            y = (int)(move*Math.cos(angle));
        }
        modifiedSituation.position.x +=x;
        modifiedSituation.position.y+=y;
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(5);
        gc.strokeLine(curentSituation.position.x, curentSituation.position.y, modifiedSituation.position.x, modifiedSituation.position.y);
        return canvas;
    }
}
