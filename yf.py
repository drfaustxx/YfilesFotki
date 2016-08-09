#!/usr/bin/python
# coding=UTF-8

import os

directory = '/Users/adel/Yandex.Disk.localized/Фотокамера/'
files = os.listdir(directory)

for fileName in files:
    if len(fileName)>10:
        oldFile = directory + fileName
        newPath = directory + fileName[:10]
        newFile = newPath + "/" + fileName

        if not os.path.exists(newPath):
            os.makedirs(newPath)
        os.rename(oldFile, newFile)

