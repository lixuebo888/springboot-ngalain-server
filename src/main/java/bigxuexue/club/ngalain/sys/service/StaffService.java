package bigxuexue.club.ngalain.sys.service;

import java.util.List;

import bigxuexue.club.ngalain.sys.entity.Staff;

public interface StaffService {
	Staff find(String id);
	
	Staff findStaff(Staff staff);

	Staff create(Staff staff);

	Staff update(Staff staff);

	void delete(String id);

	void delete(List<String> ids);

	List<Staff> findAll();
	
	List<Staff> findAll(Staff staff);

}
