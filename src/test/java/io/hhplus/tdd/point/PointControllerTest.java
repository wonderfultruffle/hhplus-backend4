package io.hhplus.tdd.point;

import io.hhplus.tdd.database.UserPointTable;
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
    void 이미_존재하는_사용자의_포인트_조회() throws Exception {
        // point 성공 케이스 2
        // 이미 존재하는 사용자 id 에 대해선 UserPoint 가 새로 생성되지 않고
        // UserPointTable 에 저장된 Data 가 조회되어야 한다.
        Long userId = 1L;
        UserPoint point = controller.point(userId);
//        assertEquals(point.id(), userId); // 사용자를_생성하여_포인트_조회() 의 test 를 포함할 수 있는 내용이 중복되어도 괜찮은가?

        Long saveTime = point.updateMillis();
        assertEquals(controller.point(userId).updateMillis(), saveTime);
    }
//    @Test
//    void 포인트_충전_성공() throws InterruptedException {
//        // charge 성공 케이스
//        Long user_id = 1L;
//        Long init_pt = 0L;
//        UserPointTable pt_tbl = new UserPointTable();
//        pt_tbl.insertOrUpdate(user_id, init_pt);
//
//        PointController pt_ctrl = new PointController();
//        Long amount = 1000L;
//        assertEquals(pt_ctrl.charge(user_id, amount), init_pt + amount);
//    }
//
//    @Test
//    void 포인트_최소_충전_금액_미달() throws InterruptedException {
//        // charge 실패 케이스 2: 충전 가능 최소 금액 미만
//        Long user_id = 1L;
//        Long init_pt = 0L;
//        UserPointTable pt_tbl = new UserPointTable();
//        pt_tbl.insertOrUpdate(user_id, init_pt);
//
//        PointController pt_ctrl = new PointController();
//        Long amount = 1L;
//        // 실패 확인 메서드
//        // 포인트 충전은 실패하고 잔액은 충전 전과 동일해야 한다.
//        assertEquals(pt_ctrl.charge(user_id, amount), init_pt);
//    }
//
//    @Test
//    void 포인트_사용_성공() throws InterruptedException {
//        // use 성공 케이스
//        Long user_id = 1L;
//        Long init_pt = 1000L;
//        UserPointTable pt_tbl = new UserPointTable();
//        pt_tbl.insertOrUpdate(user_id, init_pt);
//
//        PointController pt_ctrl = new PointController();
//        Long cost = 500L;
//        assertEquals(pt_ctrl.use(user_id, cost), init_pt - cost);
//    }
//
//
//    @Test
//    void 포인트_잔액_부족으로_실패() throws InterruptedException {
//        // use 실패 케이스 2: 잔액 부족
//        Long user_id = 1L;
//        Long init_pt = 1000L;
//        UserPointTable pt_tbl = new UserPointTable();
//        pt_tbl.insertOrUpdate(user_id, init_pt);
//
//        PointController pt_ctrl = new PointController();
//        Long cost = 10000L;
//        // 실패 확인 메서드
//        // 포인트 사용은 실패하고 잔액은 사용 전과 동일해야 한다.
//        assert???(pt_ctrl.use(user_id, cost), init_pt);
//    }
}