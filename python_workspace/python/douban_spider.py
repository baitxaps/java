import requests 
import bs4    # Beautifulsoup4 解释网页
import re     # 正规表达式

# pip install requests
# pip install Beautifulsoup4 # Beautifulsoup4-4.9.3

# FileNotFoundError: 系统找不到指定的文件
# 'site-packages\\chardet-5.0.0.dev0-py3.7.egg
# requests.get()返回数据乱码解决办法:
#   https://blog.csdn.net/wp7xtj98/article/details/112765324
# f12  to debug

# url_string=f'''
#     HTML在线解析
#     https://tool.ip138.com/html/
# '''

headers = {
    'Accept':'text/html,application/xhtml+xml,application/xml;\
            q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8, \
             application/signed-exchange;v=b3;q=0.9' ,#"*/*",
    'Accept-Encoding':'gzip, deflate',
    'Accept-Language':'zh-CN,zh;q=0.9',
    'Connection':'keep-alive',
    'Host':'www.douban.com',
    'Cache-Control':'no-cache',
    'Referer':'https://m.douban.com/movie/subject/1309120/',
    'User-Agent': 'Mozilla/5.0 (Linux; Android 6.0; \
        Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.'
}

# https://www.douban.com/group/topic/70867518//
def download_page(url):
    """
    下载指定页面及其所有的分页
    """
    res = requests.get(url,headers = headers)
    #resbs4_obj = bs4.Beautifulsoup4(res.text,"lxml")
    #res.encoding = 'UTF-8'
    #res.encoding = res.apparent_encoding
    #print(res.text)
    bs4_obj = bs4.BeautifulSoup(res.text,"html.parser")
    if bs4_obj:
        bs4_page_obj_list=[bs4_obj]   # the first page to  save to list 

    # get all pageController to download
    url_set = set() # 去重存下所的分页的url
    pageinator_ele = bs4_obj.find("div",attrs={"class":"paginator"})
    #print(pageinator_ele)
    if pageinator_ele:
        for e in pageinator_ele.find_all("a"):
            #print(e.attrs.get("href"))
            url_set.add(e.attrs.get("href"))

        for url in url_set:
            print(f"download the page:{url}")
            res = requests.get(url,headers=headers)
            bs4_page_obj = bs4.BeautifulSoup(res.text,"html.parser")
            bs4_page_obj_list.append(bs4_page_obj) # save data to list

    return bs4_page_obj_list

def fetch_emails(page_obj_list):
    mail_list=[]
    for bs4_obj in page_obj_list:
        comment_elem = bs4_obj.find_all("div",attrs={"class":"reply-doc"})
        #print(comment_elem)
        for elem in comment_elem:
            reply_elem= elem.find("p",attrs={"class":"reply-content"})
            #print(ct)
            email_addr = re.search("\w+@\w+.\w+",reply_elem.text,flags=re.A)
            #print(email_addr)
            if email_addr:
                pub_time = elem.find("span",attrs={"class":"pubtime"})
                print(email_addr.group(),pub_time.text)
                mail_list.append([email_addr.group(),pub_time.text])
        print(len(mail_list))    

all_bs4_page_list = download_page("https://www.douban.com/group/topic/70867518//")
fetch_emails(all_bs4_page_list)




