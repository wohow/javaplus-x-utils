package cn.xgame.gen;

import java.sql.SQLException;
import java.sql.Statement;

import x.javaplus.mysql.db.Dbcp;

public class MysqlCreateTest {
	
	public static void main(String[] args) throws SQLException {

		Statement statement = Dbcp.getConnection().createStatement();
		String hrappSQL = "CREATE DATABASE hrapp";
		statement.executeUpdate(hrappSQL);
		
		System.out.println( "完成" );
	}
}
