package com.qingying.model;

import java.util.Date;

public class RoomOrder {

    public static final int status_0 = 0;
    public static final int status_Processed = 1;
    public static final int status_cancel = -1;

    public static final int actiontype_checkin = 1;//入住
    public static final int actiontype_checkout = 2;//退房
    public static final int actiontype_extend = 3;//续住
    public static final int actiontype_change = 4;//换房

    private Integer id;
    private String hotelid;
    private String roomno;
    private String businesskey;
    //1普通入住 2退房 3续住 4换房
    private Integer actiontype;
    private Date checkin;
    private Date lastcheckout;
    private Date checkout;

    /**
     * 0:未处理
     * 1：已处理(如果是入住，初始为0，退房成功后为1, 如果是退房则直接标识为1)
     * -1:作废 (如果到达指定lastcheckout时间，但没有退房数据，则系统默认处理为-1)
     */

    private Integer status;
    private Date createtime;
    private Date updatetime;

    public RoomOrder(){

    }

    public RoomOrder(String hotelid, String roomno, String businesskey, Integer actiontype, Date checkin, Date lastcheckout, Date checkout, Integer status) {
        Date date = new Date();
        this.hotelid = hotelid;
        this.roomno = roomno;
        this.businesskey = businesskey;
        this.actiontype = actiontype;
        this.checkin = checkin;
        this.lastcheckout = lastcheckout;
        this.checkout = checkout;
        this.status = status;
        this.createtime = date;
        this.updatetime = date;
    }

    public String getBusinesskey() {
        return businesskey;
    }

    public void setBusinesskey(String businesskey) {
        this.businesskey = businesskey;
    }

    public Integer getActiontype() {
        return actiontype;
    }

    public void setActiontype(Integer actiontype) {
        this.actiontype = actiontype;
    }

    public Date getLastcheckout() {
        return lastcheckout;
    }

    public void setLastcheckout(Date lastcheckout) {
        this.lastcheckout = lastcheckout;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "RoomOrder{" +
                "id=" + id +
                ", hotelid='" + hotelid + '\'' +
                ", roomno='" + roomno + '\'' +
                ", checkin=" + checkin +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
