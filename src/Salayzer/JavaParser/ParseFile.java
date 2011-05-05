package Salayzer.JavaParser;

import antlr.Token;
import antlr.TokenStreamException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 12, 2007
 * Time: 1:15:14 PM
 */
public class ParseFile {
    protected File file = null;
    protected JavaLexer lexer = null;
    protected Token lastToken = null;
    protected Token currentToken = null;
    protected Token lastFoundType = null;
    protected String type = null;
    protected String var = null;

    public ParseFile(String filename) throws FileNotFoundException {
        this(new File(filename));
    }

    public ParseFile(File f) throws FileNotFoundException {
        lexer = new JavaLexer(new BufferedReader(new FileReader(f)));
        lexer.setFilename(f.getName());
        this.file = f;
    }

    public ParseFile(File f, String var) throws FileNotFoundException, TokenStreamException {
        this(f);
        this.var = var;
        parseForType();
    }

    protected void parseForType() throws TokenStreamException, FileNotFoundException {
        this.getNextTokenText(var);
        this.type = this.lastFoundType.getText();
    }


    private List<QueryParameters> getQueryCalls() {

        List<QueryParameters> list = new Vector<QueryParameters>();
        while (getNextTokenText("executeQuery") != null) {
            QueryParameters qp = new QueryParameters(file, getSQLStatement());
            list.add(qp);
        }


        return list;
    }

    protected Token getNextTokenType(int type) {

        Token t = null;

        try {

            do {
                t = nextToken();
            } while (t.getType() != JavaTokenTypes.EOF && t.getType() != type);

        } catch (TokenStreamException e) {
            e.printStackTrace();
        }

        assert t != null;
        return t.getType() != JavaTokenTypes.EOF ? t : null;

    }

    protected Token getNextTokenText(String text) {

        Token t = null;
        try {

            do {
                t = nextToken();

            } while (t.getType() != JavaTokenTypes.EOF && !t.getText().equals(text));

        } catch (TokenStreamException e) {
            e.printStackTrace();
        }

        assert t != null;
        return t.getType() != JavaTokenTypes.EOF ? t : null;

    }

    protected List<Token> getUpToNext(int type) {
        List<Token> list = new Vector<Token>();
        try {
            Token t;
            t = nextToken();

            while (t.getType() != JavaTokenTypes.EOF && t.getType() != type) {
                list.add(t);
                t = lexer.nextToken();
            }

        } catch (TokenStreamException e) {
            e.printStackTrace();
        }


        return list;
    }

    protected List<Token> getFromToNextToken(int from, int to) {
        getNextTokenType(from);
        return getUpToNext(to);
    }

    protected List<Token> getSQLStatement() {
        Vector<Token> list = (Vector<Token>) getFromToNextToken(JavaTokenTypes.LPAREN, JavaTokenTypes.SEMI);
        list.remove(list.lastElement()); // removes the last paranthesis

        return list;
    }

    protected Token nextToken() throws TokenStreamException {
        lastToken = currentToken;
        currentToken = lexer.nextToken();
        if (currentToken.getType() != JavaTokenTypes.EOF && (currentToken.getText().equals("String") || currentToken.getText().equals("int"))) {
            lastFoundType = currentToken;
        }
        return currentToken;

    }

    public List<String> getPossibleSQLStrings() {
        List<String> sqls = new Vector<String>();
        List<QueryParameters> qps = this.getQueryCalls();
        for (QueryParameters qp : qps) {
            qp.generateAllPossibleValues();
            for (String s : qp.getAllPossibleValues()) {
                sqls.add(s);
            }
        }

        return sqls;
    }
}
