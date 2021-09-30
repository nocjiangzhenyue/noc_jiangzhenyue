package com.noc.springmvcfs.aop;

import com.noc.springmvcfs.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
@EnableAspectJAutoProxy
public class UserAspect {
    @Pointcut("execution(* com.noc.springmvcfs.controller.UserController.addUser(..))&&args(user)")
    public void point(User user){}

    @Around(value = "point(user)", argNames = "joinPoint,user")
    public Object around(ProceedingJoinPoint joinPoint, User user){
        Object[] args = new Object[]{user};
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String answer = "name:" + user.getName()
                + ", age:" + user.getAge()
                + "\n" + "当前时间：" + df.format(new Date()) + "\n";
        Object ret = null;
        try {
            ret = joinPoint.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return answer + ret;
    }
}
