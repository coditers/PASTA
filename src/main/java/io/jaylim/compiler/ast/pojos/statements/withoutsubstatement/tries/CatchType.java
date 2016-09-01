package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement.tries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.ClassType;
import io.jaylim.compiler.ast.pojos.types.unann.UnannClassType;

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

  @JsonProperty("UnannClassType")
  public UnannClassType getUnannClassType() {
    return unannClassType;
  }

  @JsonProperty("ClassTypeList")
  public List<ClassType> getClassTypeList() {
    return classTypeList;
  }
}
