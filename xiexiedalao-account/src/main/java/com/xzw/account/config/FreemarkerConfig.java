package com.xzw.account.config;

import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author xieziwei
 * @version 2021/8/20
 * @description
 */
@Configuration
public class FreemarkerConfig {

    private static final Logger logger = LoggerFactory.getLogger(FreemarkerConfig.class);

    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${copyright.name}")
    private String foot;
    @Autowired
    private freemarker.template.Configuration configuration;
    @Autowired
    private FreemarkerCfg freemarkerCfg;

    @PostConstruct
    private void init(){
        configuration.setAutoImports(freemarkerCfg.getAutoImports());
        try {
            // 设置共享数据
            configuration.setSharedVariable("base",contextPath);
            configuration.setSharedVariable("foot",foot);
        } catch (TemplateModelException e) {
            logger.info("初始化模板数据出错");
            e.printStackTrace();
        }
    }

    @Configuration
    @ConfigurationProperties(prefix = "spring.freemarker.config")
    public static class FreemarkerCfg{
        private Map autoImports;

        public Map getAutoImports() {
            return autoImports;
        }
        public void setAutoImports(Map autoImport) {
            this.autoImports = autoImport;
        }
    }
}
