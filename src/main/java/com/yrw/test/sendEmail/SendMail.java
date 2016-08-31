package com.yrw.test.sendEmail;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
		String host="smtp.exmail.qq.com";
	    public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getToAddressList() {
			return toAddressList;
		}

		public void setToAddressList(String toAddressList) {
			this.toAddressList = toAddressList;
		}

		Integer port=465;
	    String username = "wangruy@cnepay.com";
	    String password = "Wangruyi0725";
	    String from = "wangruy@cnepay.com";;
	    String toAddressList="wangruy@cnepay.com,151278461@qq.com";
		public void sendEmail(String subject, String content) throws MessagingException {
	        sendEmail(this.host, this.port, this.username, this.password, this.from, this.toAddressList, subject, content, null);
	    }

		public void sendEmail(String host, Integer port, final String username, final String password, String from,
				String toAddressList, String subject, String content, Collection<File> files) throws MessagingException {
			// 构造mail session
			Properties props = new Properties();
			props.put("mail.smtp.host", host);

			if (port != null) {
				props.put("mail.smtp.port", port.intValue());
			}

			props.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				public javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(username, password);
				}
			});

			// 构造邮件MimeMessage 并设定基本的值
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));

			// msg.addRecipient(Message.RecipientType.TO, address);
			// //这个只能是给一个人发送email
			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(toAddressList));// 匿名抄送
			// subject = transferChinese(subject); //处理标题的中文乱码问题
			msg.setSubject(subject);

			// 构造邮件主体Multipart(包含正文和附件)
			Multipart multipart = new MimeMultipart();

			// 构造邮件正文并添加到邮件主体
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(content, "text/html;charset=gbk");
			multipart.addBodyPart(mimeBodyPart);

			// 构造邮件附件并添加到邮件主体
			if (files != null) {
				for (File file : files) {
					MimeBodyPart mbpart = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(file);
					mbpart.setDataHandler(new DataHandler(fds));

					try {
						String filename = new String(fds.getName().getBytes("gbk"), "ISO-8859-1");// 解决附件文件名乱码
						mbpart.setFileName(filename);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						mbpart.setFileName(fds.getName());
					}

					multipart.addBodyPart(mbpart);// 附件增加到邮件主体
				}
			}

			msg.setContent(multipart);
			msg.setSentDate(new Date());
			msg.saveChanges();

			// 发送邮件
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("email发送出去");
		}
	}