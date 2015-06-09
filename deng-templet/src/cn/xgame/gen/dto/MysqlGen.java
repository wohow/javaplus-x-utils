package cn.xgame.gen.dto;import java.util.List;import x.javaplus.collections.Lists;import x.javaplus.mysql.db.DBObject;import x.javaplus.mysql.db.SqlDao;import x.javaplus.mysql.db.SqlDto;public class MysqlGen {		/**	 * Mysql操作类 <br>	 * <br>	 * 列子 <br>	 * <br>	 * =====获取数据===== <br>	 * XXXDao dao = SqlUtil.getXXXDao(); <br>	 * XXXDto dto = dao.get( "101" );// 获取单个数据  默认根据id查找 <br>	 * List.XXXDto dto = dao.getAll( "101" );// 获取多个数据  默认根据id查找 <br>	 * List.XXXDto dto = dao.getByExact( "id="+101 );// 获取多个数据  根据自定义sql语句查找 可以用Condition类方便的生成语句;<br>	 * dao.commit(); // 最后提交 每个操作后 都要调用 commit<br>	 * dao.commit( dto ); // 提交并保存dto  只能保存单个数据<br>	 * <br>	 * =====创建数据===== <br>	 * XXXDao dao = SqlUtil.getXXXDao();<br>	 * RoleDto dto = dao.create();// 表示创建开始 <br>	 * dto.setId( "101" );<br>	 * dto.setName( "大峰哥" );<br>	 * dto.setLevel( 99 );<br>	 * dao.commit( dto );// 提交并保存dto <br>	 * <br>	 * =====保存数据===== <br>	 * XXXDao dao = SqlUtil.getXXXDao();<br>	 * XXXDto dto = dao.update();// 保存单个数据 默认根据id来保存 <br>	 * XXXDto dto = dao.update( "id="+101 ); // 保存多个数据  根据自定义语句来保存   这种模式必须设置id<br>	 * dto.setId( "101" );<br>	 * dto.setName( "大峰哥" );<br>	 * dto.setLevel( 99 );<br>	 * dao.commit( dto );// 提交并保存dto 默认根据id保存 <br>	 * <br>	 * =====删除数据===== <br>	 * RoleDao dao = SqlUtil.getRoleDao(); <br>	 * dao.delete( "101" );<br>     * dao.deleteByExact( "id="+101 );<br>     * dao.commit();<br>	 *<br>	 *<br>	 * @author deng	 *	 */	public static final class SqlUtil {				public static RaanlDao getRaanlDao() {			return new RaanlDao( "raanl" );		}
		public static RoleDao getRoleDao() {			return new RoleDao( "role" );		}

	}			public static class RaanlDao extends SqlDao{				public RaanlDao( String tableName ) {			super( tableName );		}				public RaanlDto get( String id ) {			super.select( id, true );			if( next() ){				RaanlDto x = new RaanlDto();				x.fromDBObject( getObject() );				return x;			}			return null;		}				public List<RaanlDto> getAll( String id ) {			super.select( id, false );			return getLs();		}		public List<RaanlDto> getByExact( String arg ) {			super.selectByExact( arg );			return getLs();		}				private List<RaanlDto> getLs() {			List<RaanlDto> ls = Lists.newArrayList();			while( next() ){				RaanlDto x = new RaanlDto();				x.fromDBObject( getObject() ) ;				ls.add( x );			}			return ls;		}				public RaanlDto update(){			_update( );			return new RaanlDto();		}		public RaanlDto updateByExact( String arg ){			_updateByExact( arg );			return new RaanlDto();		}				public RaanlDto create() {			insert();			return new RaanlDto();		}				public void delete( String id ){			super.delete( id );		}		public void deleteByExact( String arg ){			super.deleteByExact( arg );		}				public void commit(){			super.commit( false );		}				public void commit( RaanlDto dto ) {			setObject( "id", dto.getId() );
			setObject( "name", dto.getName() );
			setObject( "grad", dto.getGrad() );
			setObject( "max_grad", dto.getMax_grad() );

			super.commit( true );		}	}
	public static class RoleDao extends SqlDao{				public RoleDao( String tableName ) {			super( tableName );		}				public RoleDto get( String id ) {			super.select( id, true );			if( next() ){				RoleDto x = new RoleDto();				x.fromDBObject( getObject() );				return x;			}			return null;		}				public List<RoleDto> getAll( String id ) {			super.select( id, false );			return getLs();		}		public List<RoleDto> getByExact( String arg ) {			super.selectByExact( arg );			return getLs();		}				private List<RoleDto> getLs() {			List<RoleDto> ls = Lists.newArrayList();			while( next() ){				RoleDto x = new RoleDto();				x.fromDBObject( getObject() ) ;				ls.add( x );			}			return ls;		}				public RoleDto update(){			_update( );			return new RoleDto();		}		public RoleDto updateByExact( String arg ){			_updateByExact( arg );			return new RoleDto();		}				public RoleDto create() {			insert();			return new RoleDto();		}				public void delete( String id ){			super.delete( id );		}		public void deleteByExact( String arg ){			super.deleteByExact( arg );		}				public void commit(){			super.commit( false );		}				public void commit( RoleDto dto ) {			setObject( "id", dto.getId() );
			setObject( "a8", dto.getA8() );
			setObject( "a7", dto.getA7() );
			setObject( "name", dto.getName() );
			setObject( "a1", dto.getA1() );
			setObject( "a2", dto.getA2() );
			setObject( "a3", dto.getA3() );
			setObject( "a4", dto.getA4() );
			setObject( "a5", dto.getA5() );
			setObject( "a6", dto.getA6() );
			setObject( "b", dto.getB() );

			super.commit( true );		}	}

	public static class RaanlDto implements SqlDto{		private String id = null;
		private String name = null;
		private Integer grad = null;
		private Integer max_grad = null;

		public RaanlDto() {		}				/**		 * Copy new one		 */		public RaanlDto(RaanlDto src) {			this.id = src.id;
			this.name = src.name;
			this.grad = src.grad;
			this.max_grad = src.max_grad;

		}		/** 无 */		public String getId(){			return this.id;		}
		/** 无 */		public String getName(){			return this.name;		}
		/** 无 */		public Integer getGrad(){			return this.grad;		}
		/** 无 */		public Integer getMax_grad(){			return this.max_grad;		}

		/** 无 */		public void setId( String id ){			this.id = id;		}
		/** 无 */		public void setName( String name ){			this.name = name;		}
		/** 无 */		public void setGrad( Integer grad ){			this.grad = grad;		}
		/** 无 */		public void setMax_grad( Integer max_grad ){			this.max_grad = max_grad;		}

		public static String idChangeSql( String x) {			return "id=" + "'"+x+"'";		}
		public static String nameChangeSql( String x) {			return "name=" + "'"+x+"'";		}
		public static String gradChangeSql( Integer x) {			return "grad=" + x;		}
		public static String max_gradChangeSql( Integer x) {			return "max_grad=" + x;		}

		@Override		public void fromDBObject(DBObject o) {			id = o.getString( "id" );
			name = o.getString( "name" );
			grad = o.getInt( "grad" );
			max_grad = o.getInt( "max_grad" );

		}				@Override		public String toString() {			return "id="+id+","+"name="+name+","+"grad="+grad+","+"max_grad="+max_grad;		}	}
	public static class RoleDto implements SqlDto{		private String id = null;
		private byte[] a8 = null;
		private Integer a7 = null;
		private String name = null;
		private String a1 = null;
		private Long a2 = null;
		private Integer a3 = null;
		private Float a4 = null;
		private Short a5 = null;
		private Byte a6 = null;
		private byte[] b = null;

		public RoleDto() {		}				/**		 * Copy new one		 */		public RoleDto(RoleDto src) {			this.id = src.id;
			this.a8 = src.a8;
			this.a7 = src.a7;
			this.name = src.name;
			this.a1 = src.a1;
			this.a2 = src.a2;
			this.a3 = src.a3;
			this.a4 = src.a4;
			this.a5 = src.a5;
			this.a6 = src.a6;
			this.b = src.b;

		}		/** 唯一ID */		public String getId(){			return this.id;		}
		/** 我操 */		public byte[] getA8(){			return this.a8;		}
		/** 无 */		public Integer getA7(){			return this.a7;		}
		/** 你好啊 */		public String getName(){			return this.name;		}
		/** 你好啊1 */		public String getA1(){			return this.a1;		}
		/** 你好啊2 */		public Long getA2(){			return this.a2;		}
		/** 你好啊3 */		public Integer getA3(){			return this.a3;		}
		/** 你好啊4 */		public Float getA4(){			return this.a4;		}
		/** 你好啊5 */		public Short getA5(){			return this.a5;		}
		/** 你好啊6 */		public Byte getA6(){			return this.a6;		}
		/** 你好啊7 */		public byte[] getB(){			return this.b;		}

		/** 唯一ID */		public void setId( String id ){			this.id = id;		}
		/** 我操 */		public void setA8( byte[] a8 ){			this.a8 = a8;		}
		/** 无 */		public void setA7( Integer a7 ){			this.a7 = a7;		}
		/** 你好啊 */		public void setName( String name ){			this.name = name;		}
		/** 你好啊1 */		public void setA1( String a1 ){			this.a1 = a1;		}
		/** 你好啊2 */		public void setA2( Long a2 ){			this.a2 = a2;		}
		/** 你好啊3 */		public void setA3( Integer a3 ){			this.a3 = a3;		}
		/** 你好啊4 */		public void setA4( Float a4 ){			this.a4 = a4;		}
		/** 你好啊5 */		public void setA5( Short a5 ){			this.a5 = a5;		}
		/** 你好啊6 */		public void setA6( Byte a6 ){			this.a6 = a6;		}
		/** 你好啊7 */		public void setB( byte[] b ){			this.b = b;		}

		public static String idChangeSql( String x) {			return "id=" + "'"+x+"'";		}
		public static String a8ChangeSql( byte[] x) {			return "a8=" + x;		}
		public static String a7ChangeSql( Integer x) {			return "a7=" + x;		}
		public static String nameChangeSql( String x) {			return "name=" + "'"+x+"'";		}
		public static String a1ChangeSql( String x) {			return "a1=" + "'"+x+"'";		}
		public static String a2ChangeSql( Long x) {			return "a2=" + x;		}
		public static String a3ChangeSql( Integer x) {			return "a3=" + x;		}
		public static String a4ChangeSql( Float x) {			return "a4=" + x;		}
		public static String a5ChangeSql( Short x) {			return "a5=" + x;		}
		public static String a6ChangeSql( Byte x) {			return "a6=" + x;		}
		public static String bChangeSql( byte[] x) {			return "b=" + x;		}

		@Override		public void fromDBObject(DBObject o) {			id = o.getString( "id" );
			a8 = o.getBytes( "a8" );
			a7 = o.getInt( "a7" );
			name = o.getString( "name" );
			a1 = o.getString( "a1" );
			a2 = o.getLong( "a2" );
			a3 = o.getInt( "a3" );
			a4 = o.getFloat( "a4" );
			a5 = o.getShort( "a5" );
			a6 = o.getByte( "a6" );
			b = o.getBytes( "b" );

		}				@Override		public String toString() {			return "id="+id+","+"a8="+a8+","+"a7="+a7+","+"name="+name+","+"a1="+a1+","+"a2="+a2+","+"a3="+a3+","+"a4="+a4+","+"a5="+a5+","+"a6="+a6+","+"b="+b;		}	}

}