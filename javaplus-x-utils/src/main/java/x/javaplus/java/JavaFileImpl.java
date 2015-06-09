package x.javaplus.java;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;

import java.io.File;
import java.util.List;

import x.javaplus.collections.Lists;
import x.javaplus.mysql.generator.gen.Field;


public class JavaFileImpl implements JavaFile {

	private CompilationUnit	parse;

	public JavaFileImpl(CompilationUnit parse) {
		this.parse = parse;
	}

	public JavaFileImpl(String filePath)  {
		this(path(filePath));
	}

	private static CompilationUnit path(String filePath)  {
		try {
			return JavaParser.parse(new File(filePath));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public TypeDeclaration getType() {
		List<TypeDeclaration> types = parse.getTypes();
		if (types == null || types.size() != 1) {
			throw new TooManyClassException("一个文件只能有1个类" + parse);
		}
		return types.get(0);
	}

	public String getPackage() {
		return getPacketName(parse.getPackage());
	}

	/**
	 * 包名
	 *
	 * @param p
	 * @return
	 */
	public static String getPacketName(PackageDeclaration p) {
		return (p + "").replaceAll("package", "").replaceAll(";", "").trim();
	}

	public String toString() {
		return getType().getName();
	}

	public List<Field> getMethods() {
		List<Field> ls 		= Lists.newArrayList();
		TypeDeclaration t 	= getType();
		List<BodyDeclaration> all = t.getMembers();
		for (BodyDeclaration b : all) {
			if( !(b instanceof MethodDeclaration) )
				ls.add( new Field(b) );
		}
		return ls;
	}

	public String getClassSimpleName() {
		return getType().getName();
	}

	public String getClassFullName() {
		if (getPackage().isEmpty()) {
			return getClassSimpleName();
		}
		return getPackage() + "." + getClassSimpleName();
	}

	public List<ImportDeclaration> getImports() {
		return parse.getImports();
	}

}
