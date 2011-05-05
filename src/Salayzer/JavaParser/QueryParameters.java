package Salayzer.JavaParser;

import antlr.Token;

import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 15, 2007
 * Time: 12:10:54 AM
 */
public class QueryParameters {
    private List<Parameter> params;
    private File file;
    private List<String> allValues;


    public QueryParameters(File f, List<Token> tokens) {
        this();
        this.file = f;
        setTokens(tokens);
    }


    public QueryParameters() {
        this.params = new Vector<Parameter>();
    }


    public List<Parameter> getTokens() {
        return params;
    }

    public void setTokens(List<Token> tokens) {

        Parameter p = null;

        for (Token t : tokens) {
            if (p == null) {
                if (file == null) {
                    throw new RuntimeException("File is null");
                }
                p = new Parameter(file, t.getText(), t.getType());
            } else if (t.getType() == JavaTokenTypes.PLUS) {
                params.add(p);
                p = null;
            } else {
                p.appendText(t.getText());
            }
        }
        params.add(p);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Parameter p : params) {
            buffer.append(p);
        }

        return buffer.toString();
    }

    public void generateAllPossibleValues() {
        allValues = new Vector<String>();
        for (Parameter p : params) {
            p.parseAllPossibleValues();
            addToAllValues(p.getPossibleValues());
        }
    }

    private void addToAllValues(List<String> values) {
        if (allValues.size() == 0) {
            allValues.add("");
        }
        List<String> temp = new Vector<String>(allValues);
        allValues.clear();

        for (String prefix : temp) {
            for (String s : values) {
                allValues.add(prefix + s);
            }
        }
    }

    public List<String> getAllPossibleValues() {
        return allValues;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
