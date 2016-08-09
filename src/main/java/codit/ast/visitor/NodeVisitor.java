package codit.ast.visitor;

import codit.ast.pojos.AstNode;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public interface NodeVisitor<T> {

  /**
   *
   * @param astNode The Node of Abstract Syntax Tree.
   * @return The visiting result.
   */
  T visit(AstNode astNode);

  /**
   *
   * @param astNode The Node of Abstract Syntax Tree.
   * @return The result of visiting children nodes.
   */
  T visitChildren(AstNode astNode);

  /**
   *
   * @param astNode The Node of Abstract Syntax Tree.
   * @return The result of visiting terminal node.
   */
  T visitTerminal(AstNode astNode);

  /**
   *
   * @param astNode The Node of Abstract Syntax Tree.
   * @return The result of visiting error node.
   */
  T visitErrorNode(AstNode astNode);


}
