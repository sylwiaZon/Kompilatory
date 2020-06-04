package Logo.Compiler;

import javafx.scene.canvas.Canvas;

public class LogoIconCommand implements LogoCommandInterface {
    TurtleSituation modifiedSituation;
    TurtleSituation currentSituation;
    public int icon;

    public LogoIconCommand(NumberRecord iconNum){
        icon = iconNum.getNumber();
    }

    @Override
    public TurtleSituation calculateSituation(TurtleSituation currentSituation) {
        this.currentSituation = currentSituation;
        modifiedSituation = new TurtleSituation(currentSituation);
        modifiedSituation.icon = icon;
        return modifiedSituation;
    }

    @Override
    public Canvas draw(Canvas canvas) {
        return canvas;
    }
}
