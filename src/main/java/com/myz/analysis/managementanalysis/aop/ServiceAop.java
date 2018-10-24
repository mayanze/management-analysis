package com.myz.analysis.managementanalysis.aop;

import com.myz.analysis.managementanalysis.base.entity.BaseEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/9/19 08:55
 * @Description: view 切面
 */
@Aspect
@Component
public class ServiceAop {
    /**
     * 业务层拦截器
     * 凡是参数集成了BaseEntity实体类的
     * 都会设置日期会当前日期
     *
     * @auther mayanze
     * @date 2018/9/19 上午9:11
     * @param point  连接点
     * @return 
     */
    @Before(value = "execution(* com.myz.analysis.managementanalysis.view.*.save*(..))")
    public void setDate(JoinPoint point){
        Object[] args = point.getArgs();
        for (Object arr : args) {
            if(arr instanceof BaseEntity){
                BaseEntity entity = (BaseEntity) arr;
                entity.setDate(new Date());
                break;
            }
        }
    }
}
