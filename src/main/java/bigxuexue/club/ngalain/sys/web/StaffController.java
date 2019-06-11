package bigxuexue.club.ngalain.sys.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bigxuexue.club.ngalain.sys.entity.Staff;
import bigxuexue.club.ngalain.sys.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffService staffService;

	@GetMapping("/all")
	public List<Staff> findList(@RequestParam(required = false) String id) {
		List<Staff> staffs = new ArrayList<>();
		if (StringUtils.isEmpty(id)) {
			staffs = staffService.findAll();
		} else {
			if (!StringUtils.isEmpty(staffService.find(id))) {
				staffs.add(staffService.find(id));
			}
		}
		return staffs;

	}

}
