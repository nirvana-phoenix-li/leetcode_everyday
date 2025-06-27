package es;

import com.google.common.collect.Lists;
import entity.DateTimeUtils;
import entity.ElasticSearchConstants;
import entity.TimePair;
import entity.WindowTypeEnum;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public class ExtractParam {
    public static void main(String[] args) {
        int timeSpan = 7;
        WindowTypeEnum timeUnit = WindowTypeEnum.D;
        String esKey = "9M8D_R-1653262@1_R-1872433@1_R-454164@6_16-3XS-59-8@PTYY-LKPY-ZLQ-HN-FZ-49-8_1046";
        TimePair timePair = TimePair.build(timeSpan, timeUnit, null, null);
        MultiGetRequest request = new MultiGetRequest();
        List<GetResponse> resultResponse = Lists.newArrayList();
        long start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start);

        splitTime(timePair, (l1, l2) -> {
            String date = DateTimeUtils.dateFormatShZone(l2, DateTimeUtils.FORMAT_DEFAULT_YEAR_MONTH_DAY_1);
            MultiGetRequest.Item item = new MultiGetRequest.Item((String) ElasticSearchConstants.RISK_FEATURE_INDEX_PREFIX_MAP.get(l1) + date, buildEsId(esKey, l2));
            request.add(item);
        });
        System.out.println(System.currentTimeMillis() - start);
        for (int i = 0; i < request.getItems().size(); i++) {
            MultiGetRequest.Item item = request.getItems().get(i);
            System.out.println("{\"_index\": \""+item.index()+"\", \"_id\": \""+item.id()+"\"},");
        }
        if (request.getItems().isEmpty()) {
            System.out.println(Collections.EMPTY_LIST);
        } else {
//            MultiGetItemResponse[] responses = this.restHighLevelClient.mget(request, RequestOptions.DEFAULT).getResponses();
        }


    }

    public static void splitTime(TimePair timePair, BiConsumer<Long, Long> callback) {
        long startTime = timePair.getStartTime();
        startTime = ceilTimes(startTime, 1000L);
        if (Objects.isNull(callback)) {
            callback = (l1, l2) -> {
            };
        }

        splitTime(startTime, timePair.getEndTime(), callback);
    }

    private static void splitTime(long startTime, long endTime, BiConsumer<Long, Long> callback) {
        while (startTime <= endTime) {
            if (startTime % 3600000L == 0L && startTime + 3600000L <= endTime) {
                startTime += 3600000L;
                callback.accept(3600000L, startTime);
            } else if (startTime % 60000L == 0L && startTime + 60000L <= endTime) {
                startTime += 60000L;
                callback.accept(60000L, startTime);
            } else if ((startTime += 1000L) <= endTime) {
                callback.accept(1000L, startTime);
            }
        }
    }

    public static long ceilTimes(long time, long windowsTimes) {
        return time % windowsTimes == 0L ? time : (time / windowsTimes + 1L) * windowsTimes;
    }

    public static String buildEsId(String key, long time) {
        return key + "_" + time;
    }

}
