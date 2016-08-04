package codit.ast.pojos.expressions.primaries.methodreference;

import codit.ast.pojos.expressions.primaries.interfacearray.LfDefaultArrayAccess;
import codit.ast.pojos.expressions.primaries.interfacearray.LfNoArrayAccess;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfNoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, LfnoArrayDefaultPrimary {
}
