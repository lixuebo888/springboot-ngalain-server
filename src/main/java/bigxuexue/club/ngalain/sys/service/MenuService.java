package bigxuexue.club.ngalain.sys.service;

import java.util.List;

import bigxuexue.club.ngalain.sys.entity.Menu;

public interface MenuService {

	List<Menu> findAll();

	List<Menu> findAll(Menu menu);

	int queryChildCount(String parentId);

	Menu create(Menu menu, String id);

	Menu update(Menu menu, String id);

	void deleteCascadeMenusById(String id);
}
