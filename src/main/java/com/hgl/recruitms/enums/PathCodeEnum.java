package com.hgl.recruitms.enums;

public enum PathCodeEnum {
	YEAR("YYYY", "年"), YEAR_MOUTH("YYYY/MM", "月"), YEAR_MOUTH_DAY("YYYY/MM/DD","日"),
	ABSOLUTEPATH("F:\\GraduationTest\\attach","absolutePath"),
	SUBPATH("YYYY/MM","subPath");
	private String code;
	private String name;

	PathCodeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static PathCodeEnum fromCode(String code) {
		for (PathCodeEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static PathCodeEnum fromName(String name) {
		for (PathCodeEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}
