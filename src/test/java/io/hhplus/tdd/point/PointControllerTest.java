package io.hhplus.tdd.point;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PointControllerTest {
    private PointController controller = new PointController();
    @Test
    void 사용자를_생성하여_포인트_조회() throws Exception {
        // point 성공 케이스 1
        // 지정한 ID 를 갖는 사용자의 Point Data 가 조회되어야 한다.
        Long userId = 1L;
        assertEquals(controller.point(userId).id(), userId);
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