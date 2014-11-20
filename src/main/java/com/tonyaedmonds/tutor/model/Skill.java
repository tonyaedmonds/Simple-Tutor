package com.tonyaedmonds.tutor.model;

import com.tonyaedmonds.tutor.enums.SkillName;

/**
 * Represents a skill in the tutoring system
 * 
 * @author tonyaedmonds
 *
 */
public class Skill {
	private SkillName name;
	
	public SkillName getName() {
		return name;
	}

	public void setName(SkillName name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object other){
		if(other == null || !(other.getClass().isAssignableFrom(Skill.class)))
			return false;
		
		Skill otherSkill = (Skill)other;
		if(this.getName().equals(otherSkill.getName()))
				return true;
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return (int)this.name.hashCode(); 
	}
	
	

}
