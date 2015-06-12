package x.javaplus.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误码
 * @author deng		
 * @date 2015-6-12 下午12:55:25
 */
public enum ErrorCode {

	/** 10001 - 账号或者密码错误 */
	AORP_ERROR( 10001, "账号或者密码错误" ),
	
	
	
	
	
	
	
	/** 0 - 成功 */
	SUCCEED( 0, "成功" ),
	/** 30001 - 其他错误 */
	OTHER_ERROR( 30001, "其他错误" );
	
	
	private final short			number;
	private final String 		desc;
	
	ErrorCode( int value, String desc ) {
		if( value >= Short.MAX_VALUE || value < 0 )
			throw new IllegalArgumentException( "不符合规范：" + value );
		this.number 		= (short) value;
		this.desc 			= desc;
	}
	
	private static final Map<Short, ErrorCode> numToEnum = new HashMap<Short, ErrorCode>();
	
	static{
		for( ErrorCode a : values() ){
			
			ErrorCode p = numToEnum.put( a.number, a );
			if( p != null ){
				throw new RuntimeException( "ErrorCode " + a.number + " 重复了" );
			}
		}
	}
	
	public String getDesc() {
		return desc;
	}
	public short toNumber() {
		return number;
	}
	public static ErrorCode fromNum( int n ){
		return numToEnum.get( (short)n );
	}
	
}
