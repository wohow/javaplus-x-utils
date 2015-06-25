package x.javaplus.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.zip.CRC32;

import x.javaplus.collections.Lists;

public class Util {
	
	public static byte[] copy( byte[] value ) {
		return java.util.Arrays.copyOf( value, value.length );
	}
	
	
	public static final class Sleep {
		
		public static void sleep(){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static final class Check {
		
		public static void isNull( Object ...objects ) {
			for( int i = 0; i < objects.length; i++ ){
				if( objects[i] == null )
					throw new RuntimeException( "object is null" );
			}
		}
		
	}
	
	/**
	 * byte数组操作
	 * @author deng
	 */
	public static class Bytes {

		/**
		 * 数据源
		 * 0000 0000
		 */
		private byte data[];
		private Bytes( int capacity ){
			data = new byte[capacity];
		}
		
		/**
		 */
		public static Bytes create( int capacity ){
			return new Bytes( capacity );
		}
		
		public void set( int index, int isopen ){
			int ind = (index-1)/8;
			int idx	= (index-1)%8;
			if( isopen == 1 )
				data[ind] |= (int)Math.pow( 2, idx );
			else
				data[ind] &= ~(int)Math.pow( 2, idx );
		}
		public void open( int index ){
			int ind = (index-1)/8;
			int idx	= (index-1)%8;
			data[ind] |= (int)Math.pow( 2, idx );
		}
		public void close( int index ){
			int ind = (index-1)/8;
			int idx	= (index-1)%8;
			data[ind] &= ~(int)Math.pow( 2, idx );
		}
		public int isOpen( int index ){
			int ind = (index-1)/8;
			int idx	= (index-1)%8;
			return (data[ind] & (int)Math.pow( 2, idx )) != 0 ? 1 : 0;
		}
		public byte[] getData(){
			return data;
		}
		public String toString(){
			StringBuilder content = new StringBuilder();
			for( int i = data.length-1; i >= 0; i-- ){
				String temp = Integer.toBinaryString( data[i] );
				if( temp.length() > 8 ) {
					temp	= temp.substring( temp.length() - 8 );
				}else{
					int l 	= 8 - temp.length();
					for( int j = 0; j < l; j++ ) temp="0"+temp;
				}
				content.append( temp );
				if( i != 0 ) content.append( " " );
			}
			return content.toString();
		}
		public int length(){
			return data.length * 8;
		}
		
	}
	
	/**
	 * 文件工具
	 * 
	 * @author deng
	 * 
	 */
	public static final class File {

		/**
		 * 获得指定路径的文件内容
		 * 
		 * @param path
		 * @return
		 */
		public static String getContent(String path) {
			return getContent(new java.io.File(path));
		}
		
		/**
		 * 获取指定URL文件内容
		 * @param r
		 * @return
		 */
		public static String getContent(URL r) {
			InputStream s = null;
			BufferedReader bufferedReader = null;
			try {
				s = r.openStream();

				bufferedReader = new BufferedReader(new InputStreamReader(s, "utf8"));
				StringBuffer sb = new StringBuffer();
				read(sb, bufferedReader);
				return sb.toString();

			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				Closer.close(s);
				Closer.close(bufferedReader);
			}
		}
		
		/**
		 * 获得文本文件内容
		 * @param file
		 * @return
		 */
		public static String getContent(java.io.File file) {

			BufferedReader bufferedReader = null;
			try {
				bufferedReader = new BufferedReader( new java.io.FileReader(file) );
				StringBuffer sb = new StringBuffer();
				read(sb, bufferedReader);
				return sb.toString();
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} finally {
				Closer.close(bufferedReader);
			}
		}
		
		private static void read(StringBuffer sb, BufferedReader bufferedReader) {
			while (true) {
				String line;
				try {
					line = bufferedReader.readLine();

					if (line == null) {
						break;
					}
					sb.append(line);
					sb.append("\r");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		/**
		 * 将content以文本的方式, 写入到dst文件中. 强制覆盖
		 * 
		 * @param file
		 * @param content
		 */
		public static void write(String file, String content) {
			OutputStream fos = null;
			OutputStreamWriter osw = null;
			try {
				java.io.File f = new java.io.File(file);
				if (!f.exists()) {
					int lastIndexOf = file.lastIndexOf("/");
					if (lastIndexOf == -1) {
						lastIndexOf = file.lastIndexOf("\\");
					}
					java.io.File path = new java.io.File(file.substring(0,
							lastIndexOf));
					path.mkdirs();
					f.createNewFile();
				}

				fos = new FileOutputStream(f);
				osw = new OutputStreamWriter(fos, "UTF-8");
				osw.write(content);
				osw.flush();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				Closer.close(fos);
			}
		}

		public static void write(String file, Object content) {
			write(file, content.toString());
		}
		
		/**
		 * 获得某个文件夹下, 所有的文件
		 * 
		 * @param path
		 *            文件夹路径
		 * @return
		 */
		public static List<java.io.File> getFiles(String path) {
			List<java.io.File> files = Lists.newArrayList();
			java.io.File f = new java.io.File(path);
			String[] all = f.list();

			if (all != null) {
				for (String fname : all) {
					java.io.File fs = new java.io.File(path + "/" + fname);
					if (fs.isDirectory()) {
						files.addAll(getFiles(path + "/" + fname));
					} else {
						files.add(fs);
					}
				}
			}
			return files;
		}
		
		
		/**
		 * 获取某个文件夹下，指定类型的文件
		 * @param path
		 * @param regex
		 * @return
		 */
		public static List<java.io.File> getFiles( String path, String regex ){
			List<java.io.File> files = Lists.newArrayList();
			java.io.File f = new java.io.File(path);
			String[] all = f.list();

			if (all != null) {
				for (String fname : all) {
					java.io.File fs = new java.io.File(path + "/" + fname);
					if (fs.isDirectory()) {
						files.addAll( getFiles(path + "/" + fname, regex ) );
					} else if( fs.getName().toLowerCase().endsWith( "."+regex.toLowerCase() ) ){
						
						files.add(fs);
					}
				}
			}
			
			return files;
		}
		
		/**
		 * 获得某个文件中所有的行
		 * 
		 * @param filePath
		 * @return
		 */
		public static List<String> getLines(String filePath) {
			java.io.File file;
			try {
				file = new java.io.File(filePath);
			} catch (java.lang.Exception e) {
				throw new RuntimeException(e);
			}
			return getLines(file);
		}

		public static List<String> getLines(java.io.File file) {
			
			List<String> newArrayList = Lists.newArrayList();

			BufferedReader br = null;
			InputStreamReader is = null;
			try {

				is	= new InputStreamReader( new FileInputStream(file), "utf8" );
				br 	= new BufferedReader( is );

				read(br, newArrayList);

			} catch (Exception e) {

				throw new RuntimeException(e);

			} finally {
				Closer.close(br,is);
			}

			return newArrayList;
		}
		
		private static void read(BufferedReader br, List<String> newArrayList) throws IOException {
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				newArrayList.add(line);
			}
		}

	}
	
	public static final class Propertie {
		
		/**
		 * 根据 文件名 获取文件
		 * @param name
		 * @return
		 */
		public static Properties loadProperty( String name ){
			
			if ( null == name || name.isEmpty() )
				throw new IllegalArgumentException( "Properties file path can not be null : " + name );
			
			Properties properties = null;
			InputStream input = null;
			try {
				properties	= new Properties();
				input 		= new FileInputStream( Resources.getResource( name ) );
				properties.load( input );
			
			} catch (FileNotFoundException e) { e.printStackTrace();
			} catch (IOException e) { e.printStackTrace(); }
			finally {
				Closer.close( input );
			}
			return properties;
		}
	}
	
	
	public static final class Collection {
		
		/**
		 * 把null列表转为空列表
		 * @param ts
		 * @return
		 */
		public static <T> List<T> nullToEmpty(List<T> ts) {
			if (ts == null) {
				ts = Lists.newArrayList();
			}
			return ts;
		}
	}
	
	
	public static final class CRC{
		
		private static CRC32 crc = new CRC32();
		
		/**
		 * 获取一个 32位  的数字
		 * @param str
		 * @return
		 */
		public static long update( String str ){
			crc.update( str.getBytes() );
			return crc.getValue();
		}
		
		/**
		 * 获取一个 固定长度为9的数字
		 * @param str
		 * @return
		 */
		public static long update_9( String str ){
			crc.update( str.getBytes() );
			return toNew( crc.getValue() );
		}
		private static int toNew( long value ){
			
			int newVlaue 	= 0;
		    int length		= String.valueOf( value ).length();
		    
		    int l 			= Math.abs( length - 9 );
	    	int xx			= (int) Math.pow( 10, l );
		    if( length > 9 ) {
		    	newVlaue	= (int) (value / xx);
		    }else if( length < 9 ){
		    	newVlaue	= (int) (value * xx);
		    }else{
		    	newVlaue	= (int) value;
		    }
		    
			return newVlaue;
		}
		
	}
	
	public static final class Random{
		
		private static final java.util.Random random = new java.util.Random();
		
		/** min和max都必须大于0    <br> 
		 * 在min和max中随机一个数字，包括上下限[min,max] 
		 * */
		public static int get( int min, int max ) {
			
			if( min < 0 || max == Integer.MAX_VALUE )
				throw new IllegalArgumentException( "随机数下限不得<0，上限不得>=2的32次方" );
			
			++max;
			int n = max - min;
			if( n <= 0 ) n = 1;
			
			int ret = random.nextInt( n );
			return min + ret;
		}
	}
	
	/** 验证码 */
	public static final class Key{
		
		/**
		 * 生成一个 验证码
		 * @param cpassword 协商密码
		 * @return
		 */
		public static String generateKey( Object cpassword ){
			// 获取一个 随机密码
			String rand_password 	= randomPassword();
			// 随机密码  + 协商密码
			String md5				= MD5.md5( rand_password + cpassword.toString() );
			// md5 + 随机密码 
			return md5 + rand_password;
		}
		
		/**
		 * 验证 验证码 是否正确
		 * @param key 需要验证的 验证码
		 * @param cpassword 协商密码
		 * @return
		 */
		public static boolean verify( String key, Object cpassword ){
			String rand_password 	= key.substring( key.length()-6, key.length());
			String rawMd5			= key.substring( 0, key.length()-6 );
			String nowMd5			= MD5.md5( rand_password + cpassword.toString() );
			return rawMd5.equals( nowMd5 );
		}
		
		private static String randomPassword() {
			int len 	= 6;
			String ret 	= "";
			char [] x 	= MD5.getLookUpHexAlphabet();
			while( len-- > 0 ){
				int index = Random.get( 0, x.length - 1 );
				ret += x[index];
			}
			return ret;
		}
		
	}
	
	public static final class Time{
		
		/**====================================== 计时工具 ======================================*/
		private volatile static long l1;
		public static void beginTimer(){ l1 = System.nanoTime(); }
		public static float endTimer(){ return (System.nanoTime() - l1) / 1000000f; }
		public static void endTimerToPrint(){ System.out.println( " 逻辑耗时：" + ((System.nanoTime() - l1) / 1000000f) + "毫秒"  ); }
		

		
		/** =============================将时间转成字符串  把一个用秒数保存的时间值转换为易读的字符串 =============================== */
		public static String refFormatDate( long millis ){ return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( millis );  }
		public static String refFormatDate( ){ return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( System.currentTimeMillis() ); }
		public static String refFormatDate( long millis, String pattern ){ return new SimpleDateFormat( pattern ).format( millis ); }//可以方便地修改日期格式
		public static String refFormatDate( String pattern ){ return new SimpleDateFormat( pattern ).format( System.currentTimeMillis() ); }
		
		
		
		/** ===================计算从当前时间，满足条件 hourOfDay, minuteOfHour, secondOfMinite的最近时间 =========================*/
		public static long refTimeInMillis( int hourOfDay, int minuteOfHour, int secondOfMinite ){
			Calendar calendar = Calendar.getInstance();
			if( hourOfDay != -1 ) calendar.set( Calendar.HOUR_OF_DAY, hourOfDay );
			if( minuteOfHour != -1 ) calendar.set( Calendar.MINUTE, minuteOfHour );
			if( secondOfMinite != -1 ) calendar.set( Calendar.SECOND, secondOfMinite );
			calendar.set( Calendar.MILLISECOND, 0 );
			return calendar.getTimeInMillis();
		}
		public static long refTimeInMillis( long currentTime, int hourOfDay, int minuteOfHour, int secondOfMinite ) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis( currentTime );
			if( hourOfDay != -1 ) calendar.set( Calendar.HOUR_OF_DAY, hourOfDay );
			if( minuteOfHour != -1 ) calendar.set( Calendar.MINUTE, minuteOfHour );
			if( secondOfMinite != -1 ) calendar.set( Calendar.SECOND, secondOfMinite );
			calendar.set( Calendar.MILLISECOND, 0 );
			return calendar.getTimeInMillis();
		}
		
		
		
		/**=============================================== 获得当前星期 ==========================================================*/
		public static byte currentWeek( long currentTimeMillis ){
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis( currentTimeMillis );
			return (byte) ( cal.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : (cal.get(Calendar.DAY_OF_WEEK) - 1) );
		}
		public static byte currentWeek(){
			Calendar cal = Calendar.getInstance();
			return (byte) ( cal.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : (cal.get(Calendar.DAY_OF_WEEK) - 1) );
		}
		
		/** 到凌晨还剩余多少时间 */
		public static long toWeehoursTime() {
			return refTimeInMillis( 24, 0, 0 ) - System.currentTimeMillis();
		}
		
	}
	
}
