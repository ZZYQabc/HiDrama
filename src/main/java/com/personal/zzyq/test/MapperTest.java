package com.personal.zzyq.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.personal.zzyq.bean.Drama;
import com.personal.zzyq.bean.Type;
import com.personal.zzyq.dao.DramaMapper;
import com.personal.zzyq.dao.TypeMapper;


/* 测试dao层
 推荐spring的项目使用spring的单元测试，可以自动注入我们需要的组件
 1.导入springTest模块
 2.使用@ContextConfiguration指定spring配置文件的位置
 3.直接autowired要使用的组件即可
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	TypeMapper typeMapper;
	
	@Autowired
	DramaMapper dramaMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
//	测试type的Mapper
	
	@Test
	public void tesrCRUD() {
		/*
		 * //1.创建SpringIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //2.从容器中获取mapper
		 * TypeMapper bean = ioc.getBean(TypeMapper.class);
		 */
		//System.out.println(typeMapper);
		//1.插入几个类型
		
//		typeMapper.insertSelective(new Type(1,"动漫"));
//		typeMapper.insertSelective(new Type(2,"电视剧"));
		
		//2.生成剧集数据,测试剧集插入
		//dramaMapper.insertSelective(new Drama(null, 1, 1, "斗罗大陆", 0, 92, null, null));
		//3.批量插入多个剧集，使用可以执行批量操作的sqlsession
//		for (int i = 0; i < array.length; i++) {
//			dramaMapper.insertSelective(new Drama(null, 1, 1, , 0, , null, null));
//		}
		DramaMapper mapper = sqlSession.getMapper(DramaMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5);
			mapper.insertSelective(new Drama(null, 1, 1, uid, 0, 0, null, null));
		}
	}
}
