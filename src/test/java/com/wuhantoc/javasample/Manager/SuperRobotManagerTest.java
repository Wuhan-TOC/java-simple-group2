package com.wuhantoc.javasample.Manager;

import com.wuhantoc.javasample.entity.Ticket;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperRobotManagerTest {

    @Test
    public void should_store_in_locker1_when_save_package_given_locker1_has_2_capacity_no_box_used_and_locker2_has_2_capacity_no_box_used() {
        // given
        SuperRobotManager superRobotManager = new SuperRobotManager(2, Arrays.asList(2, 2));

        // when
        Ticket ticket = superRobotManager.savePackage();

        //than
        assertNotNull(ticket);
        assertEquals(1, ticket.getLockerNumber());
    }

    @Test
    public void should_store_in_locker1_when_save_package_given_locker1_has_2_capacity_1_box_used_and_locker2_has_6_capacity_3_box_used() {
        // given
        SuperRobotManager superRobotManager = new SuperRobotManager(2, Arrays.asList(2, 6));
        LockerManager lockerManager = superRobotManager.getLockerManagers().get(1);
        lockerManager.savePackage();
        lockerManager.savePackage();
        lockerManager.savePackage();

        // when
        Ticket ticket = superRobotManager.savePackage();

        //than
        assertNotNull(ticket);
        assertEquals(1, ticket.getLockerNumber());
    }

    @Test
    void should_store_in_locker2_when_save_package_given_locker1_has_4_capacity_1_box_be_used_and_locker2_has_2_capacity_no_box_used() {
        // given
        SuperRobotManager superRobotManager = new SuperRobotManager(2, Arrays.asList(4, 2));
        superRobotManager.getLockerManagers().get(0).savePackage();

        //when
        Ticket ticket = superRobotManager.savePackage();


        //than
        assertNotNull(ticket);
        assertEquals(2, ticket.getLockerNumber());
    }

    @Test
    public void should_return_null_when_save_package_given_locker1_has_0_capacity_and_locker2_has_0_capacity () {
        // given
        SuperRobotManager superRobotManager = new SuperRobotManager(2, Arrays.asList(0, 0));

        // when
        Ticket ticket = superRobotManager.savePackage();

        // then
        assertNull(ticket);
    }

}
