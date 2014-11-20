package com.tonyaedmonds.tutor.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import com.tonyaedmonds.tutor.enums.SkillName;
import com.tonyaedmonds.tutor.model.Skill;
import com.tonyaedmonds.tutor.model.StudentSkill;

public class SkillTest {
	Skill skillAddFractions;
	Skill skillAddFractions2;
	Skill skillMultiplyFractions;
	StudentSkill studentSkillAddFractions;
	
	@Before
	public void init(){
		skillAddFractions = new Skill();
		skillAddFractions.setName(SkillName.ADD_FRACTIONS);
		
		skillAddFractions2 = new Skill();
		skillAddFractions2.setName(SkillName.ADD_FRACTIONS);
		
		skillMultiplyFractions = new Skill();
		skillMultiplyFractions.setName(SkillName.MULTIPLY_FRACTIONS);
		

		studentSkillAddFractions = new StudentSkill();
		
	}
	
	@Test
	public void equals_differentSkills_ShouldReturnFalse(){
		assertFalse(skillAddFractions.equals(skillMultiplyFractions));
	}
	@Test
	public void equals_sameSkills_ShouldReturnTrue(){
		assertTrue(skillAddFractions.equals(skillAddFractions2));
	}
	@Test
	public void hashCode_TwoEqualSkills_True(){
		Skill skill2 = new Skill();
		skill2.setName(SkillName.ADD_FRACTIONS);
		
		assertThat(skillAddFractions.hashCode(), is(skill2.hashCode()));
	}
	
	@Test
	public void hashCode_EquivalentSkillStudentSkill_ShouldReturnSameHashCode(){
		studentSkillAddFractions.setName(SkillName.ADD_FRACTIONS);
		studentSkillAddFractions.setScore(.78);
		
		assertThat(skillAddFractions.hashCode(), is(studentSkillAddFractions.hashCode()));
	}
	
	@Test
	public void hashCode_DifferentSkills_ShouldReturnDifferentHashCode(){
		assertThat(skillAddFractions.hashCode(), not(is(skillMultiplyFractions.hashCode())));
	}

}
