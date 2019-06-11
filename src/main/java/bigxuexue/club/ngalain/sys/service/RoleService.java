package bigxuexue.club.ngalain.sys.service;

import java.util.List;

import bigxuexue.club.ngalain.sys.entity.Role;

public interface RoleService {

	List<Role> findAll();

	List<Role> findAll(Role role);

}
