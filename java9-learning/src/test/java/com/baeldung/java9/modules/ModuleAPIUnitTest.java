package com.baeldung.java9.modules;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.sql.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class ModuleAPIUnitTest {

	private class Person {
        private String name;
        public Person(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
	
	public static final String JAVA_BASE_MODULE_NAME = "java.base";

	private Module javaBaseModule;
	private Module javaSqlModule;
	private Module module;
	
	@Before
	public void setUp() {
		javaBaseModule = HashMap.class.getModule();
		javaSqlModule = Date.class.getModule();
		module = Person.class.getModule();
	}
	
	@Test
	public void whenCheckingIfNamed_thenModuleIsNamed() {
		assertThat(javaBaseModule.isNamed(), is(true));
	}
}
