package io.github.CarolinaCedro.sumaxSoft.aplication.errors.exception;



import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;

@Component
public class ExceptionManager {

    @Resource
    Environment environment;

    public CustomException create(String code) {
        return new CustomException(code, environment.getProperty(code));
    }
}