import globals.Globals
/**
 * Created by Favio on 04/06/15.
 */

object FrequentPatternMining {
def main(args: Array[String]) {

    val conf = new SparkConf()
//            .setMaster("local")
      .setMaster(Globals.masterSpark)
      .setAppName("Feature Extraction and Transformation")
      .set("spark.executor.memory", "13g")
      .set("spark.cores.max", "10")
    val sc = new SparkContext(conf)
}
