/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.simulation.core.sexec.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import com.google.inject.Inject;
import static org.junit.Assert.assertTrue;
/**
 * Unit TestCase for TypeAlias
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class TypeAlias extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception{
		ExecutionFlow flow = models.loadExecutionFlowFromResource("TypeAlias.sct");
		initInterpreter(flow);
	}
	@Test
	public void typeAliasTest() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("Start"));
		assertTrue(getInteger("myVar") == 1l);
		interpreter.runCycle();
		assertTrue(isStateActive("Mid"));
		assertTrue(getString("myString").equals("TypeSystem"));
		interpreter.runCycle();
		assertTrue(isStateActive("Mid2"));
		raiseEvent("myEvent");
		interpreter.runCycle();
		assertTrue(isStateActive("End"));
	}
}
