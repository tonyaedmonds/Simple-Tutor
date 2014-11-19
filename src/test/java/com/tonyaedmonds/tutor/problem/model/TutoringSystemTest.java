/**
 * 
 */
package com.tonyaedmonds.tutor.problem.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tonyaedmonds.tutor.exceptions.TutorException;
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
	private Skill skillMultiplyFractions;
	private Skill skillAddFractions;
	private Skill skillAddDecimals;
	
	private Problem problem1;
	private Problem problem4;
	
	private final String MULTIPLY_FRACTIONS = "multiply-fractions";
	private final String ADD_FRACTIONS = "add-fractions";
	private final String ADD_DECIMALS = "add-decimals";
	
	@Before
	public void init(){
		createSkills();
	}
	
	@Test
	public void selectNextProblem_ShouldReturnProblem4() throws TutorException{
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
	public void selectNextProblem_ShouldThrowException() throws TutorException{
		Student student = createStudent();
		List<Problem> problems = new ArrayList<Problem>();
		
		TutoringSystem system = new TutoringSystem();
		system.selectNextProblem(student, problems);
	}
	
	////////////////////////////////////////////////////
	
	public void createSkills(){
		skillMultiplyFractions = new Skill();
		skillMultiplyFractions.setName("multiply-fractions");
		
		skillAddFractions = new Skill();
		skillAddFractions.setName("add-fractions");
		
		skillAddDecimals = new Skill();
		skillAddDecimals.setName("add-decimals");
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
		student.setCurrentSkills(createStudentSkills());
		return student;
	}

	public List<StudentSkill> createStudentSkills(){
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
		
		return studentSkills;
	}
}
