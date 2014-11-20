package com.tonyaedmonds.tutor.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.tonyaedmonds.tutor.enums.SkillName;
import com.tonyaedmonds.tutor.model.Problem;
import com.tonyaedmonds.tutor.model.Skill;


public class ProblemTest {
	Problem problem1;
	Problem problem1Copy;
	Problem problem1Different;
	Skill skillAddition;
	Skill skillMultiplication;
	
	@Before
	public void init(){
		skillAddition = new Skill();
		skillAddition.setName(SkillName.ADD);
		
		skillMultiplication = new Skill();
		skillMultiplication.setName(SkillName.MULTIPLY);
		
		problem1 = new Problem();
		problem1.setName("problem1");
		problem1.setProblem("2+3*4");
		problem1.setSkills(new ArrayList<Skill>());
		problem1.getSkills().add(skillAddition);
		problem1.getSkills().add(skillMultiplication);
		
		//create new problem with same attributes, but different memory location
		problem1Copy = new Problem();
		problem1Copy.setName("problem1");
		problem1Copy.setProblem("2+3*4");
		problem1Copy.setSkills(new ArrayList<Skill>());
		problem1Copy.getSkills().add(skillAddition);
		problem1Copy.getSkills().add(skillMultiplication);
		
		//same name as problem1, but different problem and skills
		problem1Different = new Problem();
		problem1Copy.setName("problem1");
		problem1Copy.setProblem("1+5*4");
		problem1Copy.setSkills(new ArrayList<Skill>());
		problem1Copy.getSkills().add(skillMultiplication);
		
		
	}
	
	@Test
	public void equals_ProblemWithSameNameShouldBeEqual(){
		assertTrue(problem1.equals(problem1Copy));
		
	}
	
	@Test
	public void equals_ProblemWithSameNameDifferentProblemAndSkillsShouldBeEqual(){
		assertTrue(problem1.equals(problem1Copy));
	}
	
	@Test
	public void equals_DifferentProblemName_ShouldNotBeEqual(){
		assertFalse(problem1.equals(problem1Different));
	}
}
