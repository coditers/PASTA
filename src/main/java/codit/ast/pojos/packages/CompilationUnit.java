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
public class CompilationUnit extends AstNode {
  
  // [0...1]
  private final PackageDeclaration packageDeclaration;
  // [0...N]
  private final List<ImportDeclaration> importDeclarationList;
  // [0...N]
  private final List<TypeDeclaration> typeDeclarationList;

  public CompilationUnit(Range range, 
                         PackageDeclaration packageDeclaration, 
                         Collection<ImportDeclaration> importDeclarationList,
                         Collection<TypeDeclaration> typeDeclarationList) {
    
    super(range);
    this.packageDeclaration = packageDeclaration;
    this.importDeclarationList = new ArrayList<ImportDeclaration>(importDeclarationList);
    this.typeDeclarationList = new ArrayList<TypeDeclaration>(typeDeclarationList);
  }

  public CompilationUnit(Position start, Position end, 
                         PackageDeclaration packageDeclaration, 
                         Collection<ImportDeclaration> importDeclarationList, 
                         Collection<TypeDeclaration> typeDeclarationList) {
    
    super(start, end);
    this.packageDeclaration = packageDeclaration;
    this.importDeclarationList = new ArrayList<ImportDeclaration>(importDeclarationList);
    this.typeDeclarationList = new ArrayList<TypeDeclaration>(typeDeclarationList);
  }

  public CompilationUnit(int startLine, int startCol, 
                         int endLine, int endCol, 
                         PackageDeclaration packageDeclaration, 
                         Collection<ImportDeclaration> importDeclarationList, 
                         Collection<TypeDeclaration> typeDeclarationList) {
    
    super(startLine, startCol, endLine, endCol);
    this.packageDeclaration = packageDeclaration;
    this.importDeclarationList = new ArrayList<ImportDeclaration>(importDeclarationList);
    this.typeDeclarationList = new ArrayList<TypeDeclaration>(typeDeclarationList);
  }
}