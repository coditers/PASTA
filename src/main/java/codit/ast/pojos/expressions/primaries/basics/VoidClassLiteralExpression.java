package codit.ast.pojos.expressions.primaries.basics;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfacearray.LfDefaultArrayAccess;
import codit.ast.pojos.expressions.primaries.interfacearray.LfNoArrayAccess;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfNoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class VoidClassLiteralExpression extends BasicExpression
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  public VoidClassLiteralExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public VoidClassLiteralExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public VoidClassLiteralExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
