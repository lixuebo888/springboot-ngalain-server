package bigxuexue.club.ngalain.sys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bigxuexue.club.ngalain.sys.entity.Menu;

@Repository
public interface MenuDAO extends JpaRepository<Menu, String>, JpaSpecificationExecutor<Menu> {
	@Modifying
	@Query("delete from Menu where id in (?1)")
	void deleteByIds(List<String> ids);
	
	@Query("select count(*) from Menu m where m.parentId in ?1")
	int queryChildCount(String parentId);

	@Modifying
	@Query("DELETE FROM Menu WHERE menuSeq LIKE ?1")
	void deleteCascadeMenusById(String id);
	
}
