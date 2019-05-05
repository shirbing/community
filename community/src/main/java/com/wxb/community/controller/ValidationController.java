package com.wxb.community.controller;

import com.wxb.community.util.ValidationCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/val")
public class ValidationController {
    @RequestMapping("/getValimg")
    public void getValimg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //处理数据
        //生成随机字符串
        ValidationCode va=new ValidationCode();
        String code=va.getCode();
        //将验证码存放在session
        if(code != null){
            req.getSession().setAttribute("CODE_SESSION_KEY",code);
        }
        //生成图片
        BufferedImage img=va.createImg(code);
        //数据响应给客户端
        ImageIO.write(img, "JPEG",resp.getOutputStream());
    }
}
