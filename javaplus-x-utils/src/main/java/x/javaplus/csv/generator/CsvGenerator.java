package x.javaplus.csv.generator;

import java.util.List;

import x.javaplus.csv.util.Csv;
import x.javaplus.string.StringPrinter;
import x.javaplus.string.StringUtil;
import x.javaplus.util.Util;
import x.javaplus.util.templet.Config;
import x.javaplus.util.templet.Templet;

/**
 * CSV生成
 * @author deng		
 * @date 2015-6-19 上午10:20:34
 */
public class CsvGenerator {

	private final String className = "CsvGen";
	
	public CsvGenerator( List<Csv> csvs, String filePath, String genPath, String cPackageName, String oPackageName ) {
		
		Templet temp 		= Config.getTemplet( "CSV_GEN" );
		
		temp.set( "PACKAGE_NAME", cPackageName );
		temp.set( "CLASS_NAME", className );
		
		StringPrinter importString = new StringPrinter();
		StringPrinter pfinalString = new StringPrinter();
		StringPrinter lfunString = new StringPrinter();
		StringPrinter funString = new StringPrinter();
		StringPrinter getString = new StringPrinter();
		
		for( Csv csv : csvs ){
			
			String className 	= csv.getFileName().substring( 0, csv.getFileName().length() - 4 );
			className			= StringUtil.firstToUpper(className);
			
			generatorImport( importString , oPackageName + "." + className );
			
			generatorPfinal( pfinalString , className );
			
			generatorLfun( lfunString , className, csv.getFileName() );
			
			generatorFun( funString , className );

			generatorGet( getString , className, csv );
		}
		
		temp.append( "IMPORT", importString.toString() );
		temp.append( "PRIVATE_FINAL", pfinalString.toString() );
		temp.append( "CSV_LOADFUN_TO", lfunString.toString() );
		temp.append( "CSV_LOADFUN", funString.toString() );
		temp.append( "CSV_GET", getString.toString() );
		
		String content = temp.toString().trim();
//		System.out.println( content );
		Util.File.write( genPath+"/"+className+".java", content );
		
	}

	private void generatorGet(StringPrinter print, String className, Csv csv ) {
		Templet temp 		= Config.getTemplet( "CSV_GET" );
		temp.set( "CLASS_NAME", className );
		temp.set( "VAR_NAME", className.toLowerCase() + "s" );
		temp.set( "DATA_NAME", csv.getNames().get(0) );
		temp.set( "VAR_TYPE", csv.getTypes().get(0).type() );
		print.print( temp.toString() );
	}

	private void generatorFun(StringPrinter print, String className ) {
		Templet temp 		= Config.getTemplet( "CSV_LOADFUN" );
		temp.set( "CLASS_NAME", className );
		temp.set( "VAR_NAME", className.toLowerCase() + "s" );
		print.print( temp.toString() );
	}

	private void generatorLfun( StringPrinter print, String className, String fileName ) {
		Templet temp 		= Config.getTemplet( "CSV_LOADFUN_TO" );
		temp.set( "CLASS_NAME", className );
		temp.set( "FILE_NAME", fileName );
		print.print( temp.toString() );
	}

	private void generatorPfinal(StringPrinter print, String className ) {
		Templet temp 		= Config.getTemplet( "PRIVATE_FINAL" );
		temp.set( "CLASS_NAME", className );
		temp.set( "VAR_NAME", className.toLowerCase() + "s" );
		print.print( temp.toString() );
	}

	private void generatorImport( StringPrinter print, String packageName ) {
		Templet temp 		= Config.getTemplet( "IMPORT" );
		temp.set( "PACKAGE_NAME", packageName );
		print.print( temp.toString() );
	}

}
