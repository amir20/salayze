package Salayzer.JavaParser;

import antlr.TokenStreamException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 15, 2007
 * Time: 9:41:12 PM
 */
public class Parameter {
    private StringBuffer text;
    private int type;
    private File file;
    private ParseQueryVariable variable;
    private List<String> possibleValues;

    public Parameter(String text, int type) {
        setText(text);
        setType(type);
    }

    public Parameter() {
        this("", 0);
    }

    public Parameter(File file, String text, int type) {
        this(text, type);
        this.file = file;

    }

    public String getText() {
        return text.toString();
    }

    public void setText(String text) {
        if (text.startsWith("\"") && text.endsWith("\"")) {
            text = text.substring(1, text.length() - 1);
        }
        this.text = new StringBuffer(text);
    }

    public void appendText(String t) {
        this.text.append(t);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return "[(" + this.type + ") " + this.text + "]";
    }

    public void parseAllPossibleValues() {
        possibleValues = new Vector<String>();

        if (this.type == JavaTokenTypes.STRING_LITERAL) {
            possibleValues.add(this.text.toString());
        } else if (this.type == JavaTokenTypes.IDENT) {
            if (this.text.toString().contains("(") && this.text.toString().contains(")")) {
                System.out.println("I don't know how to handle function calls in an SQL statement");
                System.exit(1);
            } else {
                parseJavaFile();
            }
        }
    }

    public List<String> getPossibleValues() {
        return possibleValues;
    }

    private void parseJavaFile() {
        try {
            if (file != null) {
                variable = new ParseQueryVariable(file, text.toString());
                possibleValues = variable.getPossibleValues();
            } else {
                throw new RuntimeException("File is null");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TokenStreamException e) {
            e.printStackTrace();
        }

    }


    public void setFile(File file) {
        this.file = file;
    }
}
