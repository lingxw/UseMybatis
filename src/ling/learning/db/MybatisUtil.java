package ling.learning.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	   private static SqlSessionFactory sqlSessionFactory;
	   static {
	       try {
	           Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
	           sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }

	   public static SqlSession getSession(){
	       return sqlSessionFactory.openSession();
	   }
}
