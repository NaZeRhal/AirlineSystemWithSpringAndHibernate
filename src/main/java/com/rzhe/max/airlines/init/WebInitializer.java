package com.rzhe.max.airlines.init;

import com.rzhe.max.airlines.config.AppContext;
import com.rzhe.max.airlines.config.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //метод создает корневой контекст приложения с помощью данных конфиг-классов
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppContext.class};
    }

    //метод создает контекст веб-приложения с помощью данного конфиг-класса
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //метод сопоставления для DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //массив фильтров для применения к каждому запросу
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding("UTF-8");
        cef.setForceEncoding(true);
        return new Filter[]{new HiddenHttpMethodFilter(), cef};
        //HiddenHttpMethodFilter поддерживает другие методы доступа по сетевому
        //протоколу НТТР, кроме GET и POST (например,
        //метода PUT
    }
}
