package Yf

import java.io.File

object Yf extends App {


  val dirname= "/Users/adel/Yandex.Disk.localized/Фотокамера/"

  def moveFiles(directoryName: String) = {

    def getListOfFiles(directoryName: String): Array[String] = {
      new File(directoryName).listFiles.filter(_.isFile).map(_.getName)
    }


    def move(file: String, newdir: String) = {

      val oldFile = new File(directoryName + file)
      val newFile = new File(directoryName + newdir +"/"+ file)
      newFile.getParentFile.mkdirs()
      oldFile.renameTo(newFile)
    }

    val dir : Array[String] = getListOfFiles(directoryName)

    for (c <- dir.indices) {
      if (dir(c).length>10) {
        move(dir(c).toString, dir(c).toString.substring(0, 10))
      }
    }


  }

  moveFiles(dirname)

}
