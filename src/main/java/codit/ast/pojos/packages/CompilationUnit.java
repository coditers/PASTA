package codit.ast.pojos.packages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

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

  public CompilationUnit(Range range, AstNode parent,
                         PackageDeclaration packageDeclaration, 
                         Collection<ImportDeclaration> importDeclarationList,
                         Collection<TypeDeclaration> typeDeclarationList) {
    
    super(range, parent);
    this.packageDeclaration = packageDeclaration;
    this.importDeclarationList = new ArrayList<ImportDeclaration>(importDeclarationList);
    this.typeDeclarationList = new ArrayList<TypeDeclaration>(typeDeclarationList);
  }

  public CompilationUnit(Position start, Position end, AstNode parent,
                         PackageDeclaration packageDeclaration, 
                         Collection<ImportDeclaration> importDeclarationList, 
                         Collection<TypeDeclaration> typeDeclarationList) {
    
    super(start, end, parent);
    this.packageDeclaration = packageDeclaration;
    this.importDeclarationList = new ArrayList<ImportDeclaration>(importDeclarationList);
    this.typeDeclarationList = new ArrayList<TypeDeclaration>(typeDeclarationList);
  }

  public CompilationUnit(int startLine, int startCol, 
                         int endLine, int endCol, AstNode parent,
                         PackageDeclaration packageDeclaration, 
                         Collection<ImportDeclaration> importDeclarationList, 
                         Collection<TypeDeclaration> typeDeclarationList) {
    
    super(startLine, startCol, endLine, endCol, parent);
    this.packageDeclaration = packageDeclaration;
    this.importDeclarationList = new ArrayList<ImportDeclaration>(importDeclarationList);
    this.typeDeclarationList = new ArrayList<TypeDeclaration>(typeDeclarationList);
  }
}