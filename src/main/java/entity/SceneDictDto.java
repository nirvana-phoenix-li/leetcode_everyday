package entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SceneDictDto implements Serializable {

    private String sceneName;

    /**
     * 三元组
     */
    private String sceneCode;

    private String businessType;

    private String eventType;

    private String sceneType;

    private static final long serialVersionUID = 1L;

    public static SceneDictDto build(String sceneCode,
                                     String eventType,
                                     String businessType,
                                     String sceneType,
                                     String sceneName) {
        SceneDictDto sceneDictDto = new SceneDictDto();
        sceneDictDto.setSceneCode(sceneCode);
        sceneDictDto.setSceneName(sceneName);
        sceneDictDto.setSceneType(sceneType);
        sceneDictDto.setBusinessType(businessType);
        sceneDictDto.setEventType(eventType);
        return sceneDictDto;
    }
}