package bigxuexue.club.ngalain.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigxuexue.club.ngalain.sys.entity.Role;
import bigxuexue.club.ngalain.sys.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping("/all")
	public List<Role> findList(Role role) {
		List<Role> roles = roleService.findAll(role);
		return roles;

	}

}
