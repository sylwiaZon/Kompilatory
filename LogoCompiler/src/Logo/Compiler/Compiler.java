package Logo.Compiler;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class Compiler {
    public static TurtleSituation compile(String args, Canvas canvas, TurtleSituation situation) throws Exception {
        Scanner scanner = new Scanner(args);
        Parser parser = new Parser(scanner);
        ArrayList<LogoCommandInterface> stack = parser.parseLogoProgram();

        for(LogoCommandInterface l: stack){
            situation = l.calculateSituation(situation);
            canvas = l.draw(canvas);
        }
        return  situation;
    }
}
