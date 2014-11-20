/**
 * 
 */
package com.tonyaedmonds.tutor.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.istack.internal.logging.Logger;
import com.tonyaedmonds.tutor.exceptions.TutorException;

/**
 * Represents the tutoring system that chooses the next problem for a student to work on.
 * 
 * @author tonyaedmonds
 *
 */
public class TutoringSystem {
	private Double threshold;
	private final Double DEFAULT_THRESHOLD = .95;
	private final Logger logger = Logger.getLogger(this.getClass());

	public TutoringSystem(){
		threshold = DEFAULT_THRESHOLD;
		logger.config("Threshold set at default."+DEFAULT_THRESHOLD);
	}

	public TutoringSystem(Student student, List<Problem> problemSet){
		threshold = DEFAULT_THRESHOLD;
		logger.config("Threshold set at default."+DEFAULT_THRESHOLD);
	}
	public void setThreshold(Double value){
		logger.entering(value);
		this.threshold = value;
	}

	public Problem selectNextProblem(Student student, List<Problem> problemSet) throws TutorException{
		logger.entering(student, problemSet);

		Problem next = null;

		Set<StudentSkill> studentSkills = new HashSet<StudentSkill>(student.getSkillsBelowThreshold(threshold));

		for(Problem aProblem: problemSet){
			Set<Skill> intersection = getIntersectionOfSkills(studentSkills, aProblem);

			//select an arbitrary problem that contains a skill that 
			//needs to be worked on by the student
			Iterator<Skill> it = intersection.iterator();
			if(it.hasNext()){
				Skill skill = (Skill)it.next();
				for(Problem problem: problemSet){
					if(problem.getSkills().contains(skill)){
						next = problem;
						logger.exiting(next);
						return next;
					}
				}
			}
		}
		throw new TutorException("Appropriate next problem could not be found.");
	}

	/* Gets the intersection of the skills in the problem and student
	 * skills below the threshold*/

	protected Set<Skill> getIntersectionOfSkills(Set<StudentSkill> studentSkills, Problem aProblem) throws TutorException {
		HashSet<Skill> intersection = new HashSet<Skill>(studentSkills);
		intersection.retainAll(new HashSet<Skill>(aProblem.getSkills()));
		return intersection;
	}

}
