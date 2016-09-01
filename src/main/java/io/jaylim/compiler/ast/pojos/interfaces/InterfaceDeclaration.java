package io.jaylim.compiler.ast.pojos.interfaces;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.AnnotationTypeMemberable;
import io.jaylim.compiler.ast.pojos.classes.members.ClassMemberable;
import io.jaylim.compiler.ast.pojos.packages.TypeDeclaration;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceDeclaration extends TypeDeclaration implements ClassMemberable, InterfaceMemberable, AnnotationTypeMemberable {
  public InterfaceDeclaration(Range range, AstNode parent) {
    super(range, parent);
  }

  public InterfaceDeclaration(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public InterfaceDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
