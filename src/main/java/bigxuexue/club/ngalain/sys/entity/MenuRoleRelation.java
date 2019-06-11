package bigxuexue.club.ngalain.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PORTAL_MENU_ROLE")
public class MenuRoleRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", length = 32)
	private String id;

	@Column(name = "MENU_ID", length = 32)
	private String menuId; // 菜单ID，对应表QY_FUN_MENU的MENU_ID

	@Column(name = "ROLE_ID", length = 32)
	private String roleId; // 角色ID，对应表QY_ROLE的ROLE_ID

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

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
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
