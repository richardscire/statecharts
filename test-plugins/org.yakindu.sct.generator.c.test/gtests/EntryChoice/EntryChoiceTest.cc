/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "EntryChoice.h"

#include "sc_timer_service.h"



//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;

static EntryChoice statechart;

class EntryChoiceTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		entryChoice_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &entryChoice_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(EntryChoiceTest, EntryChoiceTest) {
	entryChoice_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(entryChoice_isStateActive(&statechart, EntryChoice_main_region_A));
}


