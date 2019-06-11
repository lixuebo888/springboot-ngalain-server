package bigxuexue.club.ngalain.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bigxuexue.club.ngalain.sys.dao.RoleDAO;
import bigxuexue.club.ngalain.sys.entity.Role;
import bigxuexue.club.ngalain.sys.service.RoleService;

@Service
@Transactional
public class StaffServiceImpl implements RoleService {
	@Autowired
	private RoleDAO dao;

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Role> findAll(Role role) {
		Example<Role> example = Example.of(role);
		return dao.findAll(example);
	}
}
