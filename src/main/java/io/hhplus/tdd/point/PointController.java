package io.hhplus.tdd.point;

import io.hhplus.tdd.database.UserPointTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequestMapping("/point")
@RestController
public class PointController {
    /**
     * TODO - 특정 유저의 포인트를 조회하는 기능을 작성해주세요.
     */
    UserPointTable pointTable = new UserPointTable();

    @GetMapping("{id}")
    public UserPoint point(@PathVariable Long id) throws InterruptedException {
        return pointTable.selectById(id);
    }

    /**
     * TODO - 특정 유저의 포인트 충전/이용 내역을 조회하는 기능을 작성해주세요.
     */
    @GetMapping("{id}/histories")
    public List<PointHistory> history(@PathVariable Long id) {

        return Collections.emptyList();
    }

    /**
     * TODO - 특정 유저의 포인트를 충전하는 기능을 작성해주세요.
     */
    @PatchMapping("{id}/charge")
    public UserPoint charge(@PathVariable Long id, @RequestBody Long amount) throws InterruptedException {
        UserPoint point;

        if (amount < 1000L) {
            System.out.println("Warning: The charge amount must be greater than or equal to 1000.");
            point = this.pointTable.selectById(id);
        } else if (amount > 99999999L) {
            System.out.println("Warning: The charge amount must be less than or equal to 99999999.");
            point = this.pointTable.selectById(id);
        } else{
            point = this.pointTable.insertOrUpdate(id, amount);
        }
        System.out.println("[Result]");
        System.out.println("User ID: "+ point.id());
        System.out.println("Point: "+ point.point());
        return point;
    }

    /**
     * TODO - 특정 유저의 포인트를 사용하는 기능을 작성해주세요.
     */
    @PatchMapping("{id}/use")
    public UserPoint use(@PathVariable Long id, @RequestBody Long amount) {
        return new UserPoint(0L, 0L, 0L);
    }
}
