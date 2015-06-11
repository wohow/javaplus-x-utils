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
import java.util.List;

import x.javaplus.collections.Lists;

public class Util {
	
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
	
	public static byte[] copy( byte[] value ) {
		return java.util.Arrays.copyOf( value, value.length );
	}
	
	/**
	 * byte数组操作
	 * @author deng
	 */
	public static class Byte {

		/**
		 * 数据源
		 * 0000 0000
		 */
		private byte data[];
		private Byte( int capacity ){
			data = new byte[capacity];
		}
		
		/**
		 */
		public static Byte create( int capacity ){
			return new Byte( capacity );
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
	
}
