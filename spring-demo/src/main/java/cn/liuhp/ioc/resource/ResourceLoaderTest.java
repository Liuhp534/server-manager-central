package cn.liuhp.ioc.resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @description: 资源加载类
 * @author: liuhp534
 * @create: 2019-06-21 14:26
 */
public class ResourceLoaderTest {

    public static void main(String[] args) {
        //test1();
        //testUrl();
        //testHttp();
        //testFileResourceLoader();
        //testPatchResourceLoader();
        testApplicationContent();
    }


    /*加载路径资源*/
    private static void test1() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fileResource = resourceLoader.getResource("C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof FileSystemResource);
        System.out.println(fileResource.exists());
    }

    /*加载路径资源,带有协议前缀的*/
    private static void testUrl() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fileResource = resourceLoader.getResource("file:C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof UrlResource);
        System.out.println(fileResource.exists());
    }

    /*加载路径资源,带有协议前缀的*/
    private static void testHttp() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fileResource = resourceLoader.getResource("http://www.baidu.com");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof UrlResource);
        System.out.println(fileResource.exists());
    }

    /*特定的资源加载器，加载路径资源*/
    private static void testFileResourceLoader() {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileResource = resourceLoader.getResource("C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof FileSystemResource);
        System.out.println(fileResource.exists());
        System.out.println(System.lineSeparator());
        fileResource = resourceLoader.getResource("file:C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof UrlResource);
        System.out.println(fileResource.exists());
    }

    /*批量处理资源的加载*/
    private static void testPatchResourceLoader() {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();//其中一个实现类，默认是DefaultResourceLoader加载策略
        Resource fileResource = resourcePatternResolver.getResource("C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof FileSystemResource);
        System.out.println(fileResource.exists());
        System.out.println("使用其他资源加载策略");
        resourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());//其中一个实现类，默认是DefaultResourceLoader加载策略
        fileResource = resourcePatternResolver.getResource("C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof FileSystemResource);
        System.out.println(fileResource.exists());
    }


    /*把applicationContent当做资源加载器*/
    private static void testApplicationContent() {
        ResourceLoader resourceLoader =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Resource fileResource = resourceLoader.getResource("C:\\Users\\liuhp\\Desktop\\我的pdf\\阿里巴巴java代码规范v1.2.0.doc");
        System.out.println(fileResource instanceof ClassPathResource);
        System.out.println(fileResource instanceof FileSystemResource);
        System.out.println(fileResource.exists());
    }


}
