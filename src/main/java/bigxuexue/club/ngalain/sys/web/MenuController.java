package bigxuexue.club.ngalain.sys.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigxuexue.club.ngalain.sys.dto.ResultMenuDTO;
import bigxuexue.club.ngalain.sys.entity.Menu;
import bigxuexue.club.ngalain.sys.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	@GetMapping("/all")
	public List<Menu> findList(Menu menu) {
		List<Menu> menus = menuService.findAll(menu);
		return menus;
	}

	/**
	 * 初始化资源权限树形结构(查找所有资源权限)
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<ResultMenuDTO> innitPermissions() {

		List<Menu> menus = menuService.findAll();

		List<ResultMenuDTO> finalList = new ArrayList<>();

		// 先找到所有的一级菜单
		for (Menu menu : menus) {
			// 一级菜单父id为-1
			if (menu.getParentId().equals("-1")) {
				ResultMenuDTO resultMenuDTO = new ResultMenuDTO();
				resultMenuDTO.setId(menu.getId());
				resultMenuDTO.setMenuLevel(menu.getMenuLevel());
				resultMenuDTO.setMenuUrl(menu.getMenuUrl());
				resultMenuDTO.setParentId(menu.getParentId());
				resultMenuDTO.setTitle(menu.getMenuLabel());
				resultMenuDTO.setKey(menu.getId());
				int count = menuService.queryChildCount(menu.getId());
				if (count == 0) {
					resultMenuDTO.setIsLeaf(true);
				} else {
					resultMenuDTO.setIsLeaf(false);
				}
				finalList.add(resultMenuDTO);
			}
		}
		// 为一级菜单设置子菜单，getChild是递归调用的
		for (ResultMenuDTO resultMenuDTO : finalList) {
			resultMenuDTO.setChildren(getChild(resultMenuDTO.getId(), menus));
		}
		return finalList;
	}

	/**
	 * 查询资源权限的子权限
	 * 
	 * @param id
	 * @param root
	 * @return
	 */
	private List<ResultMenuDTO> getChild(String id, List<Menu> menus) {
		// 子菜单
		List<ResultMenuDTO> childList = new ArrayList<>();
		for (Menu menu : menus) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (!menu.getParentId().equals("-1")) {
				if (menu.getParentId().equals(id)) {
					ResultMenuDTO resultMenuDTO = new ResultMenuDTO();
					resultMenuDTO.setId(menu.getId());
					resultMenuDTO.setMenuLevel(menu.getMenuLevel());
					resultMenuDTO.setMenuUrl(menu.getMenuUrl());
					resultMenuDTO.setParentId(menu.getParentId());
					resultMenuDTO.setTitle(menu.getMenuLabel());
					resultMenuDTO.setKey(menu.getId());
					int count = menuService.queryChildCount(menu.getId());
					if (count == 0) {
						resultMenuDTO.setIsLeaf(true);
					} else {
						resultMenuDTO.setIsLeaf(false);
					}
					childList.add(resultMenuDTO);
				}
			}
		}
		// 递归终止的条件,没有子权限时
		if (childList.size() == 0) {
			return null;
		}
		// 如果有子菜单还有子菜单,把子菜单的子菜单再循环一遍
		for (ResultMenuDTO resultMenuDTO : childList) {
			resultMenuDTO.setChildren(getChild(resultMenuDTO.getId(), menus));
		}

		return childList;
	}

	@PostMapping("/{id}/save")
	public Menu saveMenu(@RequestBody Menu menu, @PathVariable("id") String id) {
		return menuService.create(menu, id);
	}
	
	@PostMapping("/{id}/edit")
	public Menu editMenu(@RequestBody Menu menu, @PathVariable("id") String id) {
		return menuService.update(menu, id);
	}
	
	@PostMapping("/{id}/delete")
	public void deleteMenu(@PathVariable("id") String id) {
		menuService.deleteCascadeMenusById(id);
	}

}
