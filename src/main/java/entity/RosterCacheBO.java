package entity;

import lombok.Data;

/**
 * @author Yawei
 * @description
 * @date 2021-10-26 17:43
 */
@Data
public class RosterCacheBO {
    /**
     * 标识类型
     */
    private Integer symbolType;
    /**
     * 标识
     */
    private String symbol;
    /**
     * 描述
     */
    private String desc;
    /**
     * 名单类型
     */
    private Integer rosterType;
    /**
     * 风险级别
     */
    private Integer riskLevel;
    /**
     * 命中的是哪个场景
     */
    private SceneDictDto sceneDictDto;

    /**
     * 原三元组
     */
    private SceneDictDto sceneDictDtoSource;
}
