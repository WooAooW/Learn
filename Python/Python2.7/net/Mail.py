#encoding=utf-8

from email import encoders
from email.header import Header
from email.mime.text import MIMEText
from email.utils import parseaddr, formataddr

import smtplib

def _format_addr(s):
    name, addr = parseaddr(s)
    return formataddr((Header(name, 'utf-8').encode(), addr))

from_addr = "346886697@qq.com"
password = raw_input('Password: ')
to_addr = "973245301@qq.com"
smtp_server = "smtp.qq.com"
smtp_port = 465

msg = MIMEText('Hello, This Message is send by Python SMTP, please don\'t delete this  ', 'plain', 'utf-8')
msg['From'] = _format_addr('<%s>' % from_addr)
msg['To'] = _format_addr('<%s>' % to_addr)
msg['Subject'] = Header('PythonSMTP发送', 'utf-8').encode()

smtpObj = smtplib.SMTP_SSL()
smtpObj.connect(smtp_server, smtp_port)
smtpObj.set_debuglevel(1)
smtpObj.login(from_addr, password)
smtpObj.sendmail(from_addr, [to_addr], msg.as_string())