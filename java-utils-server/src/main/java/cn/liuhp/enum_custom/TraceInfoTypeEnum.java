package cn.liuhp.enum_custom;


/**
 * <p>
 * <p>
 * <p>
 * 行星枚举：使用的规则，常用的方法配制。
 * 枚举不可变的、
 * </p>
 *
 * @author hz16092620
 * @date 2018年9月5日 下午8:09:34
 */
public enum TraceInfoTypeEnum {

    /**
     * 枚举在变量之前
     */
    Product_Info_IS((byte) 1, PlanetEnum.EARTH.getValue(), "earth"),
    Health_Info_IS((byte) 2, PlanetEnum.MARS.getValue(), "mars"),
    Manual_Audit_IS((byte) 3, PlanetEnum.VENUS.getValue(), "venus");

    /**
     * 枚举不可变的，变量设置成final，添加对应的访问方法
     */
    private final byte infoTypeValue;

    private final byte sourceValue;

    private final String desc;


    /**
     * 不需要权限修饰符修饰，构造函数
     */
    TraceInfoTypeEnum(byte infoTypeValue, byte sourceValue, String desc) {
        this.infoTypeValue = infoTypeValue;
        this.sourceValue = sourceValue;
        this.desc = desc;
    }

    public byte getInfoTypeValue() {
        return infoTypeValue;
    }

    public byte getSourceValue() {
        return sourceValue;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据value获取对应的枚举
     */
    public static TraceInfoTypeEnum getByInfoTypeValue(byte value) {
        TraceInfoTypeEnum result = null;
        if (value <= 0) {
            return result;
        }
        for (TraceInfoTypeEnum tempEnum : TraceInfoTypeEnum.values()) {
            if (value == tempEnum.infoTypeValue) {
                result = tempEnum;
                break;
            }
        }
        return result;
    }

    /**
     * 根据value获取对应的枚举描述
     */
    public static String getDescByValue(byte value) {
        String result = null;
        if (value <= 0) {
            return result;
        }
        for (TraceInfoTypeEnum tempEnum : TraceInfoTypeEnum.values()) {
            if (value == tempEnum.infoTypeValue) {
                result = tempEnum.getDesc();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
	/*for (PlanetEnum planetEnum : PlanetEnum.values()) {
	    System.out.printf("Planet value is %s , desc is %s %n", planetEnum, planetEnum);
	}*/
        for (TraceInfoTypeEnum traceInfoTypeEnum : TraceInfoTypeEnum.values()) {
            System.out.println(traceInfoTypeEnum.getInfoTypeValue());
            System.out.println(traceInfoTypeEnum.getSourceValue());
            System.out.println(traceInfoTypeEnum.getDesc());
        }
    }


}
 