package Logo.Compiler;

import java.util.ArrayList;

public class Parser {
    private Scanner scanner;
    private ArrayList<LogoCommandInterface> commandsToRepeat = new ArrayList<>();
    private boolean rightBracketFound = false;
    public Parser(Scanner logoScanner)
    {
        scanner = logoScanner;
    }
    // <logo-program>  ::= <logo-sentence> { <logo-sentence> } <EOF>
    public ArrayList<LogoCommandInterface> parseLogoProgram() throws Exception {
        ArrayList<LogoCommandInterface> commands = new ArrayList<LogoCommandInterface>();
        commands.add(parseLogoSentence());
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
                case SHOWTURTLE:
                case HIDETURTLE:
                case CLEAN:
                case CLEARSCREEN:
                case SHOWNP:
                case PENDOWN:
                case PENUP:
                case PENPAINT:
                case PENERASE:
                case PENREVERSE:
                case SETX:
                case SETY:
                case SETHEADING:
                case SETPENCOLOR:
                case SETPENSIZE:
                case SETBACKGROUND:
                case SETXY:
                case ARC:
                case SETPOS:
                case TOWARDS:
                case IF:
                case WHILE:
                case EQUAL:
                case LESS:
                case GREATER:
                case LESSEQ:
                case GREATEREQ:
                case REPEAT:
                case SETICON:
                    commands.add(parseLogoSentence());
                    break;
                default:
                    Match(Token.EOF);
                    return commands;
            }
        }
    }
    // <logo-sentence> ::= FORWARD <integer>
    //                   | BACK <integer>
    //                   | LEFT <integer>
    //                   | RIGHT <integer>
    //                   | REPEAT <integer> [ <logo-sentence> { <logo-sentence> } ]
    private LogoCommandInterface parseLogoSentence() throws Exception {
        LogoCommandInterface result = null;
        Token nextToken = scanner.nextToken();
        NumberRecord numberRecord;
        NumberRecord numberRecord2;
        switch(nextToken)
        {
            case HOME:
                result = new LogoHomeCommand();
                Match(nextToken);
                break;
            case POS:
                result = new LogoReturnPositionCommand(Token.POS);
                Match(nextToken);
                break;
            case XCOR:
                result = new LogoReturnPositionCommand(Token.XCOR);
                Match(nextToken);
                break;
            case YCOR:
                result = new LogoReturnPositionCommand(Token.YCOR);
                Match(nextToken);
                break;
            case SHOWTURTLE:
                result = new LogoVisibilityCommand(Token.SHOWTURTLE);
                Match(nextToken);
                break;
            case HIDETURTLE:
                result = new LogoVisibilityCommand(Token.HIDETURTLE);
                Match(nextToken);
                break;
            case PENDOWN:
                result = new LogoPenCommand(Token.PENDOWN);
                Match(nextToken);
                break;
            case PENUP:
                result = new LogoPenCommand(Token.PENUP);
                Match(nextToken);
                break;
            case CLEAN:
                result = new LogoBackgroundCommand(Token.CLEAN);
                Match(nextToken);
                break;
            case HEADING:
                result = new LogoReturnPositionCommand(Token.HEADING);
                Match(nextToken);
                break;
            case CLEARSCREEN:
                result = new LogoBackgroundCommand(Token.CLEARSCREEN);
                Match(nextToken);
                break;
            case SHOWNP:
                result = new LogoReturnPositionCommand(Token.SHOWNP);
                Match(nextToken);
                break;
            case PENPAINT:
                result = new LogoPenCommand(Token.PENPAINT);
                Match(nextToken);
                break;
            case PENERASE:
                result = new LogoPenCommand(Token.PENERASE);
                Match(nextToken);
                break;
            case PENREVERSE:
                result = new LogoPenCommand(Token.PENREVERSE);
                Match(nextToken);
                break;
            case FORWARD:
            case BACK:
            case LEFT:
            case RIGHT:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                if (nextToken == Token.FORWARD || nextToken == Token.BACK)
                {
                    result = new LogoMoveCommand(numberRecord);
                }
                else
                {
                    result = new LogoTurnCommand(numberRecord);
                }
                break;
            case SETICON:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoIconCommand(numberRecord);
                break;
            case SETX:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPositionCommand(numberRecord, Token.SETX);
                break;
            case SETY:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPositionCommand(numberRecord, Token.SETY);
                break;
            case SETPENCOLOR:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPenCommand(numberRecord, Token.SETPENCOLOR);
                break;
            case SETPENSIZE:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPenCommand(numberRecord, Token.SETPENSIZE);
                break;
            case SETBACKGROUND:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoBackgroundCommand(numberRecord, Token.SETBACKGROUND);
                break;
            case SETXY:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                Match(Token.NUMBER);
                numberRecord2 = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPositionCommand(numberRecord, numberRecord2, Token.SETXY);
                break;
            case SETHEADING:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPositionCommand(numberRecord, Token.SETHEADING);
                break;
            case ARC:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                Match(Token.NUMBER);
                numberRecord2 = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoArcCommand(numberRecord, numberRecord2);
                break;
            case SETPOS:
                Match(nextToken);
                Match(Token.LBRACKET);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                Match(Token.NUMBER);
                numberRecord2 = new NumberRecord(nextToken, scanner.scanBuffer);
                result = new LogoPositionCommand(numberRecord, numberRecord2, Token.SETXY);
                Match(Token.RBRACKET);
                break;
            case TOWARDS:
                Match(nextToken);
                Match(Token.LBRACKET);
                Match(Token.NUMBER);
                Match(Token.NUMBER);
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
            case RBRACKET:
                rightBracketFound = true;
                break;
            case REPEAT:
                Match(nextToken);
                Match(Token.NUMBER);
                numberRecord = new NumberRecord(nextToken, scanner.scanBuffer);
                Match(Token.LBRACKET);
                while(true) {
                    result = parseLogoSentence();
                    if(rightBracketFound) break;
                    commandsToRepeat.add(result);
                }
                Match(Token.RBRACKET);
                result = new LogoRepeatCommand(numberRecord,commandsToRepeat);
                break;
            default:
                SyntaxError(String.format("Expected one of: FORWARD, BACK, LEFT, RIGHT or REPEAT but found %s",
                        nextToken), new Exception());
                break;
        }
        return result;
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
