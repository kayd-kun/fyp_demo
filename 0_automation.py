from selenium.webdriver import Firefox
from selenium.webdriver.firefox.options import Options

opts = Options()
opts.add_argument('--headless')
browser = Firefox(options=opts)

result = browser.get('https://duckduckgo.com')
print(type(result))
print('=====================')
print(result)

# from selenium import webdriver 
# from selenium.webdriver.chrome.options import Options
# chrome_options = Options()
# #chrome_options.add_argument("--disable-extensions")
# #chrome_options.add_argument("--disable-gpu")
# #chrome_options.add_argument("--no-sandbox") # linux only
# chrome_options.add_argument("--headless")
# # chrome_options.headless = True # also works
# driver = webdriver.Chrome(options=chrome_options)
# start_url = "https://duckgo.com"
# driver.get(start_url)
# print(driver.page_source.encode("utf-8"))
# # b'<!DOCTYPE html><html xmlns="http://www....
# driver.quit()