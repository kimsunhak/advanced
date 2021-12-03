package hello.advanced.trace.threadlocal;

import hello.advanced.common.SleepUtil;
import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private SleepUtil sleepUtil = new SleepUtil();
    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> {
            threadLocalService.logic("userA");
        };

        Runnable userB = () -> {
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); //동시성 문제 발생 X
        sleepUtil.sleep(100); //동시성 문제 발생 O
        threadB.start();

        sleepUtil.sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

}
