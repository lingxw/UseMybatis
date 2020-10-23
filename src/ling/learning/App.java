package ling.learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import ling.learning.db.MybatisUtil;
import ling.learning.db.entity.JdtBinding;

public class App {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("(/[^/]*;)");
		String text = "[co.jp.aa/com/d:\\doc\\fac.java;cee()Visit/d:\\\\doc\\\\fac1.java;Microsoft!";
		Matcher m = p.matcher(text); 

		int count = 0;

		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m.start());
			System.out.println("end(): " + m.end());
			System.out.println("match: " + m.group(1));
		}
		
		String replace = m.replaceAll("/");
		System.out.println(text + "\r\n" + replace);
		
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
