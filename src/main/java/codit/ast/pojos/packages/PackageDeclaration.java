package codit.ast.pojos.packages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PackageDeclaration extends AstNode {

  private final List<PackageModifier> packageModifierList;
  private final List<String> identifierList;


  public PackageDeclaration(Range range,
                            Collection<PackageModifier> packageModifierList,
                            Collection<String> identifierList) {
    super(range);
    this.packageModifierList = new ArrayList<>(packageModifierList);
    this.identifierList = new ArrayList<>(identifierList);
  }

  public PackageDeclaration(Position start, Position end,
                            Collection<PackageModifier> packageModifierList,
                            Collection<String> identifierList) {
    super(start, end);
    this.packageModifierList = new ArrayList<>(packageModifierList);
    this.identifierList = new ArrayList<>(identifierList);
  }

  public PackageDeclaration(int startLine, int startCol, int endLine, int endCol,
                            Collection<PackageModifier> packageModifierList,
                            Collection<String> identifierList) {
    super(startLine, startCol, endLine, endCol);
    this.packageModifierList = new ArrayList<>(packageModifierList);
    this.identifierList = new ArrayList<>(identifierList);
  }
}
