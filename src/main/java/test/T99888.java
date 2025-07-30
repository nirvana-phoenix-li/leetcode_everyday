package test;

import com.google.common.collect.HashMultiset;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import org.simmetrics.StringMetric;
import org.simmetrics.metrics.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class T99888 {
    public static void main(String[] args) {
        String addr1 = "河北省石家庄市裕华区万达广场";
        String addr2 = "河北石家庄市裕华万达广场";
        String addr3 = "河北石家庄市裕华万达公馆";


        List<String> addr1List = hanlpSeg(addr1);
        List<String> addr2List = hanlpSeg(addr2);
        List<String> addr3List = hanlpSeg(addr3);

        //
        System.out.println("---cosine：  a·b / (||a|| * ||b||)---");
        CosineSimilarity<String> cosineClient = new CosineSimilarity<String>();
        float score = cosineClient.compare(HashMultiset.create(addr1List),
                HashMultiset.create(addr2List));
        System.out.println(score);
        score = cosineClient.compare(HashMultiset.create(addr1List),
                HashMultiset.create(addr3List));
        System.out.println(score);


        System.out.println("---jaccard：∣a ∩ b∣ / ∣a ∪ b∣--- ");
        Jaccard jaccard = new Jaccard<String>();
        System.out.println(jaccard.compare(new HashSet<>(addr1List), new HashSet<>(addr2List)));
        System.out.println(jaccard.compare(new HashSet<>(addr1List), new HashSet<>(addr3List)));

        System.out.println("---dice：2倍交集大小除以两集合大小之和 类似Jaccard但对共有词更敏感 --- ");
        Dice<String> dice = new Dice<String>();
        System.out.println(dice.compare(new HashSet<>(addr1List), new HashSet<>(addr2List)));
        System.out.println(dice.compare(new HashSet<>(addr1List), new HashSet<>(addr3List)));

        System.out.println("---overlapCoefficient：交集大小除以较短集合的大小--- ");
        OverlapCoefficient<String> overlapCoefficient = new OverlapCoefficient<String>();
        System.out.println(overlapCoefficient.compare(new HashSet<>(addr1List), new HashSet<>(addr2List)));
        System.out.println(overlapCoefficient.compare(new HashSet<>(addr1List), new HashSet<>(addr3List)));


        System.out.println("---smithWaterman：局部序列对齐 动态规划+得分矩阵--- ");
        StringMetric smithWaterman = StringMetrics.smithWaterman();
        System.out.println(smithWaterman.compare(addr1, addr2));
        System.out.println(smithWaterman.compare(addr1, addr3));

        System.out.println("---needlemanWunch：全局序列对齐，动态规划+固定空位罚分--- ");
        StringMetric needlemanWunch = StringMetrics.needlemanWunch();
        System.out.println(needlemanWunch.compare(addr1, addr2));
        System.out.println(needlemanWunch.compare(addr1, addr3));

        System.out.println("---jaroWinkler：关注前缀匹配--- ");
        StringMetric jaroWinkler = StringMetrics.jaroWinkler();
        System.out.println(jaroWinkler.compare(addr1, addr2));
        System.out.println(jaroWinkler.compare(addr1, addr3));

        System.out.println("---levenshtein：编辑距离--- ");
        Levenshtein levenshtein = new Levenshtein();
        System.out.println(levenshtein.compare(addr1, addr2) + ":距离=" + levenshtein.distance(addr1, addr2));
        System.out.println(levenshtein.compare(addr1, addr3) + ":距离=" + levenshtein.distance(addr1, addr3));
    }

    private static List<String> hanlpSeg(String str) {
        Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
        // 可以通过这种方式，自己指定分词
//      CustomDictionary.add("万达广场","ns 1000");

        List<String> list = segment.seg(str).stream().map(term -> term.word).collect(Collectors.toList());
        System.out.println(list);
        return list;

    }


}
