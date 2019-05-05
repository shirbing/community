package com.wxb.community.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class ValidationCode {
	//声明一个String 字符串
	String valid="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	//随机生成字符串
	public String getCode(){
		//初始化一个可变字符串
		StringBuilder str=new StringBuilder();
		//2.通过随机函数  获取字符串的字符
		ThreadLocalRandom random=ThreadLocalRandom.current();
		for (int i = 0; i < 4; i++) {
			//1.生成随机数
			int num=random.nextInt(0,valid.length());
			char c=valid.charAt(num);
			//追加字符串
			str.append(c);
		}
		return str.toString();
	}
	//通过验证码 创建一张图片
	public BufferedImage createImg(String str){
		int width=80;
		int height=50;
		BufferedImage  img=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取图片的上下文
		Graphics g=img.getGraphics();
		//设置图片背景颜色
		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);

		//绘制文字
		g.setColor(Color.yellow);
		g.setFont(new Font("楷体",Font.BOLD,30));
		g.drawString(str, 5, 35);

		return img;
	}
}
