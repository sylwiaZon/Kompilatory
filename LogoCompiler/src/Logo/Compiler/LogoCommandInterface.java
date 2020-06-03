package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public interface LogoCommandInterface {
    TurtleSituation calculateSituation(TurtleSituation currentSituation);
    Canvas draw(Canvas canvas);
}
