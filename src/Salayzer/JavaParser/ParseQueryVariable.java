package Salayzer.JavaParser;

import antlr.Token;
import antlr.TokenStreamException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 16, 2007
 * Time: 1:51:30 AM
 */
public class ParseQueryVariable extends ParseFile {
    protected Stack<List<StringBuffer>> stack = null;
    protected Stack<List<String>> beforeCondition = null;
    protected Token createdFirst;

    protected enum conditionType {
        IF, ELSEIF, ELSE
    }

    protected Stack<conditionType> current_condition;

    public ParseQueryVariable(String filename, String var) throws FileNotFoundException, TokenStreamException {
        this(new File(filename), var);
    }

    public ParseQueryVariable(File f, String var) throws FileNotFoundException, TokenStreamException {
        super(f);
        stack = new Stack<List<StringBuffer>>();
        beforeCondition = new Stack<List<String>>();
        stack.push(new Vector<StringBuffer>());
        current_condition = new Stack<conditionType>();
        this.var = var;
        parseForType();
        parseForValues();
    }


    public List<String> getPossibleValues() {
        List<String> list = new Vector<String>();
        if (stack.size() == 1) {
            for (StringBuffer sb : stack.peek()) {
                list.add(sb.toString());
            }
        } else {
            throw new RuntimeException("Stack must only have have on element.");
        }


        return list;
    }

    protected void parseForType() throws TokenStreamException, FileNotFoundException {
        super.parseForType();
        this.createdFirst = this.lastFoundType;
        if (nextToken().getType() == JavaTokenTypes.ASSIGN) {
            handleAssignment();
        }
    }

    public void parseForValues() throws TokenStreamException, FileNotFoundException {
        if (type != null) {
            while (this.getNextTokenText(var) != null) {
                Token t = nextToken();

                if (t.getType() == JavaTokenTypes.PLUS_ASSIGN) {
                    handleConcat();
                } else if (t.getType() == JavaTokenTypes.ASSIGN) {
                    handleAssignment();
                }
            }

        } else {
            throw new RuntimeException("Type is not set");
        }
    }

    private String removeQuotes(String s) {
        return (s.startsWith("\"") && s.endsWith("\"") ? s.substring(1, s.length() - 1) : s);
    }

    private void addQuery(String s) {
        stack.peek().clear();
        stack.peek().add(new StringBuffer(removeQuotes(s)));
    }

    private void appendQuery(String s) {
        for (StringBuffer sb : stack.peek()) {
            sb.append(removeQuotes(s));
        }
    }

    private void handleConcat() throws FileNotFoundException, TokenStreamException {
        StringBuffer s = readQuery();
        appendQuery(s.toString());
    }

    private void handleAssignment() throws FileNotFoundException, TokenStreamException {
        StringBuffer s = readQuery();
        addQuery(s.toString());
    }

    private StringBuffer readQuery() throws FileNotFoundException, TokenStreamException {
        StringBuffer s = new StringBuffer();
        for (Token t : getUpToNext(JavaTokenTypes.SEMI)) {
            if (t.getType() == JavaTokenTypes.STRING_LITERAL) {
                s.append(removeQuotes(t.getText()));
            } else if (t.getType() == JavaTokenTypes.PLUS) {
                continue;
            } else if (t.getType() == JavaTokenTypes.IDENT) {
                s.append("java_var_").append(new ParseFile(file, t.getText()).type.toLowerCase()).append("_").append(t.getText());
            } else {
                throw new RuntimeException("Unknown type for handling :" + t);
            }
        }
        return s;
    }

    private void mergeStack() {
        List<StringBuffer> top = stack.pop();
        stack.peek().addAll(top);
    }


    private void removeFromStack(List<String> removeList) {
        for (String s : removeList) {
            StringBuffer toRemove = null;
            for (StringBuffer sb : stack.peek()) {
                if (sb.toString().equals(s)) {
                    toRemove = sb;
                }
            }
            stack.peek().remove(toRemove);
        }
    }


    private List<String> convertBufferToStringStack(List<StringBuffer> sb) {
        List<String> string_stack = new Vector<String>();

        for (StringBuffer s : sb) {
            string_stack.add(s.toString());
        }

        return string_stack;
    }

    private List<StringBuffer> converStringToBuffer(List<String> strings) {
        List<StringBuffer> stringb_stack = new Vector<StringBuffer>();

        for (String s : strings) {
            stringb_stack.add(new StringBuffer(s));
        }

        return stringb_stack;
    }

    private List<StringBuffer> copyStringBufferList(List<StringBuffer> original) {
        List<StringBuffer> destination = new Vector<StringBuffer>();

        for (StringBuffer s : original) {
            destination.add(new StringBuffer(s));
        }

        return destination;
    }


    protected Token nextToken() throws TokenStreamException {
        super.nextToken();

        if (current_condition != null && current_condition.size() > 0 && lastToken != null && lastToken.getType() == JavaTokenTypes.RCURLY) {
            if (currentToken.getType() == JavaTokenTypes.LITERAL_else) {
                super.nextToken();

                if (currentToken.getType() == JavaTokenTypes.LCURLY) {
                    // else statement
                    current_condition.pop();
                    current_condition.push(conditionType.ELSE);
                    mergeStack();
                    stack.push(converStringToBuffer(beforeCondition.peek()));
                } else {
                    // else if statement
                    current_condition.pop();
                    current_condition.push(conditionType.ELSEIF);
                    mergeStack();
                    stack.push(converStringToBuffer(beforeCondition.peek()));
                }

            } else {
                // end of if statement
                if (current_condition.peek() == conditionType.ELSE) {
                    mergeStack();
                    removeFromStack(beforeCondition.pop());
                } else if (current_condition.peek() == conditionType.ELSEIF) {
                    mergeStack();
                } else {
                    mergeStack();
                    beforeCondition.pop();
                }
                current_condition.pop();
            }
        }

        if (lastToken != null && lastToken.getType() != JavaTokenTypes.LITERAL_else
                && currentToken.getType() == JavaTokenTypes.LITERAL_if) {
            // if statement
            current_condition.push(conditionType.IF);
            beforeCondition.push(convertBufferToStringStack(stack.peek()));
            stack.push(copyStringBufferList(stack.peek()));

        }

        return currentToken;
    }
}
