package bigxuexue.club.ngalain.sys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bigxuexue.club.ngalain.sys.entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
	@Modifying
	@Query("delete from Role where id in (?1)")
	void deleteByIds(List<String> ids);
}
