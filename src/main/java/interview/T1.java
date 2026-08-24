//import com.yl.risk.data.enums.AggMethod;
//import java.util.*;
//
//String featureCode="f_poi_sender_name_count";
//String table="risk_outline_waybill_feature";
//
//HashMap<String, Object> hashMap = new HashMap<>();
//
//hashMap.put("feature_code","f_poi_sender_name_count");
//hashMap.put("dimension_main",senderNameMasked);
//
//ArrayList<Long> mainTimeRange= new ArrayList<>();
//        mainTimeRange.add(startTimestamp);
//        mainTimeRange.add(endTimestamp);
//String mainTimeRangeField="stat_date";
//
//
//ArrayList<String> aggField= new ArrayList<>();
//        aggField.add("agg_result");
//
//AggMethod aggMethod=AggMethod.SUM;
//
//return queryOffCommonFeature(featureCode, table, hashMap, mainTimeRange, mainTimeRangeField, aggField,aggMethod,null);