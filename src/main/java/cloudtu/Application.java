package cloudtu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import cloudtu.bean.Author;
import cloudtu.bean.DbName;

// @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
// 匯入 XML 格式的 spring 設定檔
@ImportResource("classpath:application-context.xml")
// 設定 property file 設定檔的來源位置
@PropertySource("classpath:author.properties")
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);   
    
    // author.properties 裡的 author.* 設定會自動綁定到 authorName, authorDept 變數
    @Value("${author.name}") private String authorName;    
    @Value("${author.department}") private String authorDept;
    
    @Bean
    public Author author(){
        Author author = new Author();
        // 手工指定 author bean 裡的各項 setter 設定
        author.setName(authorName);
        author.setDepartment(authorDept);
        return author;
    }
    
    @Bean
    // application.properties 裡的 db.prd.* 設定會自動綁定到 prdDbName bean
    @ConfigurationProperties(prefix="db.prd")
    @Profile("prd")
    public DbName prdDbName(){
        return new DbName();
    }
    
    @Bean
    // application.properties 裡的 db.dev.* 設定會自動綁定到 devDbName bean
    @ConfigurationProperties(prefix="db.dev")
    @Profile("dev")
    public DbName devDbName(){
        return new DbName();
    }
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);        
        
        logger.debug("hello bean content : " + context.getBean("hello").toString());
        logger.debug("author bean content : " + context.getBean("author").toString());
        logger.debug("welcome bean content : " + context.getBean("welcome").toString());
        logger.debug("appVersion bean content : " + context.getBean("appVersion").toString());        
        if(context.containsBean("prdDbName")){
            logger.debug("prdDbName bean content : " + context.getBean("prdDbName").toString());
        }        
        if(context.containsBean("devDbName")){
            logger.debug("devDbName bean content : " + context.getBean("devDbName").toString());
        }
    }
}
