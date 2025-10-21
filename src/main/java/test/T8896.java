package test;

import org.apache.commons.lang3.StringUtils;

public class T8896 {

    public static void main(String[] args) {
        String idWithTimeStamp = "JZKU6U32VUMG5ZYP3D6E333RNQHV56F4_1059_1760796000000";
        String queryESKey = getQueryESKey(idWithTimeStamp);
        System.out.println(queryESKey);
    }

    public static String getQueryESKey(String idWithTimeStamp) {
        String idWithoutTimeStamp = null;

        if (!StringUtils.isEmpty(idWithTimeStamp)) {
            int z;
            for (z = idWithTimeStamp.length() - 1; z >= 0; z--) {
                if (idWithTimeStamp.charAt(z) == '_') {
                    break;
                }
            }
            if (z != -1) {
                idWithoutTimeStamp = idWithTimeStamp.substring(0, z);
            }
        }
        return idWithoutTimeStamp;

    }
}
