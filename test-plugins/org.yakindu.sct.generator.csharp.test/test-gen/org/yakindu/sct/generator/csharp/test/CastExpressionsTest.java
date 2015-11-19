/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.csharp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.castexpressions.CastExpressionsStatemachine;
import org.yakindu.scr.castexpressions.CastExpressionsStatemachine.State;
/**
 *  Unit TestCase for CastExpressions
 */
@SuppressWarnings("all")
public class CastExpressionsTest {

	private CastExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new CastExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testCastExpressionTest() {
		statemachine.enter();
		assertTrue(statemachine.getRealValue() == 5l);
		assertTrue(statemachine.getIntValue() == 5l);
		statemachine.runCycle();
		assertTrue(statemachine.getRealValue() == 15l);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
		assertTrue(statemachine.getRealValue() == 757l);
	}
}
