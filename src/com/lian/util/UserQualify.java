package com.lian.util;

public enum UserQualify {
	
	ADMIN(0),IN_USE(1),OUT_USE(2);

	private int value;

	private UserQualify(int value) {
		this.value = value;
	}

	public static UserQualify valueOf(int value) {
		switch (value) {
		case 0:
			return ADMIN;
		case 1:
			return IN_USE;
		case 2:
			return OUT_USE;
		default:
			return null;
		}
	}
	
	public int value() {
        return this.value;
    }

}
