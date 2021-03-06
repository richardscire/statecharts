/* Generated by YAKINDU Statechart Tools code generator. */
#include <string>
#include "gtest/gtest.h"
#include "ChildFirstExecutionHierarchy.h"
#include "sc_runner.h"
#include "sc_types.h"



static ChildFirstExecutionHierarchy* statechart;

//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ChildFirstExecutionHierarchyTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ChildFirstExecutionHierarchy();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};

void assertNoLocalReaction(){
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_local());
	
}

TEST_F(ChildFirstExecutionHierarchyTest, childShouldTakeTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_B));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_reacted());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_reacted());
	
	assertNoLocalReaction();
	
}
TEST_F(ChildFirstExecutionHierarchyTest, parentShouldTakeTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->set_disable_aaa(true);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_B));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_reacted());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local());
	
}
TEST_F(ChildFirstExecutionHierarchyTest, grandparentShouldTakeTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->set_disable_aa(true);
	
	statechart->getDefaultSCI()->set_disable_aaa(true);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local());
	
}
TEST_F(ChildFirstExecutionHierarchyTest, expectLocalReactrionsExecuteWithNoTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ChildFirstExecutionHierarchy::ChildFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local());
	
}
