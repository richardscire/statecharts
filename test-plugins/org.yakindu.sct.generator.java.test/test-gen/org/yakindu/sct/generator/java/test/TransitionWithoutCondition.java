/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.transitionwithoutcondition.TransitionWithoutConditionStatemachine;
import org.yakindu.scr.transitionwithoutcondition.TransitionWithoutConditionStatemachine.State;	

/**
 * Unit TestCase for TransitionWithoutCondition
 */
@SuppressWarnings("all")
public class TransitionWithoutCondition {
	
	private TransitionWithoutConditionStatemachine statemachine;	
	
	
	
	@Before
	public void transitionWithoutCondition_setUp() {
		statemachine = new TransitionWithoutConditionStatemachine();
		statemachine.init();
	}

	@After
	public void transitionWithoutCondition_tearDown() {
		statemachine = null;
	}
	
	@Test
	public void transitionWithoutConditionTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
}
