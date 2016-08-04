package codit.ast.pojos.expressions.primaries.methodreference;

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
public class TypeSuperMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {
}
