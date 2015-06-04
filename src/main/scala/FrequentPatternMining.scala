import globals.Globals
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Favio on 04/06/15.
 */

object FrequentPatternMining {
  def main(args: Array[String]) {

    val conf = new SparkConf()
      //            .setMaster("local")
      .setMaster(Globals.masterSpark)
      .setAppName("MLlib - Frequent Pattern Mining")
      .set("spark.executor.memory", "13g")
      .set("spark.cores.max", "10")
    val sc = new SparkContext(conf)

    /**
     * Mining frequent items, itemsets, subsequences, or other substructures
     * is usually among the first steps to analyze a large-scale dataset,
     * which has been an active research topic in data mining for years.
     * We refer users to Wikipedia’s association rule learning for more
     * information. MLlib provides a parallel implementation of FP-growth,
     * a popular algorithm to mining frequent itemsets.
     */

    /**
     * FP-growth
     *
     * The FP-growth algorithm is described in the paper Han et al., Mining
     * frequent patterns without candidate generation, where “FP” stands for
     * frequent pattern. Given a dataset of transactions, the first step of
     * FP-growth is to calculate item frequencies and identify frequent items.
     * Different from Apriori-like algorithms designed for the same purpose,
     * the second step of FP-growth uses a suffix tree (FP-tree) structure to
     * encode transactions without generating candidate sets explicitly, which
     * are usually expensive to generate. After the second step, the frequent
     * itemsets can be extracted from the FP-tree. In MLlib, we implemented a
     * parallel version of FP-growth called PFP, as described in Li et al.,
     * PFP: Parallel FP-growth for query recommendation. PFP distributes the
     * work of growing FP-trees based on the suffices of transactions, and
     * hence more scalable than a single-machine implementation. We refer
     * users to the papers for more details.
     *
     * MLlib’s FP-growth implementation takes the following (hyper-)parameters:
     *
     * - minSupport: the minimum support for an itemset to be identified as
     * frequent. For example, if an item appears 3 out of 5 transactions,
     * it has a support of 3/5=0.6.
     *
     * - numPartitions: the number of partitions used to distribute the work.
     *
     * FPGrowth implements the FP-growth algorithm. It take a JavaRDD of
     * transactions, where each transaction is an Iterable of items of a
     * generic type. Calling FPGrowth.run with transactions returns an
     * FPGrowthModel that stores the frequent itemsets with their frequencies.
     */

   val transactions: RDD[Array[String]] = sc.parallelize(Seq())
  }
}
