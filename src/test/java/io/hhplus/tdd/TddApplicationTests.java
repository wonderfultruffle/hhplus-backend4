package io.hhplus.tdd;

import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.point.PointController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TddApplicationTests {

	PointController pt = new PointController();

	@Test
	void contextLoads() { // contextLoads 의 의미는? 그냥 사용한거?
	}

	@Test
	void test_point() throws InterruptedException {
		// point 성공 케이스
		Long init_pt = 0L;
		UserPointTable pt_tbl = new UserPointTable();
		pt_tbl.insertOrUpdate(1L, init_pt);

		PointController pt_ctrl = new PointController();

		assertEquals(pt_ctrl.point(1L), init_pt);
	}

//	@Test
//	void test_point_nonexist_user() throws InterruptedException {
//		// point 실패 케이스
//		Long init_pt = 0L;
//		UserPointTable pt_tbl = new UserPointTable();
//		pt_tbl.insertOrUpdate(1L, init_pt);
//
//		PointController pt_ctrl = new PointController();
//
//		// 실패하는지 확인하는 함수
//		assert???(pt_ctrl.point(2L));
//	}

	@Test
	void test_history() throws InterruptedException {
		// history 성공 케이스
		Long init_pt = 0L;
		UserPointTable pt_tbl = new UserPointTable();
		pt_tbl.insertOrUpdate(1L, init_pt);

		PointController pt_ctrl = new PointController();

		assertEquals(pt_ctrl.point(1L), init_pt);
	}

//	@Test
//	void test_history_with_nonexist_user() throws InterruptedException {
//		// history 실패 케이스
//		Long init_pt = 0L;
//		UserPointTable pt_tbl = new UserPointTable();
//		pt_tbl.insertOrUpdate(1L, init_pt);
//
//		PointController pt_ctrl = new PointController();
//		// 실패 확인 메서드
//		assert???(pt_ctrl.history(1L));
//	}

	@Test
	void test_charge() throws InterruptedException {
		// charge 성공 케이스
		Long user_id = 1L;
		Long init_pt = 0L;
		UserPointTable pt_tbl = new UserPointTable();
		pt_tbl.insertOrUpdate(user_id, init_pt);

		PointController pt_ctrl = new PointController();
		Long amount = 1000L;
		assertEquals(pt_ctrl.charge(user_id, amount), init_pt + amount);
	}
	
//	@Test
//	void test_charge_with_nonexist_user() throws InterruptedException {
//		// charge 실패 케이스 1: 없는 사용자
//		Long user_id = 1L;
//		Long init_pt = 0L;
//		UserPointTable pt_tbl = new UserPointTable();
//		pt_tbl.insertOrUpdate(user_id, init_pt);
//
//		PointController pt_ctrl = new PointController();
//		Long amount = 1000L;
//		// 실패 확인 메서드
//		assert???(pt_ctrl.charge(2L, amount));
//	}
//
	@Test
	void test_charge_with_below_minimum() throws InterruptedException {
		// charge 실패 케이스 2: 충전 가능 최소 금액 미만
		Long user_id = 1L;
		Long init_pt = 0L;
		UserPointTable pt_tbl = new UserPointTable();
		pt_tbl.insertOrUpdate(user_id, init_pt);

		PointController pt_ctrl = new PointController();
		Long amount = 1L;
		// 실패 확인 메서드
		// 포인트 충전은 실패하고 잔액은 충전 전과 동일해야 한다.
		assertEquals(pt_ctrl.charge(user_id, amount), init_pt);
	}

	@Test
	void test_use() throws InterruptedException {
		// use 성공 케이스
		Long user_id = 1L;
		Long init_pt = 1000L;
		UserPointTable pt_tbl = new UserPointTable();
		pt_tbl.insertOrUpdate(user_id, init_pt);

		PointController pt_ctrl = new PointController();
		Long cost = 500L;
		assertEquals(pt_ctrl.use(user_id, cost), init_pt - amount);
	}
	
//	@Test
//	void test_use_with_nonexist_user() throws InterruptedException {
//		// use 실패 케이스 1: 없는 사용자
//		Long user_id = 1L;
//		Long init_pt = 1000L;
//		UserPointTable pt_tbl = new UserPointTable();
//		pt_tbl.insertOrUpdate(user_id, init_pt);
//
//		PointController pt_ctrl = new PointController();
//		Long cost = 500L;
//		// 실패 확인 메서드
//		assert???(pt_ctrl.use(2L, cost));
//	}

	@Test
	void test_use_with_insufficient_funds() throws InterruptedException {
		// use 실패 케이스 2: 잔액 부족
		Long user_id = 1L;
		Long init_pt = 1000L;
		UserPointTable pt_tbl = new UserPointTable();
		pt_tbl.insertOrUpdate(user_id, init_pt);

		PointController pt_ctrl = new PointController();
		Long cost = 10000L;
		// 실패 확인 메서드
		// 포인트 사용은 실패하고 잔액은 사용 전과 동일해야 한다.
		assert???(pt_ctrl.use(user_id, cost), init_pt);
	}
}