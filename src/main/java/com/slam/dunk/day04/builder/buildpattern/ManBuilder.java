package com.slam.dunk.day04.builder.buildpattern;


import com.slam.dunk.day04.builder.buildpattern.product.Man;
import com.slam.dunk.day04.builder.buildpattern.product.Person;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class ManBuilder extends PersonBuilder {
	
	private Person person;
	
	public ManBuilder() {
		this.person = new Man();
	}

	@Override
	public void buildHead() {
		person.setHead("Brave Head");
		
	}

	@Override
	public void buildBody() {
		person.setBody("Strong body");
		
	}

	@Override
	public void buildFoot() {
		person.setFoot("powful foot");
		
	}

	@Override
	public Person createPerson() {
		return person;
	}
	
	

}
