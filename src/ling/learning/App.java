package ling.learning;

import org.apache.ibatis.session.SqlSession;

import ling.learning.db.MybatisUtil;
import ling.learning.db.entity.JdtBinding;

public class App {
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSession();
		JdtBinding binding = new JdtBinding();
		binding.setPath("d:");
		binding.setName("a.java");
		binding.setKey("ling.learning.A");
		binding.setSrcId(1);
		int id = session.insert("JdtDao.insertBinding", binding);
		System.out.println(id);
		System.out.println(binding.getId());
		session.commit();
		session.close();
	}
}
