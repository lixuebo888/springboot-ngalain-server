package bigxuexue.club.ngalain.sys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bigxuexue.club.ngalain.sys.entity.Staff;

@Repository
public interface StaffDAO extends JpaRepository<Staff, String>, JpaSpecificationExecutor<Staff> {
	@Modifying
	@Query("delete from Staff where id in (?1)")
	void deleteByIds(List<String> ids);
}
