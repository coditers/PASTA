package io.jaylim.compiler.ast.pojos.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.blocks.Block;
import io.jaylim.compiler.ast.pojos.classes.members.MethodHeader;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceMethodDeclaration extends AstNode implements InterfaceMemberable {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final MethodHeader methodHeader;

  private final Block block;

  public InterfaceMethodDeclaration(Range range, AstNode parent,
                                    List<Annotation> annotationList,
                                    int modifiers,
                                    MethodHeader methodHeader,
                                    Block block) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.methodHeader = methodHeader;
    this.block = block;
  }

  public InterfaceMethodDeclaration(Position start, Position end, AstNode parent,
                                    List<Annotation> annotationList,
                                    int modifiers,
                                    MethodHeader methodHeader,
                                    Block block) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.methodHeader = methodHeader;
    this.block = block;
  }

  public InterfaceMethodDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                    List<Annotation> annotationList,
                                    int modifiers,
                                    MethodHeader methodHeader,
                                    Block block) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.methodHeader = methodHeader;
    this.block = block;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Modifiers")
  public int getModifiers() {
    return modifiers;
  }

  @JsonProperty("MethodHeader")
  public MethodHeader getMethodHeader() {
    return methodHeader;
  }

  @JsonProperty("Block")
  public Block getBlock() {
    return block;
  }
}
