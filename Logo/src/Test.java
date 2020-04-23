public class Test {
    public static void main(String[] args) throws Exception {
        String input = "IF 2 >=4";
        Scanner scanner = new Scanner(input);
        Token scan;
        do {
            scan = scanner.scan();
            System.out.println(scan);
        } while(scan != Token.EOF);
    }
}
