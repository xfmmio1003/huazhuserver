package com.qingying.model;

import com.qingying.mapper.CityMapper;
import com.qingying.mapper.RoomOrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuazhuserverApplicationTests {

   @Autowired
   RoomOrderMapper roomOrderMapper;
    @Test
    public void contextLoads() {
        RoomOrder roomOrder = new RoomOrder();
        roomOrder.setRoomno("1_2_8201_0");
        List list = roomOrderMapper.queryOrderListByRoomNo(roomOrder);
        System.out.println(list.size());
    }

}
