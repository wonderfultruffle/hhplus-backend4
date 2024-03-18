package io.hhplus.tdd.point;

import io.hhplus.tdd.database.UserPointTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointControllerTest {
    @Test
    void 포인트_조회_성공() throws InterruptedException {
        // point 성공 케이스
        Long init_pt = 0L;
        UserPointTable pt_tbl = new UserPointTable();
        pt_tbl.insertOrUpdate(1L, init_pt);

        PointController pt_ctrl = new PointController();

        assertEquals(pt_ctrl.point(1L), init_pt);
    }

    @Test
    void 포인트_내역_조회_성공() throws InterruptedException {
        // history 성공 케이스
        Long init_pt = 0L;
        UserPointTable pt_tbl = new UserPointTable();
        pt_tbl.insertOrUpdate(1L, init_pt);

        PointController pt_ctrl = new PointController();

        assertEquals(pt_ctrl.point(1L), init_pt);
    }

    @Test
    void 포인트_충전_성공() throws InterruptedException {
        // charge 성공 케이스
        Long user_id = 1L;
        Long init_pt = 0L;
        UserPointTable pt_tbl = new UserPointTable();
        pt_tbl.insertOrUpdate(user_id, init_pt);

        PointController pt_ctrl = new PointController();
        Long amount = 1000L;
        assertEquals(pt_ctrl.charge(user_id, amount), init_pt + amount);
    }
    
    @Test
    void 포인트_최소_충전_금액_미달() throws InterruptedException {
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
    void 포인트_사용_성공() throws InterruptedException {
        // use 성공 케이스
        Long user_id = 1L;
        Long init_pt = 1000L;
        UserPointTable pt_tbl = new UserPointTable();
        pt_tbl.insertOrUpdate(user_id, init_pt);

        PointController pt_ctrl = new PointController();
        Long cost = 500L;
        assertEquals(pt_ctrl.use(user_id, cost), init_pt - cost);
    }


    @Test
    void 포인트_잔액_부족으로_실패() throws InterruptedException {
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