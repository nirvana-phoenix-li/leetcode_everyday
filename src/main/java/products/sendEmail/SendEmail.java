package products.sendEmail;

// 文件名 SendEmail.java

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 发送邮件的工具类QQ
 * @author 宗潇帅
 * @Title SendEmailService
 * @时间   2017-1-5下午2:14:13
 */
public class SendEmail {

    public static void main(String[] args) throws Exception {
        send_email("hello","再试一下","2352502842@qq.com");
    }
    /**
     * 目前发送到163 qq个人邮箱可以，企业邮箱有问题
     * @param subject 邮件主题
     * @param text 邮件内容纯文本
     * @param mails 邮件地址多个用逗号隔开
     * @throws Exception
     */
    public static void send_email(String subject,String text,String mails) throws Exception{
        //用于读取配置文件
        Properties props=new Properties();
        //开启Debug调试
        props.setProperty("mail.debug", "true");
        //发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        //发送邮件服务器的主机名
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        //端口号
        props.setProperty("mail.smtp.port", "465");
        //发送邮件协议
        props.setProperty("mail.transport.protocol", "smtp");
        //开启ssl加密（并不是所有的邮箱服务器都需要，但是qq邮箱服务器是必须的）
        MailSSLSocketFactory msf= new MailSSLSocketFactory();
        msf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory",msf);
        //获取Session会话实例（javamail Session与HttpSession的区别是Javamail的Session只是配置信息的集合）
        Session session=Session.getInstance(props,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                //用户名密码验证（取得的授权吗）
                return new PasswordAuthentication ("2332054958@qq.com","mrycbeevipcwdjbh");
            }
        });

        //抽象类MimeMessage为实现类 消息载体封装了邮件的所有消息
        Message message=new MimeMessage(session);
        //设置邮件主题
        message.setSubject(subject);
        //封装需要发送电子邮件的信息
        message.setText(text);
        //设置发件人地址
        message.setFrom(new InternetAddress("2332054958@qq.com"));
        //此类的功能是发送邮件 又会话获得实例
        Transport transport=session.getTransport();
        //开启连接
        transport.connect();
        //设置收件人地址邮件信息
        String mailAddress[] = mails.split(",");
        for (int i = 0; i < mailAddress.length; i++) {
            transport.sendMessage(message,new Address[]{new InternetAddress(mailAddress[i])});
            //邮件发送后关闭信息
            transport.close();
        }

    }

}