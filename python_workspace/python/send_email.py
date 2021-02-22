import smtplib
from email.mime.text import MIMEText #mail 正文
from email.header import Header # mail 

from email.mime.multipart import MIMEMultipart
from email.mime.image import MIMEImage

# 成功开启POP3/SMTP服务,在第三方客户端登录时，密码框请输入以下授权码：
# fbcdcwapmjtkbicd
# 成功开启IMAP/SMTP服务,在第三方客户端登录时，密码框请输入以下授权码：
# funolqabfwpicaai

def html_mail_image():
    #login
    smtp_obj = smtplib.SMTP_SSL("smtp.qq.com",465)
    smtp_obj.login("hnchenhairong2008@qq.com","fbcdcwapmjtkbicd")
    smtp_obj.set_debuglevel(1) #show debug info

    mail_body='''
    <h5>hello</h5>
    <p>
        python send email...<a href="http://www.baidu.com">link</a></p>
        <p><img src="cid:image1"</p>
    </p>
    '''
    # mail body
    msg = MIMEMultipart('related')#充许添加附件，图片等
    msg["From"]=Header("rong","utf-8")# 发送者
    msg["To"] = Header("to","utf-8")#接收者
    msg["Subject"]=Header("rong letter","utf-8")#主题

    #充许添加附件，图片
    msgAlternative=MIMEMultipart("alternative")
    msgAlternative.attach(MIMEText(mail_body,"html","utf-8"))

    msg.attach(msgAlternative)#邮件正文加到msg中

    # add image
    fp = open("python\\utc.png","rb")
    msgImage=MIMEImage(fp.read())
    fp.close()

    #define the iamge ID,在HTML 文本中引用
    msgImage.add_header("Content-ID","<imagel>")
    msg.attach(msgImage) #添加图片到msg对象里

    #send 
    smtp_obj.sendmail("hnchenhairong2008@qq.com",["baitxaps@126.com","150558115@qq.com"],msg.as_string())


def html_mail():
    #login
    smtp_obj = smtplib.SMTP_SSL("smtp.qq.com",465)
    smtp_obj.login("hnchenhairong2008@qq.com","fbcdcwapmjtkbicd")
    #smtp_obj.set_debuglevel(1) #show debug info

    mail_body='''
    <h5>hello</h5>
    <p>
        python send email...<a href="http://www.baidu.com">link</a></p>
    </p>
    '''
    # mail body
    msg = MIMEText(mail_body,"html","utf-8")
    msg["From"]=Header("rong","utf-8")# 发送者
    msg["To"] = Header("to","utf-8")#接收者
    msg["Subject"]=Header("rong letter","utf-8")#主题

    #send 
    smtp_obj.sendmail("hnchenhairong2008@qq.com",["baitxaps@126.com","150558115@qq.com"],msg.as_string())

def plain_mail():
    #login
    smtp_obj = smtplib.SMTP_SSL("smtp.qq.com",465)
    smtp_obj.login("hnchenhairong2008@qq.com","fbcdcwapmjtkbicd")

    # mail body
    msg = MIMEText("hello,python send email...","plain","utf-8")
    msg["From"]=Header("rong","utf-8")# 发送者
    msg["To"] = Header("to","utf-8")#接收者
    msg["Subject"]=Header("rong letter","utf-8")#主题

    #send 
    smtp_obj.sendmail("hnchenhairong2008@qq.com",["baitxaps@126.com","150558115@qq.com"],msg.as_string())

html_mail_image()
#html_mail()
#plain_mail()
