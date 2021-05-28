package spring5_rest_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class,ContextSqlSession.class,MvcConfig.class})
@ComponentScan(basePackages = {
		
		})
public class ContextRoot {

}
