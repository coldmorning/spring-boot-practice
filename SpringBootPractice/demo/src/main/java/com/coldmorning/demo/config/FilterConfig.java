package com.coldmorning.demo.config;

import com.coldmorning.demo.filter.LogApiStatusFilter;
import com.coldmorning.demo.filter.LogProcessTimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class FilterConfig {
    @Bean
    public FilterRegistrationBean logProcessTimeFilter() {
        FilterRegistrationBean<LogProcessTimeFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LogProcessTimeFilter());
        bean.addUrlPatterns("/*");
        bean.setName("logProcessTimeFilter");
        bean.setOrder(1);

        return bean;
    }

    @Bean
    public FilterRegistrationBean logApiFilter() {
        FilterRegistrationBean<LogApiStatusFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new LogApiStatusFilter());
        bean.setName("logApiFilter");
        bean.setOrder(2);
        return bean;
    }

}
