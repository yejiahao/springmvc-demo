package org.yejh.demo.mail;

import org.apache.log4j.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

public class MailTest {
    private static final Logger logger = Logger.getLogger(MailTest.class);

    private static String sendEmailAccount = "454696086@qq.com";
    private static String sendEmailSMTPPassword = "mddxvayxkxkxbggi";
    private static String sendEmailSMTPHost = "smtp.qq.com";
    private static String[] receiveEmailAccount = new String[]{"244102959@qq.com", "632562364@qq.com",
            "jiahao.ye@frontpay.cn"};

    public static void main(String[] args) {
        // MailSSLSocketFactory sf = null;
        // try {
        // sf = new MailSSLSocketFactory();
        // } catch (GeneralSecurityException e) {
        // logger.error("(main)GeneralSecurityException: ", e);
        // }
        // sf.setTrustAllHosts(Boolean.TRUE);

        logger.info("props start: -------------------------");
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", sendEmailSMTPHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.user", sendEmailAccount);
        props.put("mail.smtp.password", sendEmailSMTPPassword);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        // props.put("mail.smtp.ssl.socketFactory", sf);
        logger.info("props end: -------------------------");

        Session session = Session.getDefaultInstance(props);
        session.setDebug(Boolean.TRUE);

        logger.info("message start: -------------------------");
        MimeMessage message = MailTest.createMimeMessage(session, sendEmailAccount, receiveEmailAccount);
        logger.info("message end: -------------------------");

        try {
            logger.info("transport start: -------------------------");
            Transport transport = session.getTransport();
            transport.connect(sendEmailAccount, sendEmailSMTPPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            logger.info("transport end: -------------------------");
        } catch (Exception e) {
            logger.error("(main)Exception: ", e);
        }

    }

    private static MimeMessage createMimeMessage(Session session, String sendEmailAccount,
                                                 String[] receiveEmailAccount) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendEmailAccount, "USER_FROM", "UTF-8"));
            message.setRecipient(MimeMessage.RecipientType.TO,
                    new InternetAddress(receiveEmailAccount[0], "USER_TO", "UTF-8"));
            message.addRecipient(MimeMessage.RecipientType.TO,
                    new InternetAddress(receiveEmailAccount[1], "USER_TO_ADD", "UTF-8"));
            message.setRecipient(MimeMessage.RecipientType.CC,
                    new InternetAddress(receiveEmailAccount[2], "USER_CC", "UTF-8"));
            message.setRecipient(MimeMessage.RecipientType.BCC,
                    new InternetAddress(sendEmailAccount, "USER_BCC", "UTF-8"));

            message.setSubject("QQ邮箱Java邮件测试Subject", "UTF-8");
            message.setContent("使用一张霸王餐券。", "text/html;charset=UTF-8");

            message.setSentDate(new Date());

            message.saveChanges();

            OutputStream os = new FileOutputStream("sendEmail.eml");
            message.writeTo(os);
            os.flush();
            os.close();
            return message;
        } catch (Exception e) {
            logger.error("(createMimeMessage)Exception: ", e);
        }
        return null;
    }
}
