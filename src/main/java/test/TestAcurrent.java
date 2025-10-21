package test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import entity.RosterCacheBO;
import entity.SceneDictDto;
import entity.SymbolTypEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TestAcurrent {
    public static void main(String[] args) throws Exception {
test();
    }

    private static void test() throws Exception {
        SceneDictDto sceneDictDto = new SceneDictDto();
        sceneDictDto.setSceneCode("marketing_yhsh_yqyl-binding");
        sceneDictDto.setBusinessType("yhsh");
        sceneDictDto.setEventType("marketing");
        sceneDictDto.setSceneType("yqyl-binding");
//        结果:{"businessType":"yhsh","eventType":"marketing",
//                "sceneCode":"marketing_yhsh_yqyl-binding","sceneName":"邀请有礼——邀请关系绑定","sceneType":"yqyl-binding"}
//

        if (null == sceneDictDto
                || StringUtils.isBlank(sceneDictDto.getEventType())
                || StringUtils.isBlank(sceneDictDto.getSceneType())
                || StringUtils.isBlank(sceneDictDto.getBusinessType())) {
            System.out.println("[RosterCache]查询名单库缓存时传入的三元组不能为空");
            return;
        }

        Map<SymbolTypEnum, String> symbolMap = new HashMap<>();
//        {"DEVICE_FINGERPRINT":"3O44KE4QCVSSOSPYS73WZILDOZF76XVG","PHONE_NUMBER":"13890809817","MEMBER_ID":"181627120211098008"
//                ,"IP":"183.70.83.121","DEVICE_ID":"e30d0d32-5025-42b5-a81e-9dd3ebc95159"}
        symbolMap.put(SymbolTypEnum.DEVICE_FINGERPRINT,"3O44KE4QCVSSOSPYS73WZILDOZF76XVG");
        symbolMap.put(SymbolTypEnum.PHONE_NUMBER,"13890809817");
        symbolMap.put(SymbolTypEnum.MEMBER_ID,"181627120211098008");
        symbolMap.put(SymbolTypEnum.IP,"183.70.83.121");
        symbolMap.put(SymbolTypEnum.DEVICE_ID,"e30d0d32-5025-42b5-a81e-9dd3ebc95159");
        Map<SymbolTypEnum, String> sortedMap = symbolMap
                .entrySet()
                .stream()
                .filter(t -> null != t.getValue())
                .sorted(Comparator.comparing(t -> t.getKey().getPriority()))
                .collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue(), (oldVal, newVal) -> oldVal, LinkedHashMap::new
                ));
        String eventType = sceneDictDto.getEventType(),
                businessType = sceneDictDto.getBusinessType(),
                sceneType = sceneDictDto.getSceneType();
//两种查询优先级(查询默认业态的场景不需要了，因为sceneDictDto已经匹配过的三元组)
        String priorityFirst = Joiner.on("_").join(eventType, "all", "all");
        String prioritySecond = Joiner.on("_").join(eventType, businessType, sceneType);

        Integer result = null;
        RosterCacheBO rosterCacheBO = null;
        for (Map.Entry<SymbolTypEnum, String> entry : sortedMap.entrySet()) {
            if (StringUtils.isBlank(entry.getValue())) {
                continue;
            }
            List<String> matchPriorityList = Lists.newArrayList(priorityFirst, prioritySecond);
            for (String priorityType : matchPriorityList) {
//                final String key = buildPK(entry.getKey().name(), priorityType, entry.getValue());
//                final String value = entry.getValue();
                System.out.println("开始获取名单库缓存-key:{}-value:{}");
//                result = get(key, value);
//                if (null == result) {
//                    continue;
//                }
                rosterCacheBO = new RosterCacheBO();
                rosterCacheBO.setRosterType(result);
                rosterCacheBO.setDesc(entry.getKey().getDesc());
                rosterCacheBO.setSymbolType(entry.getKey().getCode());
                rosterCacheBO.setSymbol(entry.getValue());
                if (StringUtils.equals(priorityFirst, priorityType)) {
                    String[] matchedType = StringUtils.split(priorityType, "_");
                    if (null != matchedType && matchedType.length >= 3) {
                        sceneDictDto = SceneDictDto.build(priorityType,
                                matchedType[0], matchedType[1], matchedType[2], entry.getKey().getDesc());
                    } else {
                        System.out.println("发现了不符合格式要求的三元组组合。三元组组合为：{}");

                        throw new Exception("发现了不符合格式要求的三元组组合。三元组组合为：" + priorityType);
                    }
                }
                rosterCacheBO.setSceneDictDto(sceneDictDto);
//                rosterCacheBO.setRiskLevel(RosterTypeEnum.getBelongRiskLevel(result));
                break;
            }
            if (null != result) {
                break;
            }
        }

    }
}
