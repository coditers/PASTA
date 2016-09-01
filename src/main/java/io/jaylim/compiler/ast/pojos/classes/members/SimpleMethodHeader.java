package io.jaylim.compiler.ast.pojos.classes.members;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.classes.Result;
import io.jaylim.compiler.ast.pojos.types.exceptions.ExceptionType;

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
