package cn.liu.hui.peng;

import cn.liuhp.base.config.ConfigurationPropertiesTest;
import cn.liuhp.domain.XmlCreateBean;
import cn.liuhp.utils.JackJsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigJunitTest {


	@Autowired
	ApplicationContext ioc;

	@Autowired
	ConfigurationPropertiesTest configurationPropertiesTest;

	@Autowired
	XmlCreateBean xmlCreateBean;

	@Test
	public void testConfigTest() {
		System.out.println(JackJsonUtils.beanToJson(configurationPropertiesTest));
	}

	@Test
	public void testXmlCreateBean() {
		System.out.println(JackJsonUtils.beanToJson(xmlCreateBean));
	}

	@Test
	public void testIoc(){
		boolean b = ioc.containsBean("xmlCreateBean");
		System.out.println(b);
	}


}
