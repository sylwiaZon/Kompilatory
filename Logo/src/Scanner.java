import java.util.HashMap;

public class Scanner {
    HashMap<String, Token> reserved = new HashMap<>();
    private String rawContents;
    private String scanBuffer;
    private int idx;
    private char ch;
    public Scanner(String input)
    {
        rawContents = input;
        reserved.put("REPEAT", Token.REPEAT);
        reserved.put("FORWARD", Token.FORWARD);
        reserved.put("BACK", Token.BACK);
        reserved.put("LEFT", Token.LEFT);
        reserved.put("RIGHT", Token.RIGHT);
        reserved.put("NUMBER", Token.NUMBER);
        reserved.put("[", Token.LBRACKET);
        reserved.put("]", Token.RBRACKET);
    }
    public Token scan() throws Exception {
        while (idx < rawContents.length())
        {
            ch = rawContents.charAt(idx);
            if (ch == '[')
            {
                idx++;
                return Token.LBRACKET;
            }
            else if (ch == ']')
            {
                idx++;
                return Token.RBRACKET;
            }
            else if (Character.isDigit(ch))
            {
                scanBuffer = "";
                scanBuffer += ch;
                idx++;
                while (idx < rawContents.length())
                {
                    ch = rawContents.charAt(idx);
                    if (Character.isDigit(ch))
                    {
                        scanBuffer += ch;
                        idx++;
                    }
                    else break;
                }
                return Token.NUMBER;
            }
            else if (Character.isLetter(ch))
            {
                scanBuffer = "";
                scanBuffer += ch;
                idx++;
                while (idx < rawContents.length())
                {
                    ch = rawContents.charAt(idx);
                    if (Character.isLetter(ch))
                    {
                        scanBuffer += ch;
                        idx++;
                    }
                    else break;
                }

                if (reserved.containsKey(scanBuffer))
                {
                    return reserved.get(scanBuffer);
                }
                else {
                    LexicalError();
                }
            }
            else if (Character.isWhitespace(ch))
            {
                idx++;
            }
            else
            {
                LexicalError();
            }
        }
        return Token.EOF;
    }
    private void LexicalError() throws Exception {
        throw new Exception("Lexical error at '" + ch + "' (' " + scanBuffer + " ')");
    }
}
