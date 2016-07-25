package codit.ast.pojos.classes;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.types.InterfaceType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnumDeclaration extends ClassDeclaration {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final String identifier;

  private final List<InterfaceType> superInterfaceList;

  private final EnumBody enumBody;

  public EnumDeclaration(Range range, AstNode parent,
                         List<Annotation> annotationList,
                         int modifiers,
                         String identifier,
                         List<InterfaceType> superInterfaceList,
                         EnumBody enumBody) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.superInterfaceList = superInterfaceList;
    this.enumBody = enumBody;
  }

  public EnumDeclaration(Position start, Position end, AstNode parent,
                         List<Annotation> annotationList,
                         int modifiers,
                         String identifier,
                         List<InterfaceType> superInterfaceList,
                         EnumBody enumBody) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.superInterfaceList = superInterfaceList;
    this.enumBody = enumBody;
  }

  public EnumDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                         List<Annotation> annotationList,
                         int modifiers,
                         String identifier,
                         List<InterfaceType> superInterfaceList,
                         EnumBody enumBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.superInterfaceList = superInterfaceList;
    this.enumBody = enumBody;
  }
}
