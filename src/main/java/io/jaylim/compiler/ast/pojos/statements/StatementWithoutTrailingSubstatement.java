package io.jaylim.compiler.ast.pojos.statements;

import io.jaylim.compiler.ast.pojos.ParseTree;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public interface StatementWithoutTrailingSubstatement extends Statement, StatementNoShortIf, ParseTree {
}
