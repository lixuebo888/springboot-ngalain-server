package bigxuexue.club.ngalain.sys.dto;

import java.io.Serializable;
import java.util.List;

public class ResultMenuDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private String key;

	private boolean isLeaf;

	private List<ResultMenuDTO> children;

	private String id;

	private String menuUrl; // 菜单URL

	private Integer menuLevel; // 级别，从0开始

	private String parentId; // 父menu_id，对于没有上级的，写-1

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<ResultMenuDTO> getChildren() {
		return children;
	}

	public void setChildren(List<ResultMenuDTO> children) {
		this.children = children;
	}

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

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
