package x.javaplus.mysql;


import java.sql.SQLException;

import x.javaplus.mysql.generator.db.Mysql;
import x.javaplus.mysql.generator.gen.MysqlGenerator;
import x.javaplus.util.Util.Check;

public class App {

	/**
	 * 生成mysql主类1
	 * @param args
	 */
	public static void generateMysqlGen( String[] args ) {
		
		String dtoPath = null;
		String dstPath = null;
		String packageName = null;
		
		for( int i = 0; i < args.length; i+=2 ){
			if( args[i].equals( "-dtoPath" ) )
				dtoPath = args[i+1];
			if( args[i].equals( "-dstPath" ) )
				dstPath = args[i+1];
			if( args[i].equals( "-packageName" ) )
				packageName = args[i+1];
		}
		
		Check.isNull( dtoPath, dstPath, packageName );

		new MysqlGenerator( dtoPath, dstPath, packageName );
	}

	/**
	 * 生成mysql数据库
	 * @param args
	 */
	public static void generateMysql( String args ) {
		
		try {
			new Mysql( args );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
