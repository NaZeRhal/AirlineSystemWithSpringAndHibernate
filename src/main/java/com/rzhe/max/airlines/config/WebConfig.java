package com.rzhe.max.airlines.config;

import com.rzhe.max.airlines.utils.LocalDateFormatter;
import com.rzhe.max.airlines.utils.LocalDateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.rzhe.max.airlines"})
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

    //     <=> <mvc:view-controllers ... />
//    Определяет простые автоматизированные
//    контроллеры, предварительно сконфигурированные с ответным кодом состояния
//    и/или представлением для воспроизведения тела ответа.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("hello");
    }

    // <=> <mvc:default-servlet-handler/>
    //Активизирует обработчик статических ресурсов.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    //служит для загрузки сообщений из определенных файлов, предназначенных для интернационализации
    @Bean
    ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/i18n/messages", "WEB-INF/i18n/application");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    // в классе LocaleChangeInterceptor из модуля Spring MVC
    // определяется перехватчик всех запросов к сервлету диспетчера типа DispatcherServlet.
    // В конфигурации этого перехватчика
    // определяется параметр URL под именем lang для смены региональных настроек веб-приложения.
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    // поддерживается хранение и извлечение региональных настроек из сооkiе-файла пользовательского браузера
    @Bean
    CookieLocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieMaxAge(3600);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver;
    }

    @Bean
    public Validator validator() {
        final LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    // <=> <mvc:annotation-driven validator="validator"/>
    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public LocalDateFormatter localDateFormatter() {
        return new LocalDateFormatter();
    }

    @Bean
    public LocalDateTimeFormatter localDateTimeFormatter() {
        return new LocalDateTimeFormatter();
    }

    //добавление форматтеров для форматирования отображения дат
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(localDateFormatter());
        registry.addFormatter(localDateTimeFormatter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
