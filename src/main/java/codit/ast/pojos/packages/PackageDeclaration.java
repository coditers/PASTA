package codit.ast.pojos.packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PackageDeclaration extends AstNode {

  private final List<Annotation> annotationList;
  private final List<String> identifierList;


  public PackageDeclaration(Range range, AstNode parent,
                            Collection<Annotation> annotationList,
                            Collection<String> identifierList) {
    super(range, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.identifierList = new ArrayList<>(identifierList);
  }

  public PackageDeclaration(Position start, Position end, AstNode parent,
                            Collection<Annotation> annotationList,
                            Collection<String> identifierList) {
    super(start, end, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.identifierList = new ArrayList<>(identifierList);
  }

  public PackageDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                            Collection<Annotation> annotationList,
                            Collection<String> identifierList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.identifierList = new ArrayList<>(identifierList);
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("IdentifierList")
  public List<String> getIdentifierList() {
    return identifierList;
  }
}
