package x.javaplus.mysql.generator.db;

import java.sql.SQLException;
import java.util.List;

import x.javaplus.mysql.db.DBObject;
import x.javaplus.mysql.generator.gen.Dto;
import x.javaplus.util.templet.Config;
import x.javaplus.util.templet.Field;

/**
 * 数据库生成
 * @author deng		
 * @date 2015-7-14 上午9:17:32
 */
public class MysqlGenerator {

	private DBObject dbo ;
	
	public MysqlGenerator( String args ) throws SQLException {
		
		dbo = DBObject.create();
		
		List<Dto> dtos = Config.getDtos( args );
		for( Dto d : dtos ){
			
			String table = d.getSimpleClassName();
			
			if( tableIsExists( table ) ){
				
				createColumns( table, d.getVariablesAll() );
				
			}else{
				createTable( table, d.getVariablesAll() );
			}
		}
		
		dbo.close();
	}

	private void createColumns( String table, List<Field> columns ) throws SQLException {
		
		for( Field f : columns ){
			
			String type = columnIsExists( table, f.getName() );
			if( type == null ){
				addColumn( table, f );
			} else if( !f.sqlType().equalsIgnoreCase( type ) ) {
				modifyColumn( table, f );
			}
		}
	}




	private void createTable( String table, List<Field> columns ) throws SQLException {
		if( columns == null || columns.isEmpty() )
			return;
		String sql = "";
		for( Field f : columns ){
			if( !sql.isEmpty() ) 
				sql += ",";
			sql += f.sql();
		}
		sql = "CREATE TABLE `"+table+"` (" +sql+ ")ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;";
		dbo.prepareStatement( sql );
		dbo.executeUpdate();
	}
	
	// 添加一个字段到表里 
	private void addColumn( String table, Field f ) throws SQLException {
		dbo.prepareStatement( "ALTER TABLE "+table+" ADD "+f.sql() );
		dbo.executeUpdate();
	}

	// 修改一个字段
	private void modifyColumn( String table, Field f ) throws SQLException {
		dbo.prepareStatement( "ALTER TABLE "+table+" MODIFY COLUMN "+f.sql() );
		dbo.executeUpdate();
	}
	
	// 检查这个表 是否存在
	private boolean tableIsExists( String table ) throws SQLException {
		dbo.prepareStatement( "SHOW TABLES LIKE '"+table+"'" );
		dbo.executeQuery();
		return dbo.next();
	}
	
	// 检查这个字段是否存在
	private String columnIsExists( String table, String column ) throws SQLException {
		dbo.prepareStatement( "DESC " +table + " " + column );
		dbo.executeQuery();
		return (String) (dbo.next() ? dbo.get("Type") : null);
	}

}
