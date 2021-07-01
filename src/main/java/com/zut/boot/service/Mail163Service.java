package com.zut.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author 梁贵莹
 * @create 2021/7/1 下午 3:42
 */
@Service
public class Mail163Service {
    @Autowired
    private JavaMailSender javaMailSender;
    public void send1(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //设置标题
        simpleMailMessage.setSubject("测试springbootmail-1");
        //内容
        simpleMailMessage.setText("1+1=2");
        //指定发送时间
        simpleMailMessage.setSentDate(new Date());
        //指定发送人
        simpleMailMessage.setFrom("15236603373@163.com");
        //指定接收人
        simpleMailMessage.setTo(("lgvying@163.com"));
        //发送
        javaMailSender.send(simpleMailMessage);
    }
    public void send2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        //设置标题
        mimeMessageHelper.setSubject("测试springbootmail-2");
        //设置发送人
        mimeMessageHelper.setFrom("15236603373@163.com");
        //设置接收人
        mimeMessageHelper.setTo("lgvying@163.com");
        //内容  true 表示是html内容
        mimeMessageHelper.setText("<p>hello大家好，这是一封测试邮件，这封邮件包含两种图片，分别如下</p>" +
                "<p>第一张图片：</p><img src='cid:p01'/>" +
                "<p>第二张图片：</p><img src='cid:p02'/",true);
        //添加文件内容
        mimeMessageHelper.addInline("p01",new FileSystemResource(new File("C:\\Users\\GuiyingLiang\\Desktop\\jpg\\bora-bora-french-polynesia-sunset.jpg")));
        mimeMessageHelper.addInline("p02",new FileSystemResource(new File("C:\\Users\\GuiyingLiang\\Desktop\\jpg\\中工.jpg")));
        //添加文件附件
        mimeMessageHelper.addAttachment("附件1",new File("C:\\Users\\GuiyingLiang\\Desktop\\jpg\\t1.jpg"));
        mimeMessageHelper.addAttachment("附件2",new File("C:\\Users\\GuiyingLiang\\Desktop\\jpg\\t2.jpg"));
        //发送
        javaMailSender.send(mimeMessage);

    }
}
