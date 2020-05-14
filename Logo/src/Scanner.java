import java.util.HashMap;

public class Scanner {
    HashMap<String, Token> reserved = new HashMap<>();
    private String rawContents;
    public String scanBuffer;
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
        reserved.put("HOME", Token.HOME);
        reserved.put("POS", Token.POS);
        reserved.put("XCOR", Token.XCOR);
        reserved.put("YCOR", Token.YCOR);
        reserved.put("HEADING", Token.HEADING);
        reserved.put("SCRUNCH", Token.SCRUNCH);
        reserved.put("SHOWTURTLE", Token.SHOWTURTLE);
        reserved.put("HIDETURTLE", Token.HIDETURTLE);
        reserved.put("CLEAN", Token.CLEAN);
        reserved.put("CLEARSCREEN", Token.CLEARSCREEN);
        reserved.put("WRAP", Token.WRAP);
        reserved.put("WINDOW", Token.WINDOW);
        reserved.put("PENCE", Token.PENCE);
        reserved.put("FILL", Token.FILL);
        reserved.put("SHOWNP", Token.SHOWNP);
        reserved.put("PENDOWN", Token.PENDOWN);
        reserved.put("PENUP", Token.PENUP);
        reserved.put("PENPAINT", Token.PENPAINT);
        reserved.put("PENERASE", Token.PENERASE);
        reserved.put("PENREVERSE", Token.PENREVERSE);
        reserved.put("SETX", Token.SETX);
        reserved.put("SETY", Token.SETY);
        reserved.put("SETHEADING", Token.SETHEADING);
        reserved.put("LABEL", Token.LABEL);
        reserved.put("SETLABELHEIGHT", Token.SETLABELHEIGHT);
        reserved.put("SETPENCOLOR", Token.SETPENCOLOR);
        reserved.put("SETPENSIZE", Token.SETPENSIZE);
        reserved.put("SETBACKGROUND", Token.SETBACKGROUND);
        reserved.put("SETXY", Token.SETXY);
        reserved.put("ARC", Token.ARC);
        reserved.put("SETSCRUNCH", Token.SETSCRUNCH);
        reserved.put("SETPOS", Token.SETPOS);
        reserved.put("TOWARDS", Token.TOWARDS);
        reserved.put("FILLED", Token.FILLED);
        reserved.put("FOREVER", Token.FOREVER);

        reserved.put("TO", Token.TO);
        reserved.put("END", Token.END);
        reserved.put("IF", Token.IF);
        reserved.put("WHILE", Token.WHILE);

        reserved.put("=", Token.EQUAL);
        reserved.put("!", Token.NOT);
        reserved.put("<", Token.LESS);
        reserved.put(">", Token.GREATER);
        reserved.put("<=", Token.LESSEQ);
        reserved.put(">=", Token.GREATEREQ);
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
            else if (ch == '=')
            {
                idx++;
                return Token.EQUAL;
            }
            else if (ch == '!')
            {
                idx++;
                return Token.NOT;
            }
            else if (ch == '>')
            {
                idx++;
                ch = rawContents.charAt(idx);
                if(ch == '='){
                    idx++;
                    return Token.GREATEREQ;
                }
                else{
                    return Token.GREATER;
                }
            }
            else if (ch == '<'){
                idx++;
                ch = rawContents.charAt(idx);
                if(ch == '='){
                    idx++;
                    return Token.LESSEQ;
                }
                else{
                    return Token.LESS;
                }
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
    public Token nextToken() throws Exception {
        int oldIdx = idx;
        Token result = scan();
        idx = oldIdx;
        return result;
    }
}
