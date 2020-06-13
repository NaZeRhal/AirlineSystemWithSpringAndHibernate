package com.rzhe.max.airlines.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.rzhe.max.airlines.controllers"})
public class WebConfig implements WebMvcConfigurer {

    // объявить статические ресурсы
    //Вводит обработчики, предназначенные для
    //обслуживания таких статических ресурсов, как изображения, сценарии
    //JavaScript и файлы стилевых таблиц CSS, извлекаемых из отдельных мест
    //и находящихся по иерархии ниже корневого узла веб-приложения, по пути к
    //классам
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/")
                .setCachePeriod(31556926);
    }

    //Объявляет распознаватель представлений типа
    //InternalResourceViewResolver, выполняющий сопоставление символических
    //имен представлений с шаблонами* .jsp по пути /WEB-INF/views.
    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setRequestContextAttribute("requestContext");
        return viewResolver;
    }

    // <=> <mvc:view-controllers ... />
    //Определяет простые автоматизированные
    //контроллеры, предварительно сконфигурированные с ответным кодом состояния
    //и/или представлением для воспроизведения тела ответа.
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("airports/list");
//    }

    // <=> <mvc:default-servlet-handler/>
    //Активизирует обработчик статических ресурсов.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
