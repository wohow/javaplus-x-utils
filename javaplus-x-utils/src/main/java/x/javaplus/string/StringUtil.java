package x.javaplus.string;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串 操作
 * 
 * @author deng
 * @date 2015-6-19 下午12:27:44
 */
public class StringUtil {

	/**
	 * 把第一位字符转成大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstToUpper(String str) {
		char a = str.charAt(0);
		char b = (char) (Character.isLowerCase(a) ? a - 32 : a);
		return str.replaceFirst(a + "", b + "");
	}

	/**
	 * 将一个字符串转成数字 字符串  如果不是数字就转成0
	 * @param str
	 * @return
	 */
	public static String convertNumberString(String str) {
		if( str == null || str.isEmpty() ) return "0";
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches() ? str : "0";
	}

	/**
	 * 创建一个与给定的模式和使用MessageFormat格式化给定的参数
	 * @param pattern
	 * @param arguments
	 * @return
	 */
	public static String format( String pattern, Object... arguments ) {
		return MessageFormat.format( pattern, arguments );
	}

	
}
