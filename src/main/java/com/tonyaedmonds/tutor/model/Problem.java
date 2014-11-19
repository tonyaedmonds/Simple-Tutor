/**
 * 
 */
package com.tonyaedmonds.tutor.model;

import java.util.List;

/**
 * Represents a problem within the system.

 * @author tonyaedmonds
 *
 */
public class Problem {
	private String name;
	private List<Skill> skills;
	private String problem;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	@Override
	public boolean equals(Object other){
		//Based on the problem description each problem has a unique name
		if(!other.getClass().equals(this.getClass()) || other == null)
			return false;
		Problem otherProblem = (Problem)other;
			
		if(this.name.equals(otherProblem.getName()))
			return true;
		return false;
	}

}
