package com.qingying.service;

import com.qingying.mapper.RoomOrderMapper;
import com.qingying.model.RoomOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    RoomOrderMapper roomOrderMapper;

    public void addRoomOrder(RoomOrder roomOrder) {
        try {
            roomOrderMapper.addRoomOrder(roomOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询满足条件的订单信息
     *
     * @param roomOrder
     * @return
     */
    public List<RoomOrder> queryOrderListByRoomNo(RoomOrder roomOrder) {
        List<RoomOrder> orderList = null;
        try {
            orderList = roomOrderMapper.queryOrderListByRoomNo(roomOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    /**
     * 更新订单情况
     *
     * @param id
     * @param status
     */
    public void updateRoomOrderStatusById(Integer id, Integer status) {
        try {
            roomOrderMapper.updateRoomOrderStatusById(id, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新订单情况
     *
     * @param roomno
     * @param status
     */
    public void updateRoomOrderStatusByBusinesskey(String roomno, String businesskey, Integer status) {
        try {
            roomOrderMapper.updateRoomOrderStatusByBusinesskey(roomno, businesskey, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
