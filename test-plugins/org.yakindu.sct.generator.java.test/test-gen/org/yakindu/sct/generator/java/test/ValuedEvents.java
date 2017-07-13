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
import org.yakindu.scr.valuedevents.ValuedEventsStatemachine;
import org.yakindu.scr.valuedevents.ValuedEventsStatemachine.State;	

/**
 * Unit TestCase for ValuedEvents
 */
@SuppressWarnings("all")
public class ValuedEvents {
	
	private ValuedEventsStatemachine statemachine;	
	
	
	
	@Before
	public void valuedEvents_setUp() {
		statemachine = new ValuedEventsStatemachine();
		statemachine.init();
	}

	@After
	public void valuedEvents_tearDown() {
		statemachine = null;
	}
	
	@Test
	public void valuedEventsTest() {
		statemachine.enter();
		statemachine.runCycle();
		assertTrue(statemachine.getMyString().equals("sct"));
		statemachine.raiseIntegerEvent(23l);
		statemachine.raiseBooleanEvent(false);
		statemachine.raiseRealEvent(20l);
		statemachine.raiseStringEvent("tool");
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.integer_region_D));
		assertTrue(statemachine.isStateActive(State.string_region_D));
		assertTrue(statemachine.isStateActive(State.boolean_region_D));
		assertTrue(statemachine.isStateActive(State.real_region_D));
		assertTrue(statemachine.getMyInt() == 23l);
		assertTrue(statemachine.getMyBool() == false);
		assertTrue(statemachine.getMyReal() == 20l);
		assertTrue(statemachine.getMyString().equals("tool"));
	}
}
