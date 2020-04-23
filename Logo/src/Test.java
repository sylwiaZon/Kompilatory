public class Test {
    public static void main(String[] args) throws Exception {
        String input = "REPEAT 4 [ FORWARD 100 LEFT 90 RIGHT 60 ] ";
        Scanner scanner = new Scanner(input);
        Token scan;
        do {
            scan = scanner.scan();
            System.out.println(scan);
        } while(scan != Token.EOF);
    }
}
