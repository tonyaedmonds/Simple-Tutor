/**
 * 
 */
package com.tonyaedmonds.tutor.problem.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.tonyaedmonds.tutor.model.Problem;
import com.tonyaedmonds.tutor.model.Skill;
import com.tonyaedmonds.tutor.model.Student;
import com.tonyaedmonds.tutor.model.StudentSkill;
import com.tonyaedmonds.tutor.model.TutoringSystem;

/**
 * @author tonyaedmonds
 *
 */
public class TutoringSystemTest {
	Skill skillMultiplyFractions;
	Skill skillAddFractions;
	Skill skillAddDecimals;
	
	private final String MULTIPLY_FRACTIONS = "multiply-fractions";
	private final String ADD_FRACTIONS = "add-fractions";
	private final String ADD_DECIMALS = "add-decimals";
	
	@Before
	public void init(){
		skillMultiplyFractions = new Skill();
		skillMultiplyFractions.setName("multiply-fractions");
		
		skillAddFractions = new Skill();
		skillAddFractions.setName("add-fractions");
		
		skillAddDecimals = new Skill();
		skillAddDecimals.setName("add-decimals");
		
	}
	
	@Test
	public void selectNextProblem(){
		Student student = new Student();
		List<StudentSkill> studentSkills = new ArrayList<StudentSkill>();
		StudentSkill addDecimals = new StudentSkill();
		addDecimals.setName(ADD_DECIMALS);
		addDecimals.setScore(.97);
		studentSkills.add(addDecimals);
		
		StudentSkill addFractions = new StudentSkill();
		addFractions.setName(ADD_FRACTIONS);
		addFractions.setScore(.17);
		studentSkills.add(addFractions);
		
		StudentSkill multiplyFractions = new StudentSkill();
		multiplyFractions.setName(MULTIPLY_FRACTIONS);
		multiplyFractions.setScore(.53);
		studentSkills.add(multiplyFractions);
		
		
		student.setCurrentSkills(studentSkills);
		
		List<Problem> problems = new ArrayList<Problem>();
		Problem problem = new Problem();
		problem.setName("problem1");
		problem.setSkills(new ArrayList<Skill>());
		problem.getSkills().add(skillAddDecimals);
		problem.setProblem("3.4+5.6");
		problems.add(problem);
		
		problem = new Problem();
		problem.setName("problem4");
		problem.setSkills(new ArrayList<Skill>());
		problem.getSkills().add(skillMultiplyFractions);
		problem.getSkills().add(skillAddFractions);
		problem.setProblem("1/2*3/4+5/6");
		problems.add(problem);

		//expected
		Problem expected = new Problem();
		expected.setName("problem4");
		expected.setProblem("1/2*3/4+5/6");
		
		TutoringSystem system = new TutoringSystem();
		
		Problem result = system.selectNextProblem(student, problems);
		
		assertThat(result, is(expected));
		
		
	}

}
