import java.util.ArrayList;

public class ParserTest {
    public static void main(String[] args) throws Exception {
        String input = "REPEAT 5 [LEFT 4 RIGHT 4]";
        Scanner scanner = new Scanner(input);
        Parser parser = new Parser(scanner);
        ArrayList<LogoCommandInterface> stack = parser.parseLogoProgram();
        System.out.println(stack.size());
        for(LogoCommandInterface l: stack){
            System.out.println(l);
        }
    }
}
