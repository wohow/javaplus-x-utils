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
	/** 11101 - 货币不足*/
	CURRENCY_LAZYWEIGHT( 11101, "货币不足" ),
	
	/** 12001 - 星球不存在 */
	PLANET_NOTEXIST( 12001, "星球不存在" ),
	/** 12101 - 材料不存在 */
	STUFF_NOTEXIST( 12101, "材料不存在" ),
	/** 12102 - 材料数量不足 */
	STUFF_LAZYWEIGHT( 12102, "材料数量不足" ),
	/** 12103 - 道具不存在 */
	PROP_NOTEXIST( 12103, "道具不存在" ),
	/** 12104 - 道具数量不足 */
	PROP_LAZYWEIGHT( 12104, "道具数量不足" ),
	
	/** 12111 - 舰船不存在 */
	SHIP_NOTEXIST( 12111, "舰船不存在" ),
	/** 12112 - 不是舰船装备 */
	NOT_SHIPEQUIP( 12112, "不是舰船装备" ),
	/** 12113 - 不是舰长装备 */
	NOT_CAPTAINEQUIP( 12113, "不是舰长装备" ),
	/** 12114 - 舰船已经有队伍了 */
	SHIP_ISHAVETEAM( 12114, "舰船已经有队伍了" ),
	/** 12115 - 舰船不是空闲中状态 */
	SHIP_NOTLEISURE( 12115, "舰船不是空闲中状态" ),
	/** 12116 - 队伍已经满了 */
	TEAM_ISMAX( 12116, "队伍已经满了" ),
	/** 12117 - 拒绝组队 */
	REJECTPARTY( 12117, "拒绝组队" ),
	/** 12118 - 组队超时 */
	TEAM_TIMEOUT( 12118, "组队超时" ),
	/** 12119 - 该玩家已经在队伍中了 */
	HAVEBEENIN_TEAM( 12119, "该玩家已经在队伍中了" ),
	/** 12120 - 该舰船不能战斗 */
	SHIP_NOTFIGHTING( 12120, "该舰船不能战斗" ),
	
	/** 12121 - 空间不足 */
	ROOM_LAZYWEIGHT( 12121, "空间不足" ),
	/** 12201 - 不可捐献 */
	CANNOT_DONATE( 12201, "不可捐献" ),
	/** 12301 - 位置被占用 */
	INDEX_OCCUPY( 12301, "位置被占用" ),
	
	/** 12401 - 没有权限操作 */
	NOT_PRIVILEGE( 12401, "没有权限操作" ),
	/** 12402 - 该投票不存在 */
	VOTE_NOTEXIST( 12402, "该投票不存在" ),
	/** 12403 - 不是元老 */
	NOT_SENATOR( 12403, "不是元老" ),
	/** 12404 - 已经在投票列表中 */
	YET_ATLIST( 12404, "已经在投票列表中" ),
	/** 12405 - 条件不满足 */
	CON_DISSATISFY( 12405, "条件不满足" ),
	/** 12406 - 申请的更新不正确 */
	UPDATE_ERROR( 12406, "申请的更新不正确" ),
	/** 12407 - 玩家不存在 */
	PLAYER_NOTEXIST( 12407, "玩家不存在" ),
	/** 12408 - 频道个数已经满了 */
	AXN_ISMAX( 12408, "频道个数已经满了" ),
	/** 12409 - 频道不存在 */
	AXN_NOEXIST( 12409, "频道不存在" ),
	/** 12410 - 频道人数已经满了 */
	AXN_MAXMEMBER( 12410, "频道人数已经满了" ),
	
	/** 12501 - 副本不存在 */
	ECTYPE_NOTEXIST( 12501, "副本不存在" ),
	/** 12502 - 该船不能战斗 */
	SHIP_CANNOT_FIGHT( 12502, "该船不能战斗" ),
	/** 12503 - 该船不在目标星球 */
	SHIP_NOTINSTAR( 12503, "该船不在目标星球" ),
	/** 12504 - 等待其他玩家 */
	AWAIT_OTHERPLAYER( 12504, "等待其他玩家" ),
	/** 12505 - 战斗时间还没结束 */
	COMBATTIME_NOTOVER( 12505, "战斗时间还没结束" ),

	
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
