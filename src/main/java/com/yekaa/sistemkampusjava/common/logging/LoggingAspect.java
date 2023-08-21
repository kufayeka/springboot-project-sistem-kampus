package com.yekaa.sistemkampusjava.common.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.yekaa.sistemkampusjava.modules.datamahasiswa.controller.DataMahasiswaController.*(..))")
    private void restApi(){}

    @Pointcut("within(com.yekaa.sistemkampusjava.modules.datamahasiswa.controller.*)")
    private void withinPointCutExample(){}

    @Before("withinPointCutExample()")
    public void beforeExecutedLogging(){
        log.info("This is a log from aspect.");
    }
}
