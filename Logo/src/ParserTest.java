public class ParserTest {
    public static void main(String[] args) throws Exception {
        String input = "RIGHT RIGHT";
        Scanner scanner = new Scanner(input);
        Parser parser = new Parser(scanner);
        parser.parseLogoProgram();
    }
}
