package bigxuexue.club.ngalain.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PORTAL_MENU")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", length = 32)
	private String id;

	@Column(name = "MENU_URL", length = 2000)
	private String menuUrl; // 菜单URL

	@Column(name = "MENU_LABEL", length = 200)
	private String menuLabel; // 菜单显示名称

	@Column(name = "SHORTCUT_LABEL", length = 200)
	private String shortCutLabel; // 快捷入口菜单显示名称

	@Column(name = "MENU_LEVEL", length = 32)
	private Integer menuLevel; // 级别，从0开始

	@Column(name = "PARENT_ID", length = 32)
	private String parentId; // 父menu_id，对于没有上级的，写-1

	@Column(name = "ORDER_COLUMN", length = 200)
	private Integer orderColumn; // 显示顺序，每一级的排序

	@Column(name = "MENU_SEQ", length = 2000)
	private String menuSeq; // 序列，格式类似“祖父menu_id.父menu_id.自己menu_id”，有多少父级就记录多少，如
	// 111.222.333，对于没有父级的，即father_id=-1的，就写自己的

	@Column(name = "memo", length = 200)
	private String memo; // 备注

	@Column(name = "CREATE_USERID", length = 32)
	private String createUserId; // 创建人

	@Column(name = "CREATE_TIME")
	private Date createTime; // 创建时间

	@Column(name = "UPDATE_TIME")
	private Date updateTime; // 更新时间

	@Column(name = "IS_SHOW", length = 32)
	private String isShow; // 是否启用，true-启用，false-不启用

	@Column(name = "IMG", length = 1024 * 1024) // 1G
	private byte[] img; // 桌面端图标 BLOB

	public static final String PC_ROOT_ID = "0";

	public static final String MOBILE_ROOT_ID = "1";

	public static final String ROOT = "-1";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuLabel() {
		return menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public String getShortCutLabel() {
		return shortCutLabel;
	}

	public void setShortCutLabel(String shortCutLabel) {
		this.shortCutLabel = shortCutLabel;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(int orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(String menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
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

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Menu() {
		super();
	}

	public Menu(String parentId) {
		super();
		this.parentId = parentId;
	}

}
