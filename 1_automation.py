from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.set_window_size(1920, 1080)
# https://www.thlib.org/reference/transliteration/wyconverter.php
# text_box_area = id_txt
driver.set_window_size(0,0)
# driver.set_window_size(0,0)

driver.close()
