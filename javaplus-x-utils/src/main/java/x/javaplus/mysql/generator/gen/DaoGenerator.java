package x.javaplus.mysql.generator.gen;

import java.util.List;

import x.javaplus.string.StringPrinter;
import x.javaplus.util.Templet;


public class DaoGenerator {
	
	private StringPrinter ret;

	public DaoGenerator( List<Dto> dtos ) {
		
		ret	= new StringPrinter();
		
		Templet temp = Config.getTemplet("DAO");
		
		for( Dto dto : dtos ){
			
			temp.set( "CLASS_NAME", dto.getSimpleClassName() );
			
			List<Field> vars = dto.getVariablesAll();
			StringPrinter setobject	= new StringPrinter();
			
			for( Field var : vars ){
				generatorSetobject( setobject, var );
			}
			
			temp.append( "SETOBJECT", setobject.toString() );
			
			ret.println( temp.toString().replaceAll("\r{2,50}", "\r") );
			temp.clear();
		}
	}

	private void generatorSetobject(StringPrinter v, Field var) {
		Templet temp = Config.getTemplet("SETOBJECT");
		temp.set( "VARIATE_NAME", var.getName() );
		temp.set( "FUN_NAME", var.getFunName() );
		String string = temp.toString();
		v.println( string );
	}

	public String toString(){
		return "\t"+ret.toString();
	}
	
}