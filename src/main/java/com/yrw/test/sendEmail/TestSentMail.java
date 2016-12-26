package com.yrw.test.sendEmail;

import javax.mail.MessagingException;

public class TestSentMail {

	public static void main(String[] args)  {

		SendMail mail = new SendMail();
		try {
			mail.sendEmail("对象","能看见吗");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
