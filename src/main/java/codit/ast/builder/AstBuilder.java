package codit.ast.builder;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

import codit.ast.AstNode;
import codit.ast.Modifiers;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.annotations.MarkerAnnotation;
import codit.ast.pojos.annotations.NormalAnnotation;
import codit.ast.pojos.annotations.SingleElementAnnotation;
import codit.ast.pojos.blocks.Block;
import codit.ast.pojos.blocks.BlockStatements;
import codit.ast.pojos.blocks.InBlockStatement;
import codit.ast.pojos.blocks.LocalVariableDeclaration;
import codit.ast.pojos.blocks.LocalVariableDeclarationStatement;
import codit.ast.pojos.classes.ArrayInitializer;
import codit.ast.pojos.classes.ClassBodyDeclaration;
import codit.ast.pojos.classes.ClassDeclaration;
import codit.ast.pojos.classes.EnumBody;
import codit.ast.pojos.classes.EnumConstant;
import codit.ast.pojos.classes.EnumDeclaration;
import codit.ast.pojos.classes.ExpressionVariableInitializer;
import codit.ast.pojos.classes.InstanceInitializer;
import codit.ast.pojos.classes.NormalClassDeclaration;
import codit.ast.pojos.classes.Result;
import codit.ast.pojos.classes.StaticInitializer;
import codit.ast.pojos.classes.constructors.ConstructorBody;
import codit.ast.pojos.classes.constructors.ConstructorDeclaration;
import codit.ast.pojos.classes.constructors.ConstructorDeclarator;
import codit.ast.pojos.classes.constructors.ExplicitConstructorInvocation;
import codit.ast.pojos.classes.constructors.ExpressionSuperConstructorInvocation;
import codit.ast.pojos.classes.constructors.PrimarySuperConstructorInvocation;
import codit.ast.pojos.classes.constructors.SuperConstructorInvocation;
import codit.ast.pojos.classes.constructors.ThisConstructorInvocation;
import codit.ast.pojos.classes.members.AnnotationMethodHeader;
import codit.ast.pojos.classes.members.ClassMemberDeclaration;
import codit.ast.pojos.classes.members.ClassMemberable;
import codit.ast.pojos.classes.members.FieldDeclaration;
import codit.ast.pojos.classes.members.MethodDeclaration;
import codit.ast.pojos.classes.members.MethodDeclarator;
import codit.ast.pojos.classes.members.MethodHeader;
import codit.ast.pojos.classes.members.SimpleMethodHeader;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.StatementExpression;
import codit.ast.pojos.expressions.StatementExpressionList;
import codit.ast.pojos.expressions.assignments.Assignment;
import codit.ast.pojos.expressions.assignments.LeftHandSide;
import codit.ast.pojos.expressions.lambdas.InferredFormalLambdaParameter;
import codit.ast.pojos.expressions.lambdas.LambdaBody;
import codit.ast.pojos.expressions.lambdas.LambdaExpression;
import codit.ast.pojos.expressions.lambdas.LambdaParameters;
import codit.ast.pojos.expressions.lambdas.SingleLambdaParameter;
import codit.ast.pojos.expressions.primaries.Primary;
import codit.ast.pojos.expressions.primaries.PrimaryArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.PrimaryNoNewArray;
import codit.ast.pojos.expressions.primaries.arrayaccess.DefaultPrimaryArrayAccess;
import codit.ast.pojos.expressions.primaries.arrayaccess.DefaultPrimaryExpressionArrayAccess;
import codit.ast.pojos.expressions.primaries.arrayaccess.LfPrimaryArrayAccess;
import codit.ast.pojos.expressions.primaries.arrayaccess.LfnoPrimaryArrayAccess;
import codit.ast.pojos.expressions.primaries.arrayaccess.LfnoPrimaryExpressionArrayAccess;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.ArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.BasicClassOrInterfaceArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.BasicPrimitiveArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.DimExpr;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.InitializeClassOrInterfaceArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.InitializePrimitiveArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.basics.BasicThisExpression;
import codit.ast.pojos.expressions.primaries.basics.LiteralExpression;
import codit.ast.pojos.expressions.primaries.basics.ParenthesizedExpression;
import codit.ast.pojos.expressions.primaries.basics.PrimitiveClassLiteralExpression;
import codit.ast.pojos.expressions.primaries.basics.ReferenceClassLiteralExpression;
import codit.ast.pojos.expressions.primaries.basics.ReferenceThisExpression;
import codit.ast.pojos.expressions.primaries.basics.VoidClassLiteralExpression;
import codit.ast.pojos.expressions.primaries.classinstancecreation.BasicClassInstanceCreationExpression;
import codit.ast.pojos.expressions.primaries.classinstancecreation.ExpressionClassInstanceCreationExpression;
import codit.ast.pojos.expressions.primaries.classinstancecreation.PostfixClassInstanceCreationExpression;
import codit.ast.pojos.expressions.primaries.classinstancecreation.PrimaryClassInstanceCreationExpression;
import codit.ast.pojos.expressions.primaries.fieldaccess.BasicFieldAccess;
import codit.ast.pojos.expressions.primaries.fieldaccess.PostfixFieldAccess;
import codit.ast.pojos.expressions.primaries.fieldaccess.PrimaryFieldAccess;
import codit.ast.pojos.expressions.primaries.fieldaccess.ReferenceFieldAccess;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.methodinvocation.BasicMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodinvocation.BasicSuperMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodinvocation.ExpressionMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodinvocation.PostfixMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodinvocation.PrimaryMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodinvocation.TypeMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodinvocation.TypeSuperMethodInvocation;
import codit.ast.pojos.expressions.primaries.methodreference.ArrayMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.BasicSuperMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.ClassMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.ExpressionMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.PostfixMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.PrimaryMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.ReferenceMethodReference;
import codit.ast.pojos.expressions.primaries.methodreference.TypeSuperMethodReference;
import codit.ast.pojos.interfaces.AnnotationTypeDeclaration;
import codit.ast.pojos.interfaces.AnnotationTypeElementDeclaration;
import codit.ast.pojos.interfaces.AnnotationTypeMemberable;
import codit.ast.pojos.interfaces.ConstantDeclaration;
import codit.ast.pojos.interfaces.ElementValue;
import codit.ast.pojos.interfaces.ElementValueArrayInitializer;
import codit.ast.pojos.interfaces.ElementValuePair;
import codit.ast.pojos.interfaces.InterfaceDeclaration;
import codit.ast.pojos.interfaces.InterfaceMemberable;
import codit.ast.pojos.interfaces.InterfaceMethodDeclaration;
import codit.ast.pojos.interfaces.NormalInterfaceDeclaration;
import codit.ast.pojos.literals.BooleanLiteral;
import codit.ast.pojos.literals.CharacterLiteral;
import codit.ast.pojos.literals.Literal;
import codit.ast.pojos.literals.NullLiteral;
import codit.ast.pojos.literals.StringLiteral;
import codit.ast.pojos.literals.floats.DecimalFloatLiteral;
import codit.ast.pojos.literals.floats.HexFloatLiteral;
import codit.ast.pojos.literals.integers.BinaryIntegerLiteral;
import codit.ast.pojos.literals.integers.DecimalIntegerLiteral;
import codit.ast.pojos.literals.integers.HexIntegerLiteral;
import codit.ast.pojos.literals.integers.OctalIntegerLiteral;
import codit.ast.pojos.names.AmbiguousName;
import codit.ast.pojos.names.ExpressionName;
import codit.ast.pojos.names.MethodName;
import codit.ast.pojos.names.PackageOrTypeName;
import codit.ast.pojos.names.TypeName;
import codit.ast.pojos.packages.CompilationUnit;
import codit.ast.pojos.packages.ImportDeclaration;
import codit.ast.pojos.packages.PackageDeclaration;
import codit.ast.pojos.packages.SingleStaticImportDeclaration;
import codit.ast.pojos.packages.SingleTypeImportDeclaration;
import codit.ast.pojos.packages.StaticImportOnDemandDeclaration;
import codit.ast.pojos.packages.TypeDeclaration;
import codit.ast.pojos.packages.TypeImportOnDemandDeclaration;
import codit.ast.pojos.parameters.FormalParameter;
import codit.ast.pojos.parameters.FormalParameterList;
import codit.ast.pojos.parameters.LastFormalParameter;
import codit.ast.pojos.parameters.Parameter;
import codit.ast.pojos.parameters.ReceiverParameter;
import codit.ast.pojos.statements.Statement;
import codit.ast.pojos.statements.StatementNoShortIf;
import codit.ast.pojos.statements.normal.BasicForStatement;
import codit.ast.pojos.statements.normal.EnhancedForStatement;
import codit.ast.pojos.statements.normal.ForInit;
import codit.ast.pojos.statements.normal.IfThenElseStatement;
import codit.ast.pojos.statements.normal.IfThenStatement;
import codit.ast.pojos.statements.normal.LabeledStatement;
import codit.ast.pojos.statements.normal.WhileStatement;
import codit.ast.pojos.statements.noshortif.BasicForStatementNoShortIf;
import codit.ast.pojos.statements.noshortif.EnhancedForStatementNoShortIf;
import codit.ast.pojos.statements.noshortif.IfThenElseStatementNoShortIf;
import codit.ast.pojos.statements.noshortif.LabeledStatementNoShortIf;
import codit.ast.pojos.statements.noshortif.WhileStatementNoShortIf;
import codit.ast.pojos.statements.withoutsubstatement.BreakStatement;
import codit.ast.pojos.statements.withoutsubstatement.ContinueStatement;
import codit.ast.pojos.statements.withoutsubstatement.DoStatement;
import codit.ast.pojos.statements.withoutsubstatement.EmptyStatement;
import codit.ast.pojos.statements.withoutsubstatement.ExpressionStatement;
import codit.ast.pojos.statements.withoutsubstatement.ReturnStatement;
import codit.ast.pojos.statements.withoutsubstatement.SynchronizedStatement;
import codit.ast.pojos.statements.withoutsubstatement.ThrowStatement;
import codit.ast.pojos.statements.withoutsubstatement.asserts.BinAssertStatement;
import codit.ast.pojos.statements.withoutsubstatement.asserts.UnaryAssertStatement;
import codit.ast.pojos.statements.withoutsubstatement.switches.ConstantSwitchLabel;
import codit.ast.pojos.statements.withoutsubstatement.switches.DefaultSwitchLabel;
import codit.ast.pojos.statements.withoutsubstatement.switches.EnumSwitchLabel;
import codit.ast.pojos.statements.withoutsubstatement.switches.SwitchBlock;
import codit.ast.pojos.statements.withoutsubstatement.switches.SwitchBlockStatementGroup;
import codit.ast.pojos.statements.withoutsubstatement.switches.SwitchLabel;
import codit.ast.pojos.statements.withoutsubstatement.switches.SwitchStatement;
import codit.ast.pojos.statements.withoutsubstatement.tries.CatchClause;
import codit.ast.pojos.statements.withoutsubstatement.tries.CatchFormalParameter;
import codit.ast.pojos.statements.withoutsubstatement.tries.CatchType;
import codit.ast.pojos.statements.withoutsubstatement.tries.Resource;
import codit.ast.pojos.statements.withoutsubstatement.tries.TryCatchFinallyStatement;
import codit.ast.pojos.statements.withoutsubstatement.tries.TryCatchStatement;
import codit.ast.pojos.statements.withoutsubstatement.tries.TryWithResourcesStatement;
import codit.ast.pojos.types.ArrayType;
import codit.ast.pojos.types.ClassOrInterfaceType;
import codit.ast.pojos.types.ClassOrInterfaceTypeBound;
import codit.ast.pojos.types.ClassType;
import codit.ast.pojos.types.Diamond;
import codit.ast.pojos.types.Dims;
import codit.ast.pojos.types.InterfaceType;
import codit.ast.pojos.types.PrimitiveType;
import codit.ast.pojos.types.ReferenceType;
import codit.ast.pojos.types.TypeArgument;
import codit.ast.pojos.types.TypeArguments;
import codit.ast.pojos.types.TypeArgumentsOrDiamond;
import codit.ast.pojos.types.TypeBound;
import codit.ast.pojos.types.TypeParameter;
import codit.ast.pojos.types.TypeVariable;
import codit.ast.pojos.types.UnitClassOrInterfaceType;
import codit.ast.pojos.types.UnitClassType;
import codit.ast.pojos.types.UnitInterfaceType;
import codit.ast.pojos.types.VariableTypeBound;
import codit.ast.pojos.types.Wildcard;
import codit.ast.pojos.types.WildcardBounds;
import codit.ast.pojos.types.exceptions.ExceptionType;
import codit.ast.pojos.types.exceptions.Exceptionable;
import codit.ast.pojos.types.unann.LfUnannUnitClassType;
import codit.ast.pojos.types.unann.LfUnannUnitInterfaceType;
import codit.ast.pojos.types.unann.UnannArrayType;
import codit.ast.pojos.types.unann.UnannClassOrInterfaceType;
import codit.ast.pojos.types.unann.UnannClassType;
import codit.ast.pojos.types.unann.UnannInterfaceType;
import codit.ast.pojos.types.unann.UnannPrimitiveType;
import codit.ast.pojos.types.unann.UnannReferenceType;
import codit.ast.pojos.types.unann.UnannType;
import codit.ast.pojos.types.unann.UnannTypeVariable;
import codit.ast.pojos.types.unann.UnannUnitClassOrInterfaceType;
import codit.ast.pojos.types.unann.UnannUnitClassType;
import codit.ast.pojos.types.unann.UnannUnitInterfaceType;
import codit.ast.pojos.variables.VariableDeclarator;
import codit.ast.pojos.variables.VariableDeclaratorId;
import codit.ast.pojos.variables.VariableInitializer;
import codit.gencode.JavaBaseVisitor;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AstBuilder extends JavaBaseVisitor<AstNode> {

  private Range getRange(ParserRuleContext ctx) {
    return new Range( ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                      ctx.getStop().getLine(),  ctx.getStop().getCharPositionInLine() );
  }

  @Override
  public AstNode visitLiteral(JavaParser.LiteralContext ctx) { // TODO - Refactoring

    // get range of symbol
    Range range = getRange(ctx);

    // get raw text
    String rawText = ctx.getText();

    // get parent
//    AstNode parent = null;
//    if( ctx.getParent() != null ) {
//      parent = visit(ctx.getParent());
//    }

    if (ctx.IntegerLiteral() != null) {
      // HEXADECIMAL / BINARY / OCTAL / DECIMAL
      if (rawText.startsWith("0x") || rawText.startsWith("0X")) {
        // Hex INTEGER / LONG Literals
        return new HexIntegerLiteral(range, null, rawText);
      } else if (rawText.startsWith("0b") || rawText.startsWith("0B")) {
        // Binary INTEGER / LONG Literals
        return new BinaryIntegerLiteral(range, null, rawText);
      } else if (rawText.startsWith("0") && !rawText.equals("0")) {
        // Oct INTEGER / LONG Literals
        return new OctalIntegerLiteral(range, null, rawText);
      } else {
        // Dec INTEGER / LONG Literals
        return new DecimalIntegerLiteral(range, null, rawText);
      }
    } else if (ctx.BooleanLiteral() != null) {
      // System.out.println("Boolean");
      return new BooleanLiteral(range, null, rawText);

    } else if (ctx.StringLiteral() != null) {
      return new StringLiteral(range, null, rawText);

    } else if (ctx.CharacterLiteral() != null) {
      return new CharacterLiteral(range, null, rawText);
    } else if (ctx.FloatingPointLiteral() != null) {
      if(rawText.startsWith("0x") || rawText.startsWith("0X")) {
        return new HexFloatLiteral(range, null, rawText);
      } else {
        return new DecimalFloatLiteral(range, null, rawText);
      }
    } else if (ctx.NullLiteral() != null) {
      return new NullLiteral(range, null, rawText);
    } else {
      System.err.println("ERROR!");
      return super.visitLiteral(ctx);
    }
  }

  @Override
  public AstNode visitType(JavaParser.TypeContext ctx) {
    if (ctx.primitiveType() != null) {
      return (PrimitiveType) visit(ctx.primitiveType());
    } else if (ctx.referenceType() != null) {
      return (ReferenceType) visit(ctx.referenceType());
    } else {
      System.err.println("ERROR : visitType");
      return super.visitType(ctx);
    }
  }

  @Override
  public AstNode visitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {

    // get range of symbol
    Range range = getRange(ctx);

    // get Annotation List
    List<Annotation> annotationList = new ArrayList<>();
    for(JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    String text;
    if (ctx.numericType() != null) {

      if (ctx.numericType().integralType() != null) {
        text = ctx.numericType().integralType().getText();

      } else if (ctx.numericType().floatingPointType() != null) {
        text = ctx.numericType().floatingPointType().getText();

      } else {
        System.err.println("ERROR");
        return super.visitPrimitiveType(ctx);
      }

    } else { text = "boolean"; }

    return new PrimitiveType(range, null, annotationList, PrimitiveType.Primitive.valueOf(text));
  }

  @Override
  public AstNode visitNumericType(JavaParser.NumericTypeContext ctx) { // Not necessary
    return super.visitNumericType(ctx);
  }

  @Override
  public AstNode visitIntegralType(JavaParser.IntegralTypeContext ctx) { // Not necessary
    return super.visitIntegralType(ctx);
  }

  @Override
  public AstNode visitFloatingPointType(JavaParser.FloatingPointTypeContext ctx) { // Not necessary
    return super.visitFloatingPointType(ctx);
  }

  @Override
  public AstNode visitReferenceType(JavaParser.ReferenceTypeContext ctx) {
    
    if (ctx.classOrInterfaceType() != null) {
      return (ClassOrInterfaceType) visit(ctx.classOrInterfaceType());   
    } /*else if (ctx.typeVariable() != null) {
      return (TypeVariable) visit(ctx.typeVariable());
    } else if (ctx.arrayType() != null) {
      return (ArrayType);
    } */else {
      System.err.println("ERROR : visitReferenceType");
      return super.visitReferenceType(ctx);
    }
  }

  @Override
  public AstNode visitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // is Interface
    boolean isInterface = false;
    if (ctx.getChild(ctx.getChildCount()-1).getParent()
        instanceof JavaParser.InterfaceType_lf_classOrInterfaceTypeContext) {
      isInterface = true;
    }

    // get Class or Interface Type List ( except last child )
    UnitClassOrInterfaceType unitClassOrInterfaceType = null;

    if (ctx.classType_lfno_classOrInterfaceType() != null) {
      unitClassOrInterfaceType
          = (UnitClassOrInterfaceType) visit(ctx.classType_lfno_classOrInterfaceType());
    } else if (ctx.interfaceType_lfno_classOrInterfaceType() != null) {
      unitClassOrInterfaceType
          = (UnitClassOrInterfaceType) visit(ctx.interfaceType_lfno_classOrInterfaceType());
    } else {
      System.err.println("ERROR : visitClassOrInterfaceType");
    }


    // get Unit Class Or Interface Type ( last child )
    List<UnitClassOrInterfaceType> unitClassOrInterfaceTypeList = new ArrayList<>();

    for (int i = 1; i < ctx.getChildCount() ; i++) {
      ParseTree child = ctx.getChild(i);
      if (child instanceof JavaParser.ClassType_lf_classOrInterfaceTypeContext) {
        UnitClassOrInterfaceType unitClassType = (UnitClassOrInterfaceType) visit(child);
        unitClassOrInterfaceTypeList.add( unitClassType );
      } else if (child instanceof JavaParser.InterfaceType_lf_classOrInterfaceTypeContext) {
        UnitClassOrInterfaceType unitInterfaceType = (UnitClassOrInterfaceType) visit(child);
        unitClassOrInterfaceTypeList.add( unitInterfaceType );
      } else {
        System.err.println("ERROR : visitClassOrInterfaceType");
      }
    }

    return new ClassOrInterfaceType(range, null, isInterface, unitClassOrInterfaceType, unitClassOrInterfaceTypeList);
  }

  @Override
  public AstNode visitClassType(JavaParser.ClassTypeContext ctx) {
    // get range of symbol
    Range range = getRange(ctx);

    // get parent
//    AstNode parent = null;
//    if( ctx.getParent() != null ) {
//      parent = visit(ctx.getParent());
//    }

    // is Interface
//    boolean isInterface = false;
//    if (ctx.getParent() instanceof JavaParser.InterfaceType_lfno_classOrInterfaceTypeContext) {
//      isInterface = true;
//    }

    // get Class or Interface Type List
    ClassOrInterfaceType classOrInterfaceType = null;
    if( ctx.classOrInterfaceType() != null ) {
      classOrInterfaceType = (ClassOrInterfaceType) visit(ctx.classOrInterfaceType());
    }

    // get annotation list
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get Type argument list
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext
        : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    return new ClassType(range, null, classOrInterfaceType, annotationList, identifier, typeArgumentList);
  }

  @Override
  public AstNode visitClassType_lf_classOrInterfaceType(JavaParser.ClassType_lf_classOrInterfaceTypeContext ctx) {

    // get range of symbol
    Range range = getRange(ctx);

    // get parent
//    AstNode parent = null;
//    if( ctx.getParent() != null ) {
//      parent = visit(ctx.getParent());
//    }

    // is Interface
//    boolean isInterface = false;
//    if (ctx.getParent() instanceof JavaParser.InterfaceType_lf_classOrInterfaceTypeContext) {
//      isInterface = true;
//    }

    // get annotation list
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get Type argument list
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext
        : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    return new UnitClassType(range, null, annotationList, identifier, typeArgumentList);
  }

  @Override
  public AstNode visitClassType_lfno_classOrInterfaceType(JavaParser.ClassType_lfno_classOrInterfaceTypeContext ctx) {

    // get range of symbol
    Range range = getRange(ctx);

    // get parent
//    AstNode parent = null;
//    if( ctx.getParent() != null ) {
//      parent = visit(ctx.getParent());
//    }

    // is Interface
//    boolean isInterface = false;
//    if (ctx.getParent() instanceof JavaParser.InterfaceType_lfno_classOrInterfaceTypeContext) {
//      isInterface = true;
//    }

    // get annotation list
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get Type argument list
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext
        : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    return new UnitClassType(range, null, annotationList, identifier, typeArgumentList);
  }

  @Override
  public AstNode visitInterfaceType(JavaParser.InterfaceTypeContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get class type
    ClassType classType = (ClassType) visit(ctx.classType());

    return new InterfaceType(range, null, classType);
  }

  @Override
  public AstNode visitInterfaceType_lf_classOrInterfaceType(JavaParser.InterfaceType_lf_classOrInterfaceTypeContext ctx) {

    // get Range
    Range range = getRange(ctx);

    //get unit Class Type
    UnitClassType unitClassType = (UnitClassType) visit(ctx.classType_lf_classOrInterfaceType());


    return new UnitInterfaceType(range, null, unitClassType);
  }

  @Override
  public AstNode visitInterfaceType_lfno_classOrInterfaceType(JavaParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx) {

    // get Range
    Range range = getRange(ctx);

    //get unit Class Type
    UnitClassType unitClassType = (UnitClassType) visit(ctx.classType_lfno_classOrInterfaceType());

    return new UnitInterfaceType(range, null, unitClassType);
  }

  @Override
  public AstNode visitTypeVariable(JavaParser.TypeVariableContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get annotation list
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    return new TypeVariable(range, null, annotationList, identifier);
  }

  @Override
  public AstNode visitArrayType(JavaParser.ArrayTypeContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get Dims
    Dims dims = (Dims) visit(ctx.dims());

    if ( ctx.classOrInterfaceType() != null ) {
      ClassOrInterfaceType classOrInterfaceType
          = (ClassOrInterfaceType) visit(ctx.classOrInterfaceType());
      return new ArrayType(range, null, classOrInterfaceType, dims);
    } else if ( ctx.typeVariable() != null ) {
      TypeVariable typeVariable
          = (TypeVariable) visit(ctx.typeVariable());
      return new ArrayType(range, null, typeVariable, dims);
    } else if ( ctx.primitiveType() != null ) {
      PrimitiveType primitiveType
          = (PrimitiveType) visit(ctx.primitiveType());
      return new ArrayType(range, null, primitiveType, dims);
    } else {
      System.err.println("ERROR : visitArrayType");
      return super.visitArrayType(ctx);
    }

  }

  @Override
  public AstNode visitDims(JavaParser.DimsContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get list of list of annotations
    List<List<Annotation>> annotationListList = new ArrayList<>();

    List<Annotation> annotationList = new ArrayList<Annotation>();
    annotationListList.add(annotationList);

    for (ParseTree child : ctx.children) {

      if (child.getText().equals("[")) {
        annotationList = new ArrayList<Annotation>();
        annotationListList.add(annotationList);
      }

      if (child instanceof JavaParser.AnnotationContext) {
        Annotation annotation = (Annotation) visit(child);
        annotationList.add(annotation);
      }
    }
    return new Dims(range, null, annotationListList);
  }

  @Override
  public AstNode visitTypeParameter(JavaParser.TypeParameterContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Annotations
    List<Annotation> annotationList = new ArrayList<>();
    for(JavaParser.TypeParameterModifierContext typeParameterModifierContext
        : ctx.typeParameterModifier()) {
      Annotation annotation = (Annotation) visit(typeParameterModifierContext.annotation());
      annotationList.add(annotation);
    }

    // get Identifier
    String identifier = ctx.Identifier().getText();

    // get Type bound
    TypeBound typeBound = (TypeBound) visit(ctx.typeBound());

    return new TypeParameter(range, null, annotationList, identifier, typeBound);
  }

  @Override
  public AstNode visitTypeParameterModifier(JavaParser.TypeParameterModifierContext ctx) {
    // Not necessary - Functional issues are handed over to visitTypeParameter
    // Because it only has an annotation as its own parameter.
    return super.visitTypeParameterModifier(ctx);
  }

  @Override
  public AstNode visitTypeBound(JavaParser.TypeBoundContext ctx) {

    // get range
    Range range = getRange(ctx);

    if(ctx.typeVariable() != null) {
      TypeVariable typeVariable = (TypeVariable) visit(ctx.typeVariable());
      return new VariableTypeBound(range, null, typeVariable);
    } else if (ctx.classOrInterfaceType() != null) {

      // get Class or interface type
      ClassOrInterfaceType classOrInterfaceType = (ClassOrInterfaceType) visit(ctx.classOrInterfaceType());

      // get Interface type list
      List<InterfaceType> interfaceTypeList = new ArrayList<>();
      for(JavaParser.AdditionalBoundContext additionalBoundContext : ctx.additionalBound()) {
        InterfaceType interfaceType = (InterfaceType) visit(additionalBoundContext.interfaceType());
        interfaceTypeList.add(interfaceType);
      }

      return new ClassOrInterfaceTypeBound(range, null, classOrInterfaceType, interfaceTypeList);
    } else {
      System.err.println("ERROR : visitTypeBound");
      return super.visitTypeBound(ctx);
    }

  }

  @Override
  public AstNode visitAdditionalBound(JavaParser.AdditionalBoundContext ctx) {
    // Not necessary - Functional issues are handed over to visitTypeBound
    // Because it only has an interfaceType as its own parameter.
    return super.visitAdditionalBound(ctx);
  }

  @Override
  public AstNode visitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
    // Not necessary
    return super.visitTypeArguments(ctx);
  }

  @Override
  public AstNode visitTypeArgumentList(JavaParser.TypeArgumentListContext ctx) {
    // Not necessary
    return super.visitTypeArgumentList(ctx);
  }

  @Override
  public AstNode visitTypeArgument(JavaParser.TypeArgumentContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Arguable instnace
    if ( ctx.referenceType() != null ) {
      ReferenceType referenceType = (ReferenceType) visit(ctx.referenceType());
      return new TypeArgument(range, null, referenceType);
    } else if ( ctx.wildcard() != null ) {
      Wildcard wildcard = (Wildcard) visit(ctx.wildcard());
      return new TypeArgument(range, null, wildcard);
    } else {
      System.err.println("ERROR : visitTypeArgumnet");
      return super.visitTypeArgument(ctx);
    }

  }

  @Override
  public AstNode visitWildcard(JavaParser.WildcardContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get annotation list
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get wildcard bounds
    WildcardBounds wildcardBounds = (WildcardBounds) visit(ctx.wildcardBounds());

    return new Wildcard(range, null, annotationList, wildcardBounds);
  }

  @Override
  public AstNode visitWildcardBounds(JavaParser.WildcardBoundsContext ctx) {

    // get range
    Range range = getRange(ctx);

    // is extends
    Boolean isExtends;
    String token = ctx.getChild(0).getText();
    switch (token) {
      case "extends":
        isExtends = true;
        break;
      case "super":
        isExtends = false;
        break;
      default:
        System.err.println("ERROR : visitWildcardBounds [ Expected : nullPointException ]");
        isExtends = null;
        break;
    }

    // get reference type
    ReferenceType referenceType = (ReferenceType) visit(ctx.referenceType());

    return new WildcardBounds(range, null, isExtends, referenceType);
  }

  @Override
  public AstNode visitPackageName(JavaParser.PackageNameContext ctx) {
    // No necessary
    return super.visitPackageName(ctx);
  }

  @Override
  public AstNode visitTypeName(JavaParser.TypeNameContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Identifier
    String identifier = ctx.Identifier().toString();

    // get packageOrTypeName
    PackageOrTypeName packageOrTypeName = null;
    if ( ctx.packageOrTypeName() != null ) {
      packageOrTypeName = (PackageOrTypeName) visit(ctx.packageOrTypeName());
    }

    return new TypeName(range, null, identifier, packageOrTypeName);
  }

  @Override
  public AstNode visitPackageOrTypeName(JavaParser.PackageOrTypeNameContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Identifier
    String identifier = ctx.Identifier().toString();

    // get packageOrTypeName
    PackageOrTypeName packageOrTypeName = null;
    if ( ctx.packageOrTypeName() != null ) {
      packageOrTypeName = (PackageOrTypeName) visit(ctx.packageOrTypeName());
    }
    return new PackageOrTypeName(range, null, identifier, packageOrTypeName);
  }

  @Override
  public AstNode visitExpressionName(JavaParser.ExpressionNameContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Identifier
    String identifier = ctx.Identifier().toString();

    // get Anbiguous mame
    AmbiguousName ambiguousName = null;
    if ( ctx.ambiguousName() != null ) {
      ambiguousName = (AmbiguousName) visit(ctx.ambiguousName());
    }

    return new ExpressionName(range, null, identifier, ambiguousName);
  }

  @Override
  public AstNode visitMethodName(JavaParser.MethodNameContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Identifier
    String identifier = ctx.Identifier().toString();

    return new MethodName(range, null, identifier);
  }

  @Override
  public AstNode visitAmbiguousName(JavaParser.AmbiguousNameContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Identifier
    String identifier = ctx.Identifier().toString();

    // get Anbiguous mame
    AmbiguousName ambiguousName = null;
    if ( ctx.ambiguousName() != null ) {
      ambiguousName = (AmbiguousName) visit(ctx.ambiguousName());
    }

    return new AmbiguousName(range, null, identifier, ambiguousName);
  }

  @Override
  public AstNode visitCompilationUnit(JavaParser.CompilationUnitContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get Parent
//    AstNode parent = null;
//    if( ctx.getParent() != null ) {
//      parent = visit(ctx.getParent());
//    }

    // get Package Declaration
    PackageDeclaration packageDeclaration = (PackageDeclaration) visit(ctx.packageDeclaration());

    // get Import Declaration List
    List<ImportDeclaration> importDeclarationList = new ArrayList<>();
    for(JavaParser.ImportDeclarationContext importDeclarationContext : ctx.importDeclaration()) {
      ImportDeclaration importDeclaration = (ImportDeclaration) visit(importDeclarationContext);
      importDeclarationList.add(importDeclaration);
    }

    // get Type Declaration List
    List<TypeDeclaration> typeDeclarationList = new ArrayList<>();
    for(JavaParser.TypeDeclarationContext typeDeclarationContext : ctx.typeDeclaration()) {
      TypeDeclaration typeDeclaration = (TypeDeclaration) visit(typeDeclarationContext);
      typeDeclarationList.add(typeDeclaration);
    }

    return new CompilationUnit(range, null, packageDeclaration, importDeclarationList, typeDeclarationList);
  }

  @Override
  public AstNode visitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {

    //
    Range range = getRange(ctx);

    // get Parent
//    AstNode parent = null;
//    if( ctx.getParent() != null ) {
//      parent = visit(ctx.getParent());
//    }

    //
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.PackageModifierContext packageModifierContext : ctx.packageModifier()) {
      Annotation annotation = (Annotation) visit(packageModifierContext.annotation());
      annotationList.add(annotation);
    }

    //
    List<String> identifierList = new ArrayList<>();
    for (TerminalNode identifierNode : ctx.Identifier()){
      String identifier = identifierNode.getText();
      identifierList.add(identifier);
    }

    return new PackageDeclaration(range, null, annotationList, identifierList);
  }

  @Override
  public AstNode visitPackageModifier(JavaParser.PackageModifierContext ctx) {
    // Not necessary
    return super.visitPackageModifier(ctx);
  }

  @Override
  public AstNode visitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
    if (ctx.singleStaticImportDeclaration() != null) {
      return (SingleStaticImportDeclaration) visit(ctx.singleStaticImportDeclaration());
    } else if (ctx.singleTypeImportDeclaration() != null) {
      return (SingleTypeImportDeclaration) visit(ctx.singleTypeImportDeclaration());
    } else if (ctx.staticImportOnDemandDeclaration() != null) {
      return (StaticImportOnDemandDeclaration) visit(ctx.staticImportOnDemandDeclaration());
    } else if (ctx.typeImportOnDemandDeclaration() != null) {
      return (TypeImportOnDemandDeclaration) visit(ctx.typeImportOnDemandDeclaration());
    } else {
      System.err.println("ERROR");
      return super.visitImportDeclaration(ctx);
    }

  }

  @Override
  public AstNode visitSingleTypeImportDeclaration(JavaParser.SingleTypeImportDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get type name
    TypeName typeName = (TypeName) visit(ctx.typeName());

    return new SingleTypeImportDeclaration(range, null, typeName);
  }

  @Override
  public AstNode visitTypeImportOnDemandDeclaration(JavaParser.TypeImportOnDemandDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get package or type name
    PackageOrTypeName packageOrTypeName = (PackageOrTypeName) visit(ctx.packageOrTypeName());

    return new TypeImportOnDemandDeclaration(range, null, packageOrTypeName);
  }

  @Override
  public AstNode visitSingleStaticImportDeclaration(JavaParser.SingleStaticImportDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Type name
    TypeName typeName = (TypeName) visit(ctx.typeName());

    // get Modifier
    String identifier = ctx.Identifier().getText();

    return new SingleStaticImportDeclaration(range, null, typeName, identifier);
  }

  @Override
  public AstNode visitStaticImportOnDemandDeclaration(JavaParser.StaticImportOnDemandDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get type name
    TypeName typeName =  (TypeName) visit(ctx.typeName());

    return new StaticImportOnDemandDeclaration(range, null, typeName);
  }

  @Override
  public AstNode visitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {

    //
    if (ctx.classDeclaration() != null) {
      return (ClassDeclaration) visit(ctx.classDeclaration());
    } else if (ctx.interfaceDeclaration() != null) {
      return (InterfaceDeclaration) visit(ctx.interfaceDeclaration());
    } else {
      System.err.println("ERROR");
      return super.visitTypeDeclaration(ctx);
    }

  }

  @Override
  public AstNode visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {

    if (ctx.normalClassDeclaration() != null) {
      return (NormalClassDeclaration) visit(ctx.normalClassDeclaration());
    } else if(ctx.enumDeclaration() != null) {
      return (EnumDeclaration) visit(ctx.enumDeclaration());
    } else {
      System.err.println("ERROR : visitClassDeclaration");
      return super.visitClassDeclaration(ctx);
    }
  }

  @Override
  public AstNode visitNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.ClassModifierContext classModifierContext : ctx.classModifier() ) {
      if (classModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(classModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = classModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          case "strictfp" :
            modifiers |= Modifiers.STRICTFP;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get type parameter list
    List<TypeParameter> typeParameterList = new ArrayList<>();
    for(JavaParser.TypeParameterContext typeParameterContext
        : ctx.typeParameters().typeParameterList().typeParameter()) {
      TypeParameter typeParameter = (TypeParameter) visit(typeParameterContext);
    }

    // get super class
    ClassType superClass = (ClassType) visit(ctx.superclass().classType());

    // get super interface list
    List<InterfaceType> superInterfaceList = new ArrayList<>();
    for (JavaParser.InterfaceTypeContext interfaceTypeContext
        : ctx.superinterfaces().interfaceTypeList().interfaceType()) {
      InterfaceType interfaceType = (InterfaceType) visit(interfaceTypeContext);
      superInterfaceList.add(interfaceType);
    }

    // get Class Body Declarations
    List<ClassBodyDeclaration> classBodyDeclarationList = new ArrayList<>();
    for (JavaParser.ClassBodyDeclarationContext classBodyDeclarationContext
        : ctx.classBody().classBodyDeclaration()) {
      ClassBodyDeclaration classBodyDeclaration
          = (ClassBodyDeclaration) visit(classBodyDeclarationContext);
      classBodyDeclarationList.add(classBodyDeclaration);
    }

    return new NormalClassDeclaration(range, null, annotationList, modifiers, identifier,
        typeParameterList, superClass, superInterfaceList, classBodyDeclarationList);
  }

  @Override
  public AstNode visitClassModifier(JavaParser.ClassModifierContext ctx) {
    // Not necessary
    return super.visitClassModifier(ctx);
  }

  @Override
  public AstNode visitTypeParameters(JavaParser.TypeParametersContext ctx) {
    // Not necessary
    return super.visitTypeParameters(ctx);
  }

  @Override
  public AstNode visitTypeParameterList(JavaParser.TypeParameterListContext ctx) {
    // Not necessary
    return super.visitTypeParameterList(ctx);
  }

  @Override
  public AstNode visitSuperclass(JavaParser.SuperclassContext ctx) {
    // Not necessary
    return super.visitSuperclass(ctx);
  }

  @Override
  public AstNode visitSuperinterfaces(JavaParser.SuperinterfacesContext ctx) {
    // Not necessary
    return super.visitSuperinterfaces(ctx);
  }

  @Override
  public AstNode visitInterfaceTypeList(JavaParser.InterfaceTypeListContext ctx) {
    // Not necessary
    return super.visitInterfaceTypeList(ctx);
  }

  @Override
  public AstNode visitClassBody(JavaParser.ClassBodyContext ctx) {
    // Not necessary
    return super.visitClassBody(ctx);
  }

  @Override
  public AstNode visitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {

    if (ctx.classMemberDeclaration() != null) {
      return (ClassMemberDeclaration) visit(ctx.classMemberDeclaration());
    } else if (ctx.instanceInitializer() != null) {
      return (InstanceInitializer) visit(ctx.instanceInitializer());
    } else if (ctx.staticInitializer() != null) {
      return (StaticInitializer) visit(ctx.staticInitializer());
    } else if (ctx.constructorDeclaration() != null) {
      return (ConstructorDeclaration) visit(ctx.constructorDeclaration());
    } else {
      System.err.println("ERROR : visitClassBodyDeclaration");
      return super.visitClassBodyDeclaration(ctx);
    }
  }

  @Override
  public AstNode visitClassMemberDeclaration(JavaParser.ClassMemberDeclarationContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get class Member
    ClassMemberable classMemberable;
    if (ctx.fieldDeclaration() != null) {
      classMemberable = (FieldDeclaration) visit(ctx.fieldDeclaration());
    } else if (ctx.methodDeclaration() != null) {
      classMemberable = (MethodDeclaration) visit(ctx.methodDeclaration());
    } else if (ctx.classDeclaration() != null) {
      classMemberable = (ClassDeclaration) visit(ctx.classDeclaration());
    } else if (ctx.interfaceDeclaration() != null) {
      classMemberable = (InterfaceDeclaration) visit(ctx.interfaceDeclaration());
    } else {
      System.err.println("ERROR : visitClassMemberDeclaration");
      classMemberable = null;
    }

    return new ClassMemberDeclaration(range, null, classMemberable);
  }

  @Override
  public AstNode visitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get Annotation and modifiers
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.FieldModifierContext fieldModifierContext : ctx.fieldModifier() ) {
      if (fieldModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(fieldModifierContext.annotation());
        annotationList.add(annotation);
      } else { // TODO - Check alternative fieldModifierContext.getText();
        String normalModifier = fieldModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          case "transient" :
            modifiers |= Modifiers.TRANSIENT;
            break;
          case "volatile" :
            modifiers |= Modifiers.VOLATILE;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get unannType
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get list of variable declarator
    List<VariableDeclarator> variableDeclaratorList = new ArrayList<>();
    for(JavaParser.VariableDeclaratorContext variableDeclaratorContext
        : ctx.variableDeclaratorList().variableDeclarator()) {
      VariableDeclarator variableDeclarator = (VariableDeclarator) visit(variableDeclaratorContext);
      variableDeclaratorList.add(variableDeclarator);
    }

    return new FieldDeclaration(range, null, annotationList, modifiers, unannType, variableDeclaratorList);
  }

  @Override
  public AstNode visitFieldModifier(JavaParser.FieldModifierContext ctx) {
    // Not necessary
    return super.visitFieldModifier(ctx);
  }

  @Override
  public AstNode visitVariableDeclaratorList(JavaParser.VariableDeclaratorListContext ctx) {
    // Not necessary
    return super.visitVariableDeclaratorList(ctx);
  }

  @Override
  public AstNode visitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {

    VariableDeclaratorId variableDeclaratorId
        = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());
    VariableInitializer variableInitializer
        = (VariableInitializer) visit(ctx.variableInitializer());
    return super.visitVariableDeclarator(ctx);
  }

  @Override
  public AstNode visitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Identifier
    String identifier = ctx.Identifier().toString();

    // get Dims
    Dims dims = (Dims) visit(ctx.dims());

    return new VariableDeclaratorId(range, null, identifier, dims);
  }

  @Override
  public AstNode visitVariableInitializer(JavaParser.VariableInitializerContext ctx) {
    // get range
    Range range = getRange(ctx);

    //

    if( ctx.expression() != null ) { // One Expression case
      Expression expression = (Expression) visit(ctx.expression());
      return new ExpressionVariableInitializer(range, null, expression);

    } else if ( ctx.arrayInitializer() != null ) { // Array case

      // get list of variable initializer
      List<VariableInitializer> variableInitializerList = new ArrayList<>();
      for (JavaParser.VariableInitializerContext variableInitializerContext
          : ctx.arrayInitializer().variableInitializerList().variableInitializer()) {
        VariableInitializer variableInitializer
            = (VariableInitializer) visit(variableInitializerContext);
        variableInitializerList.add(variableInitializer);
      }
      return new ArrayInitializer(range, null, variableInitializerList);

    } else {
      System.err.println("ERROR : visitVariableInitializer");
      return super.visitVariableInitializer(ctx);
    }
  }

  @Override
  public AstNode visitUnannType(JavaParser.UnannTypeContext ctx) {

    if (ctx.unannPrimitiveType() != null) {
      return (UnannPrimitiveType) visit(ctx.unannPrimitiveType());
    } else if (ctx.unannReferenceType() != null) {
      return (UnannReferenceType) visit(ctx.unannReferenceType());
    } else {
      System.err.println("ERROR : visitUnannType");
      return super.visitUnannType(ctx);
    }

  }

  @Override
  public AstNode visitUnannPrimitiveType(JavaParser.UnannPrimitiveTypeContext ctx) {

    // get range of symbol
    Range range = getRange(ctx);

    // get primitive type
    String text;
    if (ctx.numericType() != null) {

      if (ctx.numericType().integralType() != null) {
        text = ctx.numericType().integralType().getText();

      } else if (ctx.numericType().floatingPointType() != null) {
        text = ctx.numericType().floatingPointType().getText();

      } else {
        System.err.println("ERROR");
        return super.visitUnannPrimitiveType(ctx);
      }

    } else { text = "boolean"; }

    return new UnannPrimitiveType(range, null, PrimitiveType.Primitive.valueOf(text));
  }

  @Override
  public AstNode visitUnannReferenceType(JavaParser.UnannReferenceTypeContext ctx) {
    if (ctx.unannClassOrInterfaceType() != null) {
      return (UnannClassOrInterfaceType) visit(ctx.unannClassOrInterfaceType());
    } else if (ctx.unannTypeVariable() != null) {
      return (UnannTypeVariable) visit(ctx.unannTypeVariable());
    } else if (ctx.unannArrayType() != null) {
      return (UnannArrayType) visit(ctx.unannArrayType());
    } else {
      System.err.println("ERROR : visitUnannReferenceType");
      return super.visitUnannReferenceType(ctx);
    }
  }

  @Override
  public AstNode visitUnannClassOrInterfaceType(JavaParser.UnannClassOrInterfaceTypeContext ctx) {

    //get range
    Range range = getRange(ctx);

    // is Interface
    boolean isInterface = false;
    if (ctx.getChild(ctx.getChildCount()-1).getParent()
        instanceof JavaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext) {
      isInterface = true;
    }

    // get Class or Interface Type List ( except last child )
    UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType = null;

    if (ctx.unannClassType_lfno_unannClassOrInterfaceType() != null) {
      unannUnitClassOrInterfaceType
          = (UnannUnitClassOrInterfaceType) visit(ctx.unannClassType_lfno_unannClassOrInterfaceType());

    } else if (ctx.unannInterfaceType_lfno_unannClassOrInterfaceType() != null) {
      unannUnitClassOrInterfaceType
          = (UnannUnitClassOrInterfaceType) visit(ctx.unannInterfaceType_lfno_unannClassOrInterfaceType());

    } else {
      System.err.println("ERROR : visitUnannClassOrInterfaceType");

    }

    // get Unit Class Or Interface Type ( last child )
    List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType = new ArrayList<>();

    for (int i = 1; i < ctx.getChildCount() ; i++) {
      ParseTree child = ctx.getChild(i);
      if (child instanceof JavaParser.ClassType_lf_classOrInterfaceTypeContext) {
        UnannUnitClassOrInterfaceType unannUnitClassType = (UnannUnitClassOrInterfaceType) visit(child);
        unannClassOrInterfaceType.add( unannUnitClassType );
      } else if (child instanceof JavaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext) {
        UnannUnitClassOrInterfaceType unannUnitInterfaceType = (UnannUnitClassOrInterfaceType) visit(child);
        unannClassOrInterfaceType.add( unannUnitInterfaceType );
      } else {
        System.err.println("ERROR : visitUnannClassOrInterfaceType");
      }
    }

    return new UnannClassOrInterfaceType(range, null, isInterface, unannUnitClassOrInterfaceType, unannClassOrInterfaceType);
  }

  @Override
  public AstNode visitUnannClassType(JavaParser.UnannClassTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get unannotated class or interface type
    UnannClassOrInterfaceType unannClassOrInterfaceType = null;
    if (ctx.unannClassOrInterfaceType() != null) {
      unannClassOrInterfaceType = (UnannClassOrInterfaceType) visit(ctx.unannClassOrInterfaceType());
    }

    // get list of annotation
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // list of type argument
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext
        : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    return new UnannClassType(range, null, unannClassOrInterfaceType, annotationList, identifier, typeArgumentList);
  }

  @Override
  public AstNode visitUnannClassType_lf_unannClassOrInterfaceType(JavaParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of annotation
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifiers
    String identifier = ctx.Identifier().getText();

    // get list of type arguments
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
    }

    return new LfUnannUnitClassType(range, null, annotationList, identifier, typeArgumentList);
  }

  @Override
  public AstNode visitUnannClassType_lfno_unannClassOrInterfaceType(JavaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get list of type argument
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
    }

    return new UnannUnitClassType(range, null, identifier, typeArgumentList);
  }

  @Override
  public AstNode visitUnannInterfaceType(JavaParser.UnannInterfaceTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get unannotated class type
    UnannClassType unannClassType = (UnannClassType) visit(ctx.unannClassType());

    return new UnannInterfaceType(range, null, unannClassType);
  }

  @Override
  public AstNode visitUnannInterfaceType_lf_unannClassOrInterfaceType(JavaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get lf unit class type
    LfUnannUnitClassType lfUnannUnitClassType = (LfUnannUnitClassType) visit(ctx.unannClassType_lf_unannClassOrInterfaceType());

    return new LfUnannUnitInterfaceType(range, null, lfUnannUnitClassType);
  }

  @Override
  public AstNode visitUnannInterfaceType_lfno_unannClassOrInterfaceType(JavaParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get unit class type
    UnannUnitClassType unannUnitClassType = (UnannUnitClassType) visit(ctx.unannClassType_lfno_unannClassOrInterfaceType());

    return new UnannUnitInterfaceType(range, null, unannUnitClassType);
  }

  @Override
  public AstNode visitUnannTypeVariable(JavaParser.UnannTypeVariableContext ctx) {

    return super.visitUnannTypeVariable(ctx);
  }

  @Override
  public AstNode visitUnannArrayType(JavaParser.UnannArrayTypeContext ctx) {
    return super.visitUnannArrayType(ctx);
  }

  @Override
  public AstNode visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Annotation and modifiers
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.MethodModifierContext methodModifierContext : ctx.methodModifier() ) {
      if (methodModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(methodModifierContext.annotation());
        annotationList.add(annotation);
      } else { // TODO - Check alternative fieldModifierContext.getText();
        String normalModifier = methodModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          case "synchronized" :
            modifiers |= Modifiers.SYNCHRONIZED;
            break;
          case "native" :
            modifiers |= Modifiers.NATIVE;
            break;
          case "strictfp" :
            modifiers |= Modifiers.STRICTFP;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get method header
    MethodHeader methodHeader = (MethodHeader) visit(ctx.methodHeader());


    // get Method Body
    Block block = (Block) visit(ctx.methodBody().block());

    return new MethodDeclaration(range, null, annotationList, modifiers, methodHeader, block);
  }

  @Override
  public AstNode visitMethodModifier(JavaParser.MethodModifierContext ctx) {
    // Not necessary
    return super.visitMethodModifier(ctx);
  }

  @Override
  public AstNode visitMethodHeader(JavaParser.MethodHeaderContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get result
    Result result = (Result) visit(ctx.result());

    // get method declarator
    MethodDeclarator methodDeclarator = (MethodDeclarator) visit(ctx.methodDeclarator());

    // get list of exception type
    List<ExceptionType> exceptionTypeList = new ArrayList<>();
    for(JavaParser.ExceptionTypeContext exceptionTypeContext
        : ctx.throws_().exceptionTypeList().exceptionType()) {
      ExceptionType exceptionType = (ExceptionType) visit(exceptionTypeContext);
      exceptionTypeList.add(exceptionType);
    }

    if(ctx.typeParameters() != null) {
      // get list of Type parameter
      List<TypeParameter> typeParameterList = new ArrayList<>();

      for (JavaParser.TypeParameterContext typeParameterContext
          : ctx.typeParameters().typeParameterList().typeParameter()) {
        TypeParameter typeParameter = (TypeParameter) visit(typeParameterContext);
        typeParameterList.add(typeParameter);
      }

      // get list of annotations
      List<Annotation> annotationList = new ArrayList<>();
      for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
        Annotation annotation = (Annotation) visit(annotationContext);
        annotationList.add(annotation);
      }

      return new AnnotationMethodHeader(range, null, result, methodDeclarator, exceptionTypeList,
          typeParameterList, annotationList);
    }

    return new SimpleMethodHeader(range, null, result, methodDeclarator, exceptionTypeList);
  }

  @Override
  public AstNode visitResult(JavaParser.ResultContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get Unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    return new Result(range, null, unannType);
  }

  @Override
  public AstNode visitMethodDeclarator(JavaParser.MethodDeclaratorContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get Formal Parameter List
    FormalParameterList formalParameterList
        = (FormalParameterList) visit(ctx.formalParameterList());

    // get Dims
    Dims dims = (Dims) visit(ctx.dims());

    return new MethodDeclarator(range, null, identifier, formalParameterList, dims);
  }

  @Override
  public AstNode visitFormalParameterList(JavaParser.FormalParameterListContext ctx) {
    if (ctx.formalParameters() != null) {
      // get range
      Range range = getRange(ctx);

      // get List of Parameters
      List<Parameter> parameterList = new ArrayList<>();
      for (ParseTree parameterContext : ctx.formalParameters().children) {
        if(parameterContext instanceof JavaParser.FormalParameterContext) {
          FormalParameter formalParameter = (FormalParameter) visit(parameterContext);
          parameterList.add(formalParameter);
        } else if (parameterContext instanceof JavaParser.ReceiverParameterContext) {
          ReceiverParameter receiverParameter = (ReceiverParameter) visit(parameterContext);
          parameterList.add(receiverParameter);
        } else {
          System.err.println("ERROR : visitFormalParameterList");
        }
      }

      // get lastFormalParameter
      LastFormalParameter lastFormalParameter =
          (LastFormalParameter) visit(ctx.lastFormalParameter());

      return new FormalParameterList(range, null, parameterList, lastFormalParameter);
    } else {
      return (LastFormalParameter) visit(ctx.lastFormalParameter());
    }
  }

  @Override
  public AstNode visitFormalParameters(JavaParser.FormalParametersContext ctx) {
    // Not necessary
    return super.visitFormalParameters(ctx);
  }

  @Override
  public AstNode visitFormalParameter(JavaParser.FormalParameterContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Annotation and modifiers
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier() ) {
      if (variableModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
        annotationList.add(annotation);
      } else { // TODO - Check alternative fieldModifierContext.getText();
        String normalModifier = variableModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get unnan type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get variable declarator id
    VariableDeclaratorId variableDeclaratorId
        = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());

    return new FormalParameter(range, null, annotationList, modifiers, unannType, variableDeclaratorId);
  }

  @Override
  public AstNode visitVariableModifier(JavaParser.VariableModifierContext ctx) {
    // Not necessary
    return super.visitVariableModifier(ctx);
  }

  @Override
  public AstNode visitLastFormalParameter(JavaParser.LastFormalParameterContext ctx) {
    if (ctx.formalParameter() != null) {
      return (FormalParameter) visit(ctx.formalParameter());
    } else if (ctx.variableDeclaratorId() != null) {
      // get range
      Range range = getRange(ctx);

      // get Annotation and modifiers
      List<Annotation> annotationList = new ArrayList<>();
      int modifiers = 0;
      for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier() ) {
        if (variableModifierContext.annotation() != null) {
          Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
          annotationList.add(annotation);
        } else { // TODO - Check alternative fieldModifierContext.getText();
          String normalModifier = variableModifierContext.getChild(0).getText();
          switch(normalModifier) {
            case "final" :
              modifiers |= Modifiers.FINAL;
              break;
            default : // Error
              modifiers = -1;
              break;
          }
        }
      }

      // get unnanotated type
      UnannType unannType = (UnannType) visit(ctx.unannType());

      // get Second list of annotations
      List<Annotation> secondAnnotationList = new ArrayList<>();
      for(JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
        Annotation annotation = (Annotation) visit(annotationContext);
        secondAnnotationList.add(annotation);
      }

      // get Variable Declarator Id
      VariableDeclaratorId variableDeclaratorId
          = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());

      return new LastFormalParameter(range, null, annotationList, modifiers, unannType, secondAnnotationList, variableDeclaratorId);
    } else {
      System.err.println("ERROR : visitLastFormalParameter");
      return super.visitLastFormalParameter(ctx);
    }
  }

  @Override
  public AstNode visitReceiverParameter(JavaParser.ReceiverParameterContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of annotaitons
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get Unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get identifier
    String identifier = ctx.Identifier().getText();

    return new ReceiverParameter(range, null, annotationList, unannType, identifier);
  }

  @Override
  public AstNode visitThrows_(JavaParser.Throws_Context ctx) {
    // Not necessary
    return super.visitThrows_(ctx);
  }

  @Override
  public AstNode visitExceptionTypeList(JavaParser.ExceptionTypeListContext ctx) {
    // Not necessary
    return super.visitExceptionTypeList(ctx);
  }

  @Override
  public AstNode visitExceptionType(JavaParser.ExceptionTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Exceptionable
    Exceptionable exceptionable;
    if (ctx.classType() != null) {
      exceptionable = (ClassType) visit(ctx.classType());
    } else if (ctx.typeVariable() != null) {
      exceptionable = (TypeVariable) visit(ctx.typeVariable());
    } else {
      System.err.println("ERROR : visitExceptionType");
      exceptionable = null;
    }

    return new ExceptionType(range, null, exceptionable);
  }

  @Override
  public AstNode visitMethodBody(JavaParser.MethodBodyContext ctx) {
    // not necessary
    return super.visitMethodBody(ctx);
  }

  @Override
  public AstNode visitInstanceInitializer(JavaParser.InstanceInitializerContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get Block
    Block block = (Block) visit(ctx.block());

    return new InstanceInitializer(range, null, block);
  }

  @Override
  public AstNode visitStaticInitializer(JavaParser.StaticInitializerContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Block
    Block block = (Block) visit(ctx.block());

    return new StaticInitializer(range, null ,block);
  }

  @Override
  public AstNode visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get Annotation and modifiers
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.ConstructorModifierContext constructorModifierContext : ctx.constructorModifier() ) {
      if (constructorModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(constructorModifierContext.annotation());
        annotationList.add(annotation);
      } else { // TODO - Check alternative fieldModifierContext.getText();
        String normalModifier = constructorModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Constructor Declaration
    ConstructorDeclarator constructorDeclarator
        = (ConstructorDeclarator) visit(ctx.constructorDeclarator());

    // get list of exception
    List<ExceptionType> exceptionTypeList = new ArrayList<>();
    for(JavaParser.ExceptionTypeContext exceptionTypeContext
        : ctx.throws_().exceptionTypeList().exceptionType()) {
      ExceptionType exceptionType = (ExceptionType) visit(exceptionTypeContext);
      exceptionTypeList.add(exceptionType);
    }

    // get constructor Body
    ConstructorBody constructorBody = (ConstructorBody) visit(ctx.constructorBody());

    return new ConstructorDeclaration(range, null, annotationList, modifiers,
        constructorDeclarator, exceptionTypeList, constructorBody);
  }

  @Override
  public AstNode visitConstructorModifier(JavaParser.ConstructorModifierContext ctx) {
    // Not necessary
    return super.visitConstructorModifier(ctx);
  }

  @Override
  public AstNode visitConstructorDeclarator(JavaParser.ConstructorDeclaratorContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of type parameters
    List<TypeParameter> typeParameterList = new ArrayList<>();
    for (JavaParser.TypeParameterContext typeParameterContext :
        ctx.typeParameters().typeParameterList().typeParameter()) {
      TypeParameter typeParameter = (TypeParameter) visit(typeParameterContext);
      typeParameterList.add(typeParameter);
    }

    // get identifier
    String identifier = ctx.simpleTypeName().Identifier().getText();

    // get formal parameter list
    FormalParameterList formalParameterList = (FormalParameterList) visit(ctx.formalParameterList());
    return new ConstructorDeclarator(range, null, typeParameterList, identifier, formalParameterList);
  }

  @Override
  public AstNode visitSimpleTypeName(JavaParser.SimpleTypeNameContext ctx) {
    // Not necessary
    return super.visitSimpleTypeName(ctx);
  }

  @Override
  public AstNode visitConstructorBody(JavaParser.ConstructorBodyContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get explicit constructor invocation
    ExplicitConstructorInvocation explicitConstructorInvocation
        = (ExplicitConstructorInvocation) visit(ctx.explicitConstructorInvocation());

    // get block statements
    BlockStatements blockStatements = (BlockStatements) visit(ctx.blockStatements());

    return new ConstructorBody(range, null, explicitConstructorInvocation, blockStatements);
  }

  @Override
  public AstNode visitExplicitConstructorInvocation(JavaParser.ExplicitConstructorInvocationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of type argument
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for (JavaParser.TypeArgumentContext typeArgumentContext
        : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    // get arguemnt list
    List<Expression> expressionList = new ArrayList<>();
    for (JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      expressionList.add(expression);
    }

    if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new ExpressionSuperConstructorInvocation(range, null, typeArgumentList, expressionList, expressionName);
    } else if (ctx.primary() != null) {
      Primary primary = (Primary) visit(ctx.primary());
      return new PrimarySuperConstructorInvocation(range, null, typeArgumentList, expressionList, primary);
    } else if (ctx.getText().contains("super")) {
      return new SuperConstructorInvocation(range, null, typeArgumentList, expressionList);
    } else if (ctx.getText().contains("this")) {
      return new ThisConstructorInvocation(range, null, typeArgumentList, expressionList);
    } else {
      System.err.println("ERROR : visitExplicitConstructorInvocation");
      return super.visitExplicitConstructorInvocation(ctx);
    }

  }

  @Override
  public AstNode visitEnumDeclaration(JavaParser.EnumDeclarationContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.ClassModifierContext classModifierContext : ctx.classModifier() ) {
      if (classModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(classModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = classModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          case "strictfp" :
            modifiers |= Modifiers.STRICTFP;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get super interface list
    List<InterfaceType> superInterfaceList = new ArrayList<>();
    for (JavaParser.InterfaceTypeContext interfaceTypeContext
        : ctx.superinterfaces().interfaceTypeList().interfaceType()) {
      InterfaceType interfaceType = (InterfaceType) visit(interfaceTypeContext);
      superInterfaceList.add(interfaceType);
    }

    // get Enum Body
    EnumBody enumBody = (EnumBody) visit(ctx.enumBody());

    return new EnumDeclaration(range, null, annotationList, modifiers, identifier, superInterfaceList, enumBody);
  }

  @Override
  public AstNode visitEnumBody(JavaParser.EnumBodyContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of enum constant
    List<EnumConstant> enumConstantList = new ArrayList<>();
    for (JavaParser.EnumConstantContext enumConstantContext : ctx.enumConstantList().enumConstant()) {
      EnumConstant enumConstant = (EnumConstant) visit(enumConstantContext);
      enumConstantList.add(enumConstant);
    }

    // get lost of class body declaration
    List<ClassBodyDeclaration> classBodyDeclarationList = new ArrayList<>();
    for (JavaParser.ClassBodyDeclarationContext classBodyDeclarationContext : ctx.enumBodyDeclarations().classBodyDeclaration()) {
      ClassBodyDeclaration classBodyDeclaration = (ClassBodyDeclaration) visit(classBodyDeclarationContext);
      classBodyDeclarationList.add(classBodyDeclaration);
    }

    return new EnumBody(range, null, enumConstantList, classBodyDeclarationList);
  }

  @Override
  public AstNode visitEnumConstantList(JavaParser.EnumConstantListContext ctx) {
    // Not necessary
    return super.visitEnumConstantList(ctx);
  }

  @Override
  public AstNode visitEnumConstant(JavaParser.EnumConstantContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of annotation
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.EnumConstantModifierContext enumConstantModifierContext
        : ctx.enumConstantModifier()) {
      Annotation annotation = (Annotation) visit(enumConstantModifierContext.annotation());
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    //get list of expression
    List<Expression> expressionList = new ArrayList<>();
    for (JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      expressionList.add(expression);
    }

    // get lost of class body declaration
    List<ClassBodyDeclaration> classBodyDeclarationList = new ArrayList<>();
    for (JavaParser.ClassBodyDeclarationContext classBodyDeclarationContext : ctx.classBody().classBodyDeclaration()) {
      ClassBodyDeclaration classBodyDeclaration = (ClassBodyDeclaration) visit(classBodyDeclarationContext);
      classBodyDeclarationList.add(classBodyDeclaration);
    }

    return new EnumConstant(range, null, annotationList, identifier, expressionList, classBodyDeclarationList);
  }

  @Override
  public AstNode visitEnumConstantModifier(JavaParser.EnumConstantModifierContext ctx) {
    // not necessary
    return super.visitEnumConstantModifier(ctx);
  }

  @Override
  public AstNode visitEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) {
    // not necessary
    return super.visitEnumBodyDeclarations(ctx);
  }

  //

  @Override
  public AstNode visitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
    if (ctx.annotationTypeDeclaration() != null ) {
      return (AnnotationTypeDeclaration) visit(ctx.annotationTypeDeclaration());
    } else if (ctx.normalInterfaceDeclaration() != null) {
      return (NormalInterfaceDeclaration) visit(ctx.normalInterfaceDeclaration());
    } else {
      System.err.println("ERROR : visitInterfaceDeclaration");
      return super.visitInterfaceDeclaration(ctx);
    }
  }

  @Override
  public AstNode visitNormalInterfaceDeclaration(JavaParser.NormalInterfaceDeclarationContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.InterfaceModifierContext interfaceModifierContext : ctx.interfaceModifier()) {
      if (interfaceModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(interfaceModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = interfaceModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "strictfp" :
            modifiers |= Modifiers.STRICTFP;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get list of type parameter
    List<TypeParameter> typeParameterList = new ArrayList<>();
    for (JavaParser.TypeParameterContext typeParameterContext
        : ctx.typeParameters().typeParameterList().typeParameter()) {
      TypeParameter typeParameter = (TypeParameter) visit(typeParameterContext);
      typeParameterList.add(typeParameter);
    }

    // get interface type list
    List<InterfaceType> interfaceTypeList = new ArrayList<>();
    for (JavaParser.InterfaceTypeContext interfaceTypeContext
        : ctx.extendsInterfaces().interfaceTypeList().interfaceType()) {
      InterfaceType interfaceType = (InterfaceType) visit(interfaceTypeContext);
      interfaceTypeList.add(interfaceType);
    }

    // get list of interface Members
    List<InterfaceMemberable> interfaceMemberableList = new ArrayList<>();
    for (JavaParser.InterfaceMemberDeclarationContext interfaceMemberDeclarationContext
        : ctx.interfaceBody().interfaceMemberDeclaration()) {
      InterfaceMemberable interfaceMemberable = (InterfaceMemberable) visit(interfaceMemberDeclarationContext);
      interfaceMemberableList.add(interfaceMemberable);
    }

    return new NormalInterfaceDeclaration(range, null, annotationList, modifiers, identifier, typeParameterList, interfaceTypeList, interfaceMemberableList);
  }

  @Override
  public AstNode visitInterfaceModifier(JavaParser.InterfaceModifierContext ctx) {
    // Not necessary
    return super.visitInterfaceModifier(ctx);
  }

  @Override
  public AstNode visitExtendsInterfaces(JavaParser.ExtendsInterfacesContext ctx) {
    // Not necessary
    return super.visitExtendsInterfaces(ctx);
  }

  @Override
  public AstNode visitInterfaceBody(JavaParser.InterfaceBodyContext ctx) {
    // Not necessary
    return super.visitInterfaceBody(ctx);
  }

  @Override
  public AstNode visitInterfaceMemberDeclaration(JavaParser.InterfaceMemberDeclarationContext ctx) {

    if( ctx.constantDeclaration() != null ) {
      return (ConstantDeclaration) visit(ctx.constantDeclaration());
    } else if (ctx.interfaceMethodDeclaration() != null) {
      return (InterfaceMethodDeclaration) visit(ctx.interfaceMethodDeclaration());
    } else if (ctx.classDeclaration() != null) {
      return (ClassDeclaration) visit(ctx.classDeclaration());
    } else if (ctx.interfaceDeclaration() != null) {
      return (InterfaceDeclaration) visit(ctx.interfaceDeclaration());
    } else {
      System.err.println("ERROR : visitInterfaceMemberDeclaration");
      return super.visitInterfaceMemberDeclaration(ctx);
    }

  }

  @Override
  public AstNode visitConstantDeclaration(JavaParser.ConstantDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.ConstantModifierContext constantModifierContext : ctx.constantModifier()) {
      if (constantModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(constantModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = constantModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get list of variable declarator
    List<VariableDeclarator> variableDeclaratorList = new ArrayList<>();
    for (JavaParser.VariableDeclaratorContext variableDeclaratorContext
        : ctx.variableDeclaratorList().variableDeclarator()) {
      VariableDeclarator variableDeclarator = (VariableDeclarator) visit(variableDeclaratorContext);
      variableDeclaratorList.add(variableDeclarator);
    }

    return new ConstantDeclaration(range, null, annotationList, modifiers, unannType, variableDeclaratorList);
  }

  @Override
  public AstNode visitConstantModifier(JavaParser.ConstantModifierContext ctx) {
    // not necessary
    return super.visitConstantModifier(ctx);
  }

  @Override
  public AstNode visitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.InterfaceMethodModifierContext interfaceMethodModifierContext
        : ctx.interfaceMethodModifier()) {
      if (interfaceMethodModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(interfaceMethodModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = interfaceMethodModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "default" :
            modifiers |= Modifiers.DEFAULT;
            break;
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "strictfp" :
            modifiers |= Modifiers.STRICTFP;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get methodheader
    MethodHeader methodHeader = (MethodHeader) visit(ctx.methodHeader());

    // get Method body (block)
    Block block = (Block) visit(ctx.methodBody().block());

    return super.visitInterfaceMethodDeclaration(ctx);
  }

  @Override
  public AstNode visitInterfaceMethodModifier(JavaParser.InterfaceMethodModifierContext ctx) {
    // Not necessary
    return super.visitInterfaceMethodModifier(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.InterfaceModifierContext interfaceModifierContext : ctx.interfaceModifier()) {
      if (interfaceModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(interfaceModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = interfaceModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "protected" :
            modifiers |= Modifiers.PROTECTED;
            break;
          case "private" :
            modifiers |= Modifiers.PRIVATE;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          case "static" :
            modifiers |= Modifiers.STATIC;
            break;
          case "strictfp" :
            modifiers |= Modifiers.STRICTFP;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get annoatation Type Body
    List<AnnotationTypeMemberable> annotationTypeMemberableList = new ArrayList<>();
    for (JavaParser.AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclarationContext
        : ctx.annotationTypeBody().annotationTypeMemberDeclaration()) {
      AnnotationTypeMemberable annotationTypeMemberable
          = (AnnotationTypeMemberable) visit(annotationTypeMemberDeclarationContext);
      annotationTypeMemberableList.add(annotationTypeMemberable);
    }

    return new AnnotationTypeDeclaration(range, null, annotationList, modifiers, identifier, annotationTypeMemberableList);
  }

  @Override
  public AstNode visitAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) {
    // Not necessary
    return super.visitAnnotationTypeBody(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeMemberDeclaration(JavaParser.AnnotationTypeMemberDeclarationContext ctx) {
    if(ctx.annotationTypeElementDeclaration() != null) {
      return (AnnotationTypeElementDeclaration) visit(ctx.annotationTypeElementDeclaration());
    } else if (ctx.constantDeclaration() != null) {
      return (ConstantDeclaration) visit(ctx.constantDeclaration());
    } else if (ctx.classDeclaration() != null) {
      return (ClassDeclaration) visit(ctx.classDeclaration());
    } else if (ctx.interfaceDeclaration() != null) {
      return (InterfaceDeclaration) visit(ctx.interfaceDeclaration());
    } else {
      System.err.println("ERROR : visitAnnotationTypeMemberDeclaration");
      return super.visitAnnotationTypeMemberDeclaration(ctx);
    }
  }

  @Override
  public AstNode visitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.AnnotationTypeElementModifierContext annotationTypeElementModifierContext
        : ctx.annotationTypeElementModifier()) {

      if (annotationTypeElementModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(annotationTypeElementModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = annotationTypeElementModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "public" :
            modifiers |= Modifiers.PUBLIC;
            break;
          case "abstract" :
            modifiers |= Modifiers.ABSTRACT;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get Identifier
    String identifier = ctx.Identifier().getText();

    // get dims
    Dims dims = (Dims) visit(ctx.dims());

    // get default Value
    ElementValue elementValue = (ElementValue) visit(ctx.defaultValue().elementValue());


    return new AnnotationTypeElementDeclaration(range, null, annotationList, modifiers, unannType, identifier, dims, elementValue);
  }

  @Override
  public AstNode visitAnnotationTypeElementModifier(JavaParser.AnnotationTypeElementModifierContext ctx) {
    // Not necessary
    return super.visitAnnotationTypeElementModifier(ctx);
  }

  @Override
  public AstNode visitDefaultValue(JavaParser.DefaultValueContext ctx) {
    // Not necessary
    return super.visitDefaultValue(ctx);
  }

  @Override
  public AstNode visitAnnotation(JavaParser.AnnotationContext ctx) {
    return super.visitAnnotation(ctx);
  }

  @Override
  public AstNode visitNormalAnnotation(JavaParser.NormalAnnotationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get type name
    TypeName typeName = (TypeName) visit(ctx.typeName());

    // get list of element value pair
    List<ElementValuePair> elementValuePairList = new ArrayList<>();
    for (JavaParser.ElementValuePairContext elementValuePairContext
        : ctx.elementValuePairList().elementValuePair()) {
      ElementValuePair elementValuePair = (ElementValuePair) visit(elementValuePairContext);
      elementValuePairList.add(elementValuePair);
    }

    return new NormalAnnotation(range, null, typeName, elementValuePairList);
  }

  @Override
  public AstNode visitElementValuePairList(JavaParser.ElementValuePairListContext ctx) {
    // Not necessary
    return super.visitElementValuePairList(ctx);
  }

  @Override
  public AstNode visitElementValuePair(JavaParser.ElementValuePairContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get elementValue
    ElementValue elementValue = (ElementValue) visit(ctx.elementValue());

    return new ElementValuePair(range, null, identifier, elementValue);
  }

  @Override
  public AstNode visitElementValue(JavaParser.ElementValueContext ctx) {
    if (ctx.conditionalExpression() != null) {
      return visit(ctx.conditionalExpression());
    } else if (ctx.elementValueArrayInitializer() != null) {
      return visit(ctx.elementValueArrayInitializer());
    } else if (ctx.annotation() != null) {
      return visit(ctx.annotation());
    } else {
      System.err.println("ERROR : visitElementValue");
      return super.visitElementValue(ctx);
    }

  }

  @Override
  public AstNode visitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of element values
    List<ElementValue> elementValueList = new ArrayList<>();
    for (JavaParser.ElementValueContext elementValueContext : ctx.elementValueList().elementValue()) {
      ElementValue elementValue = (ElementValue) visit(elementValueContext);
      elementValueList.add(elementValue);
    }

    return new ElementValueArrayInitializer(range, null, elementValueList);
  }

  @Override
  public AstNode visitElementValueList(JavaParser.ElementValueListContext ctx) {
    // not necessary
    return super.visitElementValueList(ctx);
  }

  @Override
  public AstNode visitMarkerAnnotation(JavaParser.MarkerAnnotationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get type name
    TypeName typeName = (TypeName) visit(ctx.typeName());

    return new MarkerAnnotation(range, null, typeName);
  }

  @Override
  public AstNode visitSingleElementAnnotation(JavaParser.SingleElementAnnotationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get type name
    TypeName typeName = (TypeName) visit(ctx.typeName());

    // get element value
    ElementValue elementValue = (ElementValue) visit(ctx.elementValue());

    return new SingleElementAnnotation(range, null, typeName, elementValue);
  }

  @Override
  public AstNode visitArrayInitializer(JavaParser.ArrayInitializerContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of variable initializer
    List<VariableInitializer> variableInitializerList = new ArrayList<>();
    for (JavaParser.VariableInitializerContext variableInitializerContext
        : ctx.variableInitializerList().variableInitializer()) {
      VariableInitializer variableInitializer = (VariableInitializer) visit(variableInitializerContext);
      variableInitializerList.add(variableInitializer);
    }

    return new ArrayInitializer(range, null, variableInitializerList);
  }

  @Override
  public AstNode visitVariableInitializerList(JavaParser.VariableInitializerListContext ctx) {
    // Not necessary
    return super.visitVariableInitializerList(ctx);
  }

  @Override
  public AstNode visitBlock(JavaParser.BlockContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get block statements
    BlockStatements blockStatements = (BlockStatements) visit(ctx.blockStatements());


    return new Block(range, null, blockStatements);
  }

  @Override
  public AstNode visitBlockStatements(JavaParser.BlockStatementsContext ctx) {

    //get Range
    Range range = getRange(ctx);

    // get block Statement
    List<InBlockStatement> inBlockStatementList = new ArrayList<>();
    for (JavaParser.BlockStatementContext blockStatementContext
        : ctx.blockStatement()) {
      InBlockStatement inBlockStatement = (InBlockStatement) visit(blockStatementContext);
      inBlockStatementList.add(inBlockStatement);
    }
    return new BlockStatements(range, null, inBlockStatementList);
  }

  @Override
  public AstNode visitBlockStatement(JavaParser.BlockStatementContext ctx) {

    if (ctx.localVariableDeclarationStatement() != null) {
      return visit(ctx.localVariableDeclarationStatement());
    } else if (ctx.classDeclaration() != null) {
      return visit(ctx.classDeclaration());
    } else if (ctx.statement() != null) {
      return visit(ctx.statement());
    } else {
      System.err.println("ERROR : visitBlockStatement");
      return super.visitBlockStatement(ctx);
    }
  }

  @Override
  public AstNode visitLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get local variable declaration
    LocalVariableDeclaration localVariableDeclaration
        = (LocalVariableDeclaration) visit(ctx.localVariableDeclaration());

    return new LocalVariableDeclarationStatement(range, null, localVariableDeclaration);
  }

  @Override
  public AstNode visitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier()) {

      if (variableModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = variableModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get list of variable declarator
    List<VariableDeclarator> variableDeclaratorList = new ArrayList<>();
    for (JavaParser.VariableDeclaratorContext variableDeclaratorContext
        : ctx.variableDeclaratorList().variableDeclarator()) {
      VariableDeclarator variableDeclarator = (VariableDeclarator) visit(variableDeclaratorContext);
      variableDeclaratorList.add(variableDeclarator);
    }

    return new LocalVariableDeclaration(range, null, annotationList, modifiers, unannType, variableDeclaratorList);
  }

  @Override
  public AstNode visitStatement(JavaParser.StatementContext ctx) {
    // TODO -
    if (ctx.statementWithoutTrailingSubstatement() != null) {
      return visit(ctx.statementWithoutTrailingSubstatement());
    } else if (ctx.labeledStatement() != null) {
      return visit(ctx.labeledStatement());
    } else if (ctx.ifThenStatement() != null) {
      return visit(ctx.ifThenStatement());
    } else if (ctx.ifThenElseStatement() != null) {
      return visit(ctx.ifThenElseStatement());
    } else if (ctx.whileStatement() != null) {
      return visit(ctx.whileStatement());
    } else if (ctx.forStatement() != null) {
      return visit(ctx.forStatement());
    } else {
      System.err.println("ERROR : visitStatement");
      return super.visitStatement(ctx);
    }
  }

  @Override
  public AstNode visitStatementNoShortIf(JavaParser.StatementNoShortIfContext ctx) {
    // TODO -
    if (ctx.statementWithoutTrailingSubstatement() != null) {
      return visit(ctx.statementWithoutTrailingSubstatement());
    } else if (ctx.labeledStatementNoShortIf() != null) {
      return visit(ctx.labeledStatementNoShortIf());
    } else if (ctx.ifThenElseStatementNoShortIf() != null) {
      return visit(ctx.ifThenElseStatementNoShortIf());
    } else if (ctx.whileStatementNoShortIf() != null) {
      return visit(ctx.whileStatementNoShortIf());
    } else if (ctx.forStatementNoShortIf() != null) {
      return visit(ctx.forStatementNoShortIf());
    } else {
      System.err.println("ERROR : visitStatementNoShortIf");
      return super.visitStatementNoShortIf(ctx);
    }
  }

  @Override
  public AstNode visitStatementWithoutTrailingSubstatement(JavaParser.StatementWithoutTrailingSubstatementContext ctx) {
    // TODO -

    if(ctx.block() != null) {
      return visit(ctx.block());
    } else if (ctx.emptyStatement() != null) {
      return visit(ctx.emptyStatement());
    } else if (ctx.expressionStatement() != null) {
      return visit(ctx.expressionStatement());
    } else if (ctx.assertStatement() != null) {
      return visit(ctx.assertStatement());
    } else if (ctx.switchStatement() != null) {
      return visit(ctx.switchStatement());
    } else if (ctx.doStatement() != null) {
      return visit(ctx.doStatement());
    } else if (ctx.breakStatement() != null) {
      return visit(ctx.breakStatement());
    } else if (ctx.continueStatement() != null) {
      return visit(ctx.continueStatement());
    } else if (ctx.returnStatement() != null) {
      return visit(ctx.returnStatement());
    } else if (ctx.synchronizedStatement() != null) {
      return visit(ctx.synchronizedStatement());
    } else if (ctx.throwStatement() != null) {
      return visit(ctx.throwStatement());
    } else if (ctx.tryStatement() != null) {
      return visit(ctx.tryStatement());
    } else {
      System.err.println("ERROR : visitStatementWithoutTrailingSubstatement");
      return super.visitStatementWithoutTrailingSubstatement(ctx);
    }
  }

  @Override
  public AstNode visitEmptyStatement(JavaParser.EmptyStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    return new EmptyStatement(range, null);
  }

  @Override
  public AstNode visitLabeledStatement(JavaParser.LabeledStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get Statement
    Statement statement = (Statement) visit(ctx.statement());

    return new LabeledStatement(range, null, identifier, statement);
  }

  @Override
  public AstNode visitLabeledStatementNoShortIf(JavaParser.LabeledStatementNoShortIfContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get Statement no short if
    StatementNoShortIf statementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf());

    return new LabeledStatementNoShortIf(range, null, identifier, statementNoShortIf);
  }

  @Override
  public AstNode visitExpressionStatement(JavaParser.ExpressionStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get statement expression
    StatementExpression statementExpression
        = (StatementExpression) visit(ctx.statementExpression());

    return new ExpressionStatement(range, null, statementExpression);
  }

  @Override
  public AstNode visitStatementExpression(JavaParser.StatementExpressionContext ctx) {
    // TODO -
    if (ctx.assignment() != null) {
      return visit(ctx.assignment());
    } else if (ctx.preIncrementExpression() != null) {
      return visit(ctx.preIncrementExpression());
    } else if (ctx.preDecrementExpression() != null) {
      return visit(ctx.preDecrementExpression());
    } else if (ctx.postIncrementExpression() != null) {
      return visit(ctx.postIncrementExpression());
    } else if (ctx.postDecrementExpression() != null) {
      return visit(ctx.postDecrementExpression());
    } else if (ctx.methodInvocation() != null) {
      return visit(ctx.methodInvocation());
    } else if (ctx.classInstanceCreationExpression() != null) {
      return visit(ctx.classInstanceCreationExpression());
    } else {
      System.err.println("ERROR : visitStatementExpression");
      return super.visitStatementExpression(ctx);
    }
  }

  @Override
  public AstNode visitIfThenStatement(JavaParser.IfThenStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    // get Statement
    Statement statement = (Statement) visit(ctx.statement());

    return new IfThenStatement(range, null, expression, statement);
  }

  @Override
  public AstNode visitIfThenElseStatement(JavaParser.IfThenElseStatementContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    // get statement no short if
    StatementNoShortIf statementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf());

    // get Statement
    Statement statement = (Statement) visit(ctx.statement());

    return new IfThenElseStatement(range, null, expression, statementNoShortIf, statement);
  }

  @Override
  public AstNode visitIfThenElseStatementNoShortIf(JavaParser.IfThenElseStatementNoShortIfContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Expression
    Expression expression = (Expression) visit(ctx.expression());

    // get statement no short if
    StatementNoShortIf statementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf(0));

    // get els statement no short if
    StatementNoShortIf elseStatementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf(1));

    return new IfThenElseStatementNoShortIf(range, null, expression, statementNoShortIf, elseStatementNoShortIf);
  }

  @Override
  public AstNode visitAssertStatement(JavaParser.AssertStatementContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get first expression
    Expression expression = (Expression) visit(ctx.expression(0));

    // if any, get second expression.
    if (ctx.expression(1) != null) {
      Expression secondExpression = (Expression) visit(ctx.expression(1));

      return new BinAssertStatement(range, null, expression, secondExpression);
    }

    return new UnaryAssertStatement(range, null, expression);
  }

  @Override
  public AstNode visitSwitchStatement(JavaParser.SwitchStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Expression
    Expression expression = (Expression) visit(ctx.expression());

    // get switch block
    SwitchBlock switchBlock = (SwitchBlock) visit(ctx.switchBlock());

    return new SwitchStatement(range, null, expression, switchBlock);
  }

  @Override
  public AstNode visitSwitchBlock(JavaParser.SwitchBlockContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get switch block statement groups
    List<SwitchBlockStatementGroup> switchBlockStatementGroupList = new ArrayList<>();
    for (JavaParser.SwitchBlockStatementGroupContext switchBlockStatementGroupContext
        : ctx.switchBlockStatementGroup()) {
      SwitchBlockStatementGroup switchBlockStatementGroup
          = (SwitchBlockStatementGroup) visit(switchBlockStatementGroupContext);
      switchBlockStatementGroupList.add(switchBlockStatementGroup);
    }

    // get list of switch labels
    List<SwitchLabel> switchLabelList = new ArrayList<>();
    for (JavaParser.SwitchLabelContext switchLabelContext : ctx.switchLabel()) {
      SwitchLabel switchLabel = (SwitchLabel) visit(switchLabelContext);
      switchLabelList.add(switchLabel);
    }

    return new SwitchBlock(range, null, switchBlockStatementGroupList, switchLabelList);
  }

  @Override
  public AstNode visitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of switch labels
    List<SwitchLabel> switchLabelList = new ArrayList<>();
    for (JavaParser.SwitchLabelContext switchLabelContext : ctx.switchLabels().switchLabel()) {
      SwitchLabel switchLabel = (SwitchLabel) visit(switchLabelContext);
      switchLabelList.add(switchLabel);
    }

    // get block statements
    BlockStatements blockStatements = (BlockStatements) visit(ctx.blockStatements());

    return new SwitchBlockStatementGroup(range, null, switchLabelList, blockStatements);
  }

  @Override
  public AstNode visitSwitchLabels(JavaParser.SwitchLabelsContext ctx) {
    // Not necessary
    return super.visitSwitchLabels(ctx);
  }

  @Override
  public AstNode visitSwitchLabel(JavaParser.SwitchLabelContext ctx) {
    Range range =getRange(ctx);

    //
    if (ctx.constantExpression() != null) {
      Expression constantExpression = (Expression) visit(ctx.constantExpression().expression());
      return new ConstantSwitchLabel(range, null, constantExpression);
    } else if (ctx.enumConstantName() != null) {
      String enumConstantName = ctx.enumConstantName().Identifier().getText();
      return new EnumSwitchLabel(range, null, enumConstantName);
    } else if (ctx.getChild(0).getText().equals("default")) {
      return new DefaultSwitchLabel(range ,null);
    } else {
      System.err.println("ERROR : visitSwitchLabel");
      return super.visitSwitchLabel(ctx);
    }
  }

  @Override
  public AstNode visitEnumConstantName(JavaParser.EnumConstantNameContext ctx) {
    // Not necessary
    return super.visitEnumConstantName(ctx);
  }

  @Override
  public AstNode visitWhileStatement(JavaParser.WhileStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Expression
    Expression expression = (Expression) visit(ctx.expression());

    // get Statement
    Statement statement = (Statement) visit(ctx.statement());

    return new WhileStatement(range, null, expression, statement);
  }

  @Override
  public AstNode visitWhileStatementNoShortIf(JavaParser.WhileStatementNoShortIfContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Expression
    Expression expression = (Expression) visit(ctx.expression());

    // get statement
    StatementNoShortIf statementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf());

    return new WhileStatementNoShortIf(range, null, expression, statementNoShortIf);
  }

  @Override
  public AstNode visitDoStatement(JavaParser.DoStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Statement
    Statement statement = (Statement) visit(ctx.statement());

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    return new DoStatement(range, null, statement, expression);
  }

  @Override
  public AstNode visitForStatement(JavaParser.ForStatementContext ctx) {
    if (ctx.basicForStatement() != null) {
      return visit(ctx.basicForStatement());
    } else if (ctx.enhancedForStatement() != null) {
      return visit(ctx.enhancedForStatement());
    } else {
      System.err.println("ERROR : visitForStatement");
      return super.visitForStatement(ctx);
    }
  }

  @Override
  public AstNode visitForStatementNoShortIf(JavaParser.ForStatementNoShortIfContext ctx) {
    if (ctx.basicForStatementNoShortIf() != null) {
      return visit(ctx.basicForStatementNoShortIf());
    } else if (ctx.enhancedForStatementNoShortIf() != null) {
      return visit(ctx.enhancedForStatementNoShortIf());
    } else {
      System.err.println("ERROR : visitForStatementNoShortIf");
      return super.visitForStatementNoShortIf(ctx);
    }
  }

  @Override
  public AstNode visitBasicForStatement(JavaParser.BasicForStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get for init
    ForInit forInit = (ForInit) visit(ctx.forInit());

    // get for condition
    Expression forCondition = (Expression) visit(ctx.expression());

    // get for update
    StatementExpressionList forUpdate = (StatementExpressionList) visit(ctx.forUpdate().statementExpressionList());

    // get statement
    Statement statement = (Statement) visit(ctx.statement());
    return new BasicForStatement(range, null, forInit, forCondition, forUpdate, statement);
  }

  @Override
  public AstNode visitBasicForStatementNoShortIf(JavaParser.BasicForStatementNoShortIfContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get for init
    ForInit forInit = (ForInit) visit(ctx.forInit());

    // get for condition
    Expression forCondition = (Expression) visit(ctx.expression());

    // get for update
    StatementExpressionList forUpdate = (StatementExpressionList) visit(ctx.forUpdate().statementExpressionList());

    // get statement
    StatementNoShortIf statementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf());
    return new BasicForStatementNoShortIf(range, null, forInit, forCondition, forUpdate, statementNoShortIf);
  }

  @Override
  public AstNode visitForInit(JavaParser.ForInitContext ctx) {
    if (ctx.statementExpressionList() != null) {
      return visit(ctx.statementExpressionList());
    } else if (ctx.localVariableDeclaration() != null) {
      return visit(ctx.localVariableDeclaration());
    } else {
      System.err.println("ERROR : visitForInit");
      return super.visitForInit(ctx);
    }
  }

  @Override
  public AstNode visitForUpdate(JavaParser.ForUpdateContext ctx) {
    // Not Necessary
    return super.visitForUpdate(ctx);
  }

  @Override
  public AstNode visitStatementExpressionList(JavaParser.StatementExpressionListContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of statement expression
    List<StatementExpression> statementExpressionList = new ArrayList<>();

    return new StatementExpressionList(range, null, statementExpressionList);
  }

  @Override
  public AstNode visitEnhancedForStatement(JavaParser.EnhancedForStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier()) {

      if (variableModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = variableModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get variable declaratior id
    VariableDeclaratorId variableDeclaratorId = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    // get statement
    Statement statement = (Statement) visit(ctx.statement());

    return new EnhancedForStatement(range, null, annotationList, modifiers, unannType, variableDeclaratorId, expression, statement);
  }

  @Override
  public AstNode visitEnhancedForStatementNoShortIf(JavaParser.EnhancedForStatementNoShortIfContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier()) {

      if (variableModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = variableModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Unannotated type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get variable declaratior id
    VariableDeclaratorId variableDeclaratorId = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    // get statement
    StatementNoShortIf statementNoShortIf = (StatementNoShortIf) visit(ctx.statementNoShortIf());

    return new EnhancedForStatementNoShortIf(range, null, annotationList, modifiers, unannType, variableDeclaratorId, expression, statementNoShortIf);
  }

  @Override
  public AstNode visitBreakStatement(JavaParser.BreakStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    return new BreakStatement(range, null, identifier);
  }

  @Override
  public AstNode visitContinueStatement(JavaParser.ContinueStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    return new ContinueStatement(range, null, identifier);
  }

  @Override
  public AstNode visitReturnStatement(JavaParser.ReturnStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    return new ReturnStatement(range, null, expression);
  }

  @Override
  public AstNode visitThrowStatement(JavaParser.ThrowStatementContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    return new ThrowStatement(range, null, expression);
  }

  @Override
  public AstNode visitSynchronizedStatement(JavaParser.SynchronizedStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    // get block
    Block block = (Block) visit(ctx.block());

    return new SynchronizedStatement(range, null, expression, block);
  }

  @Override
  public AstNode visitTryStatement(JavaParser.TryStatementContext ctx) {

    if (ctx.tryWithResourcesStatement() != null) {
      return visit(ctx.tryWithResourcesStatement());
    }

    // Range range
    Range range = getRange(ctx);

    // get block
    Block tryBlock = (Block) visit(ctx.block());

    // get catches
    List<CatchClause> catches = new ArrayList<>();
    for (JavaParser.CatchClauseContext catchClauseContext : ctx.catches().catchClause()) {
      CatchClause catchClause = (CatchClause) visit(catchClauseContext);
      catches.add(catchClause);
    }

    if (ctx.finally_() != null) {
      Block finallyBlock = (Block) visit(ctx.finally_().block());
      return new TryCatchFinallyStatement(range, null, tryBlock, catches, finallyBlock);
    }
    return new TryCatchStatement(range, null, tryBlock, catches);
  }

  @Override
  public AstNode visitCatches(JavaParser.CatchesContext ctx) {
    // Not necessary
    return super.visitCatches(ctx);
  }

  @Override
  public AstNode visitCatchClause(JavaParser.CatchClauseContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get catcg formal Parameter
    CatchFormalParameter catchFormalParameter
        = (CatchFormalParameter) visit(ctx.catchFormalParameter());

    // get block
    Block block = (Block) visit(ctx.block());

    return new CatchClause(range, null, catchFormalParameter, block);
  }

  @Override
  public AstNode visitCatchFormalParameter(JavaParser.CatchFormalParameterContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier()) {

      if (variableModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = variableModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Catch type
    CatchType catchType = (CatchType) visit(ctx.catchType());

    // get variable declaratior id
    VariableDeclaratorId variableDeclaratorId = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());

    return new CatchFormalParameter(range, null, annotationList, modifiers, catchType, variableDeclaratorId);
  }

  @Override
  public AstNode visitCatchType(JavaParser.CatchTypeContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get unannotated class type
    UnannClassType unannClassType = (UnannClassType) visit(ctx.unannClassType());

    // get list of class type
    List<ClassType> classTypeList = new ArrayList<>();
    for (JavaParser.ClassTypeContext classTypeContext : ctx.classType()) {
      ClassType classType = (ClassType) visit(classTypeContext);
      classTypeList.add(classType);
    }

    return new CatchType(range, null, unannClassType, classTypeList);
  }

  @Override
  public AstNode visitFinally_(JavaParser.Finally_Context ctx) {
    // Not necessary
    return super.visitFinally_(ctx);
  }

  @Override
  public AstNode visitTryWithResourcesStatement(JavaParser.TryWithResourcesStatementContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get resource specification
    List<Resource> resourceSpecification = new ArrayList<>();
    for (JavaParser.ResourceContext resourceContext
        : ctx.resourceSpecification().resourceList().resource()) {
      Resource resource = (Resource) visit(resourceContext);
      resourceSpecification.add(resource);
    }

    // get try block
    Block tryBlock = (Block) visit(ctx.block());

    // get catches (list of catch clause)
    List<CatchClause> catches = new ArrayList<>();
    for (JavaParser.CatchClauseContext catchClauseContext : ctx.catches().catchClause()) {
      CatchClause catchClause = (CatchClause) visit(catchClauseContext);
      catches.add(catchClause);
    }

    // get finallyBlock
    Block finallyBlock = (Block) visit(ctx.finally_().block());

    return new TryWithResourcesStatement(range, null, resourceSpecification, tryBlock, catches, finallyBlock);
  }

  @Override
  public AstNode visitResource(JavaParser.ResourceContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get class Modifier lists
    List<Annotation> annotationList = new ArrayList<>();
    int modifiers = 0;
    for ( JavaParser.VariableModifierContext variableModifierContext : ctx.variableModifier()) {

      if (variableModifierContext.annotation() != null) {
        Annotation annotation = (Annotation) visit(variableModifierContext.annotation());
        annotationList.add(annotation);
      } else {
        String normalModifier = variableModifierContext.getChild(0).getText();
        switch(normalModifier) {
          case "final" :
            modifiers |= Modifiers.FINAL;
            break;
          default : // Error
            modifiers = -1;
            break;
        }
      }
    }

    // get Catch type
    UnannType unannType = (UnannType) visit(ctx.unannType());

    // get variable declaratior id
    VariableDeclaratorId variableDeclaratorId = (VariableDeclaratorId) visit(ctx.variableDeclaratorId());

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    return new Resource(range, null, annotationList, modifiers, unannType, variableDeclaratorId, expression);
  }

  @Override
  public AstNode visitPrimary(JavaParser.PrimaryContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get pNNA_lf_primary
    List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList = new ArrayList<>();
    for (JavaParser.PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primaryContext
        : ctx.primaryNoNewArray_lf_primary()) {
      AstNode astNode = visit(primaryNoNewArray_lf_primaryContext);

      //
      DefaultArrayLfPrimary defaultArrayLfPrimary;
      if (astNode instanceof DefaultArrayLfPrimary) {
        defaultArrayLfPrimary = (DefaultArrayLfPrimary) astNode;
      } else {
        System.err.println("ERROR : visitPrimary");
        return super.visitPrimary(ctx);
      }
      defaultArrayLfPrimaryList.add(defaultArrayLfPrimary);
    }

    if (ctx.primaryNoNewArray_lfno_primary() != null) {
      //
      AstNode astNode = visit(ctx.primaryNoNewArray_lfno_primary());
      //
      DefaultArrayLfnoPrimary defaultArrayLfnoPrimary;
      if (astNode instanceof DefaultArrayLfnoPrimary) {
        defaultArrayLfnoPrimary = (DefaultArrayLfnoPrimary) astNode;
      } else {
        System.err.println("ERROR : visitPrimary");
        return super.visitPrimary(ctx);
      }
      //
      return new PrimaryNoNewArray(range, null, defaultArrayLfnoPrimary, defaultArrayLfPrimaryList);

    } else if (ctx.arrayCreationExpression() != null) {
      //
      ArrayCreationExpression arrayCreationExpression
          = (ArrayCreationExpression) visit(ctx.arrayCreationExpression());
      //
      return new PrimaryArrayCreationExpression(range, null, arrayCreationExpression, defaultArrayLfPrimaryList);

    } else {
      System.err.println("ERROR : visitPrimary");
      return super.visitPrimary(ctx);
    }
  }

  @Override
  public AstNode visitPrimaryNoNewArray(JavaParser.PrimaryNoNewArrayContext ctx) { // Not necessary
    // get range
    Range range = getRange(ctx);

    if (ctx.literal() != null) {
      Literal literal = (Literal) visit(ctx.literal());
      return new LiteralExpression(range, null, literal);
    } else if (ctx.getChild(0).getText().equals("void")) {
      return new VoidClassLiteralExpression(range, null);
    } else if (ctx.getChild(0).getText().equals("this")) {
      return new BasicThisExpression(range, null);
    } else if (ctx.typeName() != null && ctx.getChild(2).getText().equals("this")) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new ReferenceThisExpression(range, null, typeName);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      int cnt = 0;
      for (ParseTree parseTree : ctx.children) {
        if (parseTree.getText().equals("[")) { ++cnt; }
      }
      return new ReferenceClassLiteralExpression(range, null, typeName, cnt);
    } else if (ctx.getChild(0).getText().equals("(")) {
      Expression expression = (Expression) visit(ctx.expression());
      return new ParenthesizedExpression(range, null, expression);
    } else if (ctx.classInstanceCreationExpression() != null) {
      return visit(ctx.classInstanceCreationExpression());
    } else if (ctx.fieldAccess() != null) {
      return visit(ctx.fieldAccess());
    } else if (ctx.arrayAccess() != null) {
      return visit(ctx.arrayAccess());
    } else if (ctx.methodInvocation() != null) {
      return visit(ctx.methodInvocation());
    } else if (ctx.methodReference() != null) {
      return visit(ctx.methodReference());
    } else {
      System.err.println("ERROR : visitPrimaryNoNewArray");
      return super.visitPrimaryNoNewArray(ctx);
    }
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_arrayAccess(JavaParser.PrimaryNoNewArray_lf_arrayAccessContext ctx) {
    // Not Necessary
    return super.visitPrimaryNoNewArray_lf_arrayAccess(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_arrayAccess(JavaParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
    // get range
    Range range = getRange(ctx);

    if (ctx.literal() != null) {
      Literal literal = (Literal) visit(ctx.literal());
      return new LiteralExpression(range, null, literal);
    } else if (ctx.getChild(0).getText().equals("void")) {
      return new VoidClassLiteralExpression(range, null);
    } else if (ctx.getChild(0).getText().equals("this")) {
      return new BasicThisExpression(range, null);
    } else if (ctx.typeName() != null && ctx.getChild(2).getText().equals("this")) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new ReferenceThisExpression(range, null, typeName);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      int cnt = 0;
      for (ParseTree parseTree : ctx.children) {
        if (parseTree.getText().equals("[")) { ++cnt; }
      }
      return new ReferenceClassLiteralExpression(range, null, typeName, cnt);
    } else if (ctx.getChild(0).getText().equals("(")) {
      Expression expression = (Expression) visit(ctx.expression());
      return new ParenthesizedExpression(range, null, expression);
    } else if (ctx.classInstanceCreationExpression() != null) {
      return visit(ctx.classInstanceCreationExpression());
    } else if (ctx.fieldAccess() != null) {
      return visit(ctx.fieldAccess());
    } else if (ctx.methodInvocation() != null) {
      return visit(ctx.methodInvocation());
    } else if (ctx.methodReference() != null) {
      return visit(ctx.methodReference());
    } else {
      System.err.println("ERROR : visitPrimaryNoNewArray_lfno_arrayAccess");
      return super.visitPrimaryNoNewArray_lfno_arrayAccess(ctx);
    }
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_primary(JavaParser.PrimaryNoNewArray_lf_primaryContext ctx) {
    if (ctx.classInstanceCreationExpression_lf_primary() != null) {
      return visit(ctx.classInstanceCreationExpression_lf_primary());
    } else if (ctx.fieldAccess_lf_primary() != null) {
      return visit(ctx.fieldAccess_lf_primary());
    } else if (ctx.arrayAccess_lf_primary() != null) {
      return visit(ctx.arrayAccess_lf_primary());
    } else if (ctx.methodInvocation_lf_primary() != null) {
      return visit(ctx.methodInvocation_lf_primary());
    } else if (ctx.methodReference_lf_primary() != null) {
      return visit(ctx.methodReference_lf_primary());
    } else {
      System.err.println("ERROR : visitPrimaryNoNewArray_lf_primary");
      return super.visitPrimaryNoNewArray_lf_primary(ctx);
    }
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(JavaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
    // Not Necessary TODO - check the reliability
    return super.visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(JavaParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
    if (ctx.classInstanceCreationExpression_lf_primary() != null) {
      return visit(ctx.classInstanceCreationExpression_lf_primary());
    } else if (ctx.fieldAccess_lf_primary() != null) {
      return visit(ctx.fieldAccess_lf_primary());
    } else if (ctx.methodInvocation_lf_primary() != null) {
      return visit(ctx.methodInvocation_lf_primary());
    } else if (ctx.methodReference_lf_primary() != null) {
      return visit(ctx.methodReference_lf_primary());
    } else {
      System.err.println("ERROR : visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary");
      return super.visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(ctx);
    }
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_primary(JavaParser.PrimaryNoNewArray_lfno_primaryContext ctx) {
    // get range
    Range range = getRange(ctx);

    if (ctx.literal() != null) {
      Literal literal = (Literal) visit(ctx.literal());
      return new LiteralExpression(range, null, literal);
    } else if (ctx.getChild(0).getText().equals("void")) {
      return new VoidClassLiteralExpression(range, null);
    } else if (ctx.getChild(0).getText().equals("this")) {
      return new BasicThisExpression(range, null);
    } else if (ctx.typeName() != null && ctx.getChild(2).getText().equals("this")) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new ReferenceThisExpression(range, null, typeName);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      int cnt = 0;
      for (ParseTree parseTree : ctx.children) {
        if (parseTree.getText().equals("[")) { ++cnt; }
      }
      return new ReferenceClassLiteralExpression(range, null, typeName, cnt);
    } else if (ctx.unannPrimitiveType() != null) {
      UnannPrimitiveType unannPrimitiveType = (UnannPrimitiveType) visit(ctx.unannPrimitiveType());
      int cnt = 0;
      for (ParseTree parseTree : ctx.children) {
        if (parseTree.getText().equals("[")) { ++cnt; }
      }
      return new PrimitiveClassLiteralExpression(range, null, unannPrimitiveType, cnt);
    } else if (ctx.getChild(0).getText().equals("(")) {
      Expression expression = (Expression) visit(ctx.expression());
      return new ParenthesizedExpression(range, null, expression);
    } else if (ctx.classInstanceCreationExpression_lfno_primary() != null) {
      return visit(ctx.classInstanceCreationExpression_lfno_primary());
    } else if (ctx.fieldAccess_lfno_primary() != null) {
      return visit(ctx.fieldAccess_lfno_primary());
    } else if (ctx.arrayAccess_lfno_primary() != null) {
      return visit(ctx.arrayAccess_lfno_primary());
    } else if (ctx.methodInvocation_lfno_primary() != null) {
      return visit(ctx.methodInvocation_lfno_primary());
    } else if (ctx.methodReference_lfno_primary() != null) {
      return visit(ctx.methodReference_lfno_primary());
    } else {
      System.err.println("ERROR : visitPrimaryNoNewArray_lfno_primary");
      return super.visitPrimaryNoNewArray_lfno_primary(ctx);
    }
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(JavaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
    // Not Necessary
    return super.visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(JavaParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
    // get range
    Range range = getRange(ctx);

    if (ctx.literal() != null) {
      Literal literal = (Literal) visit(ctx.literal());
      return new LiteralExpression(range, null, literal);
    } else if (ctx.getChild(0).getText().equals("void")) {
      return new VoidClassLiteralExpression(range, null);
    } else if (ctx.getChild(0).getText().equals("this")) {
      return new BasicThisExpression(range, null);
    } else if (ctx.typeName() != null && ctx.getChild(2).getText().equals("this")) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new ReferenceThisExpression(range, null, typeName);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      int cnt = 0;
      for (ParseTree parseTree : ctx.children) {
        if (parseTree.getText().equals("[")) { ++cnt; }
      }
      return new ReferenceClassLiteralExpression(range, null, typeName, cnt);
    } else if (ctx.unannPrimitiveType() != null) {
      UnannPrimitiveType unannPrimitiveType = (UnannPrimitiveType) visit(ctx.unannPrimitiveType());
      int cnt = 0;
      for (ParseTree parseTree : ctx.children) {
        if (parseTree.getText().equals("[")) { ++cnt; }
      }
      return new PrimitiveClassLiteralExpression(range, null, unannPrimitiveType, cnt);
    } else if (ctx.getChild(0).getText().equals("(")) {
      Expression expression = (Expression) visit(ctx.expression());
      return new ParenthesizedExpression(range, null, expression);
    } else if (ctx.classInstanceCreationExpression_lfno_primary() != null) {
      return visit(ctx.classInstanceCreationExpression_lfno_primary());
    } else if (ctx.fieldAccess_lfno_primary() != null) {
      return visit(ctx.fieldAccess_lfno_primary());
    } else if (ctx.methodInvocation_lfno_primary() != null) {
      return visit(ctx.methodInvocation_lfno_primary());
    } else if (ctx.methodReference_lfno_primary() != null) {
      return visit(ctx.methodReference_lfno_primary());
    } else {
      System.err.println("ERROR : visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary");
      return super.visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(ctx);
    }
  }

  @Override
  public AstNode visitClassInstanceCreationExpression(JavaParser.ClassInstanceCreationExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of type arguments
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for(JavaParser.TypeArgumentContext typeArgumentContext : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    // get type argument or diamond
    TypeArgumentsOrDiamond typeArgumentsOrDiamond
        = (TypeArgumentsOrDiamond) visit(ctx.typeArgumentsOrDiamond());

    // get argument list
    List<Expression> argumentList = new ArrayList<>();
    for(JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      argumentList.add(expression);
    }

    // get class body
    List<ClassBodyDeclaration> classBody = new ArrayList<>();
    for(JavaParser.ClassBodyDeclarationContext classBodyDeclarationContext
        : ctx.classBody().classBodyDeclaration()) {
      ClassBodyDeclaration classBodyDeclaration
          = (ClassBodyDeclaration) visit(classBodyDeclarationContext);
      classBody.add(classBodyDeclaration);
    }


    if (ctx.expressionName() != null) { // expressionName
      // get expression name
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());

      // get annotation list
      List<Annotation> annotationList = new ArrayList<>();
      for(JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
        Annotation annotation = (Annotation) visit(annotationContext);
        annotationList.add(annotation);
      }

      // get identifier
      String identifier = ctx.Identifier(0).getText();

      return new ExpressionClassInstanceCreationExpression(range, null,
          expressionName, typeArgumentList, annotationList, identifier, typeArgumentsOrDiamond, argumentList, classBody);

    } else if (ctx.primary() != null) { // primary

      // get primary
      Primary primary = (Primary) visit(ctx.primary());

      // get annotation list
      List<Annotation> annotationList = new ArrayList<>();
      for(JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
        Annotation annotation = (Annotation) visit(annotationContext);
        annotationList.add(annotation);
      }

      // get identifier
      String identifier = ctx.Identifier(0).getText();

      return new PrimaryClassInstanceCreationExpression(range, null,
          primary, typeArgumentList, annotationList, identifier, typeArgumentsOrDiamond, argumentList, classBody);

    } else if (ctx.getChild(0).getText().equals("new")) { // basic

      // get list of annotations
      List<List<Annotation>> annotationListList = new ArrayList<>();
      List<String> identifierList = new ArrayList<>();

      List<Annotation> annotationList = new ArrayList<>();
      for (ParseTree parseTree : ctx.children) {
        if (parseTree instanceof JavaParser.AnnotationContext) {
          Annotation annotation = (Annotation) visit(parseTree);
          annotationList.add(annotation);
        } else if (parseTree.getText().equals(".")) {
          annotationListList.add(annotationList);
          annotationList = new ArrayList<>();
        } else if (parseTree instanceof JavaParser.TypeArgumentsContext
                 ||parseTree.getText().equals("new")) {
          // Do nothing
        } else if (parseTree instanceof JavaParser.TypeArgumentsOrDiamondContext
                 ||parseTree.getText().equals("(")) {
          annotationListList.add(annotationList);
          break;
        } else {
          String identifier = ctx.getText();
          identifierList.add(identifier);
        }
      }

      return new BasicClassInstanceCreationExpression(range, null,
          typeArgumentList, annotationListList, identifierList, typeArgumentsOrDiamond, argumentList, classBody);

    } else {
      System.err.println("ERROR : visitClassIntanceCreationExpression");
      return super.visitClassInstanceCreationExpression(ctx);
    }
  }

  @Override
  public AstNode visitClassInstanceCreationExpression_lf_primary(JavaParser.ClassInstanceCreationExpression_lf_primaryContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get list of type arguments
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for(JavaParser.TypeArgumentContext typeArgumentContext : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    // get annotation list
    List<Annotation> annotationList = new ArrayList<>();
    for(JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
      annotationList.add(annotation);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get type argument or diamond
    TypeArgumentsOrDiamond typeArgumentsOrDiamond
        = (TypeArgumentsOrDiamond) visit(ctx.typeArgumentsOrDiamond());

    // get argument list
    List<Expression> argumentList = new ArrayList<>();
    for(JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      argumentList.add(expression);
    }

    // get class body
    List<ClassBodyDeclaration> classBody = new ArrayList<>();
    for(JavaParser.ClassBodyDeclarationContext classBodyDeclarationContext
        : ctx.classBody().classBodyDeclaration()) {
      ClassBodyDeclaration classBodyDeclaration
          = (ClassBodyDeclaration) visit(classBodyDeclarationContext);
      classBody.add(classBodyDeclaration);
    }

    return new PostfixClassInstanceCreationExpression(range, null,
        typeArgumentList, annotationList, identifier, typeArgumentsOrDiamond, argumentList, classBody);
  }

  @Override
  public AstNode visitClassInstanceCreationExpression_lfno_primary(JavaParser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get list of type arguments
    List<TypeArgument> typeArgumentList = new ArrayList<>();
    for(JavaParser.TypeArgumentContext typeArgumentContext : ctx.typeArguments().typeArgumentList().typeArgument()) {
      TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
      typeArgumentList.add(typeArgument);
    }

    // get type argument or diamond
    TypeArgumentsOrDiamond typeArgumentsOrDiamond
        = (TypeArgumentsOrDiamond) visit(ctx.typeArgumentsOrDiamond());

    // get argument list
    List<Expression> argumentList = new ArrayList<>();
    for(JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      argumentList.add(expression);
    }

    // get class body
    List<ClassBodyDeclaration> classBody = new ArrayList<>();
    for(JavaParser.ClassBodyDeclarationContext classBodyDeclarationContext
        : ctx.classBody().classBodyDeclaration()) {
      ClassBodyDeclaration classBodyDeclaration
          = (ClassBodyDeclaration) visit(classBodyDeclarationContext);
      classBody.add(classBodyDeclaration);
    }


    if (ctx.expressionName() != null) { // expressionName
      // get expression name
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());

      // get annotation list
      List<Annotation> annotationList = new ArrayList<>();
      for(JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
        Annotation annotation = (Annotation) visit(annotationContext);
        annotationList.add(annotation);
      }

      // get identifier
      String identifier = ctx.Identifier(0).getText();

      return new ExpressionClassInstanceCreationExpression(range, null,
          expressionName, typeArgumentList, annotationList, identifier, typeArgumentsOrDiamond, argumentList, classBody);

    }  else if (ctx.getChild(0).getText().equals("new")) { // basic

      // get list of annotations
      List<List<Annotation>> annotationListList = new ArrayList<>();
      List<String> identifierList = new ArrayList<>();

      List<Annotation> annotationList = new ArrayList<>();
      for (ParseTree parseTree : ctx.children) {
        if (parseTree instanceof JavaParser.AnnotationContext) {
          Annotation annotation = (Annotation) visit(parseTree);
          annotationList.add(annotation);
        } else if (parseTree.getText().equals(".")) {
          annotationListList.add(annotationList);
          annotationList = new ArrayList<>();
        } else if (parseTree instanceof JavaParser.TypeArgumentsContext
            ||parseTree.getText().equals("new")) {
          // Do nothing
        } else if (parseTree instanceof JavaParser.TypeArgumentsOrDiamondContext
            ||parseTree.getText().equals("(")) {
          annotationListList.add(annotationList);
          break;
        } else {
          String identifier = ctx.getText();
          identifierList.add(identifier);
        }
      }

      return new BasicClassInstanceCreationExpression(range, null,
          typeArgumentList, annotationListList, identifierList, typeArgumentsOrDiamond, argumentList, classBody);

    } else {
      System.err.println("ERROR : visitClassInstanceCreationExpression_lfno_primary");
      return super.visitClassInstanceCreationExpression_lfno_primary(ctx);
    }
  }

  @Override
  public AstNode visitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {
    // get range
    Range range = getRange(ctx);


    if (ctx.typeArguments() != null) {
      // get type argument list
      List<TypeArgument> typeArgumentList = new ArrayList<>();
      for (JavaParser.TypeArgumentContext typeArgumentContext
          : ctx.typeArguments().typeArgumentList().typeArgument()) {
        TypeArgument typeArgument = (TypeArgument) visit(typeArgumentContext);
        typeArgumentList.add(typeArgument);
      }
      return new TypeArguments(range, null, typeArgumentList);

    } else if (ctx.getChild(0).getText().equals("<")) {
      return new Diamond(range, null);

    } else {
      System.err.println("ERROR : visitTypeArgumentsOrDiamond");
      return super.visitTypeArgumentsOrDiamond(ctx);
    }
  }

  @Override
  public AstNode visitFieldAccess(JavaParser.FieldAccessContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    if (ctx.primary() != null) {
      Primary primary = (Primary) visit(ctx.primary());
      return new PrimaryFieldAccess(range, null, primary, identifier);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new ReferenceFieldAccess(range, null, typeName, identifier);
    } else if (ctx.getChild(0).getText().equals("super")) {
      return new BasicFieldAccess(range, null, identifier);
    } else {
      System.err.println("ERROR : visitFieldAccess");
      return super.visitFieldAccess(ctx);
    }
  }

  @Override
  public AstNode visitFieldAccess_lf_primary(JavaParser.FieldAccess_lf_primaryContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    return new PostfixFieldAccess(range, null, identifier);
  }

  @Override
  public AstNode visitFieldAccess_lfno_primary(JavaParser.FieldAccess_lfno_primaryContext ctx) {


    // get range
    Range range = getRange(ctx);

    // get identifier
    String identifier = ctx.Identifier().getText();

    if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new ReferenceFieldAccess(range, null, typeName, identifier);
    } else if (ctx.getChild(0).getText().equals("super")) {
      return new BasicFieldAccess(range, null, identifier);
    } else {
      System.err.println("ERROR : visitFieldAccess_lfno_primary");
      return super.visitFieldAccess_lfno_primary(ctx);
    }
  }

  @Override
  public AstNode visitArrayAccess(JavaParser.ArrayAccessContext ctx) {

    // ger range
    Range range = getRange(ctx);

    // get first expression
    Expression firstExpression = (Expression) visit(ctx.expression(0));


    // get list of lf array default primary
    List<LfArrayDefaultPrimary> lfArrayDefaultPrimaryList = new ArrayList<>();
    for (JavaParser.PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccessContext
        : ctx.primaryNoNewArray_lf_arrayAccess()) {
      LfArrayDefaultPrimary lfArrayDefaultPrimary
          = (LfArrayDefaultPrimary) visit(primaryNoNewArray_lf_arrayAccessContext);
      lfArrayDefaultPrimaryList.add(lfArrayDefaultPrimary);
    }

    // get remain expressions
    List<Expression> expressionList = new ArrayList<>();
    for (int i = 1; i < ctx.getChildCount(); i++) {
      Expression expression = (Expression) visit(ctx.expression(i));
      expressionList.add(expression);
    }

    if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new DefaultPrimaryExpressionArrayAccess(range, null, expressionName, firstExpression, lfArrayDefaultPrimaryList, expressionList);

    } else if (ctx.primaryNoNewArray_lfno_arrayAccess() != null) {
      LfnoArrayDefaultPrimary lfnoArrayDefaultPrimary = (LfnoArrayDefaultPrimary) visit(ctx.primaryNoNewArray_lfno_arrayAccess());
      return new DefaultPrimaryArrayAccess(range, null, lfnoArrayDefaultPrimary, firstExpression, lfArrayDefaultPrimaryList, expressionList);

    } else {
      System.err.println("ERROR : visitArrayAccess");
      return super.visitArrayAccess(ctx);

    }
  }

  @Override
  public AstNode visitArrayAccess_lf_primary(JavaParser.ArrayAccess_lf_primaryContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get lfno array lf primary
    LfnoArrayLfPrimary lfnoArrayLfPrimary = (LfnoArrayLfPrimary) visit(ctx.primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary());

    // get Expression
    Expression firstExpression = (Expression) visit(ctx.expression(0));


    // get list of lf array lfno primary
    List<LfArrayLfPrimary> lfArrayLfPrimaryList= new ArrayList<>();
    for (JavaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext
        primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext
        : ctx.primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary()) {
      LfArrayLfPrimary lfArrayLfPrimary
          = (LfArrayLfPrimary) visit(primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext);
      lfArrayLfPrimaryList.add(lfArrayLfPrimary);
    }

    // get remain expressions
    List<Expression> expressionList = new ArrayList<>();
    for (int i = 1; i < ctx.getChildCount(); i++) {
      Expression expression = (Expression) visit(ctx.expression(i));
      expressionList.add(expression);
    }

    return new LfPrimaryArrayAccess(range, null, lfnoArrayLfPrimary, firstExpression, lfArrayLfPrimaryList, expressionList);
  }

  @Override
  public AstNode visitArrayAccess_lfno_primary(JavaParser.ArrayAccess_lfno_primaryContext ctx) {

    // ger range
    Range range = getRange(ctx);

    // get first expression
    Expression firstExpression = (Expression) visit(ctx.expression(0));


    // get list of lf array lfno primary
    List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList= new ArrayList<>();
    for (JavaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext
                    primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext
        : ctx.primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary()) {
      LfArrayLfnoPrimary lfArrayLfnoPrimary
          = (LfArrayLfnoPrimary) visit(primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext);
      lfArrayLfnoPrimaryList.add(lfArrayLfnoPrimary);
    }

    // get remain expressions
    List<Expression> expressionList = new ArrayList<>();
    for (int i = 1; i < ctx.getChildCount(); i++) {
      Expression expression = (Expression) visit(ctx.expression(i));
      expressionList.add(expression);
    }

    if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new LfnoPrimaryExpressionArrayAccess(range, null, expressionName, firstExpression, lfArrayLfnoPrimaryList, expressionList);

    } else if (ctx.primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() != null) {
      LfnoArrayLfnoPrimary lfnoArrayLfnoPrimary = (LfnoArrayLfnoPrimary) visit(ctx.primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary());
      return new LfnoPrimaryArrayAccess(range, null, lfnoArrayLfnoPrimary, firstExpression, lfArrayLfnoPrimaryList, expressionList);

    } else {
      System.err.println("ERROR : visitArrayAccess");
      return super.visitArrayAccess_lfno_primary(ctx);

    }
  }

  @Override
  public AstNode visitMethodInvocation(JavaParser.MethodInvocationContext ctx) {
    // get Range
    Range range = getRange(ctx);

    // get argument list
    List<Expression> argumentList = new ArrayList<>();
    for (JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      argumentList.add(expression);
    }

    if (ctx.methodName() != null) { //BASIC
      MethodName methodName = (MethodName) visit(ctx.methodName());
      return new BasicMethodInvocation(range, null, methodName, argumentList);
    }

    // get TypeArguments
    TypeArguments typeArguments = (TypeArguments) visit(ctx.typeArguments());

    // get identifier
    String identifier = ctx.Identifier().getText();

    if (ctx.getChild(0).getText().equals("super")) {
      return new BasicSuperMethodInvocation(range, null, typeArguments, identifier, argumentList);
    } else if (ctx.typeName() != null && ctx.getChild(2).getText().equals("super")) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new TypeSuperMethodInvocation(range, null, typeName, typeArguments, identifier, argumentList);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new TypeMethodInvocation(range, null, typeName, typeArguments, identifier, argumentList);
    } else if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new ExpressionMethodInvocation(range, null, expressionName, typeArguments, identifier, argumentList);
    } else if (ctx.primary() != null) {
      Primary primary = (Primary) visit(ctx.primary());
      return new PrimaryMethodInvocation(range, null, primary, typeArguments, identifier, argumentList);
    } else {
      System.err.println("ERROR : visitMethodInvocation");
      return super.visitMethodInvocation(ctx);
    }
  }

  @Override
  public AstNode visitMethodInvocation_lf_primary(JavaParser.MethodInvocation_lf_primaryContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get TypeArguments
    TypeArguments typeArguments = (TypeArguments) visit(ctx.typeArguments());

    // get identifier
    String identifier = ctx.Identifier().getText();

    // get argument list
    List<Expression> argumentList = new ArrayList<>();
    for (JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      argumentList.add(expression);
    }

    return new PostfixMethodInvocation(range, null, typeArguments,identifier, argumentList);
  }

  @Override
  public AstNode visitMethodInvocation_lfno_primary(JavaParser.MethodInvocation_lfno_primaryContext ctx) {
    // get Range
    Range range = getRange(ctx);

    // get argument list
    List<Expression> argumentList = new ArrayList<>();
    for (JavaParser.ExpressionContext expressionContext : ctx.argumentList().expression()) {
      Expression expression = (Expression) visit(expressionContext);
      argumentList.add(expression);
    }

    if (ctx.methodName() != null) { //BASIC
      MethodName methodName = (MethodName) visit(ctx.methodName());
      return new BasicMethodInvocation(range, null, methodName, argumentList);
    }

    // get TypeArguments
    TypeArguments typeArguments = (TypeArguments) visit(ctx.typeArguments());

    // get identifier
    String identifier = ctx.Identifier().getText();

    if (ctx.getChild(0).getText().equals("super")) {
      return new BasicSuperMethodInvocation(range, null, typeArguments, identifier, argumentList);
    } else if (ctx.typeName() != null && ctx.getChild(2).getText().equals("super")) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new TypeSuperMethodInvocation(range, null, typeName, typeArguments, identifier, argumentList);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new TypeMethodInvocation(range, null, typeName, typeArguments, identifier, argumentList);
    } else if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new ExpressionMethodInvocation(range, null, expressionName, typeArguments, identifier, argumentList);
    } else {
      System.err.println("ERROR : visitMethodInvocation");
      return super.visitMethodInvocation_lfno_primary(ctx);
    }
  }

  @Override
  public AstNode visitArgumentList(JavaParser.ArgumentListContext ctx) {
    // Not necessary
    return super.visitArgumentList(ctx);
  }

  @Override
  public AstNode visitMethodReference(JavaParser.MethodReferenceContext ctx) {

    // get range
    Range range = getRange(ctx);

    // RETURN array type
    if (ctx.arrayType() != null) {
      ArrayType arrayType = (ArrayType) visit(ctx.arrayType());
      return new ArrayMethodReference(range, null, arrayType);
    }

    // get type arguments
    TypeArguments typeArguments = (TypeArguments) visit(ctx.typeArguments());

    // RETURN class type
    if (ctx.classType() != null) {
      ClassType classType = (ClassType) visit(ctx.classType());
      return new ClassMethodReference(range, null, classType, typeArguments);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    //
    if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new ExpressionMethodReference(range, null, expressionName, typeArguments, identifier);
    } else if (ctx.referenceType() != null) {
      ReferenceType referenceType = (ReferenceType) visit(ctx.referenceType());
      return new ReferenceMethodReference(range, null, referenceType, typeArguments, identifier);
    } else if (ctx.primary() != null) {
      Primary primary = (Primary) visit(ctx.primary());
      return new PrimaryMethodReference(range, null, primary, typeArguments, identifier);
    } else if (ctx.getChild(0).getText().equals("super")) {
      return new BasicSuperMethodReference(range, null, typeArguments, identifier);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new TypeSuperMethodReference(range, null,typeName, typeArguments, identifier);
    } else {
      System.err.println("ERROR : visitMethodReference");
      return super.visitMethodReference(ctx);
    }
  }

  @Override
  public AstNode visitMethodReference_lf_primary(JavaParser.MethodReference_lf_primaryContext ctx) {
    // get range
    Range range = getRange(ctx);

    // get Type arguments
    TypeArguments typeArguments = (TypeArguments) visit(ctx.typeArguments());

    // get identifier
    String identifier = ctx.Identifier().getText();

    return new PostfixMethodReference(range, null, typeArguments, identifier);
  }

  @Override
  public AstNode visitMethodReference_lfno_primary(JavaParser.MethodReference_lfno_primaryContext ctx) {
    // get range
    Range range = getRange(ctx);

    // RETURN array type
    if (ctx.arrayType() != null) {
      ArrayType arrayType = (ArrayType) visit(ctx.arrayType());
      return new ArrayMethodReference(range, null, arrayType);
    }

    // get type arguments
    TypeArguments typeArguments = (TypeArguments) visit(ctx.typeArguments());

    // RETURN class type
    if (ctx.classType() != null) {
      ClassType classType = (ClassType) visit(ctx.classType());
      return new ClassMethodReference(range, null, classType, typeArguments);
    }

    // get identifier
    String identifier = ctx.Identifier().getText();

    //
    if (ctx.expressionName() != null) {
      ExpressionName expressionName = (ExpressionName) visit(ctx.expressionName());
      return new ExpressionMethodReference(range, null, expressionName, typeArguments, identifier);
    } else if (ctx.referenceType() != null) {
      ReferenceType referenceType = (ReferenceType) visit(ctx.referenceType());
      return new ReferenceMethodReference(range, null, referenceType, typeArguments, identifier);
    } else if (ctx.getChild(0).getText().equals("super")) {
      return new BasicSuperMethodReference(range, null, typeArguments, identifier);
    } else if (ctx.typeName() != null) {
      TypeName typeName = (TypeName) visit(ctx.typeName());
      return new TypeSuperMethodReference(range, null,typeName, typeArguments, identifier);
    } else {
      System.err.println("ERROR : visitMethodReference_lfno_primary");
      return super.visitMethodReference_lfno_primary(ctx);
    }
  }

  @Override
  public AstNode visitArrayCreationExpression(JavaParser.ArrayCreationExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    if (ctx.primitiveType() != null) {

      // get primitive type
      PrimitiveType primitiveType = (PrimitiveType) visit(ctx.primitiveType());

      // get dims
      Dims dims = (Dims) visit(ctx.dims());

      if (ctx.dimExprs() != null) {
        // get list of dim expression
        List<DimExpr> dimExprs = new ArrayList<>();
        for (JavaParser.DimExprContext dimExprContext : ctx.dimExprs().dimExpr()) {
          DimExpr dimExpr = (DimExpr) visit(dimExprContext);
          dimExprs.add(dimExpr);
        }
        // RETURN
        return new BasicPrimitiveArrayCreationExpression(range, null, primitiveType, dimExprs, dims);

      } else if (ctx.arrayInitializer() != null) {
        // get arrayInitializer
        ArrayInitializer arrayInitializer = (ArrayInitializer) visit(ctx.arrayInitializer());
        // RETURN
        return new InitializePrimitiveArrayCreationExpression(range, null, primitiveType, dims, arrayInitializer);

      } else {
        System.err.println("ERROR : visitArrayCreationExpression");
        return super.visitArrayCreationExpression(ctx);
      }

    } else if (ctx.classOrInterfaceType() != null) {

      // get classOrInterface type
      ClassOrInterfaceType classOrInterfaceType
          = (ClassOrInterfaceType) visit(ctx.classOrInterfaceType());

      // get dims
      Dims dims = (Dims) visit(ctx.dims());

      if (ctx.dimExprs() != null) {
        // get list of dim expression
        List<DimExpr> dimExprs = new ArrayList<>();
        for (JavaParser.DimExprContext dimExprContext : ctx.dimExprs().dimExpr()) {
          DimExpr dimExpr = (DimExpr) visit(dimExprContext);
          dimExprs.add(dimExpr);
        }
        // RETURN
        return new BasicClassOrInterfaceArrayCreationExpression(range, null, classOrInterfaceType, dimExprs, dims);

      } else if (ctx.arrayInitializer() != null) {
        // get arrayInitializer
        ArrayInitializer arrayInitializer = (ArrayInitializer) visit(ctx.arrayInitializer());
        // RETURN
        return new InitializeClassOrInterfaceArrayCreationExpression(range, null, classOrInterfaceType, dims, arrayInitializer);
      } else {
        System.err.println("ERROR : visitArrayCreationExpression");
        return super.visitArrayCreationExpression(ctx);
      }
    } else {
      System.err.println("ERROR : visitArrayCreationExpression");
      return super.visitArrayCreationExpression(ctx);
    }
  }

  @Override
  public AstNode visitDimExprs(JavaParser.DimExprsContext ctx) {
    // Not necessary
    return super.visitDimExprs(ctx);
  }

  @Override
  public AstNode visitDimExpr(JavaParser.DimExprContext ctx) {

    // get Range
    Range range = getRange(ctx);

    // get list of annotation
    List<Annotation> annotationList = new ArrayList<>();
    for (JavaParser.AnnotationContext annotationContext : ctx.annotation()) {
      Annotation annotation = (Annotation) visit(annotationContext);
    }

    // get expression
    Expression expression = (Expression) visit(ctx.expression());

    return new DimExpr(range, null, annotationList, expression);
  }

  @Override
  public AstNode visitConstantExpression(JavaParser.ConstantExpressionContext ctx) {
    // Not necessary
    return super.visitConstantExpression(ctx);
  }

  @Override
  public AstNode visitExpression(JavaParser.ExpressionContext ctx) {
    if (ctx.lambdaExpression() != null) {
      return visit(ctx.lambdaExpression());
    } else if (ctx.assignmentExpression() != null) {
      return visit(ctx.assignmentExpression());
    } else {
      System.err.println("ERROR : visitExpression");
      return super.visitExpression(ctx);
    }
  }

  @Override
  public AstNode visitLambdaExpression(JavaParser.LambdaExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Lambda parameters
    LambdaParameters lambdaParameters = (LambdaParameters) visit(ctx.lambdaParameters());

    // get Lambda body
    LambdaBody lambdaBody = (LambdaBody) visit(ctx.lambdaBody());

    return new LambdaExpression(range, null, lambdaParameters, lambdaBody);
  }

  @Override
  public AstNode visitLambdaParameters(JavaParser.LambdaParametersContext ctx) {

    // get range
    Range range = getRange(ctx);

    if (ctx.Identifier() != null) {
      String identifier = ctx.Identifier().getText();
      return new SingleLambdaParameter(range, null, identifier);
    } else if (ctx.formalParameterList() != null) {
      return visit(ctx.formalParameterList());
    } else if (ctx.inferredFormalParameterList() != null) {
      return visit(ctx.inferredFormalParameterList());
    } else {
      System.err.println("ERROR : visitLambdaParameters");
      return super.visitLambdaParameters(ctx);
    }
  }

  @Override
  public AstNode visitInferredFormalParameterList(JavaParser.InferredFormalParameterListContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get identifiers
    List<String> identifierList = new ArrayList<>();
    for (TerminalNode terminalNode : ctx.Identifier()) {
      String identifier = terminalNode.getText();
      identifierList.add(identifier);
    }
    return new InferredFormalLambdaParameter(range, null, identifierList);
  }

  @Override
  public AstNode visitLambdaBody(JavaParser.LambdaBodyContext ctx) {
    if (ctx.expression() != null) {
      return visit(ctx.expression());
    } else if (ctx.block() != null) {
      return visit(ctx.block());
    } else {
      System.err.println("ERROR : visitLambdaBody");
      return super.visitLambdaBody(ctx);
    }
  }

  @Override
  public AstNode visitAssignmentExpression(JavaParser.AssignmentExpressionContext ctx) {

    if (ctx.conditionalExpression() != null) {
      return visit(ctx.conditionalExpression());
    } else if (ctx.assignment() != null) {
      return visit(ctx.assignment());
    } else {
      System.err.println("ERROR : visitAssignmentExpression");
      return super.visitAssignmentExpression(ctx);
    }
  }

  @Override
  public AstNode visitAssignment(JavaParser.AssignmentContext ctx) {

    // get range
    Range range = getRange(ctx);

    // get Left hand side
    LeftHandSide leftHandSide = (LeftHandSide) visit(ctx.leftHandSide());

    // get operator
    String assignmentOperator = ctx.assignmentOperator().getText();

    // get Expression expression
    Expression expression = (Expression) visit(ctx.expression());

    return new Assignment(range, null, leftHandSide, assignmentOperator, expression);
  }

  @Override
  public AstNode visitLeftHandSide(JavaParser.LeftHandSideContext ctx) {

    if (ctx.expressionName() != null) {
      return visit(ctx.expressionName());
    } else if (ctx.fieldAccess() != null) {
      return visit(ctx.fieldAccess());
    } else if (ctx.arrayAccess() != null) {
      return visit(ctx.arrayAccess());
    } else {
      System.err.println("ERROR : visitLeftHandSide");
      return super.visitLeftHandSide(ctx);
    }
  }

  @Override
  public AstNode visitAssignmentOperator(JavaParser.AssignmentOperatorContext ctx) {
    // Not necessary
    return super.visitAssignmentOperator(ctx);
  }

  @Override
  public AstNode visitConditionalExpression(JavaParser.ConditionalExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    //
    if (ctx.conditionalExpression() != null) {
      // TODO
    } else if (ctx.conditionalOrExpression() != null) {
      return visit(ctx.conditionalOrExpression());
    } else {
      System.err.println("ERROR : visitConditionalExpression");
      return super.visitConditionalExpression(ctx);
    }
  }

  @Override
  public AstNode visitConditionalOrExpression(JavaParser.ConditionalOrExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    //
    if (ctx.conditionalOrExpression() != null) {
      // TODO
    } else if (ctx.conditionalAndExpression() != null) {
      return visit(ctx.conditionalAndExpression());
    } else {
      System.err.println("ERROR : visitConditionalOrExpression");
      return super.visitConditionalOrExpression(ctx);
    }
  }

  @Override
  public AstNode visitConditionalAndExpression(JavaParser.ConditionalAndExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    //
    if (ctx.conditionalAndExpression() != null) {
      // TODO
    } else if (ctx.inclusiveOrExpression() != null) {
      return visit(ctx.inclusiveOrExpression());
    } else {
      System.err.println("ERROR : visitConditionalAndExpression");
      return super.visitConditionalAndExpression(ctx);
    }
  }

  @Override
  public AstNode visitInclusiveOrExpression(JavaParser.InclusiveOrExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    if (ctx.inclusiveOrExpression() != null) {
      // TODO
    } else if (ctx.exclusiveOrExpression() != null) {
      return visit(ctx.exclusiveOrExpression());
    } else {
      System.err.println("ERROR : visitInclusiveOrExpression");
      return super.visitInclusiveOrExpression(ctx);
    }
  }

  @Override
  public AstNode visitExclusiveOrExpression(JavaParser.ExclusiveOrExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    if (ctx.exclusiveOrExpression() != null) {
      // TODO
    } else if (ctx.andExpression() != null) {
      return visit(ctx.andExpression());
    } else {
      System.err.println("ERROR : visitExclusiveOrExpression");
      return super.visitExclusiveOrExpression(ctx);
    }
  }

  @Override
  public AstNode visitAndExpression(JavaParser.AndExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    if (ctx.andExpression() != null) {
      // TODO
    } else if (ctx.equalityExpression() != null) {
      return visit(ctx.equalityExpression());
    } else {
      System.err.println("ERROR : visitAndExpression");
      return super.visitAndExpression(ctx);
    }
  }

  @Override
  public AstNode visitEqualityExpression(JavaParser.EqualityExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    if (ctx.equalityExpression() != null) {

      switch(ctx.getChild(1).getText()) {
        case "==" :
          // TODO - equals
          break;
        case "!=" :
          // TODO - unequals
          break;
        default :
          System.err.println("ERROR : visitEqualityExpression");
          return super.visitEqualityExpression(ctx);
          break;
      }
    } else if (ctx.relationalExpression() != null) {
      return visit(ctx.relationalExpression());
    } else {
      System.err.println("ERROR : visitEqualityExpression");
      return super.visitEqualityExpression(ctx);
    }
  }

  @Override
  public AstNode visitRelationalExpression(JavaParser.RelationalExpressionContext ctx) {

    // get range
    Range range = getRange(ctx);

    //
    if (ctx.referenceType() != null) {
      // TODO - instanceof
    } else if (ctx.relationalExpression() != null) {

      switch(ctx.getChild(1).getText()) {
        case "<" :
          // TODO - less than
          break;
        case ">" :
          // TODO - greater than
          break;
        case "<=" :
          // TODO - less than or equal to
          break;
        case ">=" :
          // TODO - greater than or equal to
          break;
        default :
          System.err.println("ERROR : visitRelationalExpression");
          return super.visitRelationalExpression(ctx);
          break;
      }
    } else if (ctx.shiftExpression() != null) {
      return visit(ctx.shiftExpression());
    } else {
      System.err.println("ERROR : visitRelationalExpression");
      return super.visitRelationalExpression(ctx);
    }
  }

  @Override
  public AstNode visitShiftExpression(JavaParser.ShiftExpressionContext ctx) {

    if (ctx.shiftExpression() != null) {

      if (ctx.getChild(1).getText().equals("<")) {
        // TODO - <<
      } else if (ctx.getChild(3).getText().equals(">")) {
        // TODO - >>
      } else if (ctx.getChild(2).getText().equals(">")) {
        // TODO - >>>
      } else {
        System.err.println("ERROR : visitShiftExpression");
        return super.visitShiftExpression(ctx);
      }

    } else if (ctx.additiveExpression() != null) {
      return visit(ctx.additiveExpression());
    } else {
      System.err.println("ERROR : visitShiftExpression");
      return super.visitShiftExpression(ctx);
    }
  }

  @Override
  public AstNode visitAdditiveExpression(JavaParser.AdditiveExpressionContext ctx) {

    if (ctx.additiveExpression() != null) {
      switch(ctx.getChild(1).getText()) {
        case "+" :
          // TODO - Plus
          break;
        case "-" :
          // TODO - Minus
          break;
        default :
          System.err.println("ERROR : visitAdditiveExpression");
          return super.visitAdditiveExpression(ctx);
          break;
      }
    } else if (ctx.multiplicativeExpression() != null) {
      return visit(ctx.multiplicativeExpression());
    } else {
      System.err.println("ERROR : visitAdditiveExpression");
      return super.visitAdditiveExpression(ctx);
    }
  }

  @Override
  public AstNode visitMultiplicativeExpression(JavaParser.MultiplicativeExpressionContext ctx) {
    if (ctx.multiplicativeExpression() != null) {
      switch(ctx.getChild(1).getText()) {
        case "*" :
          // TODO - multi
          break;
        case "/" :
          // TODO - div
          break;
        case "%" :
          // TODO - modulus
          break;
        default :
          System.err.println("ERROR : visitMultiplicativieExpression");
          return super.visitMultiplicativeExpression(ctx);
          break;
      }
    } else if (ctx.unaryExpression() != null) {
      visit(ctx.unaryExpression());
    } else {
      System.err.println("ERROR : visitMultiplicativieExpression");
      return super.visitMultiplicativeExpression(ctx);
    }
  }

  @Override
  public AstNode visitUnaryExpression(JavaParser.UnaryExpressionContext ctx) {
    // get range
    Range range = getRange(ctx);

    //
    if (ctx.unaryExpression() != null) {
      switch(ctx.getChild(0).getText()) {
        case "+" :
          // TODO - + unary
          break;
        case "-" :
          // TODO - - unary
          break;
        default :
          System.err.println("ERROR : visitUnaryExpression");
          return super.visitUnaryExpression(ctx);
      }
    } else if (ctx.preIncrementExpression() != null) {
      return visit(ctx.preIncrementExpression());
    } else if (ctx.preDecrementExpression() != null) {
      return visit(ctx.preDecrementExpression());
    } else if (ctx.unaryExpressionNotPlusMinus() != null) {
      return visit(ctx.unaryExpressionNotPlusMinus());
    }
    return super.visitUnaryExpression(ctx);
  }

  @Override
  public AstNode visitPreIncrementExpression(JavaParser.PreIncrementExpressionContext ctx) {
    return super.visitPreIncrementExpression(ctx);
  }

  @Override
  public AstNode visitPreDecrementExpression(JavaParser.PreDecrementExpressionContext ctx) {
    return super.visitPreDecrementExpression(ctx);
  }

  @Override
  public AstNode visitUnaryExpressionNotPlusMinus(JavaParser.UnaryExpressionNotPlusMinusContext ctx) {
    return super.visitUnaryExpressionNotPlusMinus(ctx);
  }

  @Override
  public AstNode visitPostfixExpression(JavaParser.PostfixExpressionContext ctx) {
    return super.visitPostfixExpression(ctx);
  }

  @Override
  public AstNode visitPostIncrementExpression(JavaParser.PostIncrementExpressionContext ctx) {
    return super.visitPostIncrementExpression(ctx);
  }

  @Override
  public AstNode visitPostIncrementExpression_lf_postfixExpression(JavaParser.PostIncrementExpression_lf_postfixExpressionContext ctx) {
    return super.visitPostIncrementExpression_lf_postfixExpression(ctx);
  }

  @Override
  public AstNode visitPostDecrementExpression(JavaParser.PostDecrementExpressionContext ctx) {
    return super.visitPostDecrementExpression(ctx);
  }

  @Override
  public AstNode visitPostDecrementExpression_lf_postfixExpression(JavaParser.PostDecrementExpression_lf_postfixExpressionContext ctx) {
    return super.visitPostDecrementExpression_lf_postfixExpression(ctx);
  }

  @Override
  public AstNode visitCastExpression(JavaParser.CastExpressionContext ctx) {
    return super.visitCastExpression(ctx);
  }
}
