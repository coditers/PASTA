package codit.ast.pojos.expressions.primaries.methodinvocation;

import codit.ast.pojos.expressions.primaries.interfacearray.LfDefaultArrayAccess;
import codit.ast.pojos.expressions.primaries.interfacearray.LfNoArrayAccess;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfNoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeSuperMethodInvocation extends MethodInvocation
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {
}
