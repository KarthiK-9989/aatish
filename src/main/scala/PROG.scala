import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
object PROG {
    def main(args: Array[String]): Unit = {
      val logger: Logger = Logger.getLogger(getClass.getName)

      val sparkconf = new SparkConf()
      sparkconf.set("spark.app.name", "myfirstapplication")
      sparkconf.set("spark.master", "local[*]");

      val spark = SparkSession.builder()
        .config(sparkconf)
        .getOrCreate()

      try {
        val df = spark.read
          .format("csv")
          .option("header", true)
          .option("inferSchema", true)
          .option("path", "C:/Users/Karthik Kondpak/Desktop/Spark_Training/sampledata.txt")
          .load()


      } catch {
        case e: Exception =>
          logger.error("sever down:", e)
      }
    }



}


            //with these and log files (log4j.properties)