package Yf
/**
  * Created by adel on 24.07.16.
  */

import java.io.File




object Yf extends App {


  def moveFiles(directoryName: String) = {

    def getListOfFiles(directoryName: String): Array[String] = {
      new File(directoryName).listFiles.filter(_.isFile).map(_.getName)
    }


    def move(file: String, newdir: String) = {

      var oldFile = new File(directoryName + file)
      var newFile = new File(directoryName + newdir +"/"+ file)
      newFile.getParentFile.mkdirs()

      oldFile.renameTo(newFile)

    }

    var dir : Array[String] = getListOfFiles(directoryName)

    for (c <- dir.indices) {
      if (dir(c).length>10) {
        move(dir(c).toString, dir(c).toString.substring(0, 10))
      }
    }


  }



  val dirname= "/Users/adel/Yandex.Disk.localized/Фотокамера/"
  //val dirname= "/Users/adel/Фотокамера/"

  moveFiles(dirname)



}
