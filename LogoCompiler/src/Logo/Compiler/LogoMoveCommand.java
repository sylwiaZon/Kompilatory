package Logo.Compiler;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class LogoMoveCommand implements LogoCommandInterface {
    public int move;
    TurtleSituation modifiedSituation;
    TurtleSituation currentSituation;

    public LogoMoveCommand(NumberRecord numberRecord) {
        this.move = numberRecord.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        this.currentSituation=currentSituation;

        int x=0 ;
        int y=0;
        int angle = currentSituation.angle;
        if(move<0){
          angle+=180;
          angle=angle%360;
        };
        //move = Math.abs(move);
        if(angle==0){
            y = -move;
            x = 0;
        }else if(angle == 90){
            x = move;
            y = 0;
        }
        else if(angle==180){
            y = move;
            x = 0;

        }else if(angle == 270){
            x = -move;
            y = 0;
        }
        else if(angle>0 && angle<90){
            x = (int) (move*Math.sin(2*Math.PI * angle/360 ));
            y = -(int) (move*Math.cos(2*Math.PI * angle/360));

        }else if(angle>90 && angle <180){
            angle=180-angle;
            x = (int) (move*Math.sin(2*Math.PI * angle/360));
            y = (int) (move*Math.cos(2*Math.PI * angle/360));


        }else if(angle>180 && angle<270){
            angle=270-angle;
            x = -(int) (move*Math.cos(2*Math.PI * angle/360));
            y = (int) (move*Math.sin(2*Math.PI * angle/360));

        }else if(angle>270 && angle<360){
            angle=360-angle;
            x = -(int) (move*Math.sin(2*Math.PI * angle/360));
            y = -(int)(move*Math.cos(2*Math.PI * angle/360));
        }

        x=currentSituation.position.x+x;
        y=currentSituation.position.y+y;
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.position = new TurtleSituation.Position(x,y);
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(modifiedSituation.penColor);
        gc.setLineWidth(modifiedSituation.penSize);
        gc.strokeLine(currentSituation.position.x, currentSituation.position.y, modifiedSituation.position.x, modifiedSituation.position.y);
        return canvas;
    }
}
