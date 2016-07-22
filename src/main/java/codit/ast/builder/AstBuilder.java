package codit.ast.builder;

import org.antlr.v4.runtime.ParserRuleContext;

import codit.ast.AstNode;
import codit.ast.Range;
import codit.ast.pojos.literals.integers.BinaryIntegerLiteral;
import codit.ast.pojos.literals.longs.BinaryLongLiteral;
import codit.ast.pojos.literals.integers.DecimalIntegerLiteral;
import codit.ast.pojos.literals.longs.DecimalLongLiteral;
import codit.ast.pojos.literals.integers.HexIntegerLiteral;
import codit.ast.pojos.literals.longs.HexLongLiteral;
import codit.ast.pojos.literals.integers.OctalIntegerLiteral;
import codit.ast.pojos.literals.longs.OctalLongLiteral;
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
  public AstNode visitLiteral(JavaParser.LiteralContext ctx) {
    // TODO - Refactoring

    //getRange
    Range range = getRange(ctx);

    String rawText = ctx.getText();

    if (ctx.IntegerLiteral() != null) {

      // HEXADECIMAL / BINARY / OCTAL / DECIMAL
      if ( rawText.startsWith("0x") || rawText.startsWith("0X") ) {
        // Hex INTEGER / LONG Literals
        if (rawText.endsWith("L")) {
          return new HexLongLiteral(range, rawText);
        } else {
          return new HexIntegerLiteral(range, rawText);
        }

      } else if ( rawText.startsWith("0b") || rawText.startsWith("0B") ) {
        // Binary INTEGER / LONG Literals
        if (rawText.endsWith("L")) {
          return new BinaryLongLiteral(range, rawText);
        } else {
          return new BinaryIntegerLiteral(range, rawText);
        }

      } else if ( rawText.startsWith("0") && !rawText.equals("0") ) {
        // Oct INTEGER / LONG Literals
        if (rawText.endsWith("L")) {
          return new OctalLongLiteral(range, rawText);
        } else {
          return new OctalIntegerLiteral(range, rawText);
        }
      } else {
        // Dec INTEGER / LONG Literals
        if (rawText.endsWith("L")) {
          return new DecimalLongLiteral(range, rawText);
        } else {
          return new DecimalIntegerLiteral(range, rawText);
        }
      }


    } else if (ctx.BooleanLiteral() != null) {
      System.out.println("Boolean");

    } else if (ctx.StringLiteral() != null) {
      System.out.println("String");

    } else if (ctx.CharacterLiteral() != null) {
      System.out.println("Char");

    } else if (ctx.FloatingPointLiteral() != null) {
      System.out.println("FloatPoint");

    } else if (ctx.NullLiteral() != null) {
      System.out.println("Null");

    } else {
      System.err.println("ERROR!");
    }
    return super.visitLiteral(ctx);
  }

  @Override
  public AstNode visitType(JavaParser.TypeContext ctx) {
    return super.visitType(ctx);
  }

  @Override
  public AstNode visitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {
    return super.visitPrimitiveType(ctx);
  }

  @Override
  public AstNode visitNumericType(JavaParser.NumericTypeContext ctx) {
    return super.visitNumericType(ctx);
  }

  @Override
  public AstNode visitIntegralType(JavaParser.IntegralTypeContext ctx) {
    return super.visitIntegralType(ctx);
  }

  @Override
  public AstNode visitFloatingPointType(JavaParser.FloatingPointTypeContext ctx) {
    return super.visitFloatingPointType(ctx);
  }

  @Override
  public AstNode visitReferenceType(JavaParser.ReferenceTypeContext ctx) {
    return super.visitReferenceType(ctx);
  }

  @Override
  public AstNode visitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
    return super.visitClassOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitClassType(JavaParser.ClassTypeContext ctx) {
    return super.visitClassType(ctx);
  }

  @Override
  public AstNode visitClassType_lf_classOrInterfaceType(JavaParser.ClassType_lf_classOrInterfaceTypeContext ctx) {
    return super.visitClassType_lf_classOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitClassType_lfno_classOrInterfaceType(JavaParser.ClassType_lfno_classOrInterfaceTypeContext ctx) {
    return super.visitClassType_lfno_classOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitInterfaceType(JavaParser.InterfaceTypeContext ctx) {
    return super.visitInterfaceType(ctx);
  }

  @Override
  public AstNode visitInterfaceType_lf_classOrInterfaceType(JavaParser.InterfaceType_lf_classOrInterfaceTypeContext ctx) {
    return super.visitInterfaceType_lf_classOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitInterfaceType_lfno_classOrInterfaceType(JavaParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
    return super.visitInterfaceType_lfno_classOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitTypeVariable(JavaParser.TypeVariableContext ctx) {
    return super.visitTypeVariable(ctx);
  }

  @Override
  public AstNode visitArrayType(JavaParser.ArrayTypeContext ctx) {
    return super.visitArrayType(ctx);
  }

  @Override
  public AstNode visitDims(JavaParser.DimsContext ctx) {
    return super.visitDims(ctx);
  }

  @Override
  public AstNode visitTypeParameter(JavaParser.TypeParameterContext ctx) {
    return super.visitTypeParameter(ctx);
  }

  @Override
  public AstNode visitTypeParameterModifier(JavaParser.TypeParameterModifierContext ctx) {
    return super.visitTypeParameterModifier(ctx);
  }

  @Override
  public AstNode visitTypeBound(JavaParser.TypeBoundContext ctx) {
    return super.visitTypeBound(ctx);
  }

  @Override
  public AstNode visitAdditionalBound(JavaParser.AdditionalBoundContext ctx) {
    return super.visitAdditionalBound(ctx);
  }

  @Override
  public AstNode visitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
    return super.visitTypeArguments(ctx);
  }

  @Override
  public AstNode visitTypeArgumentList(JavaParser.TypeArgumentListContext ctx) {
    return super.visitTypeArgumentList(ctx);
  }

  @Override
  public AstNode visitTypeArgument(JavaParser.TypeArgumentContext ctx) {
    return super.visitTypeArgument(ctx);
  }

  @Override
  public AstNode visitWildcard(JavaParser.WildcardContext ctx) {
    return super.visitWildcard(ctx);
  }

  @Override
  public AstNode visitWildcardBounds(JavaParser.WildcardBoundsContext ctx) {
    return super.visitWildcardBounds(ctx);
  }

  @Override
  public AstNode visitPackageName(JavaParser.PackageNameContext ctx) {
    return super.visitPackageName(ctx);
  }

  @Override
  public AstNode visitTypeName(JavaParser.TypeNameContext ctx) {
    return super.visitTypeName(ctx);
  }

  @Override
  public AstNode visitPackageOrTypeName(JavaParser.PackageOrTypeNameContext ctx) {
    return super.visitPackageOrTypeName(ctx);
  }

  @Override
  public AstNode visitExpressionName(JavaParser.ExpressionNameContext ctx) {
    return super.visitExpressionName(ctx);
  }

  @Override
  public AstNode visitMethodName(JavaParser.MethodNameContext ctx) {
    return super.visitMethodName(ctx);
  }

  @Override
  public AstNode visitAmbiguousName(JavaParser.AmbiguousNameContext ctx) {
    return super.visitAmbiguousName(ctx);
  }

  @Override
  public AstNode visitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
    return super.visitCompilationUnit(ctx);
  }

  @Override
  public AstNode visitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
    return super.visitPackageDeclaration(ctx);
  }

  @Override
  public AstNode visitPackageModifier(JavaParser.PackageModifierContext ctx) {
    return super.visitPackageModifier(ctx);
  }

  @Override
  public AstNode visitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
    return super.visitImportDeclaration(ctx);
  }

  @Override
  public AstNode visitSingleTypeImportDeclaration(JavaParser.SingleTypeImportDeclarationContext ctx) {
    return super.visitSingleTypeImportDeclaration(ctx);
  }

  @Override
  public AstNode visitTypeImportOnDemandDeclaration(JavaParser.TypeImportOnDemandDeclarationContext ctx) {
    return super.visitTypeImportOnDemandDeclaration(ctx);
  }

  @Override
  public AstNode visitSingleStaticImportDeclaration(JavaParser.SingleStaticImportDeclarationContext ctx) {
    return super.visitSingleStaticImportDeclaration(ctx);
  }

  @Override
  public AstNode visitStaticImportOnDemandDeclaration(JavaParser.StaticImportOnDemandDeclarationContext ctx) {
    return super.visitStaticImportOnDemandDeclaration(ctx);
  }

  @Override
  public AstNode visitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
    return super.visitTypeDeclaration(ctx);
  }

  @Override
  public AstNode visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
    return super.visitClassDeclaration(ctx);
  }

  @Override
  public AstNode visitNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
    return super.visitNormalClassDeclaration(ctx);
  }

  @Override
  public AstNode visitClassModifier(JavaParser.ClassModifierContext ctx) {
    return super.visitClassModifier(ctx);
  }

  @Override
  public AstNode visitTypeParameters(JavaParser.TypeParametersContext ctx) {
    return super.visitTypeParameters(ctx);
  }

  @Override
  public AstNode visitTypeParameterList(JavaParser.TypeParameterListContext ctx) {
    return super.visitTypeParameterList(ctx);
  }

  @Override
  public AstNode visitSuperclass(JavaParser.SuperclassContext ctx) {
    return super.visitSuperclass(ctx);
  }

  @Override
  public AstNode visitSuperinterfaces(JavaParser.SuperinterfacesContext ctx) {
    return super.visitSuperinterfaces(ctx);
  }

  @Override
  public AstNode visitInterfaceTypeList(JavaParser.InterfaceTypeListContext ctx) {
    return super.visitInterfaceTypeList(ctx);
  }

  @Override
  public AstNode visitClassBody(JavaParser.ClassBodyContext ctx) {
    return super.visitClassBody(ctx);
  }

  @Override
  public AstNode visitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
    return super.visitClassBodyDeclaration(ctx);
  }

  @Override
  public AstNode visitClassMemberDeclaration(JavaParser.ClassMemberDeclarationContext ctx) {
    return super.visitClassMemberDeclaration(ctx);
  }

  @Override
  public AstNode visitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
    return super.visitFieldDeclaration(ctx);
  }

  @Override
  public AstNode visitFieldModifier(JavaParser.FieldModifierContext ctx) {
    return super.visitFieldModifier(ctx);
  }

  @Override
  public AstNode visitVariableDeclaratorList(JavaParser.VariableDeclaratorListContext ctx) {
    return super.visitVariableDeclaratorList(ctx);
  }

  @Override
  public AstNode visitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
    return super.visitVariableDeclarator(ctx);
  }

  @Override
  public AstNode visitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
    return super.visitVariableDeclaratorId(ctx);
  }

  @Override
  public AstNode visitVariableInitializer(JavaParser.VariableInitializerContext ctx) {
    return super.visitVariableInitializer(ctx);
  }

  @Override
  public AstNode visitUnannType(JavaParser.UnannTypeContext ctx) {
    return super.visitUnannType(ctx);
  }

  @Override
  public AstNode visitUnannPrimitiveType(JavaParser.UnannPrimitiveTypeContext ctx) {
    return super.visitUnannPrimitiveType(ctx);
  }

  @Override
  public AstNode visitUnannReferenceType(JavaParser.UnannReferenceTypeContext ctx) {
    return super.visitUnannReferenceType(ctx);
  }

  @Override
  public AstNode visitUnannClassOrInterfaceType(JavaParser.UnannClassOrInterfaceTypeContext ctx) {
    return super.visitUnannClassOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitUnannClassType(JavaParser.UnannClassTypeContext ctx) {
    return super.visitUnannClassType(ctx);
  }

  @Override
  public AstNode visitUnannClassType_lf_unannClassOrInterfaceType(JavaParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
    return super.visitUnannClassType_lf_unannClassOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitUnannClassType_lfno_unannClassOrInterfaceType(JavaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
    return super.visitUnannClassType_lfno_unannClassOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitUnannInterfaceType(JavaParser.UnannInterfaceTypeContext ctx) {
    return super.visitUnannInterfaceType(ctx);
  }

  @Override
  public AstNode visitUnannInterfaceType_lf_unannClassOrInterfaceType(JavaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
    return super.visitUnannInterfaceType_lf_unannClassOrInterfaceType(ctx);
  }

  @Override
  public AstNode visitUnannInterfaceType_lfno_unannClassOrInterfaceType(JavaParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
    return super.visitUnannInterfaceType_lfno_unannClassOrInterfaceType(ctx);
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
    return super.visitMethodDeclaration(ctx);
  }

  @Override
  public AstNode visitMethodModifier(JavaParser.MethodModifierContext ctx) {
    return super.visitMethodModifier(ctx);
  }

  @Override
  public AstNode visitMethodHeader(JavaParser.MethodHeaderContext ctx) {
    return super.visitMethodHeader(ctx);
  }

  @Override
  public AstNode visitResult(JavaParser.ResultContext ctx) {
    return super.visitResult(ctx);
  }

  @Override
  public AstNode visitMethodDeclarator(JavaParser.MethodDeclaratorContext ctx) {
    return super.visitMethodDeclarator(ctx);
  }

  @Override
  public AstNode visitFormalParameterList(JavaParser.FormalParameterListContext ctx) {
    return super.visitFormalParameterList(ctx);
  }

  @Override
  public AstNode visitFormalParameters(JavaParser.FormalParametersContext ctx) {
    return super.visitFormalParameters(ctx);
  }

  @Override
  public AstNode visitFormalParameter(JavaParser.FormalParameterContext ctx) {
    return super.visitFormalParameter(ctx);
  }

  @Override
  public AstNode visitVariableModifier(JavaParser.VariableModifierContext ctx) {
    return super.visitVariableModifier(ctx);
  }

  @Override
  public AstNode visitLastFormalParameter(JavaParser.LastFormalParameterContext ctx) {
    return super.visitLastFormalParameter(ctx);
  }

  @Override
  public AstNode visitReceiverParameter(JavaParser.ReceiverParameterContext ctx) {
    return super.visitReceiverParameter(ctx);
  }

  @Override
  public AstNode visitThrows_(JavaParser.Throws_Context ctx) {
    return super.visitThrows_(ctx);
  }

  @Override
  public AstNode visitExceptionTypeList(JavaParser.ExceptionTypeListContext ctx) {
    return super.visitExceptionTypeList(ctx);
  }

  @Override
  public AstNode visitExceptionType(JavaParser.ExceptionTypeContext ctx) {
    return super.visitExceptionType(ctx);
  }

  @Override
  public AstNode visitMethodBody(JavaParser.MethodBodyContext ctx) {
    return super.visitMethodBody(ctx);
  }

  @Override
  public AstNode visitInstanceInitializer(JavaParser.InstanceInitializerContext ctx) {
    return super.visitInstanceInitializer(ctx);
  }

  @Override
  public AstNode visitStaticInitializer(JavaParser.StaticInitializerContext ctx) {
    return super.visitStaticInitializer(ctx);
  }

  @Override
  public AstNode visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
    return super.visitConstructorDeclaration(ctx);
  }

  @Override
  public AstNode visitConstructorModifier(JavaParser.ConstructorModifierContext ctx) {
    return super.visitConstructorModifier(ctx);
  }

  @Override
  public AstNode visitConstructorDeclarator(JavaParser.ConstructorDeclaratorContext ctx) {
    return super.visitConstructorDeclarator(ctx);
  }

  @Override
  public AstNode visitSimpleTypeName(JavaParser.SimpleTypeNameContext ctx) {
    return super.visitSimpleTypeName(ctx);
  }

  @Override
  public AstNode visitConstructorBody(JavaParser.ConstructorBodyContext ctx) {
    return super.visitConstructorBody(ctx);
  }

  @Override
  public AstNode visitExplicitConstructorInvocation(JavaParser.ExplicitConstructorInvocationContext ctx) {
    return super.visitExplicitConstructorInvocation(ctx);
  }

  @Override
  public AstNode visitEnumDeclaration(JavaParser.EnumDeclarationContext ctx) {
    return super.visitEnumDeclaration(ctx);
  }

  @Override
  public AstNode visitEnumBody(JavaParser.EnumBodyContext ctx) {
    return super.visitEnumBody(ctx);
  }

  @Override
  public AstNode visitEnumConstantList(JavaParser.EnumConstantListContext ctx) {
    return super.visitEnumConstantList(ctx);
  }

  @Override
  public AstNode visitEnumConstant(JavaParser.EnumConstantContext ctx) {
    return super.visitEnumConstant(ctx);
  }

  @Override
  public AstNode visitEnumConstantModifier(JavaParser.EnumConstantModifierContext ctx) {
    return super.visitEnumConstantModifier(ctx);
  }

  @Override
  public AstNode visitEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) {
    return super.visitEnumBodyDeclarations(ctx);
  }

  @Override
  public AstNode visitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
    return super.visitInterfaceDeclaration(ctx);
  }

  @Override
  public AstNode visitNormalInterfaceDeclaration(JavaParser.NormalInterfaceDeclarationContext ctx) {
    return super.visitNormalInterfaceDeclaration(ctx);
  }

  @Override
  public AstNode visitInterfaceModifier(JavaParser.InterfaceModifierContext ctx) {
    return super.visitInterfaceModifier(ctx);
  }

  @Override
  public AstNode visitExtendsInterfaces(JavaParser.ExtendsInterfacesContext ctx) {
    return super.visitExtendsInterfaces(ctx);
  }

  @Override
  public AstNode visitInterfaceBody(JavaParser.InterfaceBodyContext ctx) {
    return super.visitInterfaceBody(ctx);
  }

  @Override
  public AstNode visitInterfaceMemberDeclaration(JavaParser.InterfaceMemberDeclarationContext ctx) {
    return super.visitInterfaceMemberDeclaration(ctx);
  }

  @Override
  public AstNode visitConstantDeclaration(JavaParser.ConstantDeclarationContext ctx) {
    return super.visitConstantDeclaration(ctx);
  }

  @Override
  public AstNode visitConstantModifier(JavaParser.ConstantModifierContext ctx) {
    return super.visitConstantModifier(ctx);
  }

  @Override
  public AstNode visitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {
    return super.visitInterfaceMethodDeclaration(ctx);
  }

  @Override
  public AstNode visitInterfaceMethodModifier(JavaParser.InterfaceMethodModifierContext ctx) {
    return super.visitInterfaceMethodModifier(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) {
    return super.visitAnnotationTypeDeclaration(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) {
    return super.visitAnnotationTypeBody(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeMemberDeclaration(JavaParser.AnnotationTypeMemberDeclarationContext ctx) {
    return super.visitAnnotationTypeMemberDeclaration(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {
    return super.visitAnnotationTypeElementDeclaration(ctx);
  }

  @Override
  public AstNode visitAnnotationTypeElementModifier(JavaParser.AnnotationTypeElementModifierContext ctx) {
    return super.visitAnnotationTypeElementModifier(ctx);
  }

  @Override
  public AstNode visitDefaultValue(JavaParser.DefaultValueContext ctx) {
    return super.visitDefaultValue(ctx);
  }

  @Override
  public AstNode visitAnnotation(JavaParser.AnnotationContext ctx) {
    return super.visitAnnotation(ctx);
  }

  @Override
  public AstNode visitNormalAnnotation(JavaParser.NormalAnnotationContext ctx) {
    return super.visitNormalAnnotation(ctx);
  }

  @Override
  public AstNode visitElementValuePairList(JavaParser.ElementValuePairListContext ctx) {
    return super.visitElementValuePairList(ctx);
  }

  @Override
  public AstNode visitElementValuePair(JavaParser.ElementValuePairContext ctx) {
    return super.visitElementValuePair(ctx);
  }

  @Override
  public AstNode visitElementValue(JavaParser.ElementValueContext ctx) {
    return super.visitElementValue(ctx);
  }

  @Override
  public AstNode visitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {
    return super.visitElementValueArrayInitializer(ctx);
  }

  @Override
  public AstNode visitElementValueList(JavaParser.ElementValueListContext ctx) {
    return super.visitElementValueList(ctx);
  }

  @Override
  public AstNode visitMarkerAnnotation(JavaParser.MarkerAnnotationContext ctx) {
    return super.visitMarkerAnnotation(ctx);
  }

  @Override
  public AstNode visitSingleElementAnnotation(JavaParser.SingleElementAnnotationContext ctx) {
    return super.visitSingleElementAnnotation(ctx);
  }

  @Override
  public AstNode visitArrayInitializer(JavaParser.ArrayInitializerContext ctx) {
    return super.visitArrayInitializer(ctx);
  }

  @Override
  public AstNode visitVariableInitializerList(JavaParser.VariableInitializerListContext ctx) {
    return super.visitVariableInitializerList(ctx);
  }

  @Override
  public AstNode visitBlock(JavaParser.BlockContext ctx) {
    return super.visitBlock(ctx);
  }

  @Override
  public AstNode visitBlockStatements(JavaParser.BlockStatementsContext ctx) {
    return super.visitBlockStatements(ctx);
  }

  @Override
  public AstNode visitBlockStatement(JavaParser.BlockStatementContext ctx) {
    return super.visitBlockStatement(ctx);
  }

  @Override
  public AstNode visitLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx) {
    return super.visitLocalVariableDeclarationStatement(ctx);
  }

  @Override
  public AstNode visitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
    return super.visitLocalVariableDeclaration(ctx);
  }

  @Override
  public AstNode visitStatement(JavaParser.StatementContext ctx) {
    return super.visitStatement(ctx);
  }

  @Override
  public AstNode visitStatementNoShortIf(JavaParser.StatementNoShortIfContext ctx) {
    return super.visitStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitStatementWithoutTrailingSubstatement(JavaParser.StatementWithoutTrailingSubstatementContext ctx) {
    return super.visitStatementWithoutTrailingSubstatement(ctx);
  }

  @Override
  public AstNode visitEmptyStatement(JavaParser.EmptyStatementContext ctx) {
    return super.visitEmptyStatement(ctx);
  }

  @Override
  public AstNode visitLabeledStatement(JavaParser.LabeledStatementContext ctx) {
    return super.visitLabeledStatement(ctx);
  }

  @Override
  public AstNode visitLabeledStatementNoShortIf(JavaParser.LabeledStatementNoShortIfContext ctx) {
    return super.visitLabeledStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitExpressionStatement(JavaParser.ExpressionStatementContext ctx) {
    return super.visitExpressionStatement(ctx);
  }

  @Override
  public AstNode visitStatementExpression(JavaParser.StatementExpressionContext ctx) {
    return super.visitStatementExpression(ctx);
  }

  @Override
  public AstNode visitIfThenStatement(JavaParser.IfThenStatementContext ctx) {
    return super.visitIfThenStatement(ctx);
  }

  @Override
  public AstNode visitIfThenElseStatement(JavaParser.IfThenElseStatementContext ctx) {
    return super.visitIfThenElseStatement(ctx);
  }

  @Override
  public AstNode visitIfThenElseStatementNoShortIf(JavaParser.IfThenElseStatementNoShortIfContext ctx) {
    return super.visitIfThenElseStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitAssertStatement(JavaParser.AssertStatementContext ctx) {
    return super.visitAssertStatement(ctx);
  }

  @Override
  public AstNode visitSwitchStatement(JavaParser.SwitchStatementContext ctx) {
    return super.visitSwitchStatement(ctx);
  }

  @Override
  public AstNode visitSwitchBlock(JavaParser.SwitchBlockContext ctx) {
    return super.visitSwitchBlock(ctx);
  }

  @Override
  public AstNode visitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
    return super.visitSwitchBlockStatementGroup(ctx);
  }

  @Override
  public AstNode visitSwitchLabels(JavaParser.SwitchLabelsContext ctx) {
    return super.visitSwitchLabels(ctx);
  }

  @Override
  public AstNode visitSwitchLabel(JavaParser.SwitchLabelContext ctx) {
    return super.visitSwitchLabel(ctx);
  }

  @Override
  public AstNode visitEnumConstantName(JavaParser.EnumConstantNameContext ctx) {
    return super.visitEnumConstantName(ctx);
  }

  @Override
  public AstNode visitWhileStatement(JavaParser.WhileStatementContext ctx) {
    return super.visitWhileStatement(ctx);
  }

  @Override
  public AstNode visitWhileStatementNoShortIf(JavaParser.WhileStatementNoShortIfContext ctx) {
    return super.visitWhileStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitDoStatement(JavaParser.DoStatementContext ctx) {
    return super.visitDoStatement(ctx);
  }

  @Override
  public AstNode visitForStatement(JavaParser.ForStatementContext ctx) {
    return super.visitForStatement(ctx);
  }

  @Override
  public AstNode visitForStatementNoShortIf(JavaParser.ForStatementNoShortIfContext ctx) {
    return super.visitForStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitBasicForStatement(JavaParser.BasicForStatementContext ctx) {
    return super.visitBasicForStatement(ctx);
  }

  @Override
  public AstNode visitBasicForStatementNoShortIf(JavaParser.BasicForStatementNoShortIfContext ctx) {
    return super.visitBasicForStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitForInit(JavaParser.ForInitContext ctx) {
    return super.visitForInit(ctx);
  }

  @Override
  public AstNode visitForUpdate(JavaParser.ForUpdateContext ctx) {
    return super.visitForUpdate(ctx);
  }

  @Override
  public AstNode visitStatementExpressionList(JavaParser.StatementExpressionListContext ctx) {
    return super.visitStatementExpressionList(ctx);
  }

  @Override
  public AstNode visitEnhancedForStatement(JavaParser.EnhancedForStatementContext ctx) {
    return super.visitEnhancedForStatement(ctx);
  }

  @Override
  public AstNode visitEnhancedForStatementNoShortIf(JavaParser.EnhancedForStatementNoShortIfContext ctx) {
    return super.visitEnhancedForStatementNoShortIf(ctx);
  }

  @Override
  public AstNode visitBreakStatement(JavaParser.BreakStatementContext ctx) {
    return super.visitBreakStatement(ctx);
  }

  @Override
  public AstNode visitContinueStatement(JavaParser.ContinueStatementContext ctx) {
    return super.visitContinueStatement(ctx);
  }

  @Override
  public AstNode visitReturnStatement(JavaParser.ReturnStatementContext ctx) {
    return super.visitReturnStatement(ctx);
  }

  @Override
  public AstNode visitThrowStatement(JavaParser.ThrowStatementContext ctx) {
    return super.visitThrowStatement(ctx);
  }

  @Override
  public AstNode visitSynchronizedStatement(JavaParser.SynchronizedStatementContext ctx) {
    return super.visitSynchronizedStatement(ctx);
  }

  @Override
  public AstNode visitTryStatement(JavaParser.TryStatementContext ctx) {
    return super.visitTryStatement(ctx);
  }

  @Override
  public AstNode visitCatches(JavaParser.CatchesContext ctx) {
    return super.visitCatches(ctx);
  }

  @Override
  public AstNode visitCatchClause(JavaParser.CatchClauseContext ctx) {
    return super.visitCatchClause(ctx);
  }

  @Override
  public AstNode visitCatchFormalParameter(JavaParser.CatchFormalParameterContext ctx) {
    return super.visitCatchFormalParameter(ctx);
  }

  @Override
  public AstNode visitCatchType(JavaParser.CatchTypeContext ctx) {
    return super.visitCatchType(ctx);
  }

  @Override
  public AstNode visitFinally_(JavaParser.Finally_Context ctx) {
    return super.visitFinally_(ctx);
  }

  @Override
  public AstNode visitTryWithResourcesStatement(JavaParser.TryWithResourcesStatementContext ctx) {
    return super.visitTryWithResourcesStatement(ctx);
  }

  @Override
  public AstNode visitResourceSpecification(JavaParser.ResourceSpecificationContext ctx) {
    return super.visitResourceSpecification(ctx);
  }

  @Override
  public AstNode visitResourceList(JavaParser.ResourceListContext ctx) {
    return super.visitResourceList(ctx);
  }

  @Override
  public AstNode visitResource(JavaParser.ResourceContext ctx) {
    return super.visitResource(ctx);
  }

  @Override
  public AstNode visitPrimary(JavaParser.PrimaryContext ctx) {
    return super.visitPrimary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray(JavaParser.PrimaryNoNewArrayContext ctx) {
    return super.visitPrimaryNoNewArray(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_arrayAccess(JavaParser.PrimaryNoNewArray_lf_arrayAccessContext ctx) {
    return super.visitPrimaryNoNewArray_lf_arrayAccess(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_arrayAccess(JavaParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
    return super.visitPrimaryNoNewArray_lfno_arrayAccess(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_primary(JavaParser.PrimaryNoNewArray_lf_primaryContext ctx) {
    return super.visitPrimaryNoNewArray_lf_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(JavaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
    return super.visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(JavaParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
    return super.visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_primary(JavaParser.PrimaryNoNewArray_lfno_primaryContext ctx) {
    return super.visitPrimaryNoNewArray_lfno_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(JavaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
    return super.visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(ctx);
  }

  @Override
  public AstNode visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(JavaParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
    return super.visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(ctx);
  }

  @Override
  public AstNode visitClassInstanceCreationExpression(JavaParser.ClassInstanceCreationExpressionContext ctx) {
    return super.visitClassInstanceCreationExpression(ctx);
  }

  @Override
  public AstNode visitClassInstanceCreationExpression_lf_primary(JavaParser.ClassInstanceCreationExpression_lf_primaryContext ctx) {
    return super.visitClassInstanceCreationExpression_lf_primary(ctx);
  }

  @Override
  public AstNode visitClassInstanceCreationExpression_lfno_primary(JavaParser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {
    return super.visitClassInstanceCreationExpression_lfno_primary(ctx);
  }

  @Override
  public AstNode visitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {
    return super.visitTypeArgumentsOrDiamond(ctx);
  }

  @Override
  public AstNode visitFieldAccess(JavaParser.FieldAccessContext ctx) {
    return super.visitFieldAccess(ctx);
  }

  @Override
  public AstNode visitFieldAccess_lf_primary(JavaParser.FieldAccess_lf_primaryContext ctx) {
    return super.visitFieldAccess_lf_primary(ctx);
  }

  @Override
  public AstNode visitFieldAccess_lfno_primary(JavaParser.FieldAccess_lfno_primaryContext ctx) {
    return super.visitFieldAccess_lfno_primary(ctx);
  }

  @Override
  public AstNode visitArrayAccess(JavaParser.ArrayAccessContext ctx) {
    return super.visitArrayAccess(ctx);
  }

  @Override
  public AstNode visitArrayAccess_lf_primary(JavaParser.ArrayAccess_lf_primaryContext ctx) {
    return super.visitArrayAccess_lf_primary(ctx);
  }

  @Override
  public AstNode visitArrayAccess_lfno_primary(JavaParser.ArrayAccess_lfno_primaryContext ctx) {
    return super.visitArrayAccess_lfno_primary(ctx);
  }

  @Override
  public AstNode visitMethodInvocation(JavaParser.MethodInvocationContext ctx) {
    return super.visitMethodInvocation(ctx);
  }

  @Override
  public AstNode visitMethodInvocation_lf_primary(JavaParser.MethodInvocation_lf_primaryContext ctx) {
    return super.visitMethodInvocation_lf_primary(ctx);
  }

  @Override
  public AstNode visitMethodInvocation_lfno_primary(JavaParser.MethodInvocation_lfno_primaryContext ctx) {
    return super.visitMethodInvocation_lfno_primary(ctx);
  }

  @Override
  public AstNode visitArgumentList(JavaParser.ArgumentListContext ctx) {
    return super.visitArgumentList(ctx);
  }

  @Override
  public AstNode visitMethodReference(JavaParser.MethodReferenceContext ctx) {
    return super.visitMethodReference(ctx);
  }

  @Override
  public AstNode visitMethodReference_lf_primary(JavaParser.MethodReference_lf_primaryContext ctx) {
    return super.visitMethodReference_lf_primary(ctx);
  }

  @Override
  public AstNode visitMethodReference_lfno_primary(JavaParser.MethodReference_lfno_primaryContext ctx) {
    return super.visitMethodReference_lfno_primary(ctx);
  }

  @Override
  public AstNode visitArrayCreationExpression(JavaParser.ArrayCreationExpressionContext ctx) {
    return super.visitArrayCreationExpression(ctx);
  }

  @Override
  public AstNode visitDimExprs(JavaParser.DimExprsContext ctx) {
    return super.visitDimExprs(ctx);
  }

  @Override
  public AstNode visitDimExpr(JavaParser.DimExprContext ctx) {
    return super.visitDimExpr(ctx);
  }

  @Override
  public AstNode visitConstantExpression(JavaParser.ConstantExpressionContext ctx) {
    return super.visitConstantExpression(ctx);
  }

  @Override
  public AstNode visitExpression(JavaParser.ExpressionContext ctx) {
    return super.visitExpression(ctx);
  }

  @Override
  public AstNode visitLambdaExpression(JavaParser.LambdaExpressionContext ctx) {
    return super.visitLambdaExpression(ctx);
  }

  @Override
  public AstNode visitLambdaParameters(JavaParser.LambdaParametersContext ctx) {
    return super.visitLambdaParameters(ctx);
  }

  @Override
  public AstNode visitInferredFormalParameterList(JavaParser.InferredFormalParameterListContext ctx) {
    return super.visitInferredFormalParameterList(ctx);
  }

  @Override
  public AstNode visitLambdaBody(JavaParser.LambdaBodyContext ctx) {
    return super.visitLambdaBody(ctx);
  }

  @Override
  public AstNode visitAssignmentExpression(JavaParser.AssignmentExpressionContext ctx) {
    return super.visitAssignmentExpression(ctx);
  }

  @Override
  public AstNode visitAssignment(JavaParser.AssignmentContext ctx) {
    return super.visitAssignment(ctx);
  }

  @Override
  public AstNode visitLeftHandSide(JavaParser.LeftHandSideContext ctx) {
    return super.visitLeftHandSide(ctx);
  }

  @Override
  public AstNode visitAssignmentOperator(JavaParser.AssignmentOperatorContext ctx) {
    return super.visitAssignmentOperator(ctx);
  }

  @Override
  public AstNode visitConditionalExpression(JavaParser.ConditionalExpressionContext ctx) {
    return super.visitConditionalExpression(ctx);
  }

  @Override
  public AstNode visitConditionalOrExpression(JavaParser.ConditionalOrExpressionContext ctx) {
    return super.visitConditionalOrExpression(ctx);
  }

  @Override
  public AstNode visitConditionalAndExpression(JavaParser.ConditionalAndExpressionContext ctx) {
    return super.visitConditionalAndExpression(ctx);
  }

  @Override
  public AstNode visitInclusiveOrExpression(JavaParser.InclusiveOrExpressionContext ctx) {
    return super.visitInclusiveOrExpression(ctx);
  }

  @Override
  public AstNode visitExclusiveOrExpression(JavaParser.ExclusiveOrExpressionContext ctx) {
    return super.visitExclusiveOrExpression(ctx);
  }

  @Override
  public AstNode visitAndExpression(JavaParser.AndExpressionContext ctx) {
    return super.visitAndExpression(ctx);
  }

  @Override
  public AstNode visitEqualityExpression(JavaParser.EqualityExpressionContext ctx) {
    return super.visitEqualityExpression(ctx);
  }

  @Override
  public AstNode visitRelationalExpression(JavaParser.RelationalExpressionContext ctx) {
    return super.visitRelationalExpression(ctx);
  }

  @Override
  public AstNode visitShiftExpression(JavaParser.ShiftExpressionContext ctx) {
    return super.visitShiftExpression(ctx);
  }

  @Override
  public AstNode visitAdditiveExpression(JavaParser.AdditiveExpressionContext ctx) {
    return super.visitAdditiveExpression(ctx);
  }

  @Override
  public AstNode visitMultiplicativeExpression(JavaParser.MultiplicativeExpressionContext ctx) {
    return super.visitMultiplicativeExpression(ctx);
  }

  @Override
  public AstNode visitUnaryExpression(JavaParser.UnaryExpressionContext ctx) {
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
