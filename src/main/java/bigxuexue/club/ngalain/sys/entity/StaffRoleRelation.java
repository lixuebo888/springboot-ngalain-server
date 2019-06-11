package bigxuexue.club.ngalain.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PORTAL_STAFF_ROLE")
public class StaffRoleRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", length = 32)
	private String id;

	@Column(name = "USER_ID", length = 32, nullable = false)
	private String userId;

	@Column(name = "ROLE_ID", length = 32, nullable = false)
	private String roleId;

	@Column(name = "CREATE_USERID", length = 32)
	private String createUserid; // 创建人 ID

	@Column(name = "CREATE_TIME")
	private Date createTime; // 创建时间

	@Column(name = "UPDATE_TIME")
	private Date updateTime; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
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

}
