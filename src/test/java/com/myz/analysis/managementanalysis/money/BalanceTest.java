package com.myz.analysis.managementanalysis.money;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 * @Auther: mayanze
 * @Date: 2018/9/29 22:52
 * @Description: 攒钱测试
 */
public class BalanceTest {
    @Test
    public void contextLoads() {
        /*当前月收入减掉支出=余额
         * 加上之前月份余额初以月数量=平均余额
         * *要统计计划攒钱几个月的数量
         * =预计的攒钱数量
         */

        //现在余额 = 支付宝余额 + 银行卡余额 - 回家给两个姐每个孩子100 共500 - 借哥的6000 - 给家里吗放的2000 生活费
        BigDecimal beforeBalance = new BigDecimal(5072 + 456 - 500 - 6000 - 2000);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long afterTime = dateFormat.parse("2019-06-10").getTime();
            long nowTime = new Date().getTime();

            BigDecimal month = new BigDecimal(afterTime)
                    .subtract(new BigDecimal(nowTime))
                    .divide(new BigDecimal(1000), 3, ROUND_HALF_DOWN)
                    .divide(new BigDecimal(60), 3, ROUND_HALF_DOWN)
                    .divide(new BigDecimal(60), 3, ROUND_HALF_DOWN)
                    .divide(new BigDecimal(24), 3, ROUND_HALF_DOWN)
                    .divide(new BigDecimal(30), 3, ROUND_HALF_DOWN);


            BigDecimal income = new BigDecimal(6000)
                    .multiply(new BigDecimal(2))
                    .add(new BigDecimal(7500)
                    .multiply(
                            month.subtract ( new BigDecimal(2)))
                    );//总收入
            BigDecimal pay = new BigDecimal(3000) .multiply(month) ;

            BigDecimal balance = (income .subtract(pay).add(beforeBalance)).divide(new BigDecimal(10000));

            System.out.println("预计能攒 " + balance + " ¥");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
