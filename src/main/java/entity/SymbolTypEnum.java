package entity;


import com.yonghui.common.constants.Constant;
import lombok.Getter;

import javax.com.yonghui.common.exception.BaseKnownException;
import java.util.Arrays;

/**
 * @author ringo
 */

public enum SymbolTypEnum {
    /**
     * 默认值
     */
    DEFAULT(0, 999, "默认名单库","default"),
    /**
     * 设备编号
     */
    DEVICE_ID(3, 4, "设备id名单库","deviceId"),
    /**
     * 设备指纹
     */
    DEVICE_FINGERPRINT(4, 3, "设备指纹名单库","fingerPrint"),
    /**
     * ip地址
     */
    IP(5, 2, "ip地址名单库","ip"),

    /**
     * 手机号
     */
    PHONE_NUMBER(1, 1, "手机号码名单库","mobile"),
    /**
     * 会员编号
     */
    MEMBER_ID(2, 2, "会员号名单库","memberId");

    /**
     * 代码
     */
    @Getter
    private final int code;
    /**
     * 寻找优先级
     */
    @Getter
    private final int priority;
    /**
     * 寻找优先级
     */
    @Getter
    private final String desc;

    @Getter
    private final String cast;

    SymbolTypEnum(int code, int priority, String desc, String cast) {
        this.code = code;
        this.priority = priority;
        this.desc = desc;
        this.cast = cast;
    }

    public static SymbolTypEnum getSymbolTypeByCode(int value) {
        return Arrays.stream(SymbolTypEnum.values()).filter(e -> e.getCode()==value).findFirst()
                .orElseThrow(() -> new BaseKnownException(Constant.ERRORCODE_INVALID_SYSTEM_PARAMETER, "没有查询到SymbolType类型"));
    }
}
