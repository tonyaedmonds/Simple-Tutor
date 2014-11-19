/**
 * 
 */
package com.tonyaedmonds.tutor.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student 
 * 
 * @author tonyaedmonds
 *
 */
public class Student {
	private List<StudentSkill> currentSkills;

	public Student(){
		currentSkills = new ArrayList<StudentSkill>();
	}
	
	//might be better to add skills below threshold when we are adding a new skill
	public List<StudentSkill> getSkillsBelowThreshold(Double threshold){
		List<StudentSkill> belowThresholdSkills = new ArrayList<StudentSkill>();
		
		if(threshold == null)
			throw new NullPointerException("Threshold is not set!");
			
		for(StudentSkill skill : currentSkills){
			if(skill.getScore() < threshold)
				belowThresholdSkills.add(skill);
		}
		
		
		return belowThresholdSkills;
	}

	public List<StudentSkill> getCurrentSkills() {
		return currentSkills;
	}

	public void setCurrentSkills(List<StudentSkill> currentSkills) {
		this.currentSkills = currentSkills;
	}
	

}
