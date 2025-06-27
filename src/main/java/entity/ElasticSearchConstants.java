package entity;

import java.util.HashMap;
import java.util.Map;

public final class ElasticSearchConstants {


    /**
     * es 更新冲突后重试次数
     */
    public static final int RETRY_ON_CONFLICT = 3;
    /**
     * 索引名称
     */
    public static final String INDEX_NAME = "customer-current-risk-intercept-status";
    /**
     * 风控指标es key字段
     */
    public static final String FEATURE_KEY = "key";
    /**
     * 风控指标es时间字段
     */
    public static final String FEATURE_TIME = "time";
    /**
     * 指标es索引前缀
     */
    public static final String RISK_FEATURE_ES_INDEX_PREFIX = "risk-feature-";


    public static final long ONE_HOUR = 3600000L;
    public static final long ONE_MINUTES = 60000L;
    public static final long ONE_SECOND = 1000L;
    /**
     * 风控特征es id前缀
     */
    public static final Map<Long, String> RISK_FEATURE_INDEX_PREFIX_MAP = new HashMap<Long, String>() {
        {
            this.put(3600000L, RISK_FEATURE_ES_INDEX_PREFIX + "h_");
            this.put(60000L, RISK_FEATURE_ES_INDEX_PREFIX + "m_");
            this.put(1000L, RISK_FEATURE_ES_INDEX_PREFIX + "s_");
        }
    };
}
