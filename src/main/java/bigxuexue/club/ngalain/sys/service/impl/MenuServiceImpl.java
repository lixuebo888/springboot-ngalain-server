package bigxuexue.club.ngalain.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bigxuexue.club.ngalain.sys.dao.MenuDAO;
import bigxuexue.club.ngalain.sys.entity.Menu;
import bigxuexue.club.ngalain.sys.service.MenuService;
import bigxuexue.club.ngalain.sys.util.IDGenerator;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDAO dao;

	@Override
	public List<Menu> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Menu> findAll(Menu menu) {
		Example<Menu> example = Example.of(menu);
		return dao.findAll(example);
	}

	@Override
	public int queryChildCount(String parentId) {
		return dao.queryChildCount(parentId);
	}

	@Override
	public Menu create(Menu menu, String id) {
		String uuid = IDGenerator.generate();
		Menu node = dao.getOne(id);
		menu.setId(uuid);
		menu.setMenuSeq(node.getMenuSeq().concat(".").concat(uuid));
		menu.setMenuLevel(node.getMenuLevel()+1);
		menu.setParentId(id);
		menu.setIsShow("true");
		menu.setCreateTime(new Date());
		menu.setUpdateTime(new Date());
		return dao.save(menu);
	}
}
