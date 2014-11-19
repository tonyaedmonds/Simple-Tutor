/**
 * 
 */
package com.tonyaedmonds.tutor.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Represents the tutoring system that chooses the next problem for a student to work on.
 * 
 * @author tonyaedmonds
 *
 */
public class TutoringSystem {
	private Double threshold;
	private final Double DEFAULT_THRESHOLD = .95;
	
	public TutoringSystem(){
		threshold = DEFAULT_THRESHOLD;
	}

	public TutoringSystem(Student student, List<Problem> problemSet){
		threshold = DEFAULT_THRESHOLD;
		
	}
	public void setThreshold(Double value){
		this.threshold = value;
	}
	
	public Problem selectNextProblem(Student student, List<Problem> problemSet){
		Problem next = null;

		Set<StudentSkill> studentSkills = new HashSet<StudentSkill>(student.getSkillsBelowThreshold(threshold));
		
		for(Problem aProblem: problemSet){
			Set<Skill> intersection = new HashSet<Skill>(studentSkills);
			
			//get the intersection of the skills in the problem and student
			//skills below the threshold
			intersection.retainAll(new HashSet<Skill>(aProblem.getSkills()));
			
			//select an arbitrary problem that contains a skill that 
			//needs to be worked on by the student
			Iterator<Skill> it = intersection.iterator();
			if(it.hasNext()){
				Skill skill = (Skill)it.next();
				for(Problem problem: problemSet){
					if(problem.getSkills().contains(skill)){
						next = problem;
						return next;
					}
				}
		}
		}
		
		//add some error handling for if a problem was not found
		
		return null;
	}

}
