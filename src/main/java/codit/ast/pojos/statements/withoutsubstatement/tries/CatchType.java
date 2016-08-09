package codit.ast.pojos.statements.withoutsubstatement.tries;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.types.ClassType;
import codit.ast.pojos.types.unann.UnannClassType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class CatchType extends AstNode {

  private final UnannClassType unannClassType;
  private final List<ClassType> classTypeList;

  public CatchType(Range range, AstNode parent,
                   UnannClassType unannClassType,
                   List<ClassType> classTypeList) {
    super(range, parent);
    this.unannClassType = unannClassType;
    this.classTypeList = classTypeList;
  }

  public CatchType(Position start, Position end, AstNode parent,
                   UnannClassType unannClassType,
                   List<ClassType> classTypeList) {
    super(start, end, parent);
    this.unannClassType = unannClassType;
    this.classTypeList = classTypeList;
  }

  public CatchType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                   UnannClassType unannClassType,
                   List<ClassType> classTypeList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannClassType = unannClassType;
    this.classTypeList = classTypeList;
  }
}
