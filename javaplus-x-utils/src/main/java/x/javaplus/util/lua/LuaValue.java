package x.javaplus.util.lua;

import org.keplerproject.luajava.LuaObject;

/**
 * lua返回专用值
 * @author deng		
 * @date 2015-7-13 下午9:55:17
 */
public class LuaValue {

	private LuaObject lo;

	public LuaValue( LuaObject luaObject ) {
		this.lo = luaObject;
	}
	
	public boolean getBoolean(){
		try {
			return lo.getBoolean();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getInt(){
		try {
			return (int) lo.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public float getFloat(){
		try {
			return (float) lo.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}
	}
	
	public long getLong(){
		try {
			return (long) lo.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public short getShort(){
		try {
			return (short) lo.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public byte getByte(){
		try {
			return (byte) lo.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public String getString(){
		try {
			return lo.getString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public Object getObject(){
		try {
			return lo.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
