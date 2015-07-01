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
	/** 10002 - 账号已经存在 */
	ACCOUNT_EXIST( 10002, "账号已经存在" ),
	/** 10003 - 密码错误 */
	PASSWORD_ERROR( 10003, "密码错误" ),
	
	
	/** 11001 - 登录验证码错误 */
	LKEY_ERROR( 11001, "验证码错误" ),
	/** 11002 - 玩家尚未创建角色 */
	PLAYER_NOTFOUND( 11002, "玩家尚未创建角色" ),
	/** 11003 - 名字含有非法字 */
	HAVE_ILLEGALITY( 11003, "名字含有非法字" ),
	/** 11004 - 名字已存在 */
	NAME_REPEAT( 11004, "名字已存在" ),
	
	/** 12001 - 星球不存在 */
	PLANET_NOTEXIST( 12001, "星球不存在" ),
	/** 12101 - 材料不存在 */
	STUFF_NOTEXIST( 12101, "材料不存在" ),
	/** 12102 - 材料数量不足 */
	STUFF_LAZYWEIGHT( 12102, "材料数量不足" ),
	/** 12201 - 不可捐献 */
	CANNOT_DONATE( 12201, "不可捐献" ),
	/** 12301 - 位置被占用 */
	INDEX_OCCUPY( 12301, "位置被占用" ),
	/** 12401 - 没有权限操作 */
	NOT_PRIVILEGE( 12401, "没有权限操作" ),
	
	
	/////-----------------------------------
	/** 2001 - 游戏服务器 正在运行 */
	GS_EXIST( 2001, "游戏服务器 正在运行" ),
	
	
	
	
	
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
