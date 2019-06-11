package bigxuexue.club.ngalain.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_PORTAL_STAFF")
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 用户状态 ACT激活状态
	 * 
	 */

	@Transient
	public final String USER_STATUS_ACT = "ACT";

	@Id

	@Column(name = "ID", length = 32)

	private String id;

	@Column(name = "USER_NAME", length = 200)

	private String userName; // 真实姓名，与表QY_LOGIN中的USER_NAME对应

	@Column(name = "GENDER", length = 32)

	private String gender; // 性别，对应性别数据字典（以后做），M-男性，F-女性，U-未说明的性别，其他-不详

	@Column(name = "BIRTHDAY")

	private Date birthday; // 出生日期

	@Column(name = "USER_STAUS")

	private String userStatus;

	@Column(name = "MOBILE", length = 200)

	private String mobile; // 手机号码

	@Column(name = "OFFICE_TEL", length = 200)

	private String officeTel; // 办公电话

	@Column(name = "OFFICE_ADDR", length = 200)

	private String officeAddr; // 办公地址

	@Column(name = "MAIL", length = 200)

	private String mail; // 电子邮件，可以不是工作邮箱

	@Column(name = "MEMO", length = 200)

	private String memo; // 备注

	@Column(name = "PASSWORD", length = 20)
	private String password;// 登录密码

	// 操作信息

	@Column(name = "CREATE_TIME")

	private Date createTime; // 创建时间
	@Column(name = "UPDATE_TIME")

	private Date updateTime; // 更新时间

	@Column(name = "CREATER", length = 32)

	private String creater; // 创建人，系统自动记录，当前操作用户USER_ID

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getOfficeAddr() {
		return officeAddr;
	}

	public void setOfficeAddr(String officeAddr) {
		this.officeAddr = officeAddr;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

}
