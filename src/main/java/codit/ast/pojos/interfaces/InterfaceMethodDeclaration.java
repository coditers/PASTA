package codit.ast.pojos.interfaces;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.blocks.Block;
import codit.ast.pojos.classes.members.MethodHeader;

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
}
