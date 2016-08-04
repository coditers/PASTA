package codit.ast.pojos.expressions.primaries.arrayaccess;

import codit.ast.pojos.expressions.primaries.interfacearray.LfDefaultArrayAccess;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfNoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionArrayAccess extends ArrayAccess
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary {
}
