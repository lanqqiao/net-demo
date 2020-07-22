package com.lqq.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LocaleMessage {

    public static void main(String[] args) {

        Locale locale = new Locale("zh", "CH");
        System.out.println(locale.getCountry());
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);

        String pattern1 = "{0},你好！你于{1}在工商银行存入{2}元";
        String pattern2 = "At {1, time, short} On{1, date, long} {0} paid {2, number, currency}";

        Object[] params = {"John", new GregorianCalendar().getTime(), 10000};

        String msg1 = MessageFormat.format(pattern1, params);
        System.out.println(msg1);
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg2);

        String[] configs = {"beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        Object[] paramss = {"John", new GregorianCalendar().getTime()};
        String str1 = ctx.getMessage("test", paramss, Locale.US);
        String str2 = ctx.getMessage("test", paramss, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }
}
