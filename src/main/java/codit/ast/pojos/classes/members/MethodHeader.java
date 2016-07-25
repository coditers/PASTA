package codit.ast.pojos.classes.members;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.classes.Result;
import codit.ast.pojos.types.exceptions.ExceptionType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MethodHeader extends AstNode {

  private final Result result;
  private final MethodDeclarator methodDeclarator;
  private final List<ExceptionType> exceptionTypeList;

  public MethodHeader(Range range, AstNode parent, Result result, MethodDeclarator methodDeclarator, List<ExceptionType> exceptionTypeList) {
    super(range, parent);
    this.result = result;
    this.methodDeclarator = methodDeclarator;
    this.exceptionTypeList = exceptionTypeList;
  }

  public MethodHeader(Position start, Position end, AstNode parent, Result result, MethodDeclarator methodDeclarator, List<ExceptionType> exceptionTypeList) {
    super(start, end, parent);
    this.result = result;
    this.methodDeclarator = methodDeclarator;
    this.exceptionTypeList = exceptionTypeList;
  }

  public MethodHeader(int startLine, int startCol, int endLine, int endCol, AstNode parent, Result result, MethodDeclarator methodDeclarator, List<ExceptionType> exceptionTypeList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.result = result;
    this.methodDeclarator = methodDeclarator;
    this.exceptionTypeList = exceptionTypeList;
  }
}
