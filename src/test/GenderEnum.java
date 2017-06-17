package test;

import org.apache.commons.lang.enums.Enum;
import org.apache.commons.lang.enums.EnumUtils;

public enum GenderEnum {
	M("1", "男"), WM("2", "女");

	// 成员变量
	private String code;
	private String name;

	// 构造方法
	private GenderEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	// 根据code获取name
	public static String getNameByCode(String code) {
		Enum tmp = EnumUtils.getEnum(Enum.class, code);
		System.out.println(tmp.getName());
		for (GenderEnum n : GenderEnum.values()) {
			if (n.getCode().equals(code)) {
				return n.name;
			}
		}
		return "";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}