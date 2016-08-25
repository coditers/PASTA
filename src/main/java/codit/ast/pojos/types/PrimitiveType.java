package codit.ast.pojos.types;

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
public class PrimitiveType extends Type implements Arrayable {

  private final List<Annotation> annotationList;
  private final Primitive type;

  public PrimitiveType(Range range, AstNode parent,
                       Collection<Annotation> annotationList,
                       Primitive type) {
    super(range, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.type = type;
  }

  public PrimitiveType(Position start, Position end, AstNode parent,
                       Collection<Annotation> annotationList,
                       Primitive type) {
    super(start, end, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.type = type;
  }

  public PrimitiveType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                       Collection<Annotation> annotationList,
                       Primitive type) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.type = type;
  }

  public enum Primitive {
    BOOLEAN("boolean"),
    CHAR("char"),
    BYTE("byte"),
    SHORT("short"),
    INT("int"),
    LONG("long"),
    FLOAT("float"),
    DOUBLE("double");

    private final String token;

    Primitive(String token) {
      this.token = token;
    }


  }

}


