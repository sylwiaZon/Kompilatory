public class Parser {
    private Scanner scanner;
    public Parser(Scanner logoScanner)
    {
        scanner = logoScanner;
    }
    // <logo-program>  ::= <logo-sentence> { <logo-sentence> } <EOF>
    public void parseLogoProgram() throws Exception {
        parseLogoSentence();
        while (true)
        {
            switch(scanner.nextToken())
            {
                case FORWARD:
                case BACK:
                case LEFT:
                case RIGHT:
                case NUMBER:
                case LBRACKET:
                case RBRACKET:
                case HOME:
                case POS:
                case XCOR:
                case YCOR:
                case HEADING:
                case SCRUNCH:
                case SHOWTURTLE:
                case HIDETURTLE:
                case CLEAN:
                case CLEARSCREEN:
                case WRAP:
                case WINDOW:
                case PENCE:
                case FILL:
                case SHOWNP:
                case PENDOWN:
                case PENUP:
                case PENPAINT:
                case PENERASE:
                case PENREVERSE:
                case SETX:
                case SETY:
                case SETHEADING:
                case LABEL:
                case SETLABELHEIGHT:
                case SETPENCOLOR:
                case SETPENSIZE:
                case SETBACKGROUND:
                case SETXY:
                case ARC:
                case SETSCRUNCH:
                case SETPOS:
                case TOWARDS:
                case FILLED:
                case FOREVER:
                case IF:
                case WHILE:
                case EQUAL:
                case LESS:
                case GREATER:
                case LESSEQ:
                case GREATEREQ:
                case REPEAT:
                    parseLogoSentence();
                    break;
                default:
                    Match(Token.EOF);
                    return;
            }
        }
    }
    // <logo-sentence> ::= FORWARD <integer>
    //                   | BACK <integer>
    //                   | LEFT <integer>
    //                   | RIGHT <integer>
    //                   | REPEAT <integer> [ <logo-sentence> { <logo-sentence> } ]
    private void parseLogoSentence() throws Exception {
        Token nextToken = scanner.nextToken();
        switch(nextToken)
        {
            case HOME:
            case POS:
            case XCOR:
            case YCOR:
            case HEADING:
            case SCRUNCH:
            case SHOWTURTLE:
            case HIDETURTLE:
            case CLEAN:
            case CLEARSCREEN:
            case WRAP:
            case WINDOW:
            case PENCE:
            case FILL:
            case SHOWNP:
            case PENDOWN:
            case PENUP:
            case PENPAINT:
            case PENERASE:
            case PENREVERSE:
                Match(nextToken);
                break;
            case FORWARD:
            case BACK:
            case LEFT:
            case RIGHT:
            case SETX:
            case SETY:
            case SETHEADING:
            case LABEL:
            case SETLABELHEIGHT:
            case SETPENCOLOR:
            case SETPENSIZE:
            case SETBACKGROUND:
                Match(nextToken);
                Match(Token.NUMBER);
                break;
            case SETXY:
            case ARC:
            case SETSCRUNCH:
                Match(nextToken);
                Match(Token.NUMBER);
                Match(Token.NUMBER);
                break;
            case SETPOS:
            case TOWARDS:
            case FILLED:
                Match(nextToken);
                Match(Token.LBRACKET);
                Match(Token.NUMBER);
                Match(Token.NUMBER);
                Match(Token.RBRACKET);
                break;
            case FOREVER:
                Match(nextToken);
                Match(Token.LBRACKET);
                parseLogoSentence();
                Match(Token.RBRACKET);
                break;
            case IF:
            case WHILE:
                Match(nextToken);
                Match(Token.NUMBER);
                nextToken = scanner.scan();
                switch (nextToken) {
                    case EQUAL:
                    case GREATER:
                    case GREATEREQ:
                    case LESS:
                    case LESSEQ:
                        Match(Token.NUMBER);
                        Match(Token.LBRACKET);
                        parseLogoSentence();
                        Match(Token.RBRACKET);
                        break;
                    default:
                        SyntaxError(String.format("Expected one of: EQUAL, GREATER, GREATEREQ, LESS or LESSEQ but found %s",
                                nextToken), new Exception());
                        break;
                }
                break;
            case REPEAT:
                Match(nextToken);
                Match(Token.NUMBER);
                Match(Token.LBRACKET);
                parseLogoSentence();
                Match(Token.RBRACKET);
                break;
            default:
                SyntaxError(String.format("Expected one of: FORWARD, BACK, LEFT, RIGHT or REPEAT but found %s",
                        nextToken), new Exception());
                break;
        }
    }
    private void Match(Token token) throws Exception {
        Token nextToken = scanner.scan();
        if (nextToken != token)
        {
            SyntaxError(String.format("Expected %s but found %s (at '%s')",
                    token,
                    nextToken,
                    scanner.scanBuffer), new Exception());
        }
    }
    private void SyntaxError(String errorMessage, Exception errorCode) throws Exception {
        throw new Exception(String.format("Error message %s, error code %s (at '%s')",
                    errorMessage, errorCode.getMessage(), scanner.scanBuffer));
    }
}
