package com.tonyaedmonds.tutor.enums;

public enum SkillName {
	MULTIPLY_FRACTIONS("multiply-fractions"), ADD_FRACTIONS("add-fractions"), 
	ADD_DECIMALS("add-decimals"), MULTIPLY_DECIMALS("multiply-decimals"), ADD("addition"), MULTIPLY("multiplication");
	
	private String value;
	
	private SkillName(String name){
		this.value = name;
	}
	
	public String getValue(){
		return this.value;
	}
}
