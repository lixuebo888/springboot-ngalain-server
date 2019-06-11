package bigxuexue.club.ngalain.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bigxuexue.club.ngalain.sys.dao.StaffDAO;
import bigxuexue.club.ngalain.sys.entity.Staff;
import bigxuexue.club.ngalain.sys.service.StaffService;
import bigxuexue.club.ngalain.sys.util.IDGenerator;

@Service
@Transactional
public class RoleServiceImpl implements StaffService {
	@Autowired
	private StaffDAO dao;

	@Override
	public Staff find(String id) {
		if (dao.findById(id).isPresent()) {
			return dao.findById(id).get();
		}
		return null;
	}

	@Override
	public Staff create(Staff staff) {
		staff.setId(IDGenerator.generate());
		staff.setUserStatus(staff.USER_STATUS_ACT);
		return dao.save(staff);
	}

	@Override
	public Staff update(Staff staff) {
		return dao.save(staff);
	}

	@Override
	public void delete(String id) {
		dao.deleteById(id);

	}

	@Override
	public void delete(List<String> ids) {
		dao.deleteByIds(ids);

	}

	@Override
	public List<Staff> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Staff> findAll(Staff staff) {
		Example<Staff> example = Example.of(staff);
		return dao.findAll(example);
	}

	@Override
	public Staff findStaff(Staff staff) {
		Example<Staff> example = Example.of(staff);
		return dao.findOne(example).get();
	}
}
