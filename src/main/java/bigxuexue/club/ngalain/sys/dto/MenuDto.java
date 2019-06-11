package bigxuexue.club.ngalain.sys.dto;

import java.util.List;

import bigxuexue.club.ngalain.sys.entity.Menu;

public class MenuDto {
	private List<Menu> menuList;
	private int childrenCount;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}
}
