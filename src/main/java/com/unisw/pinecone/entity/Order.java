package com.unisw.pinecone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "T_ORDER")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column(name = "RECEIVER_NAME", length = 20)
    @NotEmpty(message = "收塔人不能为空。")
    private String reveiverName;

    @Column(length = 20)
    @NotEmpty(message = "手机号码不能为空。")
    private String mobile;

    @Column(length = 200)
    @NotEmpty(message = "详细地址不能为空。")
    private String address;

    @Column(length = 1000)
    private String remark;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getReveiverName()
    {
        return reveiverName;
    }

    public void setReveiverName(String reveiverName)
    {
        this.reveiverName = reveiverName;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return String
                .format("Order[id=%d, user='%s', reveiverName='%s', mobile='%s', address='%s', remark='%s', createTime='%tY-%tm-%td %tH:%tM:%tS']",
                        id, user.getNumber(), reveiverName, mobile, address, remark, createTime);
    }
}
