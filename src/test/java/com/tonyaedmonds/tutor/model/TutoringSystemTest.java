/**
 * 
 */
package com.tonyaedmonds.tutor.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.tonyaedmonds.tutor.enums.SkillName;
import com.tonyaedmonds.tutor.exceptions.TutorException;

/**
 * @author tonyaedmonds
 *
 */
public class TutoringSystemTest {
	private Skill skillMultiplyFractions;
	private Skill skillAddFractions;
	private Skill skillAddDecimals;
	
	private StudentSkill stuSkillMultiplyFractions;
	private StudentSkill stuSkillAddFractions;
	private StudentSkill stuSkillAddDecimals;
	
	private List<StudentSkill> studentSkills;
	
	private Problem problem1;
	private Problem problem4;
	
	@Before
	public void init(){
		studentSkills = new ArrayList<StudentSkill>();
		createStudentSkills();
		createSkills();
	}
	
	@Test
	public void selectNextProblem_MatchedSkills_ShouldReturnProblem4() throws TutorException{
		Student student = createStudent();
		List<Problem> problems = createProblems();
		
		//expected
		Problem expected = new Problem();
		expected.setName("problem4");
		expected.setProblem("1/2*3/4+5/6");
		
		TutoringSystem system = new TutoringSystem();
		
		//result
		Problem result = system.selectNextProblem(student, problems);
		
		assertThat(result, is(expected));
		
	}
	
	@Test(expected=TutorException.class)
	public void selectNextProblem_NoMatchingSkills_ShouldThrowException() throws TutorException{
		Student student = createStudent();
		List<Problem> problems = new ArrayList<Problem>();
		
		TutoringSystem system = new TutoringSystem();
		system.selectNextProblem(student, problems);
	}
	
	
	////////////////////////////////////////////////////
	
	public void createSkills(){
		skillMultiplyFractions = new Skill();
		skillMultiplyFractions.setName(SkillName.MULTIPLY_FRACTIONS);
		
		skillAddFractions = new Skill();
		skillAddFractions.setName(SkillName.ADD_FRACTIONS);
		
		skillAddDecimals = new Skill();
		skillAddDecimals.setName(SkillName.ADD_DECIMALS);
	}
	
	public List<Problem> createProblems(){
		List<Problem> problems = new ArrayList<Problem>();
		problem1 = new Problem();
		problem1.setName("problem1");
		problem1.setSkills(new ArrayList<Skill>());
		problem1.getSkills().add(skillAddDecimals);
		problem1.setProblem("3.4+5.6");
		problems.add(problem1);
		
		problem4 = new Problem();
		problem4.setName("problem4");
		problem4.setSkills(new ArrayList<Skill>());
		problem4.getSkills().add(skillMultiplyFractions);
		problem4.getSkills().add(skillAddFractions);
		problem4.setProblem("1/2*3/4+5/6");
		problems.add(problem4);
		
		return problems;
	}
	
	public Student createStudent(){
		Student student = new Student();
		student.setCurrentSkills(getStudentSkillsList());
		return student;
	}

	public void createStudentSkills(){
		stuSkillAddDecimals = new StudentSkill();
		stuSkillAddDecimals.setName(SkillName.ADD_DECIMALS);
		stuSkillAddDecimals.setScore(.97);

		stuSkillAddFractions = new StudentSkill();
		stuSkillAddFractions.setName(SkillName.ADD_FRACTIONS);
		stuSkillAddFractions.setScore(.17);
		
		stuSkillMultiplyFractions = new StudentSkill();
		stuSkillMultiplyFractions.setName(SkillName.MULTIPLY_FRACTIONS);
		stuSkillMultiplyFractions.setScore(.53);
	}
	
	public List<StudentSkill> getStudentSkillsList(){
//		if(studentSkills.size() != 0)
//			return studentSkills;
//		
		createStudentSkills();
		
		studentSkills.add(stuSkillAddDecimals);
		studentSkills.add(stuSkillAddFractions);
		studentSkills.add(stuSkillMultiplyFractions);
		
		return studentSkills;
	}
}
