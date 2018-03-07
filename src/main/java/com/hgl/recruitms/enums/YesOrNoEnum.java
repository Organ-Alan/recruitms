package com.hgl.recruitms.enums;

public enum YesOrNoEnum {
	Y("1", "是"), N("0", "否");
	private String code;
	private String name;

	YesOrNoEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static YesOrNoEnum fromCode(String code) {
		for (YesOrNoEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static YesOrNoEnum fromName(String name) {
		for (YesOrNoEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}
