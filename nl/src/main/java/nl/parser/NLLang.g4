grammar NLLang;


nllang :
 statements
 |expression
;


expression:
 expression op=('*'|'/') expression # MulDiv
| expression op=('+'|'-') expression        # AddSub
| expression op=('>'|'>='|'<'|'<='|'=='|'!=') expression        # comp
| number                                    #Num
| '(' expression ')'          # parens
|STRING_LITERAL #str
|function #fn
|id #theid
|call #c
|boolean #bool
|assign #as
|arrayAccess #acc
|array #arr
|object #obj
;
if: 'if' '(' expression ')' block ('else' block)?;

arrayAccess : (key=id|call|array|object) '[' expression ']'
| arrayAccess '[' expression ']'
|(key=id|call|array|object) '.' val=id
|arrayAccess '.' val=id
;

object : '{' (id ':' expression)? (',' id ':' expression)*   '}' ;

array : '[' expression? (',' expression)* ']';
assign : (id|arrayAccess) '=' expression;

while: 'while' '(' expression ')' block;

return: 'return' expression? ;

break: 'break';
continue: 'continue';

statements: statement statement* (statement|expression)?;

statement: (if|while|block|(expression?|return|break|continue) ';');





block: '{' statements? '}';

boolean : 'true' | 'false';

id: Identifier;

function : id FN_SP (expression|call|block|if|while)
|'(' id? (',' id)* ')' FN_SP (expression|call|block|if|while)
|'(' function ')'
;

call: callValue callInput callInput*
   |'(' callValue callInput callInput* ')'
;

callValue: id
|'(' function ')'
| '(' id ')'
;


callInput: '(' expression? (',' expression)* ')';

number:
 INT #int
 |Decimal #decimal
 ;



WS : [ \t\r\n\u000C]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;


fragment LETTER : [A-Z] | [a-z] | '_' | '$';
fragment NON_ZERO_DIGIT : [1-9];
fragment DIGIT : [0-9];
fragment HEX_DIGIT : [0-9] | [a-f] | [A-F];
fragment OCT_DIGIT : [0-7];
fragment BINARY_DIGIT : '0' | '1';
fragment TAB : '\t';
fragment STRING_CHAR : ~('"' | '\r' | '\n');
fragment IdentifierPart: IdentifierStart | [\p{Mn}] | [\p{Nd}] | [\p{Pc}] | '\u200C' | '\u200D';
fragment IdentifierStart: [\p{L}] | [$_] | '\\' UnicodeEscapeSequence;
fragment UnicodeEscapeSequence:
    'u' HexDigit HexDigit HexDigit HexDigit
    | 'u' '{' HexDigit HexDigit+ '}'
;
fragment HexDigit: [_0-9a-fA-F];

Identifier: IdentifierStart IdentifierPart*;


IDENTIFIER : LETTER (LETTER | DIGIT)*;
STRING_LITERAL : '"' STRING_CHAR* '"'|'\'' STRING_CHAR* '\'';
INT : '0' | NON_ZERO_DIGIT DIGIT*;
Decimal : INT '.' [0-9] [0-9_]*
    | '.' [0-9] [0-9_]* ;



FN_SP: ('＝'|'=')('>'|'》');




