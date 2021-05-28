package spring5_rest_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class,ContextSqlSession.class,MvcConfig.class})
@ComponentScan(basePackages = {
		"spring5_rest_study.mapper",
		"spring5_rest_study.service"
		})
public class ContextRoot {

}
