package x.javaplus.mysql.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import x.javaplus.collections.Lists;
import x.javaplus.util.Resources;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

/**
 * Dbcp 是数据库连接池的总管理类 封装了对于连接池的相关操�?
 * 
 * @author deng
 */
public class Dbcp {
	private Dbcp() { }
	
	// 数据�?
	private static DruidDataSource dataSource = null;

	// 初始�?
	static {
		initialize();
	}
	private static void initialize() {
		try {
			Properties properties = loadPropertyFile( "db.properties" );
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource( properties );
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	private static Properties loadPropertyFile( String configName ) {
		if ( null == configName || configName.isEmpty() )
			throw new IllegalArgumentException( "Properties file path can not be null : " + configName );

		Properties properties = new Properties();
		try {
			
			InputStream input = new FileInputStream( Resources.getResource( configName ) );
			properties.load( input );
			input.close();
		
		} catch (FileNotFoundException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }

		return properties;
	}

	/**
	 *	从连接池中获取一个有效连�?
	 * @return
	 * 		返回�?��可用数据库连�?
	 */
	public static DruidPooledConnection getConnection(){
		DruidPooledConnection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) { e.printStackTrace(); }
//		System.out.println( "返回Connection成功,当前连接数：" + dataSource.getActiveCount() + "/" + dataSource.getMaxActive() );
		return conn;
	}

	public static String toMessage(){
		return "当前连接数：" + dataSource.getActiveCount() + "/" + dataSource.getMaxActive() ;
	}
	
	/**
	 * 关闭本次查询�?��的打�?��资源，除了rs，其余两个资源应该不可能为null，有待�?�?
	 * @param rs
	 * @param st
	 * @param con
	 */
	public static void close( ResultSet rs, Statement st, DruidPooledConnection con ){
		try {
			if( rs != null )
				rs.close();
			if( st != null )
				st.close();
			if( con != null )
				con.close();
//			System.out.println( "释放Connection成功，当前连接数�? + dataSource.getActiveCount() + "/" + dataSource.getMaxActive() );
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	/**
	 * 清空所有表数据 
	 * @param database 数据库
	 * @param args 忽略的表名
	 */
	public static void pruge( String database, String ... args ){
		
		try {
			DBObject o = DBObject.create();
			
			for( String name : getAllTableName( database, args ) ){
			
				o.prepareStatement( "TRUNCATE TABLE " + name );
			
				o.executeUpdate();
			}
			o.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static List<String> getAllTableName( String database, String[] args ) {
		List<String> list		= Lists.newArrayList();
		try {
			DBObject o = DBObject.create();
			o.prepareStatement( "SELECT TABLE_SCHEMA as 'Use', TABLE_NAME as 'TableName' FROM INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='"+database+"' order by TABLE_NAME" );
			o.executeQuery();
			while( o.next() ){
				
				String name = o.getString( "TableName" );
				
				if( isHave( name, args ) )
					continue;
				
				list.add( name );
			}
			o.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private static boolean isHave(String name, String[] args) {
		if( args == null )
			return false;
		for( int i = 0; i < args.length; i++ ){
			if( name.equalsIgnoreCase( args[i] ) )
				return true;
		}
		return false;
	}
	

}
