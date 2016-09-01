package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.types.exceptions.Exceptionable;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ClassType extends MultiClassOrInterfaceType implements Exceptionable {

  private final ClassOrInterfaceType classOrInterfaceType;

  private final List<Annotation> annotaitonList;
  private final String identifier;
  private final List<TypeArgument> typeArgumentList;

  public ClassType(Range range, AstNode parent,
                   ClassOrInterfaceType classOrInterfaceType,
                   Collection<Annotation> annotaitonList,
                   String identifier,
                   Collection<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.annotaitonList = new ArrayList<>(annotaitonList);
    this.identifier = identifier;
    this.typeArgumentList = new ArrayList<>(typeArgumentList);
  }

  public ClassType(Position start, Position end, AstNode parent,
                   ClassOrInterfaceType classOrInterfaceType,
                   Collection<Annotation> annotaitonList,
                   String identifier,
                   Collection<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.annotaitonList = new ArrayList<>(annotaitonList);
    this.identifier = identifier;
    this.typeArgumentList = new ArrayList<>(typeArgumentList);
  }

  public ClassType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                   ClassOrInterfaceType classOrInterfaceType,
                   Collection<Annotation> annotaitonList,
                   String identifier,
                   Collection<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.annotaitonList = new ArrayList<>(annotaitonList);
    this.identifier = identifier;
    this.typeArgumentList = new ArrayList<>(typeArgumentList);
  }

  @JsonProperty("ClassOrInterfaceType")
  public ClassOrInterfaceType getClassOrInterfaceType() {
    return classOrInterfaceType;
  }

  @JsonProperty("AnnotaitonList")
  public List<Annotation> getAnnotaitonList() {
    return annotaitonList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return typeArgumentList;
  }
}
