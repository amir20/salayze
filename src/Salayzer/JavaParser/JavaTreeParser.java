package Salayzer.JavaParser;// $ANTLR 2.7.5 (20050128): "java.tree.g" -> "Salyze.JavaParser.JavaLexer.Lexer.JavaTreeParser.java"$

import antlr.NoViableAltException;
import antlr.RecognitionException;
import antlr.collections.AST;
import antlr.collections.impl.BitSet;


/**
 * Java 1.3 AST Recognizer Grammar
 * <p/>
 * Author: (see java.g preamble)
 * <p/>
 * This grammar is in the PUBLIC DOMAIN
 */
public class JavaTreeParser extends antlr.TreeParser implements JavaTreeParserTokenTypes {
    public JavaTreeParser() {
        tokenNames = _tokenNames;
    }

    public final void compilationUnit(AST _t) throws RecognitionException {

        AST compilationUnit_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case PACKAGE_DEF: {
                        packageDefinition(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3:
                    case CLASS_DEF:
                    case INTERFACE_DEF:
                    case IMPORT:
                    case ENUM_DEF:
                    case ANNOTATION_DEF: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            {
                _loop4:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == IMPORT)) {
                        importDefinition(_t);
                        _t = _retTree;
                    } else {
                        break _loop4;
                    }

                } while (true);
            }
            {
                _loop6:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_tokenSet_0.member(_t.getType()))) {
                        typeDefinition(_t);
                        _t = _retTree;
                    } else {
                        break _loop6;
                    }

                } while (true);
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void packageDefinition(AST _t) throws RecognitionException {

        AST packageDefinition_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t8 = _t;
            AST tmp1_AST_in = (AST) _t;
            match(_t, PACKAGE_DEF);
            _t = _t.getFirstChild();
            annotations(_t);
            _t = _retTree;
            identifier(_t);
            _t = _retTree;
            _t = __t8;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void importDefinition(AST _t) throws RecognitionException {

        AST importDefinition_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t10 = _t;
            AST tmp2_AST_in = (AST) _t;
            match(_t, IMPORT);
            _t = _t.getFirstChild();
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case LITERAL_static: {
                        AST tmp3_AST_in = (AST) _t;
                        match(_t, LITERAL_static);
                        _t = _t.getNextSibling();
                        break;
                    }
                    case IDENT:
                    case DOT: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            identifierStar(_t);
            _t = _retTree;
            _t = __t10;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void typeDefinition(AST _t) throws RecognitionException {

        AST typeDefinition_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case CLASS_DEF: {
                    AST __t13 = _t;
                    AST tmp4_AST_in = (AST) _t;
                    match(_t, CLASS_DEF);
                    _t = _t.getFirstChild();
                    modifiers(_t);
                    _t = _retTree;
                    AST tmp5_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    typeParameters(_t);
                    _t = _retTree;
                    extendsClause(_t);
                    _t = _retTree;
                    implementsClause(_t);
                    _t = _retTree;
                    objBlock(_t);
                    _t = _retTree;
                    _t = __t13;
                    _t = _t.getNextSibling();
                    break;
                }
                case INTERFACE_DEF: {
                    AST __t14 = _t;
                    AST tmp6_AST_in = (AST) _t;
                    match(_t, INTERFACE_DEF);
                    _t = _t.getFirstChild();
                    modifiers(_t);
                    _t = _retTree;
                    AST tmp7_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    typeParameters(_t);
                    _t = _retTree;
                    extendsClause(_t);
                    _t = _retTree;
                    interfaceBlock(_t);
                    _t = _retTree;
                    _t = __t14;
                    _t = _t.getNextSibling();
                    break;
                }
                case ENUM_DEF: {
                    AST __t15 = _t;
                    AST tmp8_AST_in = (AST) _t;
                    match(_t, ENUM_DEF);
                    _t = _t.getFirstChild();
                    modifiers(_t);
                    _t = _retTree;
                    AST tmp9_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    implementsClause(_t);
                    _t = _retTree;
                    enumBlock(_t);
                    _t = _retTree;
                    _t = __t15;
                    _t = _t.getNextSibling();
                    break;
                }
                case ANNOTATION_DEF: {
                    AST __t16 = _t;
                    AST tmp10_AST_in = (AST) _t;
                    match(_t, ANNOTATION_DEF);
                    _t = _t.getFirstChild();
                    modifiers(_t);
                    _t = _retTree;
                    AST tmp11_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    annotationBlock(_t);
                    _t = _retTree;
                    _t = __t16;
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotations(AST _t) throws RecognitionException {

        AST annotations_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t90 = _t;
            AST tmp12_AST_in = (AST) _t;
            match(_t, ANNOTATIONS);
            _t = _t.getFirstChild();
            {
                _loop92:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == ANNOTATION)) {
                        annotation(_t);
                        _t = _retTree;
                    } else {
                        break _loop92;
                    }

                } while (true);
            }
            _t = __t90;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void identifier(AST _t) throws RecognitionException {

        AST identifier_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT: {
                    AST tmp13_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    break;
                }
                case DOT: {
                    AST __t138 = _t;
                    AST tmp14_AST_in = (AST) _t;
                    match(_t, DOT);
                    _t = _t.getFirstChild();
                    identifier(_t);
                    _t = _retTree;
                    AST tmp15_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    _t = __t138;
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void identifierStar(AST _t) throws RecognitionException {

        AST identifierStar_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT: {
                    AST tmp16_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    break;
                }
                case DOT: {
                    AST __t140 = _t;
                    AST tmp17_AST_in = (AST) _t;
                    match(_t, DOT);
                    _t = _t.getFirstChild();
                    identifier(_t);
                    _t = _retTree;
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case STAR: {
                                AST tmp18_AST_in = (AST) _t;
                                match(_t, STAR);
                                _t = _t.getNextSibling();
                                break;
                            }
                            case IDENT: {
                                AST tmp19_AST_in = (AST) _t;
                                match(_t, IDENT);
                                _t = _t.getNextSibling();
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t140;
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void modifiers(AST _t) throws RecognitionException {

        AST modifiers_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t45 = _t;
            AST tmp20_AST_in = (AST) _t;
            match(_t, MODIFIERS);
            _t = _t.getFirstChild();
            {
                _loop47:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case FINAL:
                        case ABSTRACT:
                        case STRICTFP:
                        case LITERAL_static:
                        case LITERAL_private:
                        case LITERAL_public:
                        case LITERAL_protected:
                        case LITERAL_transient:
                        case LITERAL_native:
                        case LITERAL_threadsafe:
                        case LITERAL_synchronized:
                        case LITERAL_volatile:
                        case LITERAL_const: {
                            modifier(_t);
                            _t = _retTree;
                            break;
                        }
                        case ANNOTATION: {
                            annotation(_t);
                            _t = _retTree;
                            break;
                        }
                        default: {
                            break _loop47;
                        }
                    }
                } while (true);
            }
            _t = __t45;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void typeParameters(AST _t) throws RecognitionException {

        AST typeParameters_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t26 = _t;
            AST tmp21_AST_in = (AST) _t;
            match(_t, TYPE_PARAMS);
            _t = _t.getFirstChild();
            {
                _loop28:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == IDENT)) {
                        typeParameter(_t);
                        _t = _retTree;
                    } else {
                        break _loop28;
                    }

                } while (true);
            }
            _t = __t26;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void extendsClause(AST _t) throws RecognitionException {

        AST extendsClause_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t50 = _t;
            AST tmp22_AST_in = (AST) _t;
            match(_t, EXTENDS_CLAUSE);
            _t = _t.getFirstChild();
            {
                _loop52:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == IDENT || _t.getType() == DOT)) {
                        classOrInterfaceType(_t);
                        _t = _retTree;
                    } else {
                        break _loop52;
                    }

                } while (true);
            }
            _t = __t50;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void implementsClause(AST _t) throws RecognitionException {

        AST implementsClause_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t54 = _t;
            AST tmp23_AST_in = (AST) _t;
            match(_t, IMPLEMENTS_CLAUSE);
            _t = _t.getFirstChild();
            {
                _loop56:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == IDENT || _t.getType() == DOT)) {
                        classOrInterfaceType(_t);
                        _t = _retTree;
                    } else {
                        break _loop56;
                    }

                } while (true);
            }
            _t = __t54;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void objBlock(AST _t) throws RecognitionException {

        AST objBlock_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t62 = _t;
            AST tmp24_AST_in = (AST) _t;
            match(_t, OBJBLOCK);
            _t = _t.getFirstChild();
            {
                _loop66:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case CTOR_DEF: {
                            ctorDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case METHOD_DEF: {
                            methodDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case VARIABLE_DEF: {
                            variableDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case CLASS_DEF:
                        case INTERFACE_DEF:
                        case ENUM_DEF:
                        case ANNOTATION_DEF: {
                            typeDefinition(_t);
                            _t = _retTree;
                            break;
                        }
                        case STATIC_INIT: {
                            AST __t64 = _t;
                            AST tmp25_AST_in = (AST) _t;
                            match(_t, STATIC_INIT);
                            _t = _t.getFirstChild();
                            slist(_t);
                            _t = _retTree;
                            _t = __t64;
                            _t = _t.getNextSibling();
                            break;
                        }
                        case INSTANCE_INIT: {
                            AST __t65 = _t;
                            AST tmp26_AST_in = (AST) _t;
                            match(_t, INSTANCE_INIT);
                            _t = _t.getFirstChild();
                            slist(_t);
                            _t = _retTree;
                            _t = __t65;
                            _t = _t.getNextSibling();
                            break;
                        }
                        default: {
                            break _loop66;
                        }
                    }
                } while (true);
            }
            _t = __t62;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void interfaceBlock(AST _t) throws RecognitionException {

        AST interfaceBlock_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t58 = _t;
            AST tmp27_AST_in = (AST) _t;
            match(_t, OBJBLOCK);
            _t = _t.getFirstChild();
            {
                _loop60:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case METHOD_DEF: {
                            methodDecl(_t);
                            _t = _retTree;
                            break;
                        }
                        case VARIABLE_DEF: {
                            variableDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case CLASS_DEF:
                        case INTERFACE_DEF:
                        case ENUM_DEF:
                        case ANNOTATION_DEF: {
                            typeDefinition(_t);
                            _t = _retTree;
                            break;
                        }
                        default: {
                            break _loop60;
                        }
                    }
                } while (true);
            }
            _t = __t58;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void enumBlock(AST _t) throws RecognitionException {

        AST enumBlock_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t68 = _t;
            AST tmp28_AST_in = (AST) _t;
            match(_t, OBJBLOCK);
            _t = _t.getFirstChild();
            {
                _loop70:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == ENUM_CONST)) {
                        enumConst(_t);
                        _t = _retTree;
                    } else {
                        break _loop70;
                    }

                } while (true);
            }
            {
                _loop74:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case CTOR_DEF: {
                            ctorDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case METHOD_DEF: {
                            methodDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case VARIABLE_DEF: {
                            variableDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case CLASS_DEF:
                        case INTERFACE_DEF:
                        case ENUM_DEF:
                        case ANNOTATION_DEF: {
                            typeDefinition(_t);
                            _t = _retTree;
                            break;
                        }
                        case STATIC_INIT: {
                            AST __t72 = _t;
                            AST tmp29_AST_in = (AST) _t;
                            match(_t, STATIC_INIT);
                            _t = _t.getFirstChild();
                            slist(_t);
                            _t = _retTree;
                            _t = __t72;
                            _t = _t.getNextSibling();
                            break;
                        }
                        case INSTANCE_INIT: {
                            AST __t73 = _t;
                            AST tmp30_AST_in = (AST) _t;
                            match(_t, INSTANCE_INIT);
                            _t = _t.getFirstChild();
                            slist(_t);
                            _t = _retTree;
                            _t = __t73;
                            _t = _t.getNextSibling();
                            break;
                        }
                        default: {
                            break _loop74;
                        }
                    }
                } while (true);
            }
            _t = __t68;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotationBlock(AST _t) throws RecognitionException {

        AST annotationBlock_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t82 = _t;
            AST tmp31_AST_in = (AST) _t;
            match(_t, OBJBLOCK);
            _t = _t.getFirstChild();
            {
                _loop84:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case ANNOTATION_MEMBER_DEF: {
                            annotationMember(_t);
                            _t = _retTree;
                            break;
                        }
                        case VARIABLE_DEF: {
                            variableDef(_t);
                            _t = _retTree;
                            break;
                        }
                        case CLASS_DEF:
                        case INTERFACE_DEF:
                        case ENUM_DEF:
                        case ANNOTATION_DEF: {
                            typeDefinition(_t);
                            _t = _retTree;
                            break;
                        }
                        default: {
                            break _loop84;
                        }
                    }
                } while (true);
            }
            _t = __t82;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void simpleTypeSpecArray(AST _t) throws RecognitionException {

        AST simpleTypeSpecArray_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case ARRAY_DECLARATOR: {
                    AST __t18 = _t;
                    AST tmp32_AST_in = (AST) _t;
                    match(_t, ARRAY_DECLARATOR);
                    _t = _t.getFirstChild();
                    simpleTypeSpecArray(_t);
                    _t = _retTree;
                    _t = __t18;
                    _t = _t.getNextSibling();
                    break;
                }
                case IDENT:
                case DOT:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double: {
                    simpleType(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void simpleType(AST _t) throws RecognitionException {

        AST simpleType_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT:
                case DOT: {
                    identifier(_t);
                    _t = _retTree;
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
                    builtInType(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void builtInType(AST _t) throws RecognitionException {

        AST builtInType_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case LITERAL_void: {
                    AST tmp33_AST_in = (AST) _t;
                    match(_t, LITERAL_void);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_boolean: {
                    AST tmp34_AST_in = (AST) _t;
                    match(_t, LITERAL_boolean);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_byte: {
                    AST tmp35_AST_in = (AST) _t;
                    match(_t, LITERAL_byte);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_char: {
                    AST tmp36_AST_in = (AST) _t;
                    match(_t, LITERAL_char);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_short: {
                    AST tmp37_AST_in = (AST) _t;
                    match(_t, LITERAL_short);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_int: {
                    AST tmp38_AST_in = (AST) _t;
                    match(_t, LITERAL_int);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_float: {
                    AST tmp39_AST_in = (AST) _t;
                    match(_t, LITERAL_float);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_long: {
                    AST tmp40_AST_in = (AST) _t;
                    match(_t, LITERAL_long);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_double: {
                    AST tmp41_AST_in = (AST) _t;
                    match(_t, LITERAL_double);
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void typeSpec(AST _t) throws RecognitionException {

        AST typeSpec_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t21 = _t;
            AST tmp42_AST_in = (AST) _t;
            match(_t, TYPE);
            _t = _t.getFirstChild();
            typeSpecArray(_t);
            _t = _retTree;
            _t = __t21;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void typeSpecArray(AST _t) throws RecognitionException {

        AST typeSpecArray_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case ARRAY_DECLARATOR: {
                    AST __t23 = _t;
                    AST tmp43_AST_in = (AST) _t;
                    match(_t, ARRAY_DECLARATOR);
                    _t = _t.getFirstChild();
                    typeSpecArray(_t);
                    _t = _retTree;
                    _t = __t23;
                    _t = _t.getNextSibling();
                    break;
                }
                case IDENT:
                case DOT:
                case LITERAL_void:
                case LITERAL_boolean:
                case LITERAL_byte:
                case LITERAL_char:
                case LITERAL_short:
                case LITERAL_int:
                case LITERAL_float:
                case LITERAL_long:
                case LITERAL_double: {
                    type(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void type(AST _t) throws RecognitionException {

        AST type_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT:
                case DOT: {
                    classOrInterfaceType(_t);
                    _t = _retTree;
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
                    builtInType(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void classOrInterfaceType(AST _t) throws RecognitionException {

        AST classOrInterfaceType_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT: {
                    AST tmp44_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    typeArguments(_t);
                    _t = _retTree;
                    break;
                }
                case DOT: {
                    AST __t34 = _t;
                    AST tmp45_AST_in = (AST) _t;
                    match(_t, DOT);
                    _t = _t.getFirstChild();
                    classOrInterfaceType(_t);
                    _t = _retTree;
                    AST tmp46_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    typeArguments(_t);
                    _t = _retTree;
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case ELLIPSIS: {
                                AST tmp47_AST_in = (AST) _t;
                                match(_t, ELLIPSIS);
                                _t = _t.getNextSibling();
                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t34;
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void typeParameter(AST _t) throws RecognitionException {

        AST typeParameter_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST tmp48_AST_in = (AST) _t;
            match(_t, IDENT);
            _t = _t.getNextSibling();
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case LITERAL_extends: {
                        AST tmp49_AST_in = (AST) _t;
                        match(_t, LITERAL_extends);
                        _t = _t.getNextSibling();
                        {
                            int _cnt32 = 0;
                            _loop32:
                            do {
                                if (_t == null) _t = ASTNULL;
                                if ((_t.getType() == TYPE)) {
                                    typeSpec(_t);
                                    _t = _retTree;
                                } else {
                                    if (_cnt32 >= 1) {
                                        break _loop32;
                                    } else {
                                        throw new NoViableAltException(_t);
                                    }
                                }

                                _cnt32++;
                            } while (true);
                        }
                        break;
                    }
                    case 3:
                    case IDENT: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void typeArguments(AST _t) throws RecognitionException {

        AST typeArguments_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t37 = _t;
            AST tmp50_AST_in = (AST) _t;
            match(_t, TYPE_ARGS);
            _t = _t.getFirstChild();
            {
                _loop42:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case TYPE: {
                            typeSpec(_t);
                            _t = _retTree;
                            break;
                        }
                        case WILDCARD: {
                            AST __t39 = _t;
                            AST tmp51_AST_in = (AST) _t;
                            match(_t, WILDCARD);
                            _t = _t.getFirstChild();
                            {
                                if (_t == null) _t = ASTNULL;
                                switch (_t.getType()) {
                                    case LITERAL_extends:
                                    case LITERAL_super: {
                                        {
                                            if (_t == null) _t = ASTNULL;
                                            switch (_t.getType()) {
                                                case LITERAL_extends: {
                                                    AST tmp52_AST_in = (AST) _t;
                                                    match(_t, LITERAL_extends);
                                                    _t = _t.getNextSibling();
                                                    break;
                                                }
                                                case LITERAL_super: {
                                                    AST tmp53_AST_in = (AST) _t;
                                                    match(_t, LITERAL_super);
                                                    _t = _t.getNextSibling();
                                                    break;
                                                }
                                                default: {
                                                    throw new NoViableAltException(_t);
                                                }
                                            }
                                        }
                                        typeSpec(_t);
                                        _t = _retTree;
                                        break;
                                    }
                                    case 3: {
                                        break;
                                    }
                                    default: {
                                        throw new NoViableAltException(_t);
                                    }
                                }
                            }
                            _t = __t39;
                            _t = _t.getNextSibling();
                            break;
                        }
                        default: {
                            break _loop42;
                        }
                    }
                } while (true);
            }
            _t = __t37;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void modifier(AST _t) throws RecognitionException {

        AST modifier_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case LITERAL_private: {
                    AST tmp54_AST_in = (AST) _t;
                    match(_t, LITERAL_private);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_public: {
                    AST tmp55_AST_in = (AST) _t;
                    match(_t, LITERAL_public);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_protected: {
                    AST tmp56_AST_in = (AST) _t;
                    match(_t, LITERAL_protected);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_static: {
                    AST tmp57_AST_in = (AST) _t;
                    match(_t, LITERAL_static);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_transient: {
                    AST tmp58_AST_in = (AST) _t;
                    match(_t, LITERAL_transient);
                    _t = _t.getNextSibling();
                    break;
                }
                case FINAL: {
                    AST tmp59_AST_in = (AST) _t;
                    match(_t, FINAL);
                    _t = _t.getNextSibling();
                    break;
                }
                case ABSTRACT: {
                    AST tmp60_AST_in = (AST) _t;
                    match(_t, ABSTRACT);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_native: {
                    AST tmp61_AST_in = (AST) _t;
                    match(_t, LITERAL_native);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_threadsafe: {
                    AST tmp62_AST_in = (AST) _t;
                    match(_t, LITERAL_threadsafe);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_synchronized: {
                    AST tmp63_AST_in = (AST) _t;
                    match(_t, LITERAL_synchronized);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_const: {
                    AST tmp64_AST_in = (AST) _t;
                    match(_t, LITERAL_const);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_volatile: {
                    AST tmp65_AST_in = (AST) _t;
                    match(_t, LITERAL_volatile);
                    _t = _t.getNextSibling();
                    break;
                }
                case STRICTFP: {
                    AST tmp66_AST_in = (AST) _t;
                    match(_t, STRICTFP);
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotation(AST _t) throws RecognitionException {

        AST annotation_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t94 = _t;
            AST tmp67_AST_in = (AST) _t;
            match(_t, ANNOTATION);
            _t = _t.getFirstChild();
            identifier(_t);
            _t = _retTree;
            annotationInit(_t);
            _t = _retTree;
            _t = __t94;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void methodDecl(AST _t) throws RecognitionException {

        AST methodDecl_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t110 = _t;
            AST tmp68_AST_in = (AST) _t;
            match(_t, METHOD_DEF);
            _t = _t.getFirstChild();
            modifiers(_t);
            _t = _retTree;
            typeParameters(_t);
            _t = _retTree;
            typeSpec(_t);
            _t = _retTree;
            methodHead(_t);
            _t = _retTree;
            _t = __t110;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void variableDef(AST _t) throws RecognitionException {

        AST variableDef_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t115 = _t;
            AST tmp69_AST_in = (AST) _t;
            match(_t, VARIABLE_DEF);
            _t = _t.getFirstChild();
            modifiers(_t);
            _t = _retTree;
            typeSpec(_t);
            _t = _retTree;
            variableDeclarator(_t);
            _t = _retTree;
            varInitializer(_t);
            _t = _retTree;
            _t = __t115;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void ctorDef(AST _t) throws RecognitionException {

        AST ctorDef_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t107 = _t;
            AST tmp70_AST_in = (AST) _t;
            match(_t, CTOR_DEF);
            _t = _t.getFirstChild();
            modifiers(_t);
            _t = _retTree;
            typeParameters(_t);
            _t = _retTree;
            methodHead(_t);
            _t = _retTree;
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case SLIST: {
                        slist(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t107;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void methodDef(AST _t) throws RecognitionException {

        AST methodDef_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t112 = _t;
            AST tmp71_AST_in = (AST) _t;
            match(_t, METHOD_DEF);
            _t = _t.getFirstChild();
            modifiers(_t);
            _t = _retTree;
            typeParameters(_t);
            _t = _retTree;
            typeSpec(_t);
            _t = _retTree;
            methodHead(_t);
            _t = _retTree;
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case SLIST: {
                        slist(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t112;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void slist(AST _t) throws RecognitionException {

        AST slist_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t143 = _t;
            AST tmp72_AST_in = (AST) _t;
            match(_t, SLIST);
            _t = _t.getFirstChild();
            {
                _loop145:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_tokenSet_1.member(_t.getType()))) {
                        stat(_t);
                        _t = _retTree;
                    } else {
                        break _loop145;
                    }

                } while (true);
            }
            _t = __t143;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void enumConst(AST _t) throws RecognitionException {

        AST enumConst_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t76 = _t;
            AST tmp73_AST_in = (AST) _t;
            match(_t, ENUM_CONST);
            _t = _t.getFirstChild();
            annotations(_t);
            _t = _retTree;
            AST tmp74_AST_in = (AST) _t;
            match(_t, IDENT);
            _t = _t.getNextSibling();
            enumConstInit(_t);
            _t = _retTree;
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case OBJBLOCK: {
                        objBlock(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t76;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void enumConstInit(AST _t) throws RecognitionException {

        AST enumConstInit_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t79 = _t;
            AST tmp75_AST_in = (AST) _t;
            match(_t, ENUM_CONST_INIT);
            _t = _t.getFirstChild();
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case ELIST: {
                        elist(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t79;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void elist(AST _t) throws RecognitionException {

        AST elist_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t189 = _t;
            AST tmp76_AST_in = (AST) _t;
            match(_t, ELIST);
            _t = _t.getFirstChild();
            {
                _loop191:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == EXPR)) {
                        expression(_t);
                        _t = _retTree;
                    } else {
                        break _loop191;
                    }

                } while (true);
            }
            _t = __t189;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotationMember(AST _t) throws RecognitionException {

        AST annotationMember_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t86 = _t;
            AST tmp77_AST_in = (AST) _t;
            match(_t, ANNOTATION_MEMBER_DEF);
            _t = _t.getFirstChild();
            modifiers(_t);
            _t = _retTree;
            typeSpec(_t);
            _t = _retTree;
            AST tmp78_AST_in = (AST) _t;
            match(_t, IDENT);
            _t = _t.getNextSibling();
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case LITERAL_default: {
                        AST __t88 = _t;
                        AST tmp79_AST_in = (AST) _t;
                        match(_t, LITERAL_default);
                        _t = _t.getFirstChild();
                        annotationMemberValue(_t);
                        _t = _retTree;
                        _t = __t88;
                        _t = _t.getNextSibling();
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t86;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotationMemberValue(AST _t) throws RecognitionException {

        AST annotationMemberValue_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case ANNOTATION: {
                    annotation(_t);
                    _t = _retTree;
                    break;
                }
                case EXPR: {
                    expression(_t);
                    _t = _retTree;
                    break;
                }
                case ANNOTATION_ARRAY_INIT: {
                    annotationMemberArrayInitializer(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotationInit(AST _t) throws RecognitionException {

        AST annotationInit_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case ANNOTATION_INIT_EMPTY: {
                    AST tmp80_AST_in = (AST) _t;
                    match(_t, ANNOTATION_INIT_EMPTY);
                    _t = _t.getNextSibling();
                    break;
                }
                case ANNOTATION_INIT_VALUE: {
                    AST __t96 = _t;
                    AST tmp81_AST_in = (AST) _t;
                    match(_t, ANNOTATION_INIT_VALUE);
                    _t = _t.getFirstChild();
                    annotationMemberValue(_t);
                    _t = _retTree;
                    _t = __t96;
                    _t = _t.getNextSibling();
                    break;
                }
                case ANNOTATION_INIT_LIST: {
                    AST __t97 = _t;
                    AST tmp82_AST_in = (AST) _t;
                    match(_t, ANNOTATION_INIT_LIST);
                    _t = _t.getFirstChild();
                    {
                        _loop100:
                        do {
                            if (_t == null) _t = ASTNULL;
                            if ((_t.getType() == ANNOTATION_INIT_MEMBER)) {
                                AST __t99 = _t;
                                AST tmp83_AST_in = (AST) _t;
                                match(_t, ANNOTATION_INIT_MEMBER);
                                _t = _t.getFirstChild();
                                AST tmp84_AST_in = (AST) _t;
                                match(_t, IDENT);
                                _t = _t.getNextSibling();
                                annotationMemberValue(_t);
                                _t = _retTree;
                                _t = __t99;
                                _t = _t.getNextSibling();
                            } else {
                                break _loop100;
                            }

                        } while (true);
                    }
                    _t = __t97;
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void expression(AST _t) throws RecognitionException {

        AST expression_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t193 = _t;
            AST tmp85_AST_in = (AST) _t;
            match(_t, EXPR);
            _t = _t.getFirstChild();
            expr(_t);
            _t = _retTree;
            _t = __t193;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void annotationMemberArrayInitializer(AST _t) throws RecognitionException {

        AST annotationMemberArrayInitializer_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t103 = _t;
            AST tmp86_AST_in = (AST) _t;
            match(_t, ANNOTATION_ARRAY_INIT);
            _t = _t.getFirstChild();
            {
                _loop105:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == EXPR || _t.getType() == ANNOTATION || _t.getType() == ANNOTATION_ARRAY_INIT)) {
                        annotationMemberValue(_t);
                        _t = _retTree;
                    } else {
                        break _loop105;
                    }

                } while (true);
            }
            _t = __t103;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void methodHead(AST _t) throws RecognitionException {

        AST methodHead_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST tmp87_AST_in = (AST) _t;
            match(_t, IDENT);
            _t = _t.getNextSibling();
            AST __t129 = _t;
            AST tmp88_AST_in = (AST) _t;
            match(_t, PARAMETERS);
            _t = _t.getFirstChild();
            {
                _loop131:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == PARAMETER_DEF)) {
                        parameterDef(_t);
                        _t = _retTree;
                    } else {
                        break _loop131;
                    }

                } while (true);
            }
            _t = __t129;
            _t = _t.getNextSibling();
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case LITERAL_throws: {
                        throwsClause(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3:
                    case SLIST: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void variableDeclarator(AST _t) throws RecognitionException {

        AST variableDeclarator_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT: {
                    AST tmp89_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    break;
                }
                case LBRACK: {
                    AST tmp90_AST_in = (AST) _t;
                    match(_t, LBRACK);
                    _t = _t.getNextSibling();
                    variableDeclarator(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void varInitializer(AST _t) throws RecognitionException {

        AST varInitializer_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case ASSIGN: {
                    AST __t122 = _t;
                    AST tmp91_AST_in = (AST) _t;
                    match(_t, ASSIGN);
                    _t = _t.getFirstChild();
                    initializer(_t);
                    _t = _retTree;
                    _t = __t122;
                    _t = _t.getNextSibling();
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void parameterDef(AST _t) throws RecognitionException {

        AST parameterDef_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t117 = _t;
            AST tmp92_AST_in = (AST) _t;
            match(_t, PARAMETER_DEF);
            _t = _t.getFirstChild();
            modifiers(_t);
            _t = _retTree;
            typeSpec(_t);
            _t = _retTree;
            AST tmp93_AST_in = (AST) _t;
            match(_t, IDENT);
            _t = _t.getNextSibling();
            _t = __t117;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void objectinitializer(AST _t) throws RecognitionException {

        AST objectinitializer_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t119 = _t;
            AST tmp94_AST_in = (AST) _t;
            match(_t, INSTANCE_INIT);
            _t = _t.getFirstChild();
            slist(_t);
            _t = _retTree;
            _t = __t119;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void initializer(AST _t) throws RecognitionException {

        AST initializer_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case EXPR: {
                    expression(_t);
                    _t = _retTree;
                    break;
                }
                case ARRAY_INIT: {
                    arrayInitializer(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void arrayInitializer(AST _t) throws RecognitionException {

        AST arrayInitializer_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t125 = _t;
            AST tmp95_AST_in = (AST) _t;
            match(_t, ARRAY_INIT);
            _t = _t.getFirstChild();
            {
                _loop127:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == EXPR || _t.getType() == ARRAY_INIT)) {
                        initializer(_t);
                        _t = _retTree;
                    } else {
                        break _loop127;
                    }

                } while (true);
            }
            _t = __t125;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void throwsClause(AST _t) throws RecognitionException {

        AST throwsClause_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t134 = _t;
            AST tmp96_AST_in = (AST) _t;
            match(_t, LITERAL_throws);
            _t = _t.getFirstChild();
            {
                _loop136:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == IDENT || _t.getType() == DOT)) {
                        identifier(_t);
                        _t = _retTree;
                    } else {
                        break _loop136;
                    }

                } while (true);
            }
            _t = __t134;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void stat(AST _t) throws RecognitionException {

        AST stat_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case CLASS_DEF:
                case INTERFACE_DEF:
                case ENUM_DEF:
                case ANNOTATION_DEF: {
                    typeDefinition(_t);
                    _t = _retTree;
                    break;
                }
                case VARIABLE_DEF: {
                    variableDef(_t);
                    _t = _retTree;
                    break;
                }
                case EXPR: {
                    expression(_t);
                    _t = _retTree;
                    break;
                }
                case LABELED_STAT: {
                    AST __t147 = _t;
                    AST tmp97_AST_in = (AST) _t;
                    match(_t, LABELED_STAT);
                    _t = _t.getFirstChild();
                    AST tmp98_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    stat(_t);
                    _t = _retTree;
                    _t = __t147;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_if: {
                    AST __t148 = _t;
                    AST tmp99_AST_in = (AST) _t;
                    match(_t, LITERAL_if);
                    _t = _t.getFirstChild();
                    expression(_t);
                    _t = _retTree;
                    stat(_t);
                    _t = _retTree;
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case SLIST:
                            case VARIABLE_DEF:
                            case CLASS_DEF:
                            case INTERFACE_DEF:
                            case LABELED_STAT:
                            case EXPR:
                            case EMPTY_STAT:
                            case ASSERT:
                            case ENUM_DEF:
                            case ANNOTATION_DEF:
                            case LITERAL_synchronized:
                            case LITERAL_if:
                            case LITERAL_for:
                            case LITERAL_while:
                            case LITERAL_do:
                            case LITERAL_break:
                            case LITERAL_continue:
                            case LITERAL_return:
                            case LITERAL_switch:
                            case LITERAL_throw:
                            case LITERAL_try: {
                                stat(_t);
                                _t = _retTree;
                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t148;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_for: {
                    AST __t150 = _t;
                    AST tmp100_AST_in = (AST) _t;
                    match(_t, LITERAL_for);
                    _t = _t.getFirstChild();
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case PARAMETER_DEF: {
                                parameterDef(_t);
                                _t = _retTree;
                                expression(_t);
                                _t = _retTree;
                                break;
                            }
                            case FOR_INIT: {
                                AST __t152 = _t;
                                AST tmp101_AST_in = (AST) _t;
                                match(_t, FOR_INIT);
                                _t = _t.getFirstChild();
                                {
                                    if (_t == null) _t = ASTNULL;
                                    switch (_t.getType()) {
                                        case VARIABLE_DEF: {
                                            {
                                                int _cnt155 = 0;
                                                _loop155:
                                                do {
                                                    if (_t == null) _t = ASTNULL;
                                                    if ((_t.getType() == VARIABLE_DEF)) {
                                                        variableDef(_t);
                                                        _t = _retTree;
                                                    } else {
                                                        if (_cnt155 >= 1) {
                                                            break _loop155;
                                                        } else {
                                                            throw new NoViableAltException(_t);
                                                        }
                                                    }

                                                    _cnt155++;
                                                } while (true);
                                            }
                                            break;
                                        }
                                        case ELIST: {
                                            elist(_t);
                                            _t = _retTree;
                                            break;
                                        }
                                        case 3: {
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(_t);
                                        }
                                    }
                                }
                                _t = __t152;
                                _t = _t.getNextSibling();
                                AST __t156 = _t;
                                AST tmp102_AST_in = (AST) _t;
                                match(_t, FOR_CONDITION);
                                _t = _t.getFirstChild();
                                {
                                    if (_t == null) _t = ASTNULL;
                                    switch (_t.getType()) {
                                        case EXPR: {
                                            expression(_t);
                                            _t = _retTree;
                                            break;
                                        }
                                        case 3: {
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(_t);
                                        }
                                    }
                                }
                                _t = __t156;
                                _t = _t.getNextSibling();
                                AST __t158 = _t;
                                AST tmp103_AST_in = (AST) _t;
                                match(_t, FOR_ITERATOR);
                                _t = _t.getFirstChild();
                                {
                                    if (_t == null) _t = ASTNULL;
                                    switch (_t.getType()) {
                                        case ELIST: {
                                            elist(_t);
                                            _t = _retTree;
                                            break;
                                        }
                                        case 3: {
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(_t);
                                        }
                                    }
                                }
                                _t = __t158;
                                _t = _t.getNextSibling();
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    stat(_t);
                    _t = _retTree;
                    _t = __t150;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_while: {
                    AST __t160 = _t;
                    AST tmp104_AST_in = (AST) _t;
                    match(_t, LITERAL_while);
                    _t = _t.getFirstChild();
                    expression(_t);
                    _t = _retTree;
                    stat(_t);
                    _t = _retTree;
                    _t = __t160;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_do: {
                    AST __t161 = _t;
                    AST tmp105_AST_in = (AST) _t;
                    match(_t, LITERAL_do);
                    _t = _t.getFirstChild();
                    stat(_t);
                    _t = _retTree;
                    expression(_t);
                    _t = _retTree;
                    _t = __t161;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_break: {
                    AST __t162 = _t;
                    AST tmp106_AST_in = (AST) _t;
                    match(_t, LITERAL_break);
                    _t = _t.getFirstChild();
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case IDENT: {
                                AST tmp107_AST_in = (AST) _t;
                                match(_t, IDENT);
                                _t = _t.getNextSibling();
                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t162;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_continue: {
                    AST __t164 = _t;
                    AST tmp108_AST_in = (AST) _t;
                    match(_t, LITERAL_continue);
                    _t = _t.getFirstChild();
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case IDENT: {
                                AST tmp109_AST_in = (AST) _t;
                                match(_t, IDENT);
                                _t = _t.getNextSibling();
                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t164;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_return: {
                    AST __t166 = _t;
                    AST tmp110_AST_in = (AST) _t;
                    match(_t, LITERAL_return);
                    _t = _t.getFirstChild();
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case EXPR: {
                                expression(_t);
                                _t = _retTree;
                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t166;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_switch: {
                    AST __t168 = _t;
                    AST tmp111_AST_in = (AST) _t;
                    match(_t, LITERAL_switch);
                    _t = _t.getFirstChild();
                    expression(_t);
                    _t = _retTree;
                    {
                        _loop170:
                        do {
                            if (_t == null) _t = ASTNULL;
                            if ((_t.getType() == CASE_GROUP)) {
                                caseGroup(_t);
                                _t = _retTree;
                            } else {
                                break _loop170;
                            }

                        } while (true);
                    }
                    _t = __t168;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_throw: {
                    AST __t171 = _t;
                    AST tmp112_AST_in = (AST) _t;
                    match(_t, LITERAL_throw);
                    _t = _t.getFirstChild();
                    expression(_t);
                    _t = _retTree;
                    _t = __t171;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_synchronized: {
                    AST __t172 = _t;
                    AST tmp113_AST_in = (AST) _t;
                    match(_t, LITERAL_synchronized);
                    _t = _t.getFirstChild();
                    expression(_t);
                    _t = _retTree;
                    stat(_t);
                    _t = _retTree;
                    _t = __t172;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_try: {
                    tryBlock(_t);
                    _t = _retTree;
                    break;
                }
                case SLIST: {
                    slist(_t);
                    _t = _retTree;
                    break;
                }
                case ASSERT: {
                    AST __t173 = _t;
                    AST tmp114_AST_in = (AST) _t;
                    match(_t, ASSERT);
                    _t = _t.getFirstChild();
                    expression(_t);
                    _t = _retTree;
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case EXPR: {
                                expression(_t);
                                _t = _retTree;
                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t173;
                    _t = _t.getNextSibling();
                    break;
                }
                case EMPTY_STAT: {
                    AST tmp115_AST_in = (AST) _t;
                    match(_t, EMPTY_STAT);
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void caseGroup(AST _t) throws RecognitionException {

        AST caseGroup_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t176 = _t;
            AST tmp116_AST_in = (AST) _t;
            match(_t, CASE_GROUP);
            _t = _t.getFirstChild();
            {
                int _cnt179 = 0;
                _loop179:
                do {
                    if (_t == null) _t = ASTNULL;
                    switch (_t.getType()) {
                        case LITERAL_case: {
                            AST __t178 = _t;
                            AST tmp117_AST_in = (AST) _t;
                            match(_t, LITERAL_case);
                            _t = _t.getFirstChild();
                            expression(_t);
                            _t = _retTree;
                            _t = __t178;
                            _t = _t.getNextSibling();
                            break;
                        }
                        case LITERAL_default: {
                            AST tmp118_AST_in = (AST) _t;
                            match(_t, LITERAL_default);
                            _t = _t.getNextSibling();
                            break;
                        }
                        default: {
                            if (_cnt179 >= 1) {
                                break _loop179;
                            } else {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _cnt179++;
                } while (true);
            }
            slist(_t);
            _t = _retTree;
            _t = __t176;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void tryBlock(AST _t) throws RecognitionException {

        AST tryBlock_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t181 = _t;
            AST tmp119_AST_in = (AST) _t;
            match(_t, LITERAL_try);
            _t = _t.getFirstChild();
            slist(_t);
            _t = _retTree;
            {
                _loop183:
                do {
                    if (_t == null) _t = ASTNULL;
                    if ((_t.getType() == LITERAL_catch)) {
                        handler(_t);
                        _t = _retTree;
                    } else {
                        break _loop183;
                    }

                } while (true);
            }
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case LITERAL_finally: {
                        AST __t185 = _t;
                        AST tmp120_AST_in = (AST) _t;
                        match(_t, LITERAL_finally);
                        _t = _t.getFirstChild();
                        slist(_t);
                        _t = _retTree;
                        _t = __t185;
                        _t = _t.getNextSibling();
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t181;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void handler(AST _t) throws RecognitionException {

        AST handler_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t187 = _t;
            AST tmp121_AST_in = (AST) _t;
            match(_t, LITERAL_catch);
            _t = _t.getFirstChild();
            parameterDef(_t);
            _t = _retTree;
            slist(_t);
            _t = _retTree;
            _t = __t187;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void expr(AST _t) throws RecognitionException {

        AST expr_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case QUESTION: {
                    AST __t195 = _t;
                    AST tmp122_AST_in = (AST) _t;
                    match(_t, QUESTION);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t195;
                    _t = _t.getNextSibling();
                    break;
                }
                case ASSIGN: {
                    AST __t196 = _t;
                    AST tmp123_AST_in = (AST) _t;
                    match(_t, ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t196;
                    _t = _t.getNextSibling();
                    break;
                }
                case PLUS_ASSIGN: {
                    AST __t197 = _t;
                    AST tmp124_AST_in = (AST) _t;
                    match(_t, PLUS_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t197;
                    _t = _t.getNextSibling();
                    break;
                }
                case MINUS_ASSIGN: {
                    AST __t198 = _t;
                    AST tmp125_AST_in = (AST) _t;
                    match(_t, MINUS_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t198;
                    _t = _t.getNextSibling();
                    break;
                }
                case STAR_ASSIGN: {
                    AST __t199 = _t;
                    AST tmp126_AST_in = (AST) _t;
                    match(_t, STAR_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t199;
                    _t = _t.getNextSibling();
                    break;
                }
                case DIV_ASSIGN: {
                    AST __t200 = _t;
                    AST tmp127_AST_in = (AST) _t;
                    match(_t, DIV_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t200;
                    _t = _t.getNextSibling();
                    break;
                }
                case MOD_ASSIGN: {
                    AST __t201 = _t;
                    AST tmp128_AST_in = (AST) _t;
                    match(_t, MOD_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t201;
                    _t = _t.getNextSibling();
                    break;
                }
                case SR_ASSIGN: {
                    AST __t202 = _t;
                    AST tmp129_AST_in = (AST) _t;
                    match(_t, SR_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t202;
                    _t = _t.getNextSibling();
                    break;
                }
                case BSR_ASSIGN: {
                    AST __t203 = _t;
                    AST tmp130_AST_in = (AST) _t;
                    match(_t, BSR_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t203;
                    _t = _t.getNextSibling();
                    break;
                }
                case SL_ASSIGN: {
                    AST __t204 = _t;
                    AST tmp131_AST_in = (AST) _t;
                    match(_t, SL_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t204;
                    _t = _t.getNextSibling();
                    break;
                }
                case BAND_ASSIGN: {
                    AST __t205 = _t;
                    AST tmp132_AST_in = (AST) _t;
                    match(_t, BAND_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t205;
                    _t = _t.getNextSibling();
                    break;
                }
                case BXOR_ASSIGN: {
                    AST __t206 = _t;
                    AST tmp133_AST_in = (AST) _t;
                    match(_t, BXOR_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t206;
                    _t = _t.getNextSibling();
                    break;
                }
                case BOR_ASSIGN: {
                    AST __t207 = _t;
                    AST tmp134_AST_in = (AST) _t;
                    match(_t, BOR_ASSIGN);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t207;
                    _t = _t.getNextSibling();
                    break;
                }
                case LOR: {
                    AST __t208 = _t;
                    AST tmp135_AST_in = (AST) _t;
                    match(_t, LOR);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t208;
                    _t = _t.getNextSibling();
                    break;
                }
                case LAND: {
                    AST __t209 = _t;
                    AST tmp136_AST_in = (AST) _t;
                    match(_t, LAND);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t209;
                    _t = _t.getNextSibling();
                    break;
                }
                case BOR: {
                    AST __t210 = _t;
                    AST tmp137_AST_in = (AST) _t;
                    match(_t, BOR);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t210;
                    _t = _t.getNextSibling();
                    break;
                }
                case BXOR: {
                    AST __t211 = _t;
                    AST tmp138_AST_in = (AST) _t;
                    match(_t, BXOR);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t211;
                    _t = _t.getNextSibling();
                    break;
                }
                case BAND: {
                    AST __t212 = _t;
                    AST tmp139_AST_in = (AST) _t;
                    match(_t, BAND);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t212;
                    _t = _t.getNextSibling();
                    break;
                }
                case NOT_EQUAL: {
                    AST __t213 = _t;
                    AST tmp140_AST_in = (AST) _t;
                    match(_t, NOT_EQUAL);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t213;
                    _t = _t.getNextSibling();
                    break;
                }
                case EQUAL: {
                    AST __t214 = _t;
                    AST tmp141_AST_in = (AST) _t;
                    match(_t, EQUAL);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t214;
                    _t = _t.getNextSibling();
                    break;
                }
                case LT: {
                    AST __t215 = _t;
                    AST tmp142_AST_in = (AST) _t;
                    match(_t, LT);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t215;
                    _t = _t.getNextSibling();
                    break;
                }
                case GT: {
                    AST __t216 = _t;
                    AST tmp143_AST_in = (AST) _t;
                    match(_t, GT);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t216;
                    _t = _t.getNextSibling();
                    break;
                }
                case LE: {
                    AST __t217 = _t;
                    AST tmp144_AST_in = (AST) _t;
                    match(_t, LE);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t217;
                    _t = _t.getNextSibling();
                    break;
                }
                case GE: {
                    AST __t218 = _t;
                    AST tmp145_AST_in = (AST) _t;
                    match(_t, GE);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t218;
                    _t = _t.getNextSibling();
                    break;
                }
                case SL: {
                    AST __t219 = _t;
                    AST tmp146_AST_in = (AST) _t;
                    match(_t, SL);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t219;
                    _t = _t.getNextSibling();
                    break;
                }
                case SR: {
                    AST __t220 = _t;
                    AST tmp147_AST_in = (AST) _t;
                    match(_t, SR);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t220;
                    _t = _t.getNextSibling();
                    break;
                }
                case BSR: {
                    AST __t221 = _t;
                    AST tmp148_AST_in = (AST) _t;
                    match(_t, BSR);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t221;
                    _t = _t.getNextSibling();
                    break;
                }
                case PLUS: {
                    AST __t222 = _t;
                    AST tmp149_AST_in = (AST) _t;
                    match(_t, PLUS);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t222;
                    _t = _t.getNextSibling();
                    break;
                }
                case MINUS: {
                    AST __t223 = _t;
                    AST tmp150_AST_in = (AST) _t;
                    match(_t, MINUS);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t223;
                    _t = _t.getNextSibling();
                    break;
                }
                case DIV: {
                    AST __t224 = _t;
                    AST tmp151_AST_in = (AST) _t;
                    match(_t, DIV);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t224;
                    _t = _t.getNextSibling();
                    break;
                }
                case MOD: {
                    AST __t225 = _t;
                    AST tmp152_AST_in = (AST) _t;
                    match(_t, MOD);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t225;
                    _t = _t.getNextSibling();
                    break;
                }
                case STAR: {
                    AST __t226 = _t;
                    AST tmp153_AST_in = (AST) _t;
                    match(_t, STAR);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t226;
                    _t = _t.getNextSibling();
                    break;
                }
                case INC: {
                    AST __t227 = _t;
                    AST tmp154_AST_in = (AST) _t;
                    match(_t, INC);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t227;
                    _t = _t.getNextSibling();
                    break;
                }
                case DEC: {
                    AST __t228 = _t;
                    AST tmp155_AST_in = (AST) _t;
                    match(_t, DEC);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t228;
                    _t = _t.getNextSibling();
                    break;
                }
                case POST_INC: {
                    AST __t229 = _t;
                    AST tmp156_AST_in = (AST) _t;
                    match(_t, POST_INC);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t229;
                    _t = _t.getNextSibling();
                    break;
                }
                case POST_DEC: {
                    AST __t230 = _t;
                    AST tmp157_AST_in = (AST) _t;
                    match(_t, POST_DEC);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t230;
                    _t = _t.getNextSibling();
                    break;
                }
                case BNOT: {
                    AST __t231 = _t;
                    AST tmp158_AST_in = (AST) _t;
                    match(_t, BNOT);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t231;
                    _t = _t.getNextSibling();
                    break;
                }
                case LNOT: {
                    AST __t232 = _t;
                    AST tmp159_AST_in = (AST) _t;
                    match(_t, LNOT);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t232;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_instanceof: {
                    AST __t233 = _t;
                    AST tmp160_AST_in = (AST) _t;
                    match(_t, LITERAL_instanceof);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t233;
                    _t = _t.getNextSibling();
                    break;
                }
                case UNARY_MINUS: {
                    AST __t234 = _t;
                    AST tmp161_AST_in = (AST) _t;
                    match(_t, UNARY_MINUS);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t234;
                    _t = _t.getNextSibling();
                    break;
                }
                case UNARY_PLUS: {
                    AST __t235 = _t;
                    AST tmp162_AST_in = (AST) _t;
                    match(_t, UNARY_PLUS);
                    _t = _t.getFirstChild();
                    expr(_t);
                    _t = _retTree;
                    _t = __t235;
                    _t = _t.getNextSibling();
                    break;
                }
                case TYPE:
                case ARRAY_DECLARATOR:
                case TYPECAST:
                case INDEX_OP:
                case METHOD_CALL:
                case SUPER_CTOR_CALL:
                case CTOR_CALL:
                case IDENT:
                case DOT:
                case LITERAL_super:
                case LITERAL_this:
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
                    primaryExpression(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void primaryExpression(AST _t) throws RecognitionException {

        AST primaryExpression_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case IDENT: {
                    AST tmp163_AST_in = (AST) _t;
                    match(_t, IDENT);
                    _t = _t.getNextSibling();
                    break;
                }
                case DOT: {
                    AST __t237 = _t;
                    AST tmp164_AST_in = (AST) _t;
                    match(_t, DOT);
                    _t = _t.getFirstChild();
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case TYPE:
                            case ARRAY_DECLARATOR:
                            case TYPECAST:
                            case INDEX_OP:
                            case POST_INC:
                            case POST_DEC:
                            case METHOD_CALL:
                            case UNARY_MINUS:
                            case UNARY_PLUS:
                            case SUPER_CTOR_CALL:
                            case CTOR_CALL:
                            case IDENT:
                            case DOT:
                            case LT:
                            case QUESTION:
                            case LITERAL_super:
                            case GT:
                            case SR:
                            case BSR:
                            case STAR:
                            case ASSIGN:
                            case BAND:
                            case LITERAL_this:
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
                                expr(_t);
                                _t = _retTree;
                                {
                                    if (_t == null) _t = ASTNULL;
                                    switch (_t.getType()) {
                                        case IDENT: {
                                            AST tmp165_AST_in = (AST) _t;
                                            match(_t, IDENT);
                                            _t = _t.getNextSibling();
                                            break;
                                        }
                                        case INDEX_OP: {
                                            arrayIndex(_t);
                                            _t = _retTree;
                                            break;
                                        }
                                        case LITERAL_this: {
                                            AST tmp166_AST_in = (AST) _t;
                                            match(_t, LITERAL_this);
                                            _t = _t.getNextSibling();
                                            break;
                                        }
                                        case LITERAL_class: {
                                            AST tmp167_AST_in = (AST) _t;
                                            match(_t, LITERAL_class);
                                            _t = _t.getNextSibling();
                                            break;
                                        }
                                        case LITERAL_new: {
                                            newExpression(_t);
                                            _t = _retTree;
                                            break;
                                        }
                                        case LITERAL_super: {
                                            AST tmp168_AST_in = (AST) _t;
                                            match(_t, LITERAL_super);
                                            _t = _t.getNextSibling();
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(_t);
                                        }
                                    }
                                }
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
                                builtInType(_t);
                                _t = _retTree;
                                {
                                    if (_t == null) _t = ASTNULL;
                                    switch (_t.getType()) {
                                        case LITERAL_class: {
                                            AST tmp169_AST_in = (AST) _t;
                                            match(_t, LITERAL_class);
                                            _t = _t.getNextSibling();
                                            break;
                                        }
                                        case 3: {
                                            break;
                                        }
                                        default: {
                                            throw new NoViableAltException(_t);
                                        }
                                    }
                                }
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t237;
                    _t = _t.getNextSibling();
                    break;
                }
                case ARRAY_DECLARATOR: {
                    AST __t241 = _t;
                    AST tmp170_AST_in = (AST) _t;
                    match(_t, ARRAY_DECLARATOR);
                    _t = _t.getFirstChild();
                    simpleTypeSpecArray(_t);
                    _t = _retTree;
                    _t = __t241;
                    _t = _t.getNextSibling();
                    break;
                }
                case INDEX_OP: {
                    arrayIndex(_t);
                    _t = _retTree;
                    break;
                }
                case METHOD_CALL: {
                    AST __t242 = _t;
                    AST tmp171_AST_in = (AST) _t;
                    match(_t, METHOD_CALL);
                    _t = _t.getFirstChild();
                    primaryExpression(_t);
                    _t = _retTree;
                    typeArguments(_t);
                    _t = _retTree;
                    elist(_t);
                    _t = _retTree;
                    _t = __t242;
                    _t = _t.getNextSibling();
                    break;
                }
                case SUPER_CTOR_CALL:
                case CTOR_CALL: {
                    ctorCall(_t);
                    _t = _retTree;
                    break;
                }
                case TYPECAST: {
                    AST __t243 = _t;
                    AST tmp172_AST_in = (AST) _t;
                    match(_t, TYPECAST);
                    _t = _t.getFirstChild();
                    typeSpec(_t);
                    _t = _retTree;
                    expr(_t);
                    _t = _retTree;
                    _t = __t243;
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_new: {
                    newExpression(_t);
                    _t = _retTree;
                    break;
                }
                case NUM_INT:
                case CHAR_LITERAL:
                case STRING_LITERAL:
                case NUM_FLOAT:
                case NUM_LONG:
                case NUM_DOUBLE: {
                    constant(_t);
                    _t = _retTree;
                    break;
                }
                case LITERAL_super: {
                    AST tmp173_AST_in = (AST) _t;
                    match(_t, LITERAL_super);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_true: {
                    AST tmp174_AST_in = (AST) _t;
                    match(_t, LITERAL_true);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_false: {
                    AST tmp175_AST_in = (AST) _t;
                    match(_t, LITERAL_false);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_this: {
                    AST tmp176_AST_in = (AST) _t;
                    match(_t, LITERAL_this);
                    _t = _t.getNextSibling();
                    break;
                }
                case LITERAL_null: {
                    AST tmp177_AST_in = (AST) _t;
                    match(_t, LITERAL_null);
                    _t = _t.getNextSibling();
                    break;
                }
                case TYPE: {
                    typeSpec(_t);
                    _t = _retTree;
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void arrayIndex(AST _t) throws RecognitionException {

        AST arrayIndex_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t249 = _t;
            AST tmp178_AST_in = (AST) _t;
            match(_t, INDEX_OP);
            _t = _t.getFirstChild();
            expr(_t);
            _t = _retTree;
            expression(_t);
            _t = _retTree;
            _t = __t249;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void newExpression(AST _t) throws RecognitionException {

        AST newExpression_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t252 = _t;
            AST tmp179_AST_in = (AST) _t;
            match(_t, LITERAL_new);
            _t = _t.getFirstChild();
            typeArguments(_t);
            _t = _retTree;
            type(_t);
            _t = _retTree;
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case ARRAY_DECLARATOR: {
                        newArrayDeclarator(_t);
                        _t = _retTree;
                        {
                            if (_t == null) _t = ASTNULL;
                            switch (_t.getType()) {
                                case ARRAY_INIT: {
                                    arrayInitializer(_t);
                                    _t = _retTree;
                                    break;
                                }
                                case 3: {
                                    break;
                                }
                                default: {
                                    throw new NoViableAltException(_t);
                                }
                            }
                        }
                        break;
                    }
                    case ELIST: {
                        elist(_t);
                        _t = _retTree;
                        {
                            if (_t == null) _t = ASTNULL;
                            switch (_t.getType()) {
                                case OBJBLOCK: {
                                    objBlock(_t);
                                    _t = _retTree;
                                    break;
                                }
                                case 3: {
                                    break;
                                }
                                default: {
                                    throw new NoViableAltException(_t);
                                }
                            }
                        }
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t252;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void ctorCall(AST _t) throws RecognitionException {

        AST ctorCall_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case CTOR_CALL: {
                    AST __t245 = _t;
                    AST tmp180_AST_in = (AST) _t;
                    match(_t, CTOR_CALL);
                    _t = _t.getFirstChild();
                    typeArguments(_t);
                    _t = _retTree;
                    elist(_t);
                    _t = _retTree;
                    _t = __t245;
                    _t = _t.getNextSibling();
                    break;
                }
                case SUPER_CTOR_CALL: {
                    AST __t246 = _t;
                    AST tmp181_AST_in = (AST) _t;
                    match(_t, SUPER_CTOR_CALL);
                    _t = _t.getFirstChild();
                    {
                        if (_t == null) _t = ASTNULL;
                        switch (_t.getType()) {
                            case TYPE_ARGS: {
                                typeArguments(_t);
                                _t = _retTree;
                                elist(_t);
                                _t = _retTree;
                                break;
                            }
                            case TYPE:
                            case ARRAY_DECLARATOR:
                            case TYPECAST:
                            case INDEX_OP:
                            case METHOD_CALL:
                            case SUPER_CTOR_CALL:
                            case CTOR_CALL:
                            case IDENT:
                            case DOT:
                            case LITERAL_super:
                            case LITERAL_this:
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
                                primaryExpression(_t);
                                _t = _retTree;
                                typeArguments(_t);
                                _t = _retTree;
                                elist(_t);
                                _t = _retTree;
                                break;
                            }
                            default: {
                                throw new NoViableAltException(_t);
                            }
                        }
                    }
                    _t = __t246;
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void constant(AST _t) throws RecognitionException {

        AST constant_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            if (_t == null) _t = ASTNULL;
            switch (_t.getType()) {
                case NUM_INT: {
                    AST tmp182_AST_in = (AST) _t;
                    match(_t, NUM_INT);
                    _t = _t.getNextSibling();
                    break;
                }
                case CHAR_LITERAL: {
                    AST tmp183_AST_in = (AST) _t;
                    match(_t, CHAR_LITERAL);
                    _t = _t.getNextSibling();
                    break;
                }
                case STRING_LITERAL: {
                    AST tmp184_AST_in = (AST) _t;
                    match(_t, STRING_LITERAL);
                    _t = _t.getNextSibling();
                    break;
                }
                case NUM_FLOAT: {
                    AST tmp185_AST_in = (AST) _t;
                    match(_t, NUM_FLOAT);
                    _t = _t.getNextSibling();
                    break;
                }
                case NUM_DOUBLE: {
                    AST tmp186_AST_in = (AST) _t;
                    match(_t, NUM_DOUBLE);
                    _t = _t.getNextSibling();
                    break;
                }
                case NUM_LONG: {
                    AST tmp187_AST_in = (AST) _t;
                    match(_t, NUM_LONG);
                    _t = _t.getNextSibling();
                    break;
                }
                default: {
                    throw new NoViableAltException(_t);
                }
            }
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
    }

    public final void newArrayDeclarator(AST _t) throws RecognitionException {

        AST newArrayDeclarator_AST_in = (_t == ASTNULL) ? null : (AST) _t;

        try {      // for error handling
            AST __t257 = _t;
            AST tmp188_AST_in = (AST) _t;
            match(_t, ARRAY_DECLARATOR);
            _t = _t.getFirstChild();
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case ARRAY_DECLARATOR: {
                        newArrayDeclarator(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3:
                    case EXPR: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            {
                if (_t == null) _t = ASTNULL;
                switch (_t.getType()) {
                    case EXPR: {
                        expression(_t);
                        _t = _retTree;
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoViableAltException(_t);
                    }
                }
            }
            _t = __t257;
            _t = _t.getNextSibling();
        }
        catch (RecognitionException ex) {
            reportError(ex);
            if (_t != null) {
                _t = _t.getNextSibling();
            }
        }
        _retTree = _t;
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
            "FLOAT_SUFFIX",
            "\"const\""
    };

    private static final long[] mk_tokenSet_0() {
        long[] data = {10133099161632768L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

    private static final long[] mk_tokenSet_1() {
        long[] data = {10150966498215040L, 431923352836243456L, 0L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
}
	
