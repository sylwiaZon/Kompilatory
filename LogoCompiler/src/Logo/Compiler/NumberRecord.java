package Logo.Compiler;

public class NumberRecord {
    private int number;

    public NumberRecord(Token directionToken, String numberAsString)
    {
        number = Integer.parseInt(numberAsString);
        if (directionToken == Token.FORWARD || directionToken == Token.LEFT)
        {
            number = (-1)*number;
        }
    }

    public int getNumber() {
        return number;
    }
}
