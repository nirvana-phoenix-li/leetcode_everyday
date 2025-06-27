package test;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

public class T4 {
    public static void main(String[] args) throws ParseException {

//	"_id": "110.253.63.172_ptyx-dq-ylcw19940611_1002_1750118400000"
//        String id = "110.253.63.172_ptyx-dq-ylcw19940611_1002_1750118400000";
//        if (!StringUtils.isEmpty(id)) {
//            int z;
//            String idWithoutTimeStamp = null;
//            for (z = id.length() - 1; z >= 0; z--) {
//                if (id.charAt(z) == '_') {
//                    break;
//                }
//            }
//            if (z != -1) {
//                idWithoutTimeStamp = id.substring(0, z);
//            }
//            System.out.println(idWithoutTimeStamp);
//        }


        String queryVariableId = getQueryVariableId("36.28.139.223_1060");
        System.out.println(queryVariableId);
    }

    /**
     * "id":"36.28.139.223_1060_1750672800000",需要把最后面的时间戳给去掉
     * "ESKey":"36.28.139.223_1060",需要拿到最后面的指标变量id，用来做灰度精确流量控制
     */
    public static String getQueryVariableId(String ESKey) {
        String result = null;

        if (!StringUtils.isEmpty(ESKey)) {
            int z;
            for (z = ESKey.length() - 1; z >= 0; z--) {
                if (ESKey.charAt(z) == '_') {
                    break;
                }
            }
            if (z != -1) {
                result = ESKey.substring(z + 1);
            }
        }
        return result;
    }
}