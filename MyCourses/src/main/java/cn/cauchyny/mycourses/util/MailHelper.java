package cn.cauchyny.mycourses.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailHelper {

    private final Log log = LogFactory.getLog(this.getClass());

    private JavaMailSender mailSender = new JavaMailSenderImpl();

    private static final String from = "1092792221@qq.com";

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        System.out.println(from);
        System.out.println(to);
        System.out.println(subject);
        System.out.println(content);

        if (mailSender != null) {
            mailSender.send(message);
        } else {
            System.out.println("初始化失败");
        }
    }

}
