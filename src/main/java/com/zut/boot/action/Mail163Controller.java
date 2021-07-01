package com.zut.boot.action;

import com.zut.boot.service.Mail163Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * @author 梁贵莹
 * @create 2021/7/1 下午 4:08
 */
@RestController
@RequestMapping("/mail")
public class Mail163Controller {
    @Autowired
    private Mail163Service mail163Service;
    @RequestMapping("/send1")
    public String send1(){
        mail163Service.send1();
        return "succsee1111!";
    }
    @RequestMapping("/send2")
    public String send2() throws MessagingException {
        mail163Service.send2();
        return "succsee2222!";
    }
}
