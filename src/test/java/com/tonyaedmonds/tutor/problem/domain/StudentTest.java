package com.tonyaedmonds.tutor.problem.domain;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.tonyaedmonds.tutor.enums.SkillName;
import com.tonyaedmonds.tutor.model.Student;
import com.tonyaedmonds.tutor.model.StudentSkill;

public class StudentTest {
	
	Student student;
	StudentSkill studentSkillAddFractions;
	StudentSkill studentSkillMultiplyFractions;
	StudentSkill studentSkillAddDecimals;
	@Before
	public void init(){
	
		studentSkillAddDecimals = new StudentSkill();
		studentSkillAddFractions = new StudentSkill();
		studentSkillMultiplyFractions = new StudentSkill();
		
		studentSkillAddFractions.setName(SkillName.ADD_FRACTIONS);
		studentSkillAddFractions.setScore(.78);
		
		studentSkillAddDecimals.setName(SkillName.ADD_DECIMALS);
		studentSkillAddDecimals.setScore(.95);
		
		studentSkillMultiplyFractions = new StudentSkill();
		studentSkillMultiplyFractions.setScore(.99);
		
		student = new Student();
		student.setCurrentSkills(new ArrayList<StudentSkill>());
		
		
	}
	
	@Test
	public void getSkillsBelowThreshold_ShouldOnlyReturnSkillsBelowThreshold(){
		
	}

}
