package com.qingying.mapper;

import com.qingying.model.RoomOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomOrderMapper {

    public void addRoomOrder(RoomOrder roomOrder);

    /**
     * 更新订单状态
     * @param id
     * @param status
     */
    public void updateRoomOrderStatusById(@Param("id") Integer id, @Param("status") Integer status);


    /**
     * 更新订单状态
     * @param roomno
     * @param status
     */
    public void updateRoomOrderStatusByBusinesskey(@Param("roomno") String roomno, @Param("businesskey") String businesskey, @Param("status") Integer status);

    //查询指定房间当天所有入住退房信息 @Param("roomno") String roomno, @Param("pubdate")Integer pubdate
    public List<RoomOrder> queryOrderListByRoomNo(RoomOrder roomOrder);
}
