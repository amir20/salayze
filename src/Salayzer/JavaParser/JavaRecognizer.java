package Salayzer.JavaParser;// $ANTLR 2.7.5 (20050128): "java.g" -> "Salyze.JavaParser.JavaLexer.Lexer.JavaRecognizer.java"$

import antlr.*;
import antlr.collections.AST;
import antlr.collections.impl.ASTArray;
import antlr.collections.impl.BitSet;

/**
 * Java 1.5/JSR14/JSR201/JSR175 Recognizer
 * <p/>
 * Run 'java Main [-showtree] directory-full-of-java-files'
 * <p/>
 * [The -showtree option pops up a Swing frame that shows
 * the AST constructed from the parser.]
 * <p/>
 * Run 'java Main <directory full of java files>'
 * <p/>
 * Contributing authors:
 * John Mitchell		johnm@non.net
 * Terence Parr		parrt@magelang.com
 * John Lilley			jlilley@empathy.com
 * Scott Stanchfield	thetick@magelang.com
 * Markus Mohnen       mohnen@informatik.rwth-aachen.de
 * Peter Williams      pete.williams@sun.com
 * Allan Jacobs        Allan.Jacobs@eng.sun.com
 * Steve Messick       messick@redhills.com
 * John Pybus			john@pybus.org
 * <p/>
 * Version 1.00 December 9, 1997 -- initial release
 * Version 1.01 December 10, 1997
 * fixed bug in octal def (0..7 not 0..8)
 * Version 1.10 August 1998 (parrt)
 * added tree construction
 * fixed definition of WS,comments for mac,pc,unix newlines
 * added unary plus
 * Version 1.11 (Nov 20, 1998)
 * Added "shutup" option to turn off last ambig warning.
 * Fixed inner class def to allow named class defs as statements
 * synchronized requires compound not simple statement
 * add [] after builtInType DOT class in primaryExpression
 * "const" is reserved but not valid..removed from modifiers
 * Version 1.12 (Feb 2, 1999)
 * Changed LITERAL_xxx to xxx in tree grammar.
 * Updated java.g to use tokens {...} now for 2.6.0 (new feature).
 * <p/>
 * Version 1.13 (Apr 23, 1999)
 * Didn't have (stat)? for else clause in tree parser.
 * Didn't gen ASTs for interface extends.  Updated tree parser too.
 * Updated to 2.6.0.
 * Version 1.14 (Jun 20, 1999)
 * Allowed final/abstract on local classes.
 * Removed local interfaces from methods
 * Put instanceof precedence where it belongs...in relationalExpr
 * It also had expr not type as arg; fixed it.
 * Missing ! on SEMI in classBlock
 * fixed: (expr) + "string" was parsed incorrectly (+ as unary plus).
 * fixed: didn't like Object[].class in parser or tree parser
 * Version 1.15 (Jun 26, 1999)
 * Screwed up rule with instanceof in it. :(  Fixed.
 * Tree parser didn't like (expr).something; fixed.
 * Allowed multiple inheritance in tree grammar. oops.
 * Version 1.16 (August 22, 1999)
 * Extending an interface built a wacky tree: had extra EXTENDS.
 * Tree grammar didn't allow multiple superinterfaces.
 * Tree grammar didn't allow empty var initializer: {}
 * Version 1.17 (October 12, 1999)
 * ESC lexer rule allowed 399 max not 377 max.
 * java.tree.g didn't handle the expression of synchronized
 * statements.
 * Version 1.18 (August 12, 2001)
 * Terence updated to Java 2 Version 1.3 by
 * observing/combining work of Allan Jacobs and Steve
 * Messick.  Handles 1.3 src.  Summary:
 * o  primary didn't include boolean.class kind of thing
 * o  constructor calls parsed explicitly now:
 * see explicitConstructorInvocation
 * o  add strictfp modifier
 * o  missing objBlock after new expression in tree grammar
 * o  merged local class definition alternatives, moved after declaration
 * o  fixed problem with ClassName.super.field
 * o  reordered some alternatives to make things more efficient
 * o  long and double constants were not differentiated from int/float
 * o  whitespace rule was inefficient: matched only one char
 * o  add an examples directory with some nasty 1.3 cases
 * o  made Main.java use buffered IO and a Reader for Unicode support
 * o  supports UNICODE?
 * Using Unicode charVocabulay makes code file big, but only
 * in the bitsets at the end. I need to make ANTLR generate
 * unicode bitsets more efficiently.
 * Version 1.19 (April 25, 2002)
 * Terence added in nice fixes by John Pybus concerning floating
 * constants and problems with super() calls.  John did a nice
 * reorg of the primary/postfix expression stuff to read better
 * and makes f.g.super() parse properly (it was METHOD_CALL not
 * a SUPER_CTOR_CALL).  Also:
 * <p/>
 * o  "finally" clause was a root...made it a child of "try"
 * o  Added stuff for asserts too for Java 1.4, but *commented out*
 * as it is not backward compatible.
 * <p/>
 * Version 1.20 (October 27, 2002)
 * <p/>
 * Terence ended up reorging John Pybus' stuff to
 * remove some nondeterminisms and some syntactic predicates.
 * Note that the grammar is stricter now; e.g., this(...) must
 * be the first statement.
 * <p/>
 * Trinary ?: operator wasn't working as array name:
 * (isBig ? bigDigits : digits)[i];
 * <p/>
 * Checked parser/tree parser on source for
 * Resin-2.0.5, jive-2.1.1, jdk 1.3.1, Lucene, antlr 2.7.2a4,
 * and the 110k-line jGuru server source.
 * <p/>
 * Version 1.21 (October 17, 2003)
 * Fixed lots of problems including:
 * Ray Waldin: add typeDefinition to interfaceBlock in java.tree.g
 * He found a problem/fix with floating point that start with 0
 * Ray also fixed problem that (int.class) was not recognized.
 * Thorsten van Ellen noticed that \n are allowed incorrectly in strings.
 * TJP fixed CHAR_LITERAL analogously.
 * <p/>
 * Version 1.22 (April 14, 2004)
 * Changed vocab to be ..\uFFFE to avoid -1 char. removed dummy VOCAB rule.
 * <p/>
 * Version 1.21.2 (March, 2003)
 * Changes by Matt Quail to support generics (as per JDK1.5/JSR14)
 * Notes:
 * o We only allow the "extends" keyword and not the "implements"
 * keyword, since thats what JSR14 seems to imply.
 * o Thanks to Monty Zukowski for his help on the antlr-interest
 * mail list.
 * o Thanks to Alan Eliasen for testing the grammar over his
 * Fink source base
 * <p/>
 * Version 1.22+assert+JSR14 (2004-06-10)
 * Merged ANTLR version 1.22 with javaG.g version 1.21.2 and added
 * the ability to enable the "assert" keyword at runtime via the lexer.
 * Also made changes to generics rules for a saner AST creation.
 * <p/>
 * Version 1.22+assert+JSR14+JSR201 (2004-06-12)
 * Added support for enums, varargs, enhanced for loop, and import static
 * <p/>
 * Version 1.22+assert+JSR14+JSR201+JSR175 (2004-06-14)
 * Added support for metadata (JSR 175). Refactored the field rule into
 * classField and interfaceField.
 * <p/>
 * Version 1.22+assert+JSR14+JSR201+JSR175+AST (2004-07-02)
 * Various changes to improve AST generation; also made the tree parser
 * recognize all the fancy new stuff. Added the ability to enable the
 * "enum" keyword at runtime (just like "assert").
 * <p/>
 * Version 1.22+assert+JSR14+JSR201+JSR175+AST+fixes (2004-08-17)
 * Bug fixes and support for wildcard type arguments and constructor
 * type parameters (new in final draft of JSR 14). Formatting cleanup.
 * <p/>
 * Version 1.22+assert+JSR14+JSR201+JSR175+AST+fixes^2 (2004-08-31)
 * Fixes for bugs identified by Michael Studman:
 * - allow annotations with an empty list of args
 * - allow annotations in annotation member array initializers
 * - saner enum constant initialization ast construction
 * - also removed some cruft in rule postfixExpression
 * <p/>
 * This grammar is in the PUBLIC DOMAIN
 */
public class JavaRecognizer extends antlr.LLkParser implements JavaTokenTypes {

    /**
     * Counts the number of LT seen in the typeArguments production.
     * It is used in semantic predicates to ensure we have seen
     * enough closing '>' characters; which actually may have been
     * either GT, SR or BSR tokens.
     */
    private int ltCounter = 0;

    protected JavaRecognizer(TokenBuffer tokenBuf, int k) {
        super(tokenBuf, k);
        tokenNames = _tokenNames;
        buildTokenTypeASTClassMap();
        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
    }

    public JavaRecognizer(TokenBuffer tokenBuf) {
        this(tokenBuf, 2);
    }

    protected JavaRecognizer(TokenStream lexer, int k) {
        super(lexer, k);
        tokenNames = _tokenNames;
        buildTokenTypeASTClassMap();
        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
    }

    public JavaRecognizer(TokenStream lexer) {
        this(lexer, 2);
    }

    public JavaRecognizer(ParserSharedInputState state) {
        super(state, 2);
        tokenNames = _tokenNames;
        buildTokenTypeASTClassMap();
        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
    }

    public final void compilationUnit() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST compilationUnit_AST = null;

        {
            boolean synPredMatched4 = false;
            if (((LA(1) == LITERAL_package || LA(1) == AT) && (LA(2) == IDENT))) {
                int _m4 = mark();
                synPredMatched4 = true;
                inputState.guessing++;
                try {
                    {
                        annotations();
                        match(LITERAL_package);
                    }
                }
                catch (RecognitionException pe) {
                    synPredMatched4 = false;
                }
                rewind(_m4);
                inputState.guessing--;
            }
            if (synPredMatched4) {
                packageDefinition();
                astFactory.addASTChild(currentAST, returnAST);
            } else if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
            } else {
                throw new NoViableAltException(LT(1), getFilename());
            }

        }
        {
            _loop6:
            do {
                if ((LA(1) == LITERAL_import)) {
                    importDefinition();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop6;
                }

            } while (true);
        }
        {
            _loop8:
            do {
                if ((_tokenSet_2.member(LA(1)))) {
                    typeDefinition();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop8;
                }

            } while (true);
        }
        match(Token.EOF_TYPE);
        compilationUnit_AST = (AST) currentAST.root;
        returnAST = compilationUnit_AST;
    }

    public final void annotations() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotations_AST = null;

        {
            _loop75:
            do {
                if ((LA(1) == AT)) {
                    annotation();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop75;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            annotations_AST = (AST) currentAST.root;
            annotations_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ANNOTATIONS, "ANNOTATIONS")).add(annotations_AST));
            currentAST.root = annotations_AST;
            currentAST.child = annotations_AST != null && annotations_AST.getFirstChild() != null ?
                    annotations_AST.getFirstChild() : annotations_AST;
            currentAST.advanceChildToEnd();
        }
        annotations_AST = (AST) currentAST.root;
        returnAST = annotations_AST;
    }

    public final void packageDefinition() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST packageDefinition_AST = null;
        Token p = null;
        AST p_AST = null;

        try {      // for error handling
            annotations();
            astFactory.addASTChild(currentAST, returnAST);
            p = LT(1);
            p_AST = astFactory.create(p);
            astFactory.makeASTRoot(currentAST, p_AST);
            match(LITERAL_package);
            if (inputState.guessing == 0) {
                p_AST.setType(PACKAGE_DEF);
            }
            identifier();
            astFactory.addASTChild(currentAST, returnAST);
            match(SEMI);
            packageDefinition_AST = (AST) currentAST.root;
        }
        catch (RecognitionException ex) {
            if (inputState.guessing == 0) {
                reportError(ex);
                recover(ex, _tokenSet_0);
            } else {
                throw ex;
            }
        }
        returnAST = packageDefinition_AST;
    }

    public final void importDefinition() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST importDefinition_AST = null;
        Token i = null;
        AST i_AST = null;

        try {      // for error handling
            i = LT(1);
            i_AST = astFactory.create(i);
            astFactory.makeASTRoot(currentAST, i_AST);
            match(LITERAL_import);
            if (inputState.guessing == 0) {
                i_AST.setType(IMPORT);
            }
            {
                switch (LA(1)) {
                    case LITERAL_static: {
                        AST tmp3_AST = null;
                        tmp3_AST = astFactory.create(LT(1));
                        astFactory.addASTChild(currentAST, tmp3_AST);
                        match(LITERAL_static);
                        break;
                    }
                    case IDENT: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(LT(1), getFilename());
                    }
                }
            }
            identifierStar();
            astFactory.addASTChild(currentAST, returnAST);
            match(SEMI);
            importDefinition_AST = (AST) currentAST.root;
        }
        catch (RecognitionException ex) {
            if (inputState.guessing == 0) {
                reportError(ex);
                recover(ex, _tokenSet_0);
            } else {
                throw ex;
            }
        }
        returnAST = importDefinition_AST;
    }

    public final void typeDefinition() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeDefinition_AST = null;
        AST m_AST = null;

        try {      // for error handling
            switch (LA(1)) {
                case FINAL:
                case ABSTRACT:
                case STRICTFP:
                case ENUM:
                case LITERAL_static:
                case LITERAL_private:
                case LITERAL_public:
                case LITERAL_protected:
                case LITERAL_transient:
                case LITERAL_native:
                case LITERAL_threadsafe:
                case LITERAL_synchronized:
                case LITERAL_volatile:
                case AT:
                case LITERAL_interface:
                case LITERAL_class: {
                    modifiers();
                    m_AST = (AST) returnAST;
                    {
                        switch (LA(1)) {
                            case LITERAL_class: {
                                classDefinition(m_AST);
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case ENUM: {
                                enumDefinition(m_AST);
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case LITERAL_interface: {
                                interfaceDefinition(m_AST);
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case AT: {
                                annotationTypeDefinition(m_AST);
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    typeDefinition_AST = (AST) currentAST.root;
                    break;
                }
                case SEMI: {
                    match(SEMI);
                    typeDefinition_AST = (AST) currentAST.root;
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        catch (RecognitionException ex) {
            if (inputState.guessing == 0) {
                reportError(ex);
                recover(ex, _tokenSet_3);
            } else {
                throw ex;
            }
        }
        returnAST = typeDefinition_AST;
    }

    public final void identifier() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST identifier_AST = null;

        AST tmp6_AST = null;
        tmp6_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp6_AST);
        match(IDENT);
        {
            _loop43:
            do {
                if ((LA(1) == DOT)) {
                    AST tmp7_AST = null;
                    tmp7_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp7_AST);
                    match(DOT);
                    AST tmp8_AST = null;
                    tmp8_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp8_AST);
                    match(IDENT);
                } else {
                    break _loop43;
                }

            } while (true);
        }
        identifier_AST = (AST) currentAST.root;
        returnAST = identifier_AST;
    }

    public final void identifierStar() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST identifierStar_AST = null;

        AST tmp9_AST = null;
        tmp9_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp9_AST);
        match(IDENT);
        {
            _loop46:
            do {
                if ((LA(1) == DOT) && (LA(2) == IDENT)) {
                    AST tmp10_AST = null;
                    tmp10_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp10_AST);
                    match(DOT);
                    AST tmp11_AST = null;
                    tmp11_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp11_AST);
                    match(IDENT);
                } else {
                    break _loop46;
                }

            } while (true);
        }
        {
            switch (LA(1)) {
                case DOT: {
                    AST tmp12_AST = null;
                    tmp12_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp12_AST);
                    match(DOT);
                    AST tmp13_AST = null;
                    tmp13_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp13_AST);
                    match(STAR);
                    break;
                }
                case SEMI: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        identifierStar_AST = (AST) currentAST.root;
        returnAST = identifierStar_AST;
    }

    public final void modifiers() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST modifiers_AST = null;

        {
            _loop50:
            do {
                if ((_tokenSet_4.member(LA(1)))) {
                    modifier();
                    astFactory.addASTChild(currentAST, returnAST);
                } else if ((LA(1) == AT) && (LA(2) == IDENT)) {
                    annotation();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop50;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            modifiers_AST = (AST) currentAST.root;
            modifiers_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(MODIFIERS, "MODIFIERS")).add(modifiers_AST));
            currentAST.root = modifiers_AST;
            currentAST.child = modifiers_AST != null && modifiers_AST.getFirstChild() != null ?
                    modifiers_AST.getFirstChild() : modifiers_AST;
            currentAST.advanceChildToEnd();
        }
        modifiers_AST = (AST) currentAST.root;
        returnAST = modifiers_AST;
    }

    public final void classDefinition(
            AST modifiers
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST classDefinition_AST = null;
        AST tp_AST = null;
        AST sc_AST = null;
        AST ic_AST = null;
        AST cb_AST = null;

        match(LITERAL_class);
        AST tmp15_AST = null;
        tmp15_AST = astFactory.create(LT(1));
        match(IDENT);
        typeParameters();
        tp_AST = (AST) returnAST;
        superClassClause();
        sc_AST = (AST) returnAST;
        implementsClause();
        ic_AST = (AST) returnAST;
        classBlock();
        cb_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            classDefinition_AST = (AST) currentAST.root;
            classDefinition_AST = (AST) astFactory.make((new ASTArray(7)).add(astFactory.create(CLASS_DEF, "CLASS_DEF")).add(modifiers).add(tmp15_AST).add(tp_AST).add(sc_AST).add(ic_AST).add(cb_AST));
            currentAST.root = classDefinition_AST;
            currentAST.child = classDefinition_AST != null && classDefinition_AST.getFirstChild() != null ?
                    classDefinition_AST.getFirstChild() : classDefinition_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = classDefinition_AST;
    }

    public final void enumDefinition(
            AST modifiers
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST enumDefinition_AST = null;
        AST ic_AST = null;
        AST eb_AST = null;

        AST tmp16_AST = null;
        tmp16_AST = astFactory.create(LT(1));
        match(ENUM);
        AST tmp17_AST = null;
        tmp17_AST = astFactory.create(LT(1));
        match(IDENT);
        implementsClause();
        ic_AST = (AST) returnAST;
        enumBlock();
        eb_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            enumDefinition_AST = (AST) currentAST.root;
            enumDefinition_AST = (AST) astFactory.make((new ASTArray(5)).add(astFactory.create(ENUM_DEF, "ENUM_DEF")).add(modifiers).add(tmp17_AST).add(ic_AST).add(eb_AST));
            currentAST.root = enumDefinition_AST;
            currentAST.child = enumDefinition_AST != null && enumDefinition_AST.getFirstChild() != null ?
                    enumDefinition_AST.getFirstChild() : enumDefinition_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = enumDefinition_AST;
    }

    public final void interfaceDefinition(
            AST modifiers
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST interfaceDefinition_AST = null;
        AST tp_AST = null;
        AST ie_AST = null;
        AST ib_AST = null;

        match(LITERAL_interface);
        AST tmp19_AST = null;
        tmp19_AST = astFactory.create(LT(1));
        match(IDENT);
        typeParameters();
        tp_AST = (AST) returnAST;
        interfaceExtends();
        ie_AST = (AST) returnAST;
        interfaceBlock();
        ib_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            interfaceDefinition_AST = (AST) currentAST.root;
            interfaceDefinition_AST = (AST) astFactory.make((new ASTArray(6)).add(astFactory.create(INTERFACE_DEF, "INTERFACE_DEF")).add(modifiers).add(tmp19_AST).add(tp_AST).add(ie_AST).add(ib_AST));
            currentAST.root = interfaceDefinition_AST;
            currentAST.child = interfaceDefinition_AST != null && interfaceDefinition_AST.getFirstChild() != null ?
                    interfaceDefinition_AST.getFirstChild() : interfaceDefinition_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = interfaceDefinition_AST;
    }

    public final void annotationTypeDefinition(
            AST modifiers
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationTypeDefinition_AST = null;
        AST ab_AST = null;

        AST tmp20_AST = null;
        tmp20_AST = astFactory.create(LT(1));
        match(AT);
        match(LITERAL_interface);
        AST tmp22_AST = null;
        tmp22_AST = astFactory.create(LT(1));
        match(IDENT);
        annotationBlock();
        ab_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            annotationTypeDefinition_AST = (AST) currentAST.root;
            annotationTypeDefinition_AST = (AST) astFactory.make((new ASTArray(4)).add(astFactory.create(ANNOTATION_DEF, "ANNOTATION_DEF")).add(modifiers).add(tmp22_AST).add(ab_AST));
            currentAST.root = annotationTypeDefinition_AST;
            currentAST.child = annotationTypeDefinition_AST != null && annotationTypeDefinition_AST.getFirstChild() != null ?
                    annotationTypeDefinition_AST.getFirstChild() : annotationTypeDefinition_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = annotationTypeDefinition_AST;
    }

    /**
     * A declaration is the creation of a reference or primitive-type variable
     * Create a separate Type/Var tree for each var in the var list.
     */
    public final void declaration() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST declaration_AST = null;
        AST m_AST = null;
        AST t_AST = null;
        AST v_AST = null;

        modifiers();
        m_AST = (AST) returnAST;
        typeSpec(false);
        t_AST = (AST) returnAST;
        variableDefinitions(m_AST, t_AST);
        v_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            declaration_AST = (AST) currentAST.root;
            declaration_AST = v_AST;
            currentAST.root = declaration_AST;
            currentAST.child = declaration_AST != null && declaration_AST.getFirstChild() != null ?
                    declaration_AST.getFirstChild() : declaration_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = declaration_AST;
    }

    public final void typeSpec(
            boolean addImagNode
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeSpec_AST = null;

        switch (LA(1)) {
            case IDENT: {
                classTypeSpec(addImagNode);
                astFactory.addASTChild(currentAST, returnAST);
                typeSpec_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double: {
                builtInTypeSpec(addImagNode);
                astFactory.addASTChild(currentAST, returnAST);
                typeSpec_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = typeSpec_AST;
    }

    public final void variableDefinitions(
            AST mods, AST t
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST variableDefinitions_AST = null;

        variableDeclarator(getASTFactory().dupTree(mods),
                getASTFactory().dupList(t));
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop135:
            do {
                if ((LA(1) == COMMA)) {
                    match(COMMA);
                    variableDeclarator(getASTFactory().dupTree(mods),
                            getASTFactory().dupList(t));
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop135;
                }

            } while (true);
        }
        variableDefinitions_AST = (AST) currentAST.root;
        returnAST = variableDefinitions_AST;
    }

    public final void classTypeSpec(
            boolean addImagNode
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST classTypeSpec_AST = null;
        Token lb = null;
        AST lb_AST = null;

        classOrInterfaceType(false);
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop19:
            do {
                if ((LA(1) == LBRACK) && (LA(2) == RBRACK)) {
                    lb = LT(1);
                    lb_AST = astFactory.create(lb);
                    astFactory.makeASTRoot(currentAST, lb_AST);
                    match(LBRACK);
                    if (inputState.guessing == 0) {
                        lb_AST.setType(ARRAY_DECLARATOR);
                    }
                    match(RBRACK);
                } else {
                    break _loop19;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            classTypeSpec_AST = (AST) currentAST.root;

            if (addImagNode) {
                classTypeSpec_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(classTypeSpec_AST));
            }

            currentAST.root = classTypeSpec_AST;
            currentAST.child = classTypeSpec_AST != null && classTypeSpec_AST.getFirstChild() != null ?
                    classTypeSpec_AST.getFirstChild() : classTypeSpec_AST;
            currentAST.advanceChildToEnd();
        }
        classTypeSpec_AST = (AST) currentAST.root;
        returnAST = classTypeSpec_AST;
    }

    public final void builtInTypeSpec(
            boolean addImagNode
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST builtInTypeSpec_AST = null;
        Token lb = null;
        AST lb_AST = null;

        builtInType();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop35:
            do {
                if ((LA(1) == LBRACK)) {
                    lb = LT(1);
                    lb_AST = astFactory.create(lb);
                    astFactory.makeASTRoot(currentAST, lb_AST);
                    match(LBRACK);
                    if (inputState.guessing == 0) {
                        lb_AST.setType(ARRAY_DECLARATOR);
                    }
                    match(RBRACK);
                } else {
                    break _loop35;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            builtInTypeSpec_AST = (AST) currentAST.root;

            if (addImagNode) {
                builtInTypeSpec_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(builtInTypeSpec_AST));
            }

            currentAST.root = builtInTypeSpec_AST;
            currentAST.child = builtInTypeSpec_AST != null && builtInTypeSpec_AST.getFirstChild() != null ?
                    builtInTypeSpec_AST.getFirstChild() : builtInTypeSpec_AST;
            currentAST.advanceChildToEnd();
        }
        builtInTypeSpec_AST = (AST) currentAST.root;
        returnAST = builtInTypeSpec_AST;
    }

    public final void referenceTypeSpec(
            boolean addImagNode
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST referenceTypeSpec_AST = null;

        switch (LA(1)) {
            case IDENT: {
                classTypeSpec(addImagNode);
                astFactory.addASTChild(currentAST, returnAST);
                referenceTypeSpec_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double: {
                arrayTypeSpec(addImagNode);
                astFactory.addASTChild(currentAST, returnAST);
                referenceTypeSpec_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = referenceTypeSpec_AST;
    }

    public final void arrayTypeSpec(
            boolean addImagNode
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST arrayTypeSpec_AST = null;
        Token lb = null;
        AST lb_AST = null;

        builtInType();
        astFactory.addASTChild(currentAST, returnAST);
        {
            int _cnt38 = 0;
            _loop38:
            do {
                if ((LA(1) == LBRACK) && (LA(2) == RBRACK)) {
                    lb = LT(1);
                    lb_AST = astFactory.create(lb);
                    astFactory.makeASTRoot(currentAST, lb_AST);
                    match(LBRACK);
                    if (inputState.guessing == 0) {
                        lb_AST.setType(ARRAY_DECLARATOR);
                    }
                    match(RBRACK);
                } else {
                    if (_cnt38 >= 1) {
                        break _loop38;
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }
                }

                _cnt38++;
            } while (true);
        }
        if (inputState.guessing == 0) {
            arrayTypeSpec_AST = (AST) currentAST.root;

            if (addImagNode) {
                arrayTypeSpec_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(arrayTypeSpec_AST));
            }

            currentAST.root = arrayTypeSpec_AST;
            currentAST.child = arrayTypeSpec_AST != null && arrayTypeSpec_AST.getFirstChild() != null ?
                    arrayTypeSpec_AST.getFirstChild() : arrayTypeSpec_AST;
            currentAST.advanceChildToEnd();
        }
        arrayTypeSpec_AST = (AST) currentAST.root;
        returnAST = arrayTypeSpec_AST;
    }

    public final void classOrInterfaceType(
            boolean addImagNode
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST classOrInterfaceType_AST = null;

        AST tmp27_AST = null;
        tmp27_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp27_AST);
        match(IDENT);
        typeArguments();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop22:
            do {
                if ((LA(1) == DOT) && (LA(2) == IDENT)) {
                    AST tmp28_AST = null;
                    tmp28_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp28_AST);
                    match(DOT);
                    AST tmp29_AST = null;
                    tmp29_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp29_AST);
                    match(IDENT);
                    typeArguments();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop22;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            classOrInterfaceType_AST = (AST) currentAST.root;

            if (addImagNode) {
                classOrInterfaceType_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(classOrInterfaceType_AST));
            }

            currentAST.root = classOrInterfaceType_AST;
            currentAST.child = classOrInterfaceType_AST != null && classOrInterfaceType_AST.getFirstChild() != null ?
                    classOrInterfaceType_AST.getFirstChild() : classOrInterfaceType_AST;
            currentAST.advanceChildToEnd();
        }
        classOrInterfaceType_AST = (AST) currentAST.root;
        returnAST = classOrInterfaceType_AST;
    }

    public final void typeArguments() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeArguments_AST = null;
        Token lt = null;
        AST lt_AST = null;
        int currentLtLevel = 0;

        switch (LA(1)) {
            case LT: {
                if (inputState.guessing == 0) {
                    currentLtLevel = ltCounter;
                }
                {
                    lt = LT(1);
                    lt_AST = astFactory.create(lt);
                    astFactory.makeASTRoot(currentAST, lt_AST);
                    match(LT);
                    if (inputState.guessing == 0) {
                        ltCounter++;
                        lt_AST.setType(TYPE_ARGS);
                    }
                    typeArgument();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop26:
                        do {
                            if (((LA(1) == COMMA) && (_tokenSet_5.member(LA(2)))) && (inputState.guessing != 0 || ltCounter == currentLtLevel + 1)) {
                                match(COMMA);
                                typeArgument();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop26;
                            }

                        } while (true);
                    }
                    {
                        if (((LA(1) >= GT && LA(1) <= BSR)) && (_tokenSet_6.member(LA(2)))) {
                            typeArgumentsEnd();
                        } else if ((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
                        } else {
                            throw new NoViableAltException(LT(1), getFilename());
                        }

                    }
                }
                if (!((currentLtLevel != 0) || ltCounter == currentLtLevel))
                    throw new SemanticException("(currentLtLevel != 0) || ltCounter == currentLtLevel");
                typeArguments_AST = (AST) currentAST.root;
                break;
            }
            case SEMI:
            case LBRACK:
            case RBRACK:
            case IDENT:
            case DOT:
            case COMMA:
            case QUESTION:
            case LITERAL_extends:
            case LITERAL_super:
            case GT:
            case SR:
            case BSR:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double:
            case LCURLY:
            case RCURLY:
            case LPAREN:
            case RPAREN:
            case ASSIGN:
            case BAND:
            case LITERAL_implements:
            case LITERAL_this:
            case ELLIPSIS:
            case COLON:
            case PLUS_ASSIGN:
            case MINUS_ASSIGN:
            case STAR_ASSIGN:
            case DIV_ASSIGN:
            case MOD_ASSIGN:
            case SR_ASSIGN:
            case BSR_ASSIGN:
            case SL_ASSIGN:
            case BAND_ASSIGN:
            case BXOR_ASSIGN:
            case BOR_ASSIGN:
            case LOR:
            case LAND:
            case BOR:
            case BXOR:
            case NOT_EQUAL:
            case EQUAL: {
                if (inputState.guessing == 0) {
                    typeArguments_AST = (AST) currentAST.root;
                    typeArguments_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE_ARGS, "TYPE_ARGS")).add(typeArguments_AST));
                    currentAST.root = typeArguments_AST;
                    currentAST.child = typeArguments_AST != null && typeArguments_AST.getFirstChild() != null ?
                            typeArguments_AST.getFirstChild() : typeArguments_AST;
                    currentAST.advanceChildToEnd();
                }
                typeArguments_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = typeArguments_AST;
    }

    public final void typeArgument() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeArgument_AST = null;
        Token q = null;
        AST q_AST = null;

        switch (LA(1)) {
            case QUESTION: {
                {
                    q = LT(1);
                    q_AST = astFactory.create(q);
                    astFactory.makeASTRoot(currentAST, q_AST);
                    match(QUESTION);
                    if (inputState.guessing == 0) {
                        q_AST.setType(WILDCARD);
                    }
                    {
                        if ((LA(1) == LITERAL_extends) && (_tokenSet_8.member(LA(2)))) {
                            AST tmp31_AST = null;
                            tmp31_AST = astFactory.create(LT(1));
                            astFactory.addASTChild(currentAST, tmp31_AST);
                            match(LITERAL_extends);
                            referenceTypeSpec(true);
                            astFactory.addASTChild(currentAST, returnAST);
                        } else if ((LA(1) == LITERAL_super) && (_tokenSet_8.member(LA(2)))) {
                            AST tmp32_AST = null;
                            tmp32_AST = astFactory.create(LT(1));
                            astFactory.addASTChild(currentAST, tmp32_AST);
                            match(LITERAL_super);
                            referenceTypeSpec(true);
                            astFactory.addASTChild(currentAST, returnAST);
                        } else if ((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
                        } else {
                            throw new NoViableAltException(LT(1), getFilename());
                        }

                    }
                }
                typeArgument_AST = (AST) currentAST.root;
                break;
            }
            case IDENT:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double: {
                referenceTypeSpec(true);
                astFactory.addASTChild(currentAST, returnAST);
                typeArgument_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = typeArgument_AST;
    }

    protected final void typeArgumentsEnd() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeArgumentsEnd_AST = null;

        {
            switch (LA(1)) {
                case GT: {
                    AST tmp33_AST = null;
                    tmp33_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp33_AST);
                    match(GT);
                    if (inputState.guessing == 0) {
                        ltCounter -= 1;
                    }
                    break;
                }
                case SR: {
                    AST tmp34_AST = null;
                    tmp34_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp34_AST);
                    match(SR);
                    if (inputState.guessing == 0) {
                        ltCounter -= 2;
                    }
                    break;
                }
                case BSR: {
                    AST tmp35_AST = null;
                    tmp35_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp35_AST);
                    match(BSR);
                    if (inputState.guessing == 0) {
                        ltCounter -= 3;
                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            typeArgumentsEnd_AST = (AST) currentAST.root;
            typeArgumentsEnd_AST.setType(TYPE_ARGS_END);
        }
        typeArgumentsEnd_AST = (AST) currentAST.root;
        returnAST = typeArgumentsEnd_AST;
    }

    public final void builtInType() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST builtInType_AST = null;

        switch (LA(1)) {
            case LITERAL_void: {
                AST tmp36_AST = null;
                tmp36_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp36_AST);
                match(LITERAL_void);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_boolean: {
                AST tmp37_AST = null;
                tmp37_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp37_AST);
                match(LITERAL_boolean);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_byte: {
                AST tmp38_AST = null;
                tmp38_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp38_AST);
                match(LITERAL_byte);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_char: {
                AST tmp39_AST = null;
                tmp39_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp39_AST);
                match(LITERAL_char);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_short: {
                AST tmp40_AST = null;
                tmp40_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp40_AST);
                match(LITERAL_short);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_int: {
                AST tmp41_AST = null;
                tmp41_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp41_AST);
                match(LITERAL_int);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_float: {
                AST tmp42_AST = null;
                tmp42_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp42_AST);
                match(LITERAL_float);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_long: {
                AST tmp43_AST = null;
                tmp43_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp43_AST);
                match(LITERAL_long);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_double: {
                AST tmp44_AST = null;
                tmp44_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp44_AST);
                match(LITERAL_double);
                builtInType_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = builtInType_AST;
    }

    public final void type() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST type_AST = null;

        switch (LA(1)) {
            case IDENT: {
                classOrInterfaceType(false);
                astFactory.addASTChild(currentAST, returnAST);
                type_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double: {
                builtInType();
                astFactory.addASTChild(currentAST, returnAST);
                type_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = type_AST;
    }

    public final void modifier() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST modifier_AST = null;

        switch (LA(1)) {
            case LITERAL_private: {
                AST tmp45_AST = null;
                tmp45_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp45_AST);
                match(LITERAL_private);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_public: {
                AST tmp46_AST = null;
                tmp46_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp46_AST);
                match(LITERAL_public);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_protected: {
                AST tmp47_AST = null;
                tmp47_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp47_AST);
                match(LITERAL_protected);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_static: {
                AST tmp48_AST = null;
                tmp48_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp48_AST);
                match(LITERAL_static);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_transient: {
                AST tmp49_AST = null;
                tmp49_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp49_AST);
                match(LITERAL_transient);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case FINAL: {
                AST tmp50_AST = null;
                tmp50_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp50_AST);
                match(FINAL);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case ABSTRACT: {
                AST tmp51_AST = null;
                tmp51_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp51_AST);
                match(ABSTRACT);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_native: {
                AST tmp52_AST = null;
                tmp52_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp52_AST);
                match(LITERAL_native);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_threadsafe: {
                AST tmp53_AST = null;
                tmp53_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp53_AST);
                match(LITERAL_threadsafe);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_synchronized: {
                AST tmp54_AST = null;
                tmp54_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp54_AST);
                match(LITERAL_synchronized);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_volatile: {
                AST tmp55_AST = null;
                tmp55_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp55_AST);
                match(LITERAL_volatile);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            case STRICTFP: {
                AST tmp56_AST = null;
                tmp56_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp56_AST);
                match(STRICTFP);
                modifier_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = modifier_AST;
    }

    public final void annotation() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotation_AST = null;

        AST tmp57_AST = null;
        tmp57_AST = astFactory.create(LT(1));
        astFactory.makeASTRoot(currentAST, tmp57_AST);
        match(AT);
        identifier();
        astFactory.addASTChild(currentAST, returnAST);
        annotationInit();
        astFactory.addASTChild(currentAST, returnAST);
        if (inputState.guessing == 0) {
            tmp57_AST.setType(ANNOTATION);
        }
        annotation_AST = (AST) currentAST.root;
        returnAST = annotation_AST;
    }

    public final void implementsClause() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST implementsClause_AST = null;
        Token i = null;
        AST i_AST = null;

        {
            switch (LA(1)) {
                case LITERAL_implements: {
                    i = LT(1);
                    i_AST = astFactory.create(i);
                    match(LITERAL_implements);
                    classOrInterfaceType(false);
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop115:
                        do {
                            if ((LA(1) == COMMA)) {
                                match(COMMA);
                                classOrInterfaceType(false);
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop115;
                            }

                        } while (true);
                    }
                    break;
                }
                case LCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            implementsClause_AST = (AST) currentAST.root;
            implementsClause_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(IMPLEMENTS_CLAUSE, "IMPLEMENTS_CLAUSE")).add(implementsClause_AST));
            currentAST.root = implementsClause_AST;
            currentAST.child = implementsClause_AST != null && implementsClause_AST.getFirstChild() != null ?
                    implementsClause_AST.getFirstChild() : implementsClause_AST;
            currentAST.advanceChildToEnd();
        }
        implementsClause_AST = (AST) currentAST.root;
        returnAST = implementsClause_AST;
    }

    public final void enumBlock() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST enumBlock_AST = null;

        match(LCURLY);
        {
            switch (LA(1)) {
                case IDENT:
                case AT: {
                    enumConst();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop56:
                        do {
                            if ((LA(1) == COMMA) && (LA(2) == IDENT || LA(2) == AT)) {
                                match(COMMA);
                                enumConst();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop56;
                            }

                        } while (true);
                    }
                    break;
                }
                case SEMI:
                case COMMA:
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        {
            switch (LA(1)) {
                case COMMA: {
                    match(COMMA);
                    break;
                }
                case SEMI:
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        {
            switch (LA(1)) {
                case SEMI: {
                    match(SEMI);
                    {
                        _loop60:
                        do {
                            switch (LA(1)) {
                                case FINAL:
                                case ABSTRACT:
                                case STRICTFP:
                                case ENUM:
                                case LITERAL_static:
                                case IDENT:
                                case LT:
                                case LITERAL_void:
                                case LITERAL_boolean:
                                case LITERAL_byte:
                                case LITERAL_char:
                                case LITERAL_short:
                                case LITERAL_int:
                                case LITERAL_float:
                                case LITERAL_long:
                                case LITERAL_double:
                                case LITERAL_private:
                                case LITERAL_public:
                                case LITERAL_protected:
                                case LITERAL_transient:
                                case LITERAL_native:
                                case LITERAL_threadsafe:
                                case LITERAL_synchronized:
                                case LITERAL_volatile:
                                case LCURLY:
                                case AT:
                                case LITERAL_interface:
                                case LITERAL_class: {
                                    classField();
                                    astFactory.addASTChild(currentAST, returnAST);
                                    break;
                                }
                                case SEMI: {
                                    match(SEMI);
                                    break;
                                }
                                default: {
                                    break _loop60;
                                }
                            }
                        } while (true);
                    }
                    break;
                }
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        match(RCURLY);
        if (inputState.guessing == 0) {
            enumBlock_AST = (AST) currentAST.root;
            enumBlock_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(OBJBLOCK, "OBJBLOCK")).add(enumBlock_AST));
            currentAST.root = enumBlock_AST;
            currentAST.child = enumBlock_AST != null && enumBlock_AST.getFirstChild() != null ?
                    enumBlock_AST.getFirstChild() : enumBlock_AST;
            currentAST.advanceChildToEnd();
        }
        enumBlock_AST = (AST) currentAST.root;
        returnAST = enumBlock_AST;
    }

    public final void enumConst() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST enumConst_AST = null;

        annotations();
        astFactory.addASTChild(currentAST, returnAST);
        AST tmp65_AST = null;
        tmp65_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp65_AST);
        match(IDENT);
        enumConstInit();
        astFactory.addASTChild(currentAST, returnAST);
        {
            switch (LA(1)) {
                case LCURLY: {
                    classBlock();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case SEMI:
                case COMMA:
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            enumConst_AST = (AST) currentAST.root;
            enumConst_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ENUM_CONST, "ENUM_CONST")).add(enumConst_AST));
            currentAST.root = enumConst_AST;
            currentAST.child = enumConst_AST != null && enumConst_AST.getFirstChild() != null ?
                    enumConst_AST.getFirstChild() : enumConst_AST;
            currentAST.advanceChildToEnd();
        }
        enumConst_AST = (AST) currentAST.root;
        returnAST = enumConst_AST;
    }

    public final void classField() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST classField_AST = null;
        AST mods_AST = null;
        AST it_AST = null;
        AST tp_AST = null;
        AST h_AST = null;
        AST s_AST = null;
        AST md_AST = null;
        AST s3_AST = null;
        AST s4_AST = null;

        if ((_tokenSet_9.member(LA(1))) && (_tokenSet_10.member(LA(2)))) {
            modifiers();
            mods_AST = (AST) returnAST;
            {
                switch (LA(1)) {
                    case ENUM:
                    case AT:
                    case LITERAL_interface:
                    case LITERAL_class: {
                        innerTypeDef(mods_AST);
                        it_AST = (AST) returnAST;
                        if (inputState.guessing == 0) {
                            classField_AST = (AST) currentAST.root;
                            classField_AST = it_AST;
                            currentAST.root = classField_AST;
                            currentAST.child = classField_AST != null && classField_AST.getFirstChild() != null ?
                                    classField_AST.getFirstChild() : classField_AST;
                            currentAST.advanceChildToEnd();
                        }
                        break;
                    }
                    case IDENT:
                    case LT:
                    case LITERAL_void:
                    case LITERAL_boolean:
                    case LITERAL_byte:
                    case LITERAL_char:
                    case LITERAL_short:
                    case LITERAL_int:
                    case LITERAL_float:
                    case LITERAL_long:
                    case LITERAL_double: {
                        typeParameters();
                        tp_AST = (AST) returnAST;
                        {
                            if ((LA(1) == IDENT) && (LA(2) == LPAREN)) {
                                ctorHead();
                                h_AST = (AST) returnAST;
                                constructorBody();
                                s_AST = (AST) returnAST;
                                if (inputState.guessing == 0) {
                                    classField_AST = (AST) currentAST.root;
                                    classField_AST = (AST) astFactory.make((new ASTArray(5)).add(astFactory.create(CTOR_DEF, "CTOR_DEF")).add(mods_AST).add(tp_AST).add(h_AST).add(s_AST));
                                    currentAST.root = classField_AST;
                                    currentAST.child = classField_AST != null && classField_AST.getFirstChild() != null ?
                                            classField_AST.getFirstChild() : classField_AST;
                                    currentAST.advanceChildToEnd();
                                }
                            } else if ((_tokenSet_8.member(LA(1))) && (_tokenSet_11.member(LA(2)))) {
                                memberDef(mods_AST, tp_AST, true);
                                md_AST = (AST) returnAST;
                                if (inputState.guessing == 0) {
                                    classField_AST = (AST) currentAST.root;
                                    classField_AST = md_AST;
                                    currentAST.root = classField_AST;
                                    currentAST.child = classField_AST != null && classField_AST.getFirstChild() != null ?
                                            classField_AST.getFirstChild() : classField_AST;
                                    currentAST.advanceChildToEnd();
                                }
                            } else {
                                throw new NoViableAltException(LT(1), getFilename());
                            }

                        }
                        break;
                    }
                    default: {
                        throw new NoViableAltException(LT(1), getFilename());
                    }
                }
            }
        } else if ((LA(1) == LITERAL_static) && (LA(2) == LCURLY)) {
            match(LITERAL_static);
            compoundStatement();
            s3_AST = (AST) returnAST;
            if (inputState.guessing == 0) {
                classField_AST = (AST) currentAST.root;
                classField_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(STATIC_INIT, "STATIC_INIT")).add(s3_AST));
                currentAST.root = classField_AST;
                currentAST.child = classField_AST != null && classField_AST.getFirstChild() != null ?
                        classField_AST.getFirstChild() : classField_AST;
                currentAST.advanceChildToEnd();
            }
        } else if ((LA(1) == LCURLY)) {
            compoundStatement();
            s4_AST = (AST) returnAST;
            if (inputState.guessing == 0) {
                classField_AST = (AST) currentAST.root;
                classField_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(INSTANCE_INIT, "INSTANCE_INIT")).add(s4_AST));
                currentAST.root = classField_AST;
                currentAST.child = classField_AST != null && classField_AST.getFirstChild() != null ?
                        classField_AST.getFirstChild() : classField_AST;
                currentAST.advanceChildToEnd();
            }
        } else {
            throw new NoViableAltException(LT(1), getFilename());
        }

        returnAST = classField_AST;
    }

    public final void enumConstInit() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST enumConstInit_AST = null;
        Token lp = null;
        AST lp_AST = null;

        switch (LA(1)) {
            case LPAREN: {
                lp = LT(1);
                lp_AST = astFactory.create(lp);
                astFactory.makeASTRoot(currentAST, lp_AST);
                match(LPAREN);
                argList();
                astFactory.addASTChild(currentAST, returnAST);
                match(RPAREN);
                if (inputState.guessing == 0) {
                    lp_AST.setType(ENUM_CONST_INIT);
                }
                enumConstInit_AST = (AST) currentAST.root;
                break;
            }
            case SEMI:
            case COMMA:
            case LCURLY:
            case RCURLY: {
                if (inputState.guessing == 0) {
                    enumConstInit_AST = (AST) currentAST.root;
                    enumConstInit_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ENUM_CONST_INIT, "")).add(enumConstInit_AST));
                    currentAST.root = enumConstInit_AST;
                    currentAST.child = enumConstInit_AST != null && enumConstInit_AST.getFirstChild() != null ?
                            enumConstInit_AST.getFirstChild() : enumConstInit_AST;
                    currentAST.advanceChildToEnd();
                }
                enumConstInit_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = enumConstInit_AST;
    }

    public final void classBlock() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST classBlock_AST = null;

        match(LCURLY);
        {
            _loop107:
            do {
                switch (LA(1)) {
                    case FINAL:
                    case ABSTRACT:
                    case STRICTFP:
                    case ENUM:
                    case LITERAL_static:
                    case IDENT:
                    case LT:
                    case LITERAL_void:
                    case LITERAL_boolean:
                    case LITERAL_byte:
                    case LITERAL_char:
                    case LITERAL_short:
                    case LITERAL_int:
                    case LITERAL_float:
                    case LITERAL_long:
                    case LITERAL_double:
                    case LITERAL_private:
                    case LITERAL_public:
                    case LITERAL_protected:
                    case LITERAL_transient:
                    case LITERAL_native:
                    case LITERAL_threadsafe:
                    case LITERAL_synchronized:
                    case LITERAL_volatile:
                    case LCURLY:
                    case AT:
                    case LITERAL_interface:
                    case LITERAL_class: {
                        classField();
                        astFactory.addASTChild(currentAST, returnAST);
                        break;
                    }
                    case SEMI: {
                        match(SEMI);
                        break;
                    }
                    default: {
                        break _loop107;
                    }
                }
            } while (true);
        }
        match(RCURLY);
        if (inputState.guessing == 0) {
            classBlock_AST = (AST) currentAST.root;
            classBlock_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(OBJBLOCK, "OBJBLOCK")).add(classBlock_AST));
            currentAST.root = classBlock_AST;
            currentAST.child = classBlock_AST != null && classBlock_AST.getFirstChild() != null ?
                    classBlock_AST.getFirstChild() : classBlock_AST;
            currentAST.advanceChildToEnd();
        }
        classBlock_AST = (AST) currentAST.root;
        returnAST = classBlock_AST;
    }

    public final void argList() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST argList_AST = null;

        {
            switch (LA(1)) {
                case IDENT:
                case LT:
                case LITERAL_super:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case LPAREN:
                case LITERAL_this:
                case PLUS:
                case MINUS:
                case INC:
                case DEC:
                case BNOT:
                case LNOT:
                case LITERAL_true:
                case LITERAL_false:
                case LITERAL_null:
                case LITERAL_new:
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    expressionList();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case RPAREN: {
                    if (inputState.guessing == 0) {
                        argList_AST = (AST) currentAST.root;
                        argList_AST = astFactory.create(ELIST, "ELIST");
                        currentAST.root = argList_AST;
                        currentAST.child = argList_AST != null && argList_AST.getFirstChild() != null ?
                                argList_AST.getFirstChild() : argList_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        argList_AST = (AST) currentAST.root;
        returnAST = argList_AST;
    }

    public final void annotationBlock() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationBlock_AST = null;

        match(LCURLY);
        {
            _loop67:
            do {
                switch (LA(1)) {
                    case FINAL:
                    case ABSTRACT:
                    case STRICTFP:
                    case ENUM:
                    case LITERAL_static:
                    case IDENT:
                    case LITERAL_void:
                    case LITERAL_boolean:
                    case LITERAL_byte:
                    case LITERAL_char:
                    case LITERAL_short:
                    case LITERAL_int:
                    case LITERAL_float:
                    case LITERAL_long:
                    case LITERAL_double:
                    case LITERAL_private:
                    case LITERAL_public:
                    case LITERAL_protected:
                    case LITERAL_transient:
                    case LITERAL_native:
                    case LITERAL_threadsafe:
                    case LITERAL_synchronized:
                    case LITERAL_volatile:
                    case AT:
                    case LITERAL_interface:
                    case LITERAL_class: {
                        annotationField();
                        astFactory.addASTChild(currentAST, returnAST);
                        break;
                    }
                    case SEMI: {
                        match(SEMI);
                        break;
                    }
                    default: {
                        break _loop67;
                    }
                }
            } while (true);
        }
        match(RCURLY);
        if (inputState.guessing == 0) {
            annotationBlock_AST = (AST) currentAST.root;
            annotationBlock_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(OBJBLOCK, "OBJBLOCK")).add(annotationBlock_AST));
            currentAST.root = annotationBlock_AST;
            currentAST.child = annotationBlock_AST != null && annotationBlock_AST.getFirstChild() != null ?
                    annotationBlock_AST.getFirstChild() : annotationBlock_AST;
            currentAST.advanceChildToEnd();
        }
        annotationBlock_AST = (AST) currentAST.root;
        returnAST = annotationBlock_AST;
    }

    public final void annotationField() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationField_AST = null;
        AST mods_AST = null;
        AST it_AST = null;
        AST ts_AST = null;
        Token i = null;
        AST i_AST = null;
        AST dv_AST = null;
        AST v_AST = null;

        modifiers();
        mods_AST = (AST) returnAST;
        {
            switch (LA(1)) {
                case ENUM:
                case AT:
                case LITERAL_interface:
                case LITERAL_class: {
                    innerTypeDef(mods_AST);
                    it_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        annotationField_AST = (AST) currentAST.root;
                        annotationField_AST = it_AST;
                        currentAST.root = annotationField_AST;
                        currentAST.child = annotationField_AST != null && annotationField_AST.getFirstChild() != null ?
                                annotationField_AST.getFirstChild() : annotationField_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                case IDENT:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double: {
                    typeSpec(false);
                    ts_AST = (AST) returnAST;
                    {
                        if ((LA(1) == IDENT) && (LA(2) == LPAREN)) {
                            i = LT(1);
                            i_AST = astFactory.create(i);
                            match(IDENT);
                            AST tmp74_AST = null;
                            tmp74_AST = astFactory.create(LT(1));
                            match(LPAREN);
                            AST tmp75_AST = null;
                            tmp75_AST = astFactory.create(LT(1));
                            match(RPAREN);
                            defaultValue();
                            dv_AST = (AST) returnAST;
                            AST tmp76_AST = null;
                            tmp76_AST = astFactory.create(LT(1));
                            match(SEMI);
                            if (inputState.guessing == 0) {
                                annotationField_AST = (AST) currentAST.root;
                                annotationField_AST =
                                        (AST) astFactory.make((new ASTArray(5)).add(astFactory.create(ANNOTATION_MEMBER_DEF, "ANNOTATION_MEMBER_DEF")).add(mods_AST).add((AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(ts_AST))).add(i_AST).add(dv_AST));
                                currentAST.root = annotationField_AST;
                                currentAST.child = annotationField_AST != null && annotationField_AST.getFirstChild() != null ?
                                        annotationField_AST.getFirstChild() : annotationField_AST;
                                currentAST.advanceChildToEnd();
                            }
                        } else if ((LA(1) == IDENT) && (_tokenSet_12.member(LA(2)))) {
                            variableDefinitions(mods_AST, ts_AST);
                            v_AST = (AST) returnAST;
                            AST tmp77_AST = null;
                            tmp77_AST = astFactory.create(LT(1));
                            match(SEMI);
                            if (inputState.guessing == 0) {
                                annotationField_AST = (AST) currentAST.root;
                                annotationField_AST = v_AST;
                                currentAST.root = annotationField_AST;
                                currentAST.child = annotationField_AST != null && annotationField_AST.getFirstChild() != null ?
                                        annotationField_AST.getFirstChild() : annotationField_AST;
                                currentAST.advanceChildToEnd();
                            }
                        } else {
                            throw new NoViableAltException(LT(1), getFilename());
                        }

                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        returnAST = annotationField_AST;
    }

    protected final void innerTypeDef(
            AST modifiers
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST innerTypeDef_AST = null;
        AST ed_AST = null;
        AST cd_AST = null;
        AST id_AST = null;
        AST ad_AST = null;

        {
            switch (LA(1)) {
                case ENUM: {
                    enumDefinition(modifiers);
                    ed_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        innerTypeDef_AST = (AST) currentAST.root;
                        innerTypeDef_AST = ed_AST;
                        currentAST.root = innerTypeDef_AST;
                        currentAST.child = innerTypeDef_AST != null && innerTypeDef_AST.getFirstChild() != null ?
                                innerTypeDef_AST.getFirstChild() : innerTypeDef_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                case LITERAL_class: {
                    classDefinition(modifiers);
                    cd_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        innerTypeDef_AST = (AST) currentAST.root;
                        innerTypeDef_AST = cd_AST;
                        currentAST.root = innerTypeDef_AST;
                        currentAST.child = innerTypeDef_AST != null && innerTypeDef_AST.getFirstChild() != null ?
                                innerTypeDef_AST.getFirstChild() : innerTypeDef_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                case LITERAL_interface: {
                    interfaceDefinition(modifiers);
                    id_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        innerTypeDef_AST = (AST) currentAST.root;
                        innerTypeDef_AST = id_AST;
                        currentAST.root = innerTypeDef_AST;
                        currentAST.child = innerTypeDef_AST != null && innerTypeDef_AST.getFirstChild() != null ?
                                innerTypeDef_AST.getFirstChild() : innerTypeDef_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                case AT: {
                    annotationTypeDefinition(modifiers);
                    ad_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        innerTypeDef_AST = (AST) currentAST.root;
                        innerTypeDef_AST = ad_AST;
                        currentAST.root = innerTypeDef_AST;
                        currentAST.child = innerTypeDef_AST != null && innerTypeDef_AST.getFirstChild() != null ?
                                innerTypeDef_AST.getFirstChild() : innerTypeDef_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        returnAST = innerTypeDef_AST;
    }

    public final void defaultValue() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST defaultValue_AST = null;

        {
            switch (LA(1)) {
                case LITERAL_default: {
                    AST tmp78_AST = null;
                    tmp78_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp78_AST);
                    match(LITERAL_default);
                    annotationMemberValue();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case SEMI: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        defaultValue_AST = (AST) currentAST.root;
        returnAST = defaultValue_AST;
    }

    public final void annotationMemberValue() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationMemberValue_AST = null;

        switch (LA(1)) {
            case AT: {
                annotation();
                astFactory.addASTChild(currentAST, returnAST);
                annotationMemberValue_AST = (AST) currentAST.root;
                break;
            }
            case IDENT:
            case LT:
            case LITERAL_super:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double:
            case LPAREN:
            case LITERAL_this:
            case PLUS:
            case MINUS:
            case INC:
            case DEC:
            case BNOT:
            case LNOT:
            case LITERAL_true:
            case LITERAL_false:
            case LITERAL_null:
            case LITERAL_new:
            case NUM_INT:
            case CHAR_LITERAL:
            case STRING_LITERAL:
            case NUM_FLOAT:
            case NUM_LONG:
            case NUM_DOUBLE: {
                conditionalExpression();
                astFactory.addASTChild(currentAST, returnAST);
                if (inputState.guessing == 0) {
                    annotationMemberValue_AST = (AST) currentAST.root;
                    annotationMemberValue_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(EXPR, "EXPR")).add(annotationMemberValue_AST));
                    currentAST.root = annotationMemberValue_AST;
                    currentAST.child = annotationMemberValue_AST != null && annotationMemberValue_AST.getFirstChild() != null ?
                            annotationMemberValue_AST.getFirstChild() : annotationMemberValue_AST;
                    currentAST.advanceChildToEnd();
                }
                annotationMemberValue_AST = (AST) currentAST.root;
                break;
            }
            case LCURLY: {
                annotationMemberArrayInitializer();
                astFactory.addASTChild(currentAST, returnAST);
                annotationMemberValue_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = annotationMemberValue_AST;
    }

    public final void annotationInit() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationInit_AST = null;
        Token lp = null;
        AST lp_AST = null;

        switch (LA(1)) {
            case LPAREN: {
                {
                    lp = LT(1);
                    lp_AST = astFactory.create(lp);
                    astFactory.makeASTRoot(currentAST, lp_AST);
                    match(LPAREN);
                    {
                        if ((LA(1) == IDENT) && (LA(2) == ASSIGN)) {
                            annotationMemberInit();
                            astFactory.addASTChild(currentAST, returnAST);
                            {
                                _loop81:
                                do {
                                    if ((LA(1) == COMMA)) {
                                        match(COMMA);
                                        annotationMemberInit();
                                        astFactory.addASTChild(currentAST, returnAST);
                                    } else {
                                        break _loop81;
                                    }

                                } while (true);
                            }
                            if (inputState.guessing == 0) {
                                lp_AST.setType(ANNOTATION_INIT_LIST);
                            }
                        } else if ((_tokenSet_13.member(LA(1))) && (_tokenSet_14.member(LA(2)))) {
                            annotationMemberValue();
                            astFactory.addASTChild(currentAST, returnAST);
                            if (inputState.guessing == 0) {
                                lp_AST.setType(ANNOTATION_INIT_VALUE);
                            }
                        } else if ((LA(1) == RPAREN)) {
                            if (inputState.guessing == 0) {
                                lp_AST.setType(ANNOTATION_INIT_EMPTY);
                            }
                        } else {
                            throw new NoViableAltException(LT(1), getFilename());
                        }

                    }
                    match(RPAREN);
                }
                annotationInit_AST = (AST) currentAST.root;
                break;
            }
            case FINAL:
            case ABSTRACT:
            case STRICTFP:
            case ENUM:
            case LITERAL_package:
            case SEMI:
            case LITERAL_static:
            case IDENT:
            case LT:
            case COMMA:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double:
            case LITERAL_private:
            case LITERAL_public:
            case LITERAL_protected:
            case LITERAL_transient:
            case LITERAL_native:
            case LITERAL_threadsafe:
            case LITERAL_synchronized:
            case LITERAL_volatile:
            case RCURLY:
            case RPAREN:
            case AT:
            case LITERAL_interface:
            case LITERAL_class: {
                if (inputState.guessing == 0) {
                    annotationInit_AST = (AST) currentAST.root;
                    annotationInit_AST = (AST) astFactory.make((new ASTArray(1)).add(astFactory.create(ANNOTATION_INIT_EMPTY, "AN_INIT_EMPTY")));
                    currentAST.root = annotationInit_AST;
                    currentAST.child = annotationInit_AST != null && annotationInit_AST.getFirstChild() != null ?
                            annotationInit_AST.getFirstChild() : annotationInit_AST;
                    currentAST.advanceChildToEnd();
                }
                annotationInit_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = annotationInit_AST;
    }

    public final void annotationMemberInit() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationMemberInit_AST = null;

        AST tmp81_AST = null;
        tmp81_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp81_AST);
        match(IDENT);
        match(ASSIGN);
        annotationMemberValue();
        astFactory.addASTChild(currentAST, returnAST);
        if (inputState.guessing == 0) {
            annotationMemberInit_AST = (AST) currentAST.root;
            annotationMemberInit_AST =
                    (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ANNOTATION_INIT_MEMBER, "AN_INIT_MEMBER")).add(annotationMemberInit_AST));
            currentAST.root = annotationMemberInit_AST;
            currentAST.child = annotationMemberInit_AST != null && annotationMemberInit_AST.getFirstChild() != null ?
                    annotationMemberInit_AST.getFirstChild() : annotationMemberInit_AST;
            currentAST.advanceChildToEnd();
        }
        annotationMemberInit_AST = (AST) currentAST.root;
        returnAST = annotationMemberInit_AST;
    }

    public final void conditionalExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST conditionalExpression_AST = null;

        logicalOrExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            switch (LA(1)) {
                case QUESTION: {
                    AST tmp83_AST = null;
                    tmp83_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp83_AST);
                    match(QUESTION);
                    assignmentExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(COLON);
                    conditionalExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case SEMI:
                case RBRACK:
                case COMMA:
                case RCURLY:
                case RPAREN:
                case ASSIGN:
                case COLON:
                case PLUS_ASSIGN:
                case MINUS_ASSIGN:
                case STAR_ASSIGN:
                case DIV_ASSIGN:
                case MOD_ASSIGN:
                case SR_ASSIGN:
                case BSR_ASSIGN:
                case SL_ASSIGN:
                case BAND_ASSIGN:
                case BXOR_ASSIGN:
                case BOR_ASSIGN: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        conditionalExpression_AST = (AST) currentAST.root;
        returnAST = conditionalExpression_AST;
    }

    public final void annotationMemberArrayInitializer() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST annotationMemberArrayInitializer_AST = null;
        Token lc = null;
        AST lc_AST = null;

        lc = LT(1);
        lc_AST = astFactory.create(lc);
        astFactory.makeASTRoot(currentAST, lc_AST);
        match(LCURLY);
        if (inputState.guessing == 0) {
            lc_AST.setType(ANNOTATION_ARRAY_INIT);
        }
        {
            switch (LA(1)) {
                case IDENT:
                case LT:
                case LITERAL_super:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case LCURLY:
                case LPAREN:
                case AT:
                case LITERAL_this:
                case PLUS:
                case MINUS:
                case INC:
                case DEC:
                case BNOT:
                case LNOT:
                case LITERAL_true:
                case LITERAL_false:
                case LITERAL_null:
                case LITERAL_new:
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    annotationMemberValue();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop87:
                        do {
                            if ((LA(1) == COMMA) && (_tokenSet_13.member(LA(2)))) {
                                match(COMMA);
                                annotationMemberValue();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop87;
                            }

                        } while (true);
                    }
                    break;
                }
                case COMMA:
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        {
            switch (LA(1)) {
                case COMMA: {
                    match(COMMA);
                    break;
                }
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        match(RCURLY);
        annotationMemberArrayInitializer_AST = (AST) currentAST.root;
        returnAST = annotationMemberArrayInitializer_AST;
    }

    public final void typeParameters() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeParameters_AST = null;
        Token lt = null;
        AST lt_AST = null;
        int currentLtLevel = 0;

        switch (LA(1)) {
            case LT: {
                if (inputState.guessing == 0) {
                    currentLtLevel = ltCounter;
                }
                {
                    lt = LT(1);
                    lt_AST = astFactory.create(lt);
                    astFactory.makeASTRoot(currentAST, lt_AST);
                    match(LT);
                    if (inputState.guessing == 0) {
                        ltCounter++;
                        lt_AST.setType(TYPE_PARAMS);
                    }
                    typeParameter();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop96:
                        do {
                            if ((LA(1) == COMMA)) {
                                match(COMMA);
                                typeParameter();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop96;
                            }

                        } while (true);
                    }
                    {
                        switch (LA(1)) {
                            case GT:
                            case SR:
                            case BSR: {
                                typeArgumentsEnd();
                                break;
                            }
                            case IDENT:
                            case LITERAL_extends:
                            case LITERAL_void:
                            case LITERAL_boolean:
                            case LITERAL_byte:
                            case LITERAL_char:
                            case LITERAL_short:
                            case LITERAL_int:
                            case LITERAL_float:
                            case LITERAL_long:
                            case LITERAL_double:
                            case LCURLY:
                            case LITERAL_implements: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                }
                if (!((currentLtLevel != 0) || ltCounter == currentLtLevel))
                    throw new SemanticException("(currentLtLevel != 0) || ltCounter == currentLtLevel");
                typeParameters_AST = (AST) currentAST.root;
                break;
            }
            case IDENT:
            case LITERAL_extends:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double:
            case LCURLY:
            case LITERAL_implements: {
                if (inputState.guessing == 0) {
                    typeParameters_AST = (AST) currentAST.root;
                    typeParameters_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE_PARAMS, "TYPE_PARAMS")).add(typeParameters_AST));
                    currentAST.root = typeParameters_AST;
                    currentAST.child = typeParameters_AST != null && typeParameters_AST.getFirstChild() != null ?
                            typeParameters_AST.getFirstChild() : typeParameters_AST;
                    currentAST.advanceChildToEnd();
                }
                typeParameters_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = typeParameters_AST;
    }

    public final void superClassClause() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST superClassClause_AST = null;

        {
            switch (LA(1)) {
                case LITERAL_extends: {
                    match(LITERAL_extends);
                    classOrInterfaceType(false);
                    break;
                }
                case LCURLY:
                case LITERAL_implements: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            superClassClause_AST = (AST) currentAST.root;
            superClassClause_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(EXTENDS_CLAUSE, "EXTENDS_CLAUSE")).add(superClassClause_AST));
            currentAST.root = superClassClause_AST;
            currentAST.child = superClassClause_AST != null && superClassClause_AST.getFirstChild() != null ?
                    superClassClause_AST.getFirstChild() : superClassClause_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = superClassClause_AST;
    }

    public final void interfaceExtends() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST interfaceExtends_AST = null;
        Token e = null;
        AST e_AST = null;

        {
            switch (LA(1)) {
                case LITERAL_extends: {
                    e = LT(1);
                    e_AST = astFactory.create(e);
                    match(LITERAL_extends);
                    classOrInterfaceType(false);
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop111:
                        do {
                            if ((LA(1) == COMMA)) {
                                match(COMMA);
                                classOrInterfaceType(false);
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop111;
                            }

                        } while (true);
                    }
                    break;
                }
                case LCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            interfaceExtends_AST = (AST) currentAST.root;
            interfaceExtends_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(EXTENDS_CLAUSE, "EXTENDS_CLAUSE")).add(interfaceExtends_AST));
            currentAST.root = interfaceExtends_AST;
            currentAST.child = interfaceExtends_AST != null && interfaceExtends_AST.getFirstChild() != null ?
                    interfaceExtends_AST.getFirstChild() : interfaceExtends_AST;
            currentAST.advanceChildToEnd();
        }
        interfaceExtends_AST = (AST) currentAST.root;
        returnAST = interfaceExtends_AST;
    }

    public final void interfaceBlock() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST interfaceBlock_AST = null;

        match(LCURLY);
        {
            _loop104:
            do {
                switch (LA(1)) {
                    case FINAL:
                    case ABSTRACT:
                    case STRICTFP:
                    case ENUM:
                    case LITERAL_static:
                    case IDENT:
                    case LT:
                    case LITERAL_void:
                    case LITERAL_boolean:
                    case LITERAL_byte:
                    case LITERAL_char:
                    case LITERAL_short:
                    case LITERAL_int:
                    case LITERAL_float:
                    case LITERAL_long:
                    case LITERAL_double:
                    case LITERAL_private:
                    case LITERAL_public:
                    case LITERAL_protected:
                    case LITERAL_transient:
                    case LITERAL_native:
                    case LITERAL_threadsafe:
                    case LITERAL_synchronized:
                    case LITERAL_volatile:
                    case AT:
                    case LITERAL_interface:
                    case LITERAL_class: {
                        interfaceField();
                        astFactory.addASTChild(currentAST, returnAST);
                        break;
                    }
                    case SEMI: {
                        match(SEMI);
                        break;
                    }
                    default: {
                        break _loop104;
                    }
                }
            } while (true);
        }
        match(RCURLY);
        if (inputState.guessing == 0) {
            interfaceBlock_AST = (AST) currentAST.root;
            interfaceBlock_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(OBJBLOCK, "OBJBLOCK")).add(interfaceBlock_AST));
            currentAST.root = interfaceBlock_AST;
            currentAST.child = interfaceBlock_AST != null && interfaceBlock_AST.getFirstChild() != null ?
                    interfaceBlock_AST.getFirstChild() : interfaceBlock_AST;
            currentAST.advanceChildToEnd();
        }
        interfaceBlock_AST = (AST) currentAST.root;
        returnAST = interfaceBlock_AST;
    }

    public final void typeParameter() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST typeParameter_AST = null;

        AST tmp94_AST = null;
        tmp94_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp94_AST);
        match(IDENT);
        {
            if ((LA(1) == LITERAL_extends) && (LA(2) == IDENT)) {
                AST tmp95_AST = null;
                tmp95_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp95_AST);
                match(LITERAL_extends);
                classOrInterfaceType(true);
                astFactory.addASTChild(currentAST, returnAST);
                {
                    _loop101:
                    do {
                        if ((LA(1) == BAND)) {
                            match(BAND);
                            classOrInterfaceType(true);
                            astFactory.addASTChild(currentAST, returnAST);
                        } else {
                            break _loop101;
                        }

                    } while (true);
                }
            } else if ((_tokenSet_15.member(LA(1))) && (_tokenSet_16.member(LA(2)))) {
            } else {
                throw new NoViableAltException(LT(1), getFilename());
            }

        }
        typeParameter_AST = (AST) currentAST.root;
        returnAST = typeParameter_AST;
    }

    public final void interfaceField() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST interfaceField_AST = null;
        AST mods_AST = null;
        AST it_AST = null;
        AST tp_AST = null;
        AST md_AST = null;

        modifiers();
        mods_AST = (AST) returnAST;
        {
            switch (LA(1)) {
                case ENUM:
                case AT:
                case LITERAL_interface:
                case LITERAL_class: {
                    innerTypeDef(mods_AST);
                    it_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        interfaceField_AST = (AST) currentAST.root;
                        interfaceField_AST = it_AST;
                        currentAST.root = interfaceField_AST;
                        currentAST.child = interfaceField_AST != null && interfaceField_AST.getFirstChild() != null ?
                                interfaceField_AST.getFirstChild() : interfaceField_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                case IDENT:
                case LT:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double: {
                    typeParameters();
                    tp_AST = (AST) returnAST;
                    memberDef(mods_AST, tp_AST, false);
                    md_AST = (AST) returnAST;
                    if (inputState.guessing == 0) {
                        interfaceField_AST = (AST) currentAST.root;
                        interfaceField_AST = md_AST;
                        currentAST.root = interfaceField_AST;
                        currentAST.child = interfaceField_AST != null && interfaceField_AST.getFirstChild() != null ?
                                interfaceField_AST.getFirstChild() : interfaceField_AST;
                        currentAST.advanceChildToEnd();
                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        returnAST = interfaceField_AST;
    }

    protected final void memberDef(
            AST modifiers, AST typeParams, boolean allowMethodBody
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST memberDef_AST = null;
        AST t_AST = null;
        AST param_AST = null;
        AST rt_AST = null;
        AST tc_AST = null;
        AST s2_AST = null;
        AST v_AST = null;

        typeSpec(false);
        t_AST = (AST) returnAST;
        {
            if ((LA(1) == IDENT) && (LA(2) == LPAREN)) {
                AST tmp97_AST = null;
                tmp97_AST = astFactory.create(LT(1));
                match(IDENT);
                match(LPAREN);
                parameterDeclarationList();
                param_AST = (AST) returnAST;
                match(RPAREN);
                declaratorBrackets(t_AST);
                rt_AST = (AST) returnAST;
                {
                    switch (LA(1)) {
                        case LITERAL_throws: {
                            throwsClause();
                            tc_AST = (AST) returnAST;
                            break;
                        }
                        case SEMI:
                        case LCURLY: {
                            break;
                        }
                        default: {
                            throw new NoViableAltException(LT(1), getFilename());
                        }
                    }
                }
                {
                    if ((LA(1) == SEMI)) {
                        AST tmp100_AST = null;
                        tmp100_AST = astFactory.create(LT(1));
                        match(SEMI);
                    } else if (((LA(1) == LCURLY)) && (allowMethodBody)) {
                        compoundStatement();
                        s2_AST = (AST) returnAST;
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }

                }
                if (inputState.guessing == 0) {
                    memberDef_AST = (AST) currentAST.root;
                    memberDef_AST = (AST) astFactory.make((new ASTArray(8)).add(astFactory.create(METHOD_DEF, "METHOD_DEF")).add(modifiers).add(typeParams).add((AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(rt_AST))).add(tmp97_AST).add(param_AST).add(tc_AST).add(s2_AST));
                    currentAST.root = memberDef_AST;
                    currentAST.child = memberDef_AST != null && memberDef_AST.getFirstChild() != null ?
                            memberDef_AST.getFirstChild() : memberDef_AST;
                    currentAST.advanceChildToEnd();
                }
            } else if ((LA(1) == IDENT) && (_tokenSet_12.member(LA(2)))) {
                variableDefinitions(modifiers, t_AST);
                v_AST = (AST) returnAST;
                AST tmp101_AST = null;
                tmp101_AST = astFactory.create(LT(1));
                match(SEMI);
                if (inputState.guessing == 0) {
                    memberDef_AST = (AST) currentAST.root;
                    memberDef_AST = v_AST;
                    currentAST.root = memberDef_AST;
                    currentAST.child = memberDef_AST != null && memberDef_AST.getFirstChild() != null ?
                            memberDef_AST.getFirstChild() : memberDef_AST;
                    currentAST.advanceChildToEnd();
                }
            } else {
                throw new NoViableAltException(LT(1), getFilename());
            }

        }
        returnAST = memberDef_AST;
    }

    public final void parameterDeclarationList() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST parameterDeclarationList_AST = null;

        {
            switch (LA(1)) {
                case FINAL:
                case IDENT:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case AT: {
                    parameterDeclaration();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop156:
                        do {
                            if ((LA(1) == COMMA)) {
                                match(COMMA);
                                parameterDeclaration();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop156;
                            }

                        } while (true);
                    }
                    break;
                }
                case RPAREN: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            parameterDeclarationList_AST = (AST) currentAST.root;
            parameterDeclarationList_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(PARAMETERS, "PARAMETERS")).add(parameterDeclarationList_AST));
            currentAST.root = parameterDeclarationList_AST;
            currentAST.child = parameterDeclarationList_AST != null && parameterDeclarationList_AST.getFirstChild() != null ?
                    parameterDeclarationList_AST.getFirstChild() : parameterDeclarationList_AST;
            currentAST.advanceChildToEnd();
        }
        parameterDeclarationList_AST = (AST) currentAST.root;
        returnAST = parameterDeclarationList_AST;
    }

    public final void declaratorBrackets(
            AST typ
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST declaratorBrackets_AST = null;
        Token lb = null;
        AST lb_AST = null;

        if (inputState.guessing == 0) {
            declaratorBrackets_AST = (AST) currentAST.root;
            declaratorBrackets_AST = typ;
            currentAST.root = declaratorBrackets_AST;
            currentAST.child = declaratorBrackets_AST != null && declaratorBrackets_AST.getFirstChild() != null ?
                    declaratorBrackets_AST.getFirstChild() : declaratorBrackets_AST;
            currentAST.advanceChildToEnd();
        }
        {
            _loop139:
            do {
                if ((LA(1) == LBRACK)) {
                    lb = LT(1);
                    lb_AST = astFactory.create(lb);
                    astFactory.makeASTRoot(currentAST, lb_AST);
                    match(LBRACK);
                    if (inputState.guessing == 0) {
                        lb_AST.setType(ARRAY_DECLARATOR);
                    }
                    match(RBRACK);
                } else {
                    break _loop139;
                }

            } while (true);
        }
        declaratorBrackets_AST = (AST) currentAST.root;
        returnAST = declaratorBrackets_AST;
    }

    public final void throwsClause() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST throwsClause_AST = null;

        AST tmp104_AST = null;
        tmp104_AST = astFactory.create(LT(1));
        astFactory.makeASTRoot(currentAST, tmp104_AST);
        match(LITERAL_throws);
        identifier();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop152:
            do {
                if ((LA(1) == COMMA)) {
                    match(COMMA);
                    identifier();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop152;
                }

            } while (true);
        }
        throwsClause_AST = (AST) currentAST.root;
        returnAST = throwsClause_AST;
    }

    public final void compoundStatement() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST compoundStatement_AST = null;
        Token lc = null;
        AST lc_AST = null;

        lc = LT(1);
        lc_AST = astFactory.create(lc);
        astFactory.makeASTRoot(currentAST, lc_AST);
        match(LCURLY);
        if (inputState.guessing == 0) {
            lc_AST.setType(SLIST);
        }
        {
            _loop164:
            do {
                if ((_tokenSet_17.member(LA(1)))) {
                    statement();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop164;
                }

            } while (true);
        }
        match(RCURLY);
        compoundStatement_AST = (AST) currentAST.root;
        returnAST = compoundStatement_AST;
    }

    public final void ctorHead() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST ctorHead_AST = null;

        AST tmp107_AST = null;
        tmp107_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp107_AST);
        match(IDENT);
        match(LPAREN);
        parameterDeclarationList();
        astFactory.addASTChild(currentAST, returnAST);
        match(RPAREN);
        {
            switch (LA(1)) {
                case LITERAL_throws: {
                    throwsClause();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case LCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        ctorHead_AST = (AST) currentAST.root;
        returnAST = ctorHead_AST;
    }

    public final void constructorBody() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST constructorBody_AST = null;
        Token lc = null;
        AST lc_AST = null;

        lc = LT(1);
        lc_AST = astFactory.create(lc);
        astFactory.makeASTRoot(currentAST, lc_AST);
        match(LCURLY);
        if (inputState.guessing == 0) {
            lc_AST.setType(SLIST);
        }
        {
            if ((_tokenSet_18.member(LA(1))) && (_tokenSet_19.member(LA(2)))) {
                explicitConstructorInvocation();
                astFactory.addASTChild(currentAST, returnAST);
            } else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_21.member(LA(2)))) {
            } else {
                throw new NoViableAltException(LT(1), getFilename());
            }

        }
        {
            _loop130:
            do {
                if ((_tokenSet_17.member(LA(1)))) {
                    statement();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop130;
                }

            } while (true);
        }
        match(RCURLY);
        constructorBody_AST = (AST) currentAST.root;
        returnAST = constructorBody_AST;
    }

    /**
     * Catch obvious constructor calls, but not the expr.super(...) calls
     */
    public final void explicitConstructorInvocation() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST explicitConstructorInvocation_AST = null;
        Token lp1 = null;
        AST lp1_AST = null;
        Token lp2 = null;
        AST lp2_AST = null;

        typeArguments();
        astFactory.addASTChild(currentAST, returnAST);
        {
            switch (LA(1)) {
                case LITERAL_this: {
                    match(LITERAL_this);
                    lp1 = LT(1);
                    lp1_AST = astFactory.create(lp1);
                    astFactory.makeASTRoot(currentAST, lp1_AST);
                    match(LPAREN);
                    argList();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RPAREN);
                    match(SEMI);
                    if (inputState.guessing == 0) {
                        lp1_AST.setType(CTOR_CALL);
                    }
                    break;
                }
                case LITERAL_super: {
                    match(LITERAL_super);
                    lp2 = LT(1);
                    lp2_AST = astFactory.create(lp2);
                    astFactory.makeASTRoot(currentAST, lp2_AST);
                    match(LPAREN);
                    argList();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RPAREN);
                    match(SEMI);
                    if (inputState.guessing == 0) {
                        lp2_AST.setType(SUPER_CTOR_CALL);
                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        explicitConstructorInvocation_AST = (AST) currentAST.root;
        returnAST = explicitConstructorInvocation_AST;
    }

    public final void statement() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST statement_AST = null;
        AST m_AST = null;
        Token c = null;
        AST c_AST = null;
        Token s = null;
        AST s_AST = null;

        switch (LA(1)) {
            case LCURLY: {
                compoundStatement();
                astFactory.addASTChild(currentAST, returnAST);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_if: {
                AST tmp117_AST = null;
                tmp117_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp117_AST);
                match(LITERAL_if);
                match(LPAREN);
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                match(RPAREN);
                statement();
                astFactory.addASTChild(currentAST, returnAST);
                {
                    if ((LA(1) == LITERAL_else) && (_tokenSet_17.member(LA(2)))) {
                        match(LITERAL_else);
                        statement();
                        astFactory.addASTChild(currentAST, returnAST);
                    } else if ((_tokenSet_22.member(LA(1))) && (_tokenSet_23.member(LA(2)))) {
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }

                }
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_for: {
                AST tmp121_AST = null;
                tmp121_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp121_AST);
                match(LITERAL_for);
                match(LPAREN);
                {
                    boolean synPredMatched172 = false;
                    if (((_tokenSet_24.member(LA(1))) && (_tokenSet_25.member(LA(2))))) {
                        int _m172 = mark();
                        synPredMatched172 = true;
                        inputState.guessing++;
                        try {
                            {
                                parameterDeclaration();
                                match(COLON);
                            }
                        }
                        catch (RecognitionException pe) {
                            synPredMatched172 = false;
                        }
                        rewind(_m172);
                        inputState.guessing--;
                    }
                    if (synPredMatched172) {
                        parameterDeclaration();
                        astFactory.addASTChild(currentAST, returnAST);
                        match(COLON);
                        expression();
                        astFactory.addASTChild(currentAST, returnAST);
                    } else if ((_tokenSet_26.member(LA(1))) && (_tokenSet_27.member(LA(2)))) {
                        forInit();
                        astFactory.addASTChild(currentAST, returnAST);
                        match(SEMI);
                        forCond();
                        astFactory.addASTChild(currentAST, returnAST);
                        match(SEMI);
                        forIter();
                        astFactory.addASTChild(currentAST, returnAST);
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }

                }
                match(RPAREN);
                statement();
                astFactory.addASTChild(currentAST, returnAST);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_while: {
                AST tmp127_AST = null;
                tmp127_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp127_AST);
                match(LITERAL_while);
                match(LPAREN);
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                match(RPAREN);
                statement();
                astFactory.addASTChild(currentAST, returnAST);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_do: {
                AST tmp130_AST = null;
                tmp130_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp130_AST);
                match(LITERAL_do);
                statement();
                astFactory.addASTChild(currentAST, returnAST);
                match(LITERAL_while);
                match(LPAREN);
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                match(RPAREN);
                match(SEMI);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_break: {
                AST tmp135_AST = null;
                tmp135_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp135_AST);
                match(LITERAL_break);
                {
                    switch (LA(1)) {
                        case IDENT: {
                            AST tmp136_AST = null;
                            tmp136_AST = astFactory.create(LT(1));
                            astFactory.addASTChild(currentAST, tmp136_AST);
                            match(IDENT);
                            break;
                        }
                        case SEMI: {
                            break;
                        }
                        default: {
                            throw new NoViableAltException(LT(1), getFilename());
                        }
                    }
                }
                match(SEMI);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_continue: {
                AST tmp138_AST = null;
                tmp138_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp138_AST);
                match(LITERAL_continue);
                {
                    switch (LA(1)) {
                        case IDENT: {
                            AST tmp139_AST = null;
                            tmp139_AST = astFactory.create(LT(1));
                            astFactory.addASTChild(currentAST, tmp139_AST);
                            match(IDENT);
                            break;
                        }
                        case SEMI: {
                            break;
                        }
                        default: {
                            throw new NoViableAltException(LT(1), getFilename());
                        }
                    }
                }
                match(SEMI);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_return: {
                AST tmp141_AST = null;
                tmp141_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp141_AST);
                match(LITERAL_return);
                {
                    switch (LA(1)) {
                        case IDENT:
                        case LT:
                        case LITERAL_super:
                        case LITERAL_void:
                        case LITERAL_boolean:
                        case LITERAL_byte:
                        case LITERAL_char:
                        case LITERAL_short:
                        case LITERAL_int:
                        case LITERAL_float:
                        case LITERAL_long:
                        case LITERAL_double:
                        case LPAREN:
                        case LITERAL_this:
                        case PLUS:
                        case MINUS:
                        case INC:
                        case DEC:
                        case BNOT:
                        case LNOT:
                        case LITERAL_true:
                        case LITERAL_false:
                        case LITERAL_null:
                        case LITERAL_new:
                        case NUM_INT:
                        case CHAR_LITERAL:
                        case STRING_LITERAL:
                        case NUM_FLOAT:
                        case NUM_LONG:
                        case NUM_DOUBLE: {
                            expression();
                            astFactory.addASTChild(currentAST, returnAST);
                            break;
                        }
                        case SEMI: {
                            break;
                        }
                        default: {
                            throw new NoViableAltException(LT(1), getFilename());
                        }
                    }
                }
                match(SEMI);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_switch: {
                AST tmp143_AST = null;
                tmp143_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp143_AST);
                match(LITERAL_switch);
                match(LPAREN);
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                match(RPAREN);
                match(LCURLY);
                {
                    _loop177:
                    do {
                        if ((LA(1) == LITERAL_default || LA(1) == LITERAL_case)) {
                            casesGroup();
                            astFactory.addASTChild(currentAST, returnAST);
                        } else {
                            break _loop177;
                        }

                    } while (true);
                }
                match(RCURLY);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_try: {
                tryBlock();
                astFactory.addASTChild(currentAST, returnAST);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_throw: {
                AST tmp148_AST = null;
                tmp148_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp148_AST);
                match(LITERAL_throw);
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                match(SEMI);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case ASSERT: {
                AST tmp150_AST = null;
                tmp150_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp150_AST);
                match(ASSERT);
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                {
                    switch (LA(1)) {
                        case COLON: {
                            match(COLON);
                            expression();
                            astFactory.addASTChild(currentAST, returnAST);
                            break;
                        }
                        case SEMI: {
                            break;
                        }
                        default: {
                            throw new NoViableAltException(LT(1), getFilename());
                        }
                    }
                }
                match(SEMI);
                statement_AST = (AST) currentAST.root;
                break;
            }
            case SEMI: {
                s = LT(1);
                s_AST = astFactory.create(s);
                astFactory.addASTChild(currentAST, s_AST);
                match(SEMI);
                if (inputState.guessing == 0) {
                    s_AST.setType(EMPTY_STAT);
                }
                statement_AST = (AST) currentAST.root;
                break;
            }
            default:
                boolean synPredMatched167 = false;
                if (((_tokenSet_28.member(LA(1))) && (_tokenSet_29.member(LA(2))))) {
                    int _m167 = mark();
                    synPredMatched167 = true;
                    inputState.guessing++;
                    try {
                        {
                            declaration();
                        }
                    }
                    catch (RecognitionException pe) {
                        synPredMatched167 = false;
                    }
                    rewind(_m167);
                    inputState.guessing--;
                }
                if (synPredMatched167) {
                    declaration();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(SEMI);
                    statement_AST = (AST) currentAST.root;
                } else if ((_tokenSet_30.member(LA(1))) && (_tokenSet_31.member(LA(2)))) {
                    expression();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(SEMI);
                    statement_AST = (AST) currentAST.root;
                } else if ((_tokenSet_32.member(LA(1))) && (_tokenSet_33.member(LA(2)))) {
                    modifiers();
                    m_AST = (AST) returnAST;
                    {
                        switch (LA(1)) {
                            case ENUM: {
                                enumDefinition(m_AST);
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case LITERAL_class: {
                                classDefinition(m_AST);
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    statement_AST = (AST) currentAST.root;
                } else if ((LA(1) == IDENT) && (LA(2) == COLON)) {
                    AST tmp155_AST = null;
                    tmp155_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp155_AST);
                    match(IDENT);
                    c = LT(1);
                    c_AST = astFactory.create(c);
                    astFactory.makeASTRoot(currentAST, c_AST);
                    match(COLON);
                    if (inputState.guessing == 0) {
                        c_AST.setType(LABELED_STAT);
                    }
                    statement();
                    astFactory.addASTChild(currentAST, returnAST);
                    statement_AST = (AST) currentAST.root;
                } else if ((LA(1) == LITERAL_synchronized) && (LA(2) == LPAREN)) {
                    AST tmp156_AST = null;
                    tmp156_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp156_AST);
                    match(LITERAL_synchronized);
                    match(LPAREN);
                    expression();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RPAREN);
                    compoundStatement();
                    astFactory.addASTChild(currentAST, returnAST);
                    statement_AST = (AST) currentAST.root;
                } else {
                    throw new NoViableAltException(LT(1), getFilename());
                }
        }
        returnAST = statement_AST;
    }

    /**
     * Declaration of a variable.  This can be a class/instance variable,
     * or a local variable in a method
     * It can also include possible initialization.
     */
    public final void variableDeclarator(
            AST mods, AST t
    ) throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST variableDeclarator_AST = null;
        Token id = null;
        AST id_AST = null;
        AST d_AST = null;
        AST v_AST = null;

        id = LT(1);
        id_AST = astFactory.create(id);
        match(IDENT);
        declaratorBrackets(t);
        d_AST = (AST) returnAST;
        varInitializer();
        v_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            variableDeclarator_AST = (AST) currentAST.root;
            variableDeclarator_AST = (AST) astFactory.make((new ASTArray(5)).add(astFactory.create(VARIABLE_DEF, "VARIABLE_DEF")).add(mods).add((AST) astFactory.make((new ASTArray(2)).add(astFactory.create(TYPE, "TYPE")).add(d_AST))).add(id_AST).add(v_AST));
            currentAST.root = variableDeclarator_AST;
            currentAST.child = variableDeclarator_AST != null && variableDeclarator_AST.getFirstChild() != null ?
                    variableDeclarator_AST.getFirstChild() : variableDeclarator_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = variableDeclarator_AST;
    }

    public final void varInitializer() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST varInitializer_AST = null;

        {
            switch (LA(1)) {
                case ASSIGN: {
                    AST tmp159_AST = null;
                    tmp159_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp159_AST);
                    match(ASSIGN);
                    initializer();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case SEMI:
                case COMMA: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        varInitializer_AST = (AST) currentAST.root;
        returnAST = varInitializer_AST;
    }

    public final void initializer() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST initializer_AST = null;

        switch (LA(1)) {
            case IDENT:
            case LT:
            case LITERAL_super:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double:
            case LPAREN:
            case LITERAL_this:
            case PLUS:
            case MINUS:
            case INC:
            case DEC:
            case BNOT:
            case LNOT:
            case LITERAL_true:
            case LITERAL_false:
            case LITERAL_null:
            case LITERAL_new:
            case NUM_INT:
            case CHAR_LITERAL:
            case STRING_LITERAL:
            case NUM_FLOAT:
            case NUM_LONG:
            case NUM_DOUBLE: {
                expression();
                astFactory.addASTChild(currentAST, returnAST);
                initializer_AST = (AST) currentAST.root;
                break;
            }
            case LCURLY: {
                arrayInitializer();
                astFactory.addASTChild(currentAST, returnAST);
                initializer_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = initializer_AST;
    }

    public final void arrayInitializer() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST arrayInitializer_AST = null;
        Token lc = null;
        AST lc_AST = null;

        lc = LT(1);
        lc_AST = astFactory.create(lc);
        astFactory.makeASTRoot(currentAST, lc_AST);
        match(LCURLY);
        if (inputState.guessing == 0) {
            lc_AST.setType(ARRAY_INIT);
        }
        {
            switch (LA(1)) {
                case IDENT:
                case LT:
                case LITERAL_super:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case LCURLY:
                case LPAREN:
                case LITERAL_this:
                case PLUS:
                case MINUS:
                case INC:
                case DEC:
                case BNOT:
                case LNOT:
                case LITERAL_true:
                case LITERAL_false:
                case LITERAL_null:
                case LITERAL_new:
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    initializer();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        _loop145:
                        do {
                            if ((LA(1) == COMMA) && (_tokenSet_34.member(LA(2)))) {
                                match(COMMA);
                                initializer();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop145;
                            }

                        } while (true);
                    }
                    break;
                }
                case COMMA:
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        {
            switch (LA(1)) {
                case COMMA: {
                    match(COMMA);
                    break;
                }
                case RCURLY: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        match(RCURLY);
        arrayInitializer_AST = (AST) currentAST.root;
        returnAST = arrayInitializer_AST;
    }

    public final void expression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST expression_AST = null;

        assignmentExpression();
        astFactory.addASTChild(currentAST, returnAST);
        if (inputState.guessing == 0) {
            expression_AST = (AST) currentAST.root;
            expression_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(EXPR, "EXPR")).add(expression_AST));
            currentAST.root = expression_AST;
            currentAST.child = expression_AST != null && expression_AST.getFirstChild() != null ?
                    expression_AST.getFirstChild() : expression_AST;
            currentAST.advanceChildToEnd();
        }
        expression_AST = (AST) currentAST.root;
        returnAST = expression_AST;
    }

    public final void parameterDeclaration() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST parameterDeclaration_AST = null;
        AST pm_AST = null;
        AST t_AST = null;
        Token el = null;
        AST el_AST = null;
        Token id = null;
        AST id_AST = null;
        AST pd_AST = null;

        parameterModifier();
        pm_AST = (AST) returnAST;
        typeSpec(false);
        t_AST = (AST) returnAST;
        {
            switch (LA(1)) {
                case ELLIPSIS: {
                    el = LT(1);
                    el_AST = astFactory.create(el);
                    match(ELLIPSIS);
                    break;
                }
                case IDENT: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        id = LT(1);
        id_AST = astFactory.create(id);
        match(IDENT);
        declaratorBrackets(t_AST);
        pd_AST = (AST) returnAST;
        if (inputState.guessing == 0) {
            parameterDeclaration_AST = (AST) currentAST.root;
            parameterDeclaration_AST = (AST) astFactory.make((new ASTArray(4)).add(astFactory.create(PARAMETER_DEF, "PARAMETER_DEF")).add(pm_AST).add((AST) astFactory.make((new ASTArray(3)).add(astFactory.create(TYPE, "TYPE")).add(pd_AST).add(el_AST))).add(id_AST));
            currentAST.root = parameterDeclaration_AST;
            currentAST.child = parameterDeclaration_AST != null && parameterDeclaration_AST.getFirstChild() != null ?
                    parameterDeclaration_AST.getFirstChild() : parameterDeclaration_AST;
            currentAST.advanceChildToEnd();
        }
        returnAST = parameterDeclaration_AST;
    }

    public final void parameterModifier() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST parameterModifier_AST = null;

        {
            _loop161:
            do {
                switch (LA(1)) {
                    case FINAL: {
                        AST tmp163_AST = null;
                        tmp163_AST = astFactory.create(LT(1));
                        astFactory.addASTChild(currentAST, tmp163_AST);
                        match(FINAL);
                        break;
                    }
                    case AT: {
                        annotation();
                        astFactory.addASTChild(currentAST, returnAST);
                        break;
                    }
                    default: {
                        break _loop161;
                    }
                }
            } while (true);
        }
        if (inputState.guessing == 0) {
            parameterModifier_AST = (AST) currentAST.root;
            parameterModifier_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(MODIFIERS, "MODIFIERS")).add(parameterModifier_AST));
            currentAST.root = parameterModifier_AST;
            currentAST.child = parameterModifier_AST != null && parameterModifier_AST.getFirstChild() != null ?
                    parameterModifier_AST.getFirstChild() : parameterModifier_AST;
            currentAST.advanceChildToEnd();
        }
        parameterModifier_AST = (AST) currentAST.root;
        returnAST = parameterModifier_AST;
    }

    public final void forInit() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST forInit_AST = null;

        {
            boolean synPredMatched190 = false;
            if (((_tokenSet_28.member(LA(1))) && (_tokenSet_29.member(LA(2))))) {
                int _m190 = mark();
                synPredMatched190 = true;
                inputState.guessing++;
                try {
                    {
                        declaration();
                    }
                }
                catch (RecognitionException pe) {
                    synPredMatched190 = false;
                }
                rewind(_m190);
                inputState.guessing--;
            }
            if (synPredMatched190) {
                declaration();
                astFactory.addASTChild(currentAST, returnAST);
            } else if ((_tokenSet_30.member(LA(1))) && (_tokenSet_35.member(LA(2)))) {
                expressionList();
                astFactory.addASTChild(currentAST, returnAST);
            } else if ((LA(1) == SEMI)) {
            } else {
                throw new NoViableAltException(LT(1), getFilename());
            }

        }
        if (inputState.guessing == 0) {
            forInit_AST = (AST) currentAST.root;
            forInit_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(FOR_INIT, "FOR_INIT")).add(forInit_AST));
            currentAST.root = forInit_AST;
            currentAST.child = forInit_AST != null && forInit_AST.getFirstChild() != null ?
                    forInit_AST.getFirstChild() : forInit_AST;
            currentAST.advanceChildToEnd();
        }
        forInit_AST = (AST) currentAST.root;
        returnAST = forInit_AST;
    }

    public final void forCond() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST forCond_AST = null;

        {
            switch (LA(1)) {
                case IDENT:
                case LT:
                case LITERAL_super:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case LPAREN:
                case LITERAL_this:
                case PLUS:
                case MINUS:
                case INC:
                case DEC:
                case BNOT:
                case LNOT:
                case LITERAL_true:
                case LITERAL_false:
                case LITERAL_null:
                case LITERAL_new:
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    expression();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case SEMI: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            forCond_AST = (AST) currentAST.root;
            forCond_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(FOR_CONDITION, "FOR_CONDITION")).add(forCond_AST));
            currentAST.root = forCond_AST;
            currentAST.child = forCond_AST != null && forCond_AST.getFirstChild() != null ?
                    forCond_AST.getFirstChild() : forCond_AST;
            currentAST.advanceChildToEnd();
        }
        forCond_AST = (AST) currentAST.root;
        returnAST = forCond_AST;
    }

    public final void forIter() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST forIter_AST = null;

        {
            switch (LA(1)) {
                case IDENT:
                case LT:
                case LITERAL_super:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case LPAREN:
                case LITERAL_this:
                case PLUS:
                case MINUS:
                case INC:
                case DEC:
                case BNOT:
                case LNOT:
                case LITERAL_true:
                case LITERAL_false:
                case LITERAL_null:
                case LITERAL_new:
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    expressionList();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case RPAREN: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        if (inputState.guessing == 0) {
            forIter_AST = (AST) currentAST.root;
            forIter_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(FOR_ITERATOR, "FOR_ITERATOR")).add(forIter_AST));
            currentAST.root = forIter_AST;
            currentAST.child = forIter_AST != null && forIter_AST.getFirstChild() != null ?
                    forIter_AST.getFirstChild() : forIter_AST;
            currentAST.advanceChildToEnd();
        }
        forIter_AST = (AST) currentAST.root;
        returnAST = forIter_AST;
    }

    public final void casesGroup() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST casesGroup_AST = null;

        {
            int _cnt181 = 0;
            _loop181:
            do {
                if ((LA(1) == LITERAL_default || LA(1) == LITERAL_case) && (_tokenSet_36.member(LA(2)))) {
                    aCase();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    if (_cnt181 >= 1) {
                        break _loop181;
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }
                }

                _cnt181++;
            } while (true);
        }
        caseSList();
        astFactory.addASTChild(currentAST, returnAST);
        if (inputState.guessing == 0) {
            casesGroup_AST = (AST) currentAST.root;
            casesGroup_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(CASE_GROUP, "CASE_GROUP")).add(casesGroup_AST));
            currentAST.root = casesGroup_AST;
            currentAST.child = casesGroup_AST != null && casesGroup_AST.getFirstChild() != null ?
                    casesGroup_AST.getFirstChild() : casesGroup_AST;
            currentAST.advanceChildToEnd();
        }
        casesGroup_AST = (AST) currentAST.root;
        returnAST = casesGroup_AST;
    }

    public final void tryBlock() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST tryBlock_AST = null;

        AST tmp164_AST = null;
        tmp164_AST = astFactory.create(LT(1));
        astFactory.makeASTRoot(currentAST, tmp164_AST);
        match(LITERAL_try);
        compoundStatement();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop197:
            do {
                if ((LA(1) == LITERAL_catch)) {
                    handler();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop197;
                }

            } while (true);
        }
        {
            switch (LA(1)) {
                case LITERAL_finally: {
                    finallyClause();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case FINAL:
                case ABSTRACT:
                case STRICTFP:
                case ASSERT:
                case ENUM:
                case SEMI:
                case LITERAL_static:
                case IDENT:
                case LT:
                case LITERAL_super:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double:
                case LITERAL_private:
                case LITERAL_public:
                case LITERAL_protected:
                case LITERAL_transient:
                case LITERAL_native:
                case LITERAL_threadsafe:
                case LITERAL_synchronized:
                case LITERAL_volatile:
                case LCURLY:
                case RCURLY:
                case LPAREN:
                case AT:
                case LITERAL_default:
                case LITERAL_class:
                case LITERAL_this:
                case LITERAL_if:
                case LITERAL_else:
                case LITERAL_for:
                case LITERAL_while:
                case LITERAL_do:
                case LITERAL_break:
                case LITERAL_continue:
                case LITERAL_return:
                case LITERAL_switch:
                case LITERAL_throw:
                case LITERAL_case:
                case LITERAL_try:
                case PLUS:
                case MINUS:
                case INC:
                case DEC:
                case BNOT:
                case LNOT:
                case LITERAL_true:
                case LITERAL_false:
                case LITERAL_null:
                case LITERAL_new:
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        tryBlock_AST = (AST) currentAST.root;
        returnAST = tryBlock_AST;
    }

    public final void aCase() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST aCase_AST = null;

        {
            switch (LA(1)) {
                case LITERAL_case: {
                    AST tmp165_AST = null;
                    tmp165_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp165_AST);
                    match(LITERAL_case);
                    expression();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case LITERAL_default: {
                    AST tmp166_AST = null;
                    tmp166_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp166_AST);
                    match(LITERAL_default);
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        match(COLON);
        aCase_AST = (AST) currentAST.root;
        returnAST = aCase_AST;
    }

    public final void caseSList() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST caseSList_AST = null;

        {
            _loop186:
            do {
                if ((_tokenSet_17.member(LA(1)))) {
                    statement();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop186;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            caseSList_AST = (AST) currentAST.root;
            caseSList_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(SLIST, "SLIST")).add(caseSList_AST));
            currentAST.root = caseSList_AST;
            currentAST.child = caseSList_AST != null && caseSList_AST.getFirstChild() != null ?
                    caseSList_AST.getFirstChild() : caseSList_AST;
            currentAST.advanceChildToEnd();
        }
        caseSList_AST = (AST) currentAST.root;
        returnAST = caseSList_AST;
    }

    public final void expressionList() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST expressionList_AST = null;

        expression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop204:
            do {
                if ((LA(1) == COMMA)) {
                    match(COMMA);
                    expression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop204;
                }

            } while (true);
        }
        if (inputState.guessing == 0) {
            expressionList_AST = (AST) currentAST.root;
            expressionList_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ELIST, "ELIST")).add(expressionList_AST));
            currentAST.root = expressionList_AST;
            currentAST.child = expressionList_AST != null && expressionList_AST.getFirstChild() != null ?
                    expressionList_AST.getFirstChild() : expressionList_AST;
            currentAST.advanceChildToEnd();
        }
        expressionList_AST = (AST) currentAST.root;
        returnAST = expressionList_AST;
    }

    public final void handler() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST handler_AST = null;

        AST tmp169_AST = null;
        tmp169_AST = astFactory.create(LT(1));
        astFactory.makeASTRoot(currentAST, tmp169_AST);
        match(LITERAL_catch);
        match(LPAREN);
        parameterDeclaration();
        astFactory.addASTChild(currentAST, returnAST);
        match(RPAREN);
        compoundStatement();
        astFactory.addASTChild(currentAST, returnAST);
        handler_AST = (AST) currentAST.root;
        returnAST = handler_AST;
    }

    public final void finallyClause() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST finallyClause_AST = null;

        AST tmp172_AST = null;
        tmp172_AST = astFactory.create(LT(1));
        astFactory.makeASTRoot(currentAST, tmp172_AST);
        match(LITERAL_finally);
        compoundStatement();
        astFactory.addASTChild(currentAST, returnAST);
        finallyClause_AST = (AST) currentAST.root;
        returnAST = finallyClause_AST;
    }

    public final void assignmentExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST assignmentExpression_AST = null;

        conditionalExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            switch (LA(1)) {
                case ASSIGN:
                case PLUS_ASSIGN:
                case MINUS_ASSIGN:
                case STAR_ASSIGN:
                case DIV_ASSIGN:
                case MOD_ASSIGN:
                case SR_ASSIGN:
                case BSR_ASSIGN:
                case SL_ASSIGN:
                case BAND_ASSIGN:
                case BXOR_ASSIGN:
                case BOR_ASSIGN: {
                    {
                        switch (LA(1)) {
                            case ASSIGN: {
                                AST tmp173_AST = null;
                                tmp173_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp173_AST);
                                match(ASSIGN);
                                break;
                            }
                            case PLUS_ASSIGN: {
                                AST tmp174_AST = null;
                                tmp174_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp174_AST);
                                match(PLUS_ASSIGN);
                                break;
                            }
                            case MINUS_ASSIGN: {
                                AST tmp175_AST = null;
                                tmp175_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp175_AST);
                                match(MINUS_ASSIGN);
                                break;
                            }
                            case STAR_ASSIGN: {
                                AST tmp176_AST = null;
                                tmp176_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp176_AST);
                                match(STAR_ASSIGN);
                                break;
                            }
                            case DIV_ASSIGN: {
                                AST tmp177_AST = null;
                                tmp177_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp177_AST);
                                match(DIV_ASSIGN);
                                break;
                            }
                            case MOD_ASSIGN: {
                                AST tmp178_AST = null;
                                tmp178_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp178_AST);
                                match(MOD_ASSIGN);
                                break;
                            }
                            case SR_ASSIGN: {
                                AST tmp179_AST = null;
                                tmp179_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp179_AST);
                                match(SR_ASSIGN);
                                break;
                            }
                            case BSR_ASSIGN: {
                                AST tmp180_AST = null;
                                tmp180_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp180_AST);
                                match(BSR_ASSIGN);
                                break;
                            }
                            case SL_ASSIGN: {
                                AST tmp181_AST = null;
                                tmp181_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp181_AST);
                                match(SL_ASSIGN);
                                break;
                            }
                            case BAND_ASSIGN: {
                                AST tmp182_AST = null;
                                tmp182_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp182_AST);
                                match(BAND_ASSIGN);
                                break;
                            }
                            case BXOR_ASSIGN: {
                                AST tmp183_AST = null;
                                tmp183_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp183_AST);
                                match(BXOR_ASSIGN);
                                break;
                            }
                            case BOR_ASSIGN: {
                                AST tmp184_AST = null;
                                tmp184_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp184_AST);
                                match(BOR_ASSIGN);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    assignmentExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                case SEMI:
                case RBRACK:
                case COMMA:
                case RCURLY:
                case RPAREN:
                case COLON: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        assignmentExpression_AST = (AST) currentAST.root;
        returnAST = assignmentExpression_AST;
    }

    public final void logicalOrExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST logicalOrExpression_AST = null;

        logicalAndExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop212:
            do {
                if ((LA(1) == LOR)) {
                    AST tmp185_AST = null;
                    tmp185_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp185_AST);
                    match(LOR);
                    logicalAndExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop212;
                }

            } while (true);
        }
        logicalOrExpression_AST = (AST) currentAST.root;
        returnAST = logicalOrExpression_AST;
    }

    public final void logicalAndExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST logicalAndExpression_AST = null;

        inclusiveOrExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop215:
            do {
                if ((LA(1) == LAND)) {
                    AST tmp186_AST = null;
                    tmp186_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp186_AST);
                    match(LAND);
                    inclusiveOrExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop215;
                }

            } while (true);
        }
        logicalAndExpression_AST = (AST) currentAST.root;
        returnAST = logicalAndExpression_AST;
    }

    public final void inclusiveOrExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST inclusiveOrExpression_AST = null;

        exclusiveOrExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop218:
            do {
                if ((LA(1) == BOR)) {
                    AST tmp187_AST = null;
                    tmp187_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp187_AST);
                    match(BOR);
                    exclusiveOrExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop218;
                }

            } while (true);
        }
        inclusiveOrExpression_AST = (AST) currentAST.root;
        returnAST = inclusiveOrExpression_AST;
    }

    public final void exclusiveOrExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST exclusiveOrExpression_AST = null;

        andExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop221:
            do {
                if ((LA(1) == BXOR)) {
                    AST tmp188_AST = null;
                    tmp188_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp188_AST);
                    match(BXOR);
                    andExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop221;
                }

            } while (true);
        }
        exclusiveOrExpression_AST = (AST) currentAST.root;
        returnAST = exclusiveOrExpression_AST;
    }

    public final void andExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST andExpression_AST = null;

        equalityExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop224:
            do {
                if ((LA(1) == BAND)) {
                    AST tmp189_AST = null;
                    tmp189_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp189_AST);
                    match(BAND);
                    equalityExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop224;
                }

            } while (true);
        }
        andExpression_AST = (AST) currentAST.root;
        returnAST = andExpression_AST;
    }

    public final void equalityExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST equalityExpression_AST = null;

        relationalExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop228:
            do {
                if ((LA(1) == NOT_EQUAL || LA(1) == EQUAL)) {
                    {
                        switch (LA(1)) {
                            case NOT_EQUAL: {
                                AST tmp190_AST = null;
                                tmp190_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp190_AST);
                                match(NOT_EQUAL);
                                break;
                            }
                            case EQUAL: {
                                AST tmp191_AST = null;
                                tmp191_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp191_AST);
                                match(EQUAL);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    relationalExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop228;
                }

            } while (true);
        }
        equalityExpression_AST = (AST) currentAST.root;
        returnAST = equalityExpression_AST;
    }

    public final void relationalExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST relationalExpression_AST = null;

        shiftExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            switch (LA(1)) {
                case SEMI:
                case RBRACK:
                case LT:
                case COMMA:
                case QUESTION:
                case GT:
                case RCURLY:
                case RPAREN:
                case ASSIGN:
                case BAND:
                case COLON:
                case PLUS_ASSIGN:
                case MINUS_ASSIGN:
                case STAR_ASSIGN:
                case DIV_ASSIGN:
                case MOD_ASSIGN:
                case SR_ASSIGN:
                case BSR_ASSIGN:
                case SL_ASSIGN:
                case BAND_ASSIGN:
                case BXOR_ASSIGN:
                case BOR_ASSIGN:
                case LOR:
                case LAND:
                case BOR:
                case BXOR:
                case NOT_EQUAL:
                case EQUAL:
                case LE:
                case GE: {
                    {
                        _loop233:
                        do {
                            if ((_tokenSet_37.member(LA(1)))) {
                                {
                                    switch (LA(1)) {
                                        case LT: {
                                            AST tmp192_AST = null;
                                            tmp192_AST = astFactory.create(LT(1));
                                            astFactory.makeASTRoot(currentAST, tmp192_AST);
                                            match(LT);
                                            break;
                                        }
                                        case GT: {
                                            AST tmp193_AST = null;
                                            tmp193_AST = astFactory.create(LT(1));
                                            astFactory.makeASTRoot(currentAST, tmp193_AST);
                                            match(GT);
                                            break;
                                        }
                                        case LE: {
                                            AST tmp194_AST = null;
                                            tmp194_AST = astFactory.create(LT(1));
                                            astFactory.makeASTRoot(currentAST, tmp194_AST);
                                            match(LE);
                                            break;
                                        }
                                        case GE: {
                                            AST tmp195_AST = null;
                                            tmp195_AST = astFactory.create(LT(1));
                                            astFactory.makeASTRoot(currentAST, tmp195_AST);
                                            match(GE);
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(LT(1), getFilename());
                                        }
                                    }
                                }
                                shiftExpression();
                                astFactory.addASTChild(currentAST, returnAST);
                            } else {
                                break _loop233;
                            }

                        } while (true);
                    }
                    break;
                }
                case LITERAL_instanceof: {
                    AST tmp196_AST = null;
                    tmp196_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp196_AST);
                    match(LITERAL_instanceof);
                    typeSpec(true);
                    astFactory.addASTChild(currentAST, returnAST);
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        relationalExpression_AST = (AST) currentAST.root;
        returnAST = relationalExpression_AST;
    }

    public final void shiftExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST shiftExpression_AST = null;

        additiveExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop237:
            do {
                if ((_tokenSet_38.member(LA(1)))) {
                    {
                        switch (LA(1)) {
                            case SL: {
                                AST tmp197_AST = null;
                                tmp197_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp197_AST);
                                match(SL);
                                break;
                            }
                            case SR: {
                                AST tmp198_AST = null;
                                tmp198_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp198_AST);
                                match(SR);
                                break;
                            }
                            case BSR: {
                                AST tmp199_AST = null;
                                tmp199_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp199_AST);
                                match(BSR);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    additiveExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop237;
                }

            } while (true);
        }
        shiftExpression_AST = (AST) currentAST.root;
        returnAST = shiftExpression_AST;
    }

    public final void additiveExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST additiveExpression_AST = null;

        multiplicativeExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop241:
            do {
                if ((LA(1) == PLUS || LA(1) == MINUS)) {
                    {
                        switch (LA(1)) {
                            case PLUS: {
                                AST tmp200_AST = null;
                                tmp200_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp200_AST);
                                match(PLUS);
                                break;
                            }
                            case MINUS: {
                                AST tmp201_AST = null;
                                tmp201_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp201_AST);
                                match(MINUS);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    multiplicativeExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop241;
                }

            } while (true);
        }
        additiveExpression_AST = (AST) currentAST.root;
        returnAST = additiveExpression_AST;
    }

    public final void multiplicativeExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST multiplicativeExpression_AST = null;

        unaryExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop245:
            do {
                if ((_tokenSet_39.member(LA(1)))) {
                    {
                        switch (LA(1)) {
                            case STAR: {
                                AST tmp202_AST = null;
                                tmp202_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp202_AST);
                                match(STAR);
                                break;
                            }
                            case DIV: {
                                AST tmp203_AST = null;
                                tmp203_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp203_AST);
                                match(DIV);
                                break;
                            }
                            case MOD: {
                                AST tmp204_AST = null;
                                tmp204_AST = astFactory.create(LT(1));
                                astFactory.makeASTRoot(currentAST, tmp204_AST);
                                match(MOD);
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    unaryExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else {
                    break _loop245;
                }

            } while (true);
        }
        multiplicativeExpression_AST = (AST) currentAST.root;
        returnAST = multiplicativeExpression_AST;
    }

    public final void unaryExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST unaryExpression_AST = null;

        switch (LA(1)) {
            case INC: {
                AST tmp205_AST = null;
                tmp205_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp205_AST);
                match(INC);
                unaryExpression();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case DEC: {
                AST tmp206_AST = null;
                tmp206_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp206_AST);
                match(DEC);
                unaryExpression();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case MINUS: {
                AST tmp207_AST = null;
                tmp207_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp207_AST);
                match(MINUS);
                if (inputState.guessing == 0) {
                    tmp207_AST.setType(UNARY_MINUS);
                }
                unaryExpression();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case PLUS: {
                AST tmp208_AST = null;
                tmp208_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp208_AST);
                match(PLUS);
                if (inputState.guessing == 0) {
                    tmp208_AST.setType(UNARY_PLUS);
                }
                unaryExpression();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case IDENT:
            case LT:
            case LITERAL_super:
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double:
            case LPAREN:
            case LITERAL_this:
            case BNOT:
            case LNOT:
            case LITERAL_true:
            case LITERAL_false:
            case LITERAL_null:
            case LITERAL_new:
            case NUM_INT:
            case CHAR_LITERAL:
            case STRING_LITERAL:
            case NUM_FLOAT:
            case NUM_LONG:
            case NUM_DOUBLE: {
                unaryExpressionNotPlusMinus();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpression_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = unaryExpression_AST;
    }

    public final void unaryExpressionNotPlusMinus() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST unaryExpressionNotPlusMinus_AST = null;
        Token lpb = null;
        AST lpb_AST = null;
        Token lp = null;
        AST lp_AST = null;

        switch (LA(1)) {
            case BNOT: {
                AST tmp209_AST = null;
                tmp209_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp209_AST);
                match(BNOT);
                unaryExpression();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpressionNotPlusMinus_AST = (AST) currentAST.root;
                break;
            }
            case LNOT: {
                AST tmp210_AST = null;
                tmp210_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp210_AST);
                match(LNOT);
                unaryExpression();
                astFactory.addASTChild(currentAST, returnAST);
                unaryExpressionNotPlusMinus_AST = (AST) currentAST.root;
                break;
            }
            default:
                boolean synPredMatched249 = false;
                if (((LA(1) == LPAREN) && ((LA(2) >= LITERAL_void && LA(2) <= LITERAL_double)))) {
                    int _m249 = mark();
                    synPredMatched249 = true;
                    inputState.guessing++;
                    try {
                        {
                            match(LPAREN);
                            builtInTypeSpec(true);
                            match(RPAREN);
                        }
                    }
                    catch (RecognitionException pe) {
                        synPredMatched249 = false;
                    }
                    rewind(_m249);
                    inputState.guessing--;
                }
                if (synPredMatched249) {
                    lpb = LT(1);
                    lpb_AST = astFactory.create(lpb);
                    astFactory.makeASTRoot(currentAST, lpb_AST);
                    match(LPAREN);
                    if (inputState.guessing == 0) {
                        lpb_AST.setType(TYPECAST);
                    }
                    builtInTypeSpec(true);
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RPAREN);
                    unaryExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                    unaryExpressionNotPlusMinus_AST = (AST) currentAST.root;
                } else {
                    boolean synPredMatched251 = false;
                    if (((LA(1) == LPAREN) && (LA(2) == IDENT))) {
                        int _m251 = mark();
                        synPredMatched251 = true;
                        inputState.guessing++;
                        try {
                            {
                                match(LPAREN);
                                classTypeSpec(true);
                                match(RPAREN);
                                unaryExpressionNotPlusMinus();
                            }
                        }
                        catch (RecognitionException pe) {
                            synPredMatched251 = false;
                        }
                        rewind(_m251);
                        inputState.guessing--;
                    }
                    if (synPredMatched251) {
                        lp = LT(1);
                        lp_AST = astFactory.create(lp);
                        astFactory.makeASTRoot(currentAST, lp_AST);
                        match(LPAREN);
                        if (inputState.guessing == 0) {
                            lp_AST.setType(TYPECAST);
                        }
                        classTypeSpec(true);
                        astFactory.addASTChild(currentAST, returnAST);
                        match(RPAREN);
                        unaryExpressionNotPlusMinus();
                        astFactory.addASTChild(currentAST, returnAST);
                        unaryExpressionNotPlusMinus_AST = (AST) currentAST.root;
                    } else if ((_tokenSet_40.member(LA(1))) && (_tokenSet_41.member(LA(2)))) {
                        postfixExpression();
                        astFactory.addASTChild(currentAST, returnAST);
                        unaryExpressionNotPlusMinus_AST = (AST) currentAST.root;
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }
                }
        }
        returnAST = unaryExpressionNotPlusMinus_AST;
    }

    public final void postfixExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST postfixExpression_AST = null;
        AST ta1_AST = null;
        Token lp = null;
        AST lp_AST = null;
        Token lp3 = null;
        AST lp3_AST = null;
        AST ta2_AST = null;
        Token lps = null;
        AST lps_AST = null;
        Token lb = null;
        AST lb_AST = null;
        Token in = null;
        AST in_AST = null;
        Token de = null;
        AST de_AST = null;

        primaryExpression();
        astFactory.addASTChild(currentAST, returnAST);
        {
            _loop258:
            do {
                if ((LA(1) == DOT) && (LA(2) == LITERAL_this)) {
                    AST tmp213_AST = null;
                    tmp213_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp213_AST);
                    match(DOT);
                    AST tmp214_AST = null;
                    tmp214_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp214_AST);
                    match(LITERAL_this);
                } else if ((LA(1) == DOT) && (_tokenSet_42.member(LA(2)))) {
                    AST tmp215_AST = null;
                    tmp215_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp215_AST);
                    match(DOT);
                    typeArguments();
                    ta1_AST = (AST) returnAST;
                    {
                        switch (LA(1)) {
                            case IDENT: {
                                AST tmp216_AST = null;
                                tmp216_AST = astFactory.create(LT(1));
                                astFactory.addASTChild(currentAST, tmp216_AST);
                                match(IDENT);
                                {
                                    switch (LA(1)) {
                                        case LPAREN: {
                                            lp = LT(1);
                                            lp_AST = astFactory.create(lp);
                                            astFactory.makeASTRoot(currentAST, lp_AST);
                                            match(LPAREN);
                                            if (inputState.guessing == 0) {
                                                lp_AST.setType(METHOD_CALL);
                                            }
                                            if (inputState.guessing == 0) {
                                                astFactory.addASTChild(currentAST, ta1_AST);
                                            }
                                            argList();
                                            astFactory.addASTChild(currentAST, returnAST);
                                            match(RPAREN);
                                            break;
                                        }
                                        case SEMI:
                                        case LBRACK:
                                        case RBRACK:
                                        case DOT:
                                        case LT:
                                        case COMMA:
                                        case QUESTION:
                                        case GT:
                                        case SR:
                                        case BSR:
                                        case STAR:
                                        case RCURLY:
                                        case RPAREN:
                                        case ASSIGN:
                                        case BAND:
                                        case COLON:
                                        case PLUS_ASSIGN:
                                        case MINUS_ASSIGN:
                                        case STAR_ASSIGN:
                                        case DIV_ASSIGN:
                                        case MOD_ASSIGN:
                                        case SR_ASSIGN:
                                        case BSR_ASSIGN:
                                        case SL_ASSIGN:
                                        case BAND_ASSIGN:
                                        case BXOR_ASSIGN:
                                        case BOR_ASSIGN:
                                        case LOR:
                                        case LAND:
                                        case BOR:
                                        case BXOR:
                                        case NOT_EQUAL:
                                        case EQUAL:
                                        case LE:
                                        case GE:
                                        case LITERAL_instanceof:
                                        case SL:
                                        case PLUS:
                                        case MINUS:
                                        case DIV:
                                        case MOD:
                                        case INC:
                                        case DEC: {
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(LT(1), getFilename());
                                        }
                                    }
                                }
                                break;
                            }
                            case LITERAL_super: {
                                AST tmp218_AST = null;
                                tmp218_AST = astFactory.create(LT(1));
                                astFactory.addASTChild(currentAST, tmp218_AST);
                                match(LITERAL_super);
                                {
                                    switch (LA(1)) {
                                        case LPAREN: {
                                            lp3 = LT(1);
                                            lp3_AST = astFactory.create(lp3);
                                            astFactory.makeASTRoot(currentAST, lp3_AST);
                                            match(LPAREN);
                                            if (inputState.guessing == 0) {
                                                lp3_AST.setType(SUPER_CTOR_CALL);
                                            }
                                            if (inputState.guessing == 0) {
                                                astFactory.addASTChild(currentAST, ta1_AST);
                                            }
                                            argList();
                                            astFactory.addASTChild(currentAST, returnAST);
                                            match(RPAREN);
                                            break;
                                        }
                                        case DOT: {
                                            AST tmp220_AST = null;
                                            tmp220_AST = astFactory.create(LT(1));
                                            astFactory.makeASTRoot(currentAST, tmp220_AST);
                                            match(DOT);
                                            typeArguments();
                                            ta2_AST = (AST) returnAST;
                                            AST tmp221_AST = null;
                                            tmp221_AST = astFactory.create(LT(1));
                                            astFactory.addASTChild(currentAST, tmp221_AST);
                                            match(IDENT);
                                            {
                                                switch (LA(1)) {
                                                    case LPAREN: {
                                                        lps = LT(1);
                                                        lps_AST = astFactory.create(lps);
                                                        astFactory.makeASTRoot(currentAST, lps_AST);
                                                        match(LPAREN);
                                                        if (inputState.guessing == 0) {
                                                            lps_AST.setType(METHOD_CALL);
                                                        }
                                                        if (inputState.guessing == 0) {
                                                            astFactory.addASTChild(currentAST, ta2_AST);
                                                        }
                                                        argList();
                                                        astFactory.addASTChild(currentAST, returnAST);
                                                        match(RPAREN);
                                                        break;
                                                    }
                                                    case SEMI:
                                                    case LBRACK:
                                                    case RBRACK:
                                                    case DOT:
                                                    case LT:
                                                    case COMMA:
                                                    case QUESTION:
                                                    case GT:
                                                    case SR:
                                                    case BSR:
                                                    case STAR:
                                                    case RCURLY:
                                                    case RPAREN:
                                                    case ASSIGN:
                                                    case BAND:
                                                    case COLON:
                                                    case PLUS_ASSIGN:
                                                    case MINUS_ASSIGN:
                                                    case STAR_ASSIGN:
                                                    case DIV_ASSIGN:
                                                    case MOD_ASSIGN:
                                                    case SR_ASSIGN:
                                                    case BSR_ASSIGN:
                                                    case SL_ASSIGN:
                                                    case BAND_ASSIGN:
                                                    case BXOR_ASSIGN:
                                                    case BOR_ASSIGN:
                                                    case LOR:
                                                    case LAND:
                                                    case BOR:
                                                    case BXOR:
                                                    case NOT_EQUAL:
                                                    case EQUAL:
                                                    case LE:
                                                    case GE:
                                                    case LITERAL_instanceof:
                                                    case SL:
                                                    case PLUS:
                                                    case MINUS:
                                                    case DIV:
                                                    case MOD:
                                                    case INC:
                                                    case DEC: {
                                                        break;
                                                    }
                                                    default: {
                                                        throw new NoViableAltException(LT(1), getFilename());
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(LT(1), getFilename());
                                        }
                                    }
                                }
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                } else if ((LA(1) == DOT) && (LA(2) == LITERAL_new)) {
                    AST tmp223_AST = null;
                    tmp223_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp223_AST);
                    match(DOT);
                    newExpression();
                    astFactory.addASTChild(currentAST, returnAST);
                } else if ((LA(1) == LBRACK)) {
                    lb = LT(1);
                    lb_AST = astFactory.create(lb);
                    astFactory.makeASTRoot(currentAST, lb_AST);
                    match(LBRACK);
                    if (inputState.guessing == 0) {
                        lb_AST.setType(INDEX_OP);
                    }
                    expression();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RBRACK);
                } else {
                    break _loop258;
                }

            } while (true);
        }
        {
            switch (LA(1)) {
                case INC: {
                    in = LT(1);
                    in_AST = astFactory.create(in);
                    astFactory.makeASTRoot(currentAST, in_AST);
                    match(INC);
                    if (inputState.guessing == 0) {
                        in_AST.setType(POST_INC);
                    }
                    break;
                }
                case DEC: {
                    de = LT(1);
                    de_AST = astFactory.create(de);
                    astFactory.makeASTRoot(currentAST, de_AST);
                    match(DEC);
                    if (inputState.guessing == 0) {
                        de_AST.setType(POST_DEC);
                    }
                    break;
                }
                case SEMI:
                case RBRACK:
                case LT:
                case COMMA:
                case QUESTION:
                case GT:
                case SR:
                case BSR:
                case STAR:
                case RCURLY:
                case RPAREN:
                case ASSIGN:
                case BAND:
                case COLON:
                case PLUS_ASSIGN:
                case MINUS_ASSIGN:
                case STAR_ASSIGN:
                case DIV_ASSIGN:
                case MOD_ASSIGN:
                case SR_ASSIGN:
                case BSR_ASSIGN:
                case SL_ASSIGN:
                case BAND_ASSIGN:
                case BXOR_ASSIGN:
                case BOR_ASSIGN:
                case LOR:
                case LAND:
                case BOR:
                case BXOR:
                case NOT_EQUAL:
                case EQUAL:
                case LE:
                case GE:
                case LITERAL_instanceof:
                case SL:
                case PLUS:
                case MINUS:
                case DIV:
                case MOD: {
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        postfixExpression_AST = (AST) currentAST.root;
        returnAST = postfixExpression_AST;
    }

    public final void primaryExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST primaryExpression_AST = null;
        Token lbt = null;
        AST lbt_AST = null;

        switch (LA(1)) {
            case IDENT:
            case LT: {
                identPrimary();
                astFactory.addASTChild(currentAST, returnAST);
                {
                    if ((LA(1) == DOT) && (LA(2) == LITERAL_class)) {
                        AST tmp225_AST = null;
                        tmp225_AST = astFactory.create(LT(1));
                        astFactory.makeASTRoot(currentAST, tmp225_AST);
                        match(DOT);
                        AST tmp226_AST = null;
                        tmp226_AST = astFactory.create(LT(1));
                        astFactory.addASTChild(currentAST, tmp226_AST);
                        match(LITERAL_class);
                    } else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_44.member(LA(2)))) {
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }

                }
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case NUM_INT:
            case CHAR_LITERAL:
            case STRING_LITERAL:
            case NUM_FLOAT:
            case NUM_LONG:
            case NUM_DOUBLE: {
                constant();
                astFactory.addASTChild(currentAST, returnAST);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_true: {
                AST tmp227_AST = null;
                tmp227_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp227_AST);
                match(LITERAL_true);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_false: {
                AST tmp228_AST = null;
                tmp228_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp228_AST);
                match(LITERAL_false);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_null: {
                AST tmp229_AST = null;
                tmp229_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp229_AST);
                match(LITERAL_null);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_new: {
                newExpression();
                astFactory.addASTChild(currentAST, returnAST);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_this: {
                AST tmp230_AST = null;
                tmp230_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp230_AST);
                match(LITERAL_this);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_super: {
                AST tmp231_AST = null;
                tmp231_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp231_AST);
                match(LITERAL_super);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LPAREN: {
                match(LPAREN);
                assignmentExpression();
                astFactory.addASTChild(currentAST, returnAST);
                match(RPAREN);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            case LITERAL_void:
            case LITERAL_boolean:
            case LITERAL_byte:
            case LITERAL_char:
            case LITERAL_short:
            case LITERAL_int:
            case LITERAL_float:
            case LITERAL_long:
            case LITERAL_double: {
                builtInType();
                astFactory.addASTChild(currentAST, returnAST);
                {
                    _loop263:
                    do {
                        if ((LA(1) == LBRACK)) {
                            lbt = LT(1);
                            lbt_AST = astFactory.create(lbt);
                            astFactory.makeASTRoot(currentAST, lbt_AST);
                            match(LBRACK);
                            if (inputState.guessing == 0) {
                                lbt_AST.setType(ARRAY_DECLARATOR);
                            }
                            match(RBRACK);
                        } else {
                            break _loop263;
                        }

                    } while (true);
                }
                AST tmp235_AST = null;
                tmp235_AST = astFactory.create(LT(1));
                astFactory.makeASTRoot(currentAST, tmp235_AST);
                match(DOT);
                AST tmp236_AST = null;
                tmp236_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp236_AST);
                match(LITERAL_class);
                primaryExpression_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = primaryExpression_AST;
    }

    /**
     * object instantiation.
     * Trees are built as illustrated by the following input/tree pairs:
     * <p/>
     * new T()
     * <p/>
     * new
     * |
     * T --  ELIST
     * |
     * arg1 -- arg2 -- .. -- argn
     * <p/>
     * new int[]
     * <p/>
     * new
     * |
     * int -- ARRAY_DECLARATOR
     * <p/>
     * new int[] {1,2}
     * <p/>
     * new
     * |
     * int -- ARRAY_DECLARATOR -- ARRAY_INIT
     * |
     * EXPR -- EXPR
     * |      |
     * 1      2
     * <p/>
     * new int[3]
     * new
     * |
     * int -- ARRAY_DECLARATOR
     * |
     * EXPR
     * |
     * 3
     * <p/>
     * new int[1][2]
     * <p/>
     * new
     * |
     * int -- ARRAY_DECLARATOR
     * |
     * ARRAY_DECLARATOR -- EXPR
     * |              |
     * EXPR             1
     * |
     * 2
     * <p/>
     * Note that the typeArguments are no error here, you can write things like:
     * Foo f = new <Bar> Foo <Baz> ();
     * The first type arguments are for the constructor, the second for the class.
     */
    public final void newExpression() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST newExpression_AST = null;

        AST tmp237_AST = null;
        tmp237_AST = astFactory.create(LT(1));
        astFactory.makeASTRoot(currentAST, tmp237_AST);
        match(LITERAL_new);
        typeArguments();
        astFactory.addASTChild(currentAST, returnAST);
        type();
        astFactory.addASTChild(currentAST, returnAST);
        {
            switch (LA(1)) {
                case LPAREN: {
                    match(LPAREN);
                    argList();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RPAREN);
                    {
                        switch (LA(1)) {
                            case LCURLY: {
                                classBlock();
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case SEMI:
                            case LBRACK:
                            case RBRACK:
                            case DOT:
                            case LT:
                            case COMMA:
                            case QUESTION:
                            case GT:
                            case SR:
                            case BSR:
                            case STAR:
                            case RCURLY:
                            case RPAREN:
                            case ASSIGN:
                            case BAND:
                            case COLON:
                            case PLUS_ASSIGN:
                            case MINUS_ASSIGN:
                            case STAR_ASSIGN:
                            case DIV_ASSIGN:
                            case MOD_ASSIGN:
                            case SR_ASSIGN:
                            case BSR_ASSIGN:
                            case SL_ASSIGN:
                            case BAND_ASSIGN:
                            case BXOR_ASSIGN:
                            case BOR_ASSIGN:
                            case LOR:
                            case LAND:
                            case BOR:
                            case BXOR:
                            case NOT_EQUAL:
                            case EQUAL:
                            case LE:
                            case GE:
                            case LITERAL_instanceof:
                            case SL:
                            case PLUS:
                            case MINUS:
                            case DIV:
                            case MOD:
                            case INC:
                            case DEC: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    break;
                }
                case LBRACK: {
                    newArrayDeclarator();
                    astFactory.addASTChild(currentAST, returnAST);
                    {
                        switch (LA(1)) {
                            case LCURLY: {
                                arrayInitializer();
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case SEMI:
                            case LBRACK:
                            case RBRACK:
                            case DOT:
                            case LT:
                            case COMMA:
                            case QUESTION:
                            case GT:
                            case SR:
                            case BSR:
                            case STAR:
                            case RCURLY:
                            case RPAREN:
                            case ASSIGN:
                            case BAND:
                            case COLON:
                            case PLUS_ASSIGN:
                            case MINUS_ASSIGN:
                            case STAR_ASSIGN:
                            case DIV_ASSIGN:
                            case MOD_ASSIGN:
                            case SR_ASSIGN:
                            case BSR_ASSIGN:
                            case SL_ASSIGN:
                            case BAND_ASSIGN:
                            case BXOR_ASSIGN:
                            case BOR_ASSIGN:
                            case LOR:
                            case LAND:
                            case BOR:
                            case BXOR:
                            case NOT_EQUAL:
                            case EQUAL:
                            case LE:
                            case GE:
                            case LITERAL_instanceof:
                            case SL:
                            case PLUS:
                            case MINUS:
                            case DIV:
                            case MOD:
                            case INC:
                            case DEC: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    break;
                }
                default: {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
        }
        newExpression_AST = (AST) currentAST.root;
        returnAST = newExpression_AST;
    }

    /**
     * Match a, a.b.c refs, a.b.c(...) refs, a.b.c[], a.b.c[].class,
     * and a.b.c.class refs.  Also this(...) and super(...).  Match
     * this or super.
     */
    public final void identPrimary() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST identPrimary_AST = null;
        AST ta1_AST = null;
        AST ta2_AST = null;
        Token lp = null;
        AST lp_AST = null;
        Token lbc = null;
        AST lbc_AST = null;

        typeArguments();
        ta1_AST = (AST) returnAST;
        AST tmp240_AST = null;
        tmp240_AST = astFactory.create(LT(1));
        astFactory.addASTChild(currentAST, tmp240_AST);
        match(IDENT);
        {
            _loop268:
            do {
                boolean synPredMatched267 = false;
                if (((LA(1) == DOT) && (LA(2) == IDENT || LA(2) == LT))) {
                    int _m267 = mark();
                    synPredMatched267 = true;
                    inputState.guessing++;
                    try {
                        {
                            match(DOT);
                            typeArguments();
                            match(IDENT);
                        }
                    }
                    catch (RecognitionException pe) {
                        synPredMatched267 = false;
                    }
                    rewind(_m267);
                    inputState.guessing--;
                }
                if (synPredMatched267) {
                    AST tmp241_AST = null;
                    tmp241_AST = astFactory.create(LT(1));
                    astFactory.makeASTRoot(currentAST, tmp241_AST);
                    match(DOT);
                    typeArguments();
                    ta2_AST = (AST) returnAST;
                    AST tmp242_AST = null;
                    tmp242_AST = astFactory.create(LT(1));
                    astFactory.addASTChild(currentAST, tmp242_AST);
                    match(IDENT);
                } else if (((_tokenSet_45.member(LA(1))) && (_tokenSet_44.member(LA(2)))) && (false)) {
                } else {
                    break _loop268;
                }

            } while (true);
        }
        {
            if ((LA(1) == LPAREN)) {
                {
                    lp = LT(1);
                    lp_AST = astFactory.create(lp);
                    astFactory.makeASTRoot(currentAST, lp_AST);
                    match(LPAREN);
                    if (inputState.guessing == 0) {
                        lp_AST.setType(METHOD_CALL);
                    }
                    if (inputState.guessing == 0) {
                        if (ta2_AST != null) astFactory.addASTChild(currentAST, ta2_AST);
                    }
                    if (inputState.guessing == 0) {
                        if (ta2_AST == null) astFactory.addASTChild(currentAST, ta1_AST);
                    }
                    argList();
                    astFactory.addASTChild(currentAST, returnAST);
                    match(RPAREN);
                }
            } else if ((LA(1) == LBRACK) && (LA(2) == RBRACK)) {
                {
                    int _cnt272 = 0;
                    _loop272:
                    do {
                        if ((LA(1) == LBRACK) && (LA(2) == RBRACK)) {
                            lbc = LT(1);
                            lbc_AST = astFactory.create(lbc);
                            astFactory.makeASTRoot(currentAST, lbc_AST);
                            match(LBRACK);
                            if (inputState.guessing == 0) {
                                lbc_AST.setType(ARRAY_DECLARATOR);
                            }
                            match(RBRACK);
                        } else {
                            if (_cnt272 >= 1) {
                                break _loop272;
                            } else {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }

                        _cnt272++;
                    } while (true);
                }
            } else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_44.member(LA(2)))) {
            } else {
                throw new NoViableAltException(LT(1), getFilename());
            }

        }
        identPrimary_AST = (AST) currentAST.root;
        returnAST = identPrimary_AST;
    }

    public final void constant() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST constant_AST = null;

        switch (LA(1)) {
            case NUM_INT: {
                AST tmp245_AST = null;
                tmp245_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp245_AST);
                match(NUM_INT);
                constant_AST = (AST) currentAST.root;
                break;
            }
            case CHAR_LITERAL: {
                AST tmp246_AST = null;
                tmp246_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp246_AST);
                match(CHAR_LITERAL);
                constant_AST = (AST) currentAST.root;
                break;
            }
            case STRING_LITERAL: {
                AST tmp247_AST = null;
                tmp247_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp247_AST);
                match(STRING_LITERAL);
                constant_AST = (AST) currentAST.root;
                break;
            }
            case NUM_FLOAT: {
                AST tmp248_AST = null;
                tmp248_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp248_AST);
                match(NUM_FLOAT);
                constant_AST = (AST) currentAST.root;
                break;
            }
            case NUM_LONG: {
                AST tmp249_AST = null;
                tmp249_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp249_AST);
                match(NUM_LONG);
                constant_AST = (AST) currentAST.root;
                break;
            }
            case NUM_DOUBLE: {
                AST tmp250_AST = null;
                tmp250_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp250_AST);
                match(NUM_DOUBLE);
                constant_AST = (AST) currentAST.root;
                break;
            }
            default: {
                throw new NoViableAltException(LT(1), getFilename());
            }
        }
        returnAST = constant_AST;
    }

    public final void newArrayDeclarator() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST newArrayDeclarator_AST = null;
        Token lb = null;
        AST lb_AST = null;

        {
            int _cnt282 = 0;
            _loop282:
            do {
                if ((LA(1) == LBRACK) && (_tokenSet_46.member(LA(2)))) {
                    lb = LT(1);
                    lb_AST = astFactory.create(lb);
                    astFactory.makeASTRoot(currentAST, lb_AST);
                    match(LBRACK);
                    if (inputState.guessing == 0) {
                        lb_AST.setType(ARRAY_DECLARATOR);
                    }
                    {
                        switch (LA(1)) {
                            case IDENT:
                            case LT:
                            case LITERAL_super:
                            case LITERAL_void:
                            case LITERAL_boolean:
                            case LITERAL_byte:
                            case LITERAL_char:
                            case LITERAL_short:
                            case LITERAL_int:
                            case LITERAL_float:
                            case LITERAL_long:
                            case LITERAL_double:
                            case LPAREN:
                            case LITERAL_this:
                            case PLUS:
                            case MINUS:
                            case INC:
                            case DEC:
                            case BNOT:
                            case LNOT:
                            case LITERAL_true:
                            case LITERAL_false:
                            case LITERAL_null:
                            case LITERAL_new:
                            case NUM_INT:
                            case CHAR_LITERAL:
                            case STRING_LITERAL:
                            case NUM_FLOAT:
                            case NUM_LONG:
                            case NUM_DOUBLE: {
                                expression();
                                astFactory.addASTChild(currentAST, returnAST);
                                break;
                            }
                            case RBRACK: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(LT(1), getFilename());
                            }
                        }
                    }
                    match(RBRACK);
                } else {
                    if (_cnt282 >= 1) {
                        break _loop282;
                    } else {
                        throw new NoViableAltException(LT(1), getFilename());
                    }
                }

                _cnt282++;
            } while (true);
        }
        newArrayDeclarator_AST = (AST) currentAST.root;
        returnAST = newArrayDeclarator_AST;
    }


    public static final String[] _tokenNames = {
            "<0>",
            "EOF",
            "<2>",
            "NULL_TREE_LOOKAHEAD",
            "BLOCK",
            "MODIFIERS",
            "OBJBLOCK",
            "SLIST",
            "CTOR_DEF",
            "METHOD_DEF",
            "VARIABLE_DEF",
            "INSTANCE_INIT",
            "STATIC_INIT",
            "TYPE",
            "CLASS_DEF",
            "INTERFACE_DEF",
            "PACKAGE_DEF",
            "ARRAY_DECLARATOR",
            "EXTENDS_CLAUSE",
            "IMPLEMENTS_CLAUSE",
            "PARAMETERS",
            "PARAMETER_DEF",
            "LABELED_STAT",
            "TYPECAST",
            "INDEX_OP",
            "POST_INC",
            "POST_DEC",
            "METHOD_CALL",
            "EXPR",
            "ARRAY_INIT",
            "IMPORT",
            "UNARY_MINUS",
            "UNARY_PLUS",
            "CASE_GROUP",
            "ELIST",
            "FOR_INIT",
            "FOR_CONDITION",
            "FOR_ITERATOR",
            "EMPTY_STAT",
            "\"final\"",
            "\"abstract\"",
            "\"strictfp\"",
            "SUPER_CTOR_CALL",
            "CTOR_CALL",
            "ASSERT",
            "TYPE_ARGS",
            "TYPE_ARGS_END",
            "TYPE_PARAMS",
            "WILDCARD",
            "ENUM",
            "ENUM_DEF",
            "ENUM_CONST",
            "ENUM_CONST_INIT",
            "ANNOTATION_DEF",
            "ANNOTATION_MEMBER_DEF",
            "ANNOTATION",
            "ANNOTATIONS",
            "ANNOTATION_INIT_EMPTY",
            "ANNOTATION_INIT_VALUE",
            "ANNOTATION_INIT_LIST",
            "ANNOTATION_INIT_MEMBER",
            "ANNOTATION_ARRAY_INIT",
            "\"package\"",
            "SEMI",
            "\"import\"",
            "\"static\"",
            "LBRACK",
            "RBRACK",
            "IDENT",
            "DOT",
            "LT",
            "COMMA",
            "QUESTION",
            "\"extends\"",
            "\"super\"",
            "GT",
            "SR",
            "BSR",
            "\"void\"",
            "\"boolean\"",
            "\"byte\"",
            "\"char\"",
            "\"short\"",
            "\"int\"",
            "\"float\"",
            "\"long\"",
            "\"double\"",
            "STAR",
            "\"private\"",
            "\"public\"",
            "\"protected\"",
            "\"transient\"",
            "\"native\"",
            "\"threadsafe\"",
            "\"synchronized\"",
            "\"volatile\"",
            "LCURLY",
            "RCURLY",
            "LPAREN",
            "RPAREN",
            "AT",
            "\"interface\"",
            "\"default\"",
            "ASSIGN",
            "\"class\"",
            "BAND",
            "\"implements\"",
            "\"this\"",
            "\"throws\"",
            "ELLIPSIS",
            "COLON",
            "\"if\"",
            "\"else\"",
            "\"for\"",
            "\"while\"",
            "\"do\"",
            "\"break\"",
            "\"continue\"",
            "\"return\"",
            "\"switch\"",
            "\"throw\"",
            "\"case\"",
            "\"try\"",
            "\"finally\"",
            "\"catch\"",
            "PLUS_ASSIGN",
            "MINUS_ASSIGN",
            "STAR_ASSIGN",
            "DIV_ASSIGN",
            "MOD_ASSIGN",
            "SR_ASSIGN",
            "BSR_ASSIGN",
            "SL_ASSIGN",
            "BAND_ASSIGN",
            "BXOR_ASSIGN",
            "BOR_ASSIGN",
            "LOR",
            "LAND",
            "BOR",
            "BXOR",
            "NOT_EQUAL",
            "EQUAL",
            "LE",
            "GE",
            "\"instanceof\"",
            "SL",
            "PLUS",
            "MINUS",
            "DIV",
            "MOD",
            "INC",
            "DEC",
            "BNOT",
            "LNOT",
            "\"true\"",
            "\"false\"",
            "\"null\"",
            "\"new\"",
            "NUM_INT",
            "CHAR_LITERAL",
            "STRING_LITERAL",
            "NUM_FLOAT",
            "NUM_LONG",
            "NUM_DOUBLE",
            "WS",
            "SL_COMMENT",
            "ML_COMMENT",
            "ESC",
            "HEX_DIGIT",
            "EXPONENT",
            "FLOAT_SUFFIX"
    };

    protected void buildTokenTypeASTClassMap() {
        tokenTypeToASTClassMap = null;
    }

    ;

    private static final long[] mk_tokenSet_0() {
        long[] data = {-9222805238610657278L, 1309948248067L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

    private static final long[] mk_tokenSet_1() {
        long[] data = {-9222805238610657278L, 1309948248082L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());

    private static final long[] mk_tokenSet_2() {
        long[] data = {-9222805238610657280L, 1309948248066L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());

    private static final long[] mk_tokenSet_3() {
        long[] data = {-9222805238610657278L, 1309948248066L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

    private static final long[] mk_tokenSet_4() {
        long[] data = {3848290697216L, 4278190082L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());

    private static final long[] mk_tokenSet_5() {
        long[] data = {0L, 8372496L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());

    private static final long[] mk_tokenSet_6() {
        long[] data = {-9223372036854775808L, -2305721448745926724L, 16383L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

    private static final long[] mk_tokenSet_7() {
        long[] data = {-4611101627997224960L, -1729399849096314882L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());

    private static final long[] mk_tokenSet_8() {
        long[] data = {0L, 8372240L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());

    private static final long[] mk_tokenSet_9() {
        long[] data = {566798244118528L, 1309956620370L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());

    private static final long[] mk_tokenSet_10() {
        long[] data = {566798244118528L, 1327136489590L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());

    private static final long[] mk_tokenSet_11() {
        long[] data = {0L, 116L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());

    private static final long[] mk_tokenSet_12() {
        long[] data = {-9223372036854775808L, 549755814020L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());

    private static final long[] mk_tokenSet_13() {
        long[] data = {0L, 8886295708752L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());

    private static final long[] mk_tokenSet_14() {
        long[] data = {0L, 11128277040628L, 68719476480L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());

    private static final long[] mk_tokenSet_15() {
        long[] data = {0L, 4402349865616L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());

    private static final long[] mk_tokenSet_16() {
        long[] data = {-9222805238610657280L, 5738067903094L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());

    private static final long[] mk_tokenSet_17() {
        long[] data = {-9222787646424612864L, 431933341848028242L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());

    private static final long[] mk_tokenSet_18() {
        long[] data = {0L, 8796093023296L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());

    private static final long[] mk_tokenSet_19() {
        long[] data = {0L, 17188241680L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());

    private static final long[] mk_tokenSet_20() {
        long[] data = {-9222787646424612864L, 431933350437962834L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());

    private static final long[] mk_tokenSet_21() {
        long[] data = {-9222787646424612864L, -1873836403805127306L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());

    private static final long[] mk_tokenSet_22() {
        long[] data = {-9222787646424612864L, 576330288368436306L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());

    private static final long[] mk_tokenSet_23() {
        long[] data = {-9222787646424612864L, -57208964383370L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());

    private static final long[] mk_tokenSet_24() {
        long[] data = {549755813888L, 68727848976L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());

    private static final long[] mk_tokenSet_25() {
        long[] data = {549755813888L, 35253099937908L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());

    private static final long[] mk_tokenSet_26() {
        long[] data = {-9223368188564078592L, 8886278931538L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());

    private static final long[] mk_tokenSet_27() {
        long[] data = {-9223368188564078592L, -2305831374147289610L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());

    private static final long[] mk_tokenSet_28() {
        long[] data = {3848290697216L, 73006039058L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());

    private static final long[] mk_tokenSet_29() {
        long[] data = {3848290697216L, 73006039158L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());

    private static final long[] mk_tokenSet_30() {
        long[] data = {0L, 8813281264720L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());

    private static final long[] mk_tokenSet_31() {
        long[] data = {-9223372036854775808L, -2305831447144956556L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());

    private static final long[] mk_tokenSet_32() {
        long[] data = {566798244118528L, 1172509294594L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());

    private static final long[] mk_tokenSet_33() {
        long[] data = {566798244118528L, 1172509294610L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());

    private static final long[] mk_tokenSet_34() {
        long[] data = {0L, 8817576232016L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());

    private static final long[] mk_tokenSet_35() {
        long[] data = {-9223372036854775808L, -2305831447144956428L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());

    private static final long[] mk_tokenSet_36() {
        long[] data = {0L, 79182025442384L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());

    private static final long[] mk_tokenSet_37() {
        long[] data = {0L, 2112L, 49152L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());

    private static final long[] mk_tokenSet_38() {
        long[] data = {0L, 12288L, 131072L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());

    private static final long[] mk_tokenSet_39() {
        long[] data = {0L, 8388608L, 3145728L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());

    private static final long[] mk_tokenSet_40() {
        long[] data = {0L, 8813281264720L, 68652367872L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());

    private static final long[] mk_tokenSet_41() {
        long[] data = {-9223372036854775808L, -2305761035451105796L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());

    private static final long[] mk_tokenSet_42() {
        long[] data = {0L, 1104L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());

    private static final long[] mk_tokenSet_43() {
        long[] data = {-9223372036854775808L, -2305769848732370452L, 16777215L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());

    private static final long[] mk_tokenSet_44() {
        long[] data = {-4611101627997224960L, -1729439431514915330L, 68719476735L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());

    private static final long[] mk_tokenSet_45() {
        long[] data = {-9223372036854775808L, -2305769831552501268L, 16777215L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());

    private static final long[] mk_tokenSet_46() {
        long[] data = {0L, 8813281264728L, 68716068864L, 0L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());

}
