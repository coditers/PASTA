package codit.ast.pojos.classes.members;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.classes.Result;
import codit.ast.pojos.types.exceptions.ExceptionType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SimpleMethodHeader extends MethodHeader {
  public SimpleMethodHeader(Range range, AstNode parent, Result result, MethodDeclarator methodDeclarator, List<ExceptionType> exceptionTypeList) {
    super(range, parent, result, methodDeclarator, exceptionTypeList);
  }

  public SimpleMethodHeader(Position start, Position end, AstNode parent, Result result, MethodDeclarator methodDeclarator, List<ExceptionType> exceptionTypeList) {
    super(start, end, parent, result, methodDeclarator, exceptionTypeList);
  }

  public SimpleMethodHeader(int startLine, int startCol, int endLine, int endCol, AstNode parent, Result result, MethodDeclarator methodDeclarator, List<ExceptionType> exceptionTypeList) {
    super(startLine, startCol, endLine, endCol, parent, result, methodDeclarator, exceptionTypeList);
  }
}
