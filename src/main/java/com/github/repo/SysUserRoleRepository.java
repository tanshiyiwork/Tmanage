package com.github.repo;

import com.github.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Integer> {

    public void deleteSysUserRolesByUserIdEquals(Integer userId);

    public List<SysUserRole> findAllByUserId(Integer userId);

    @Query(value = "SELECT ur.role_id" +
            " FROM SYS_ROLE r" +
            " LEFT JOIN SYS_USER_ROLE ur ON r.role_id = ur.role_id" +
            " LEFT JOIN SYS_USER u ON u.user_id = ur.user_id" +
            " WHERE u.user_id = :userId",nativeQuery = true)
    List<String> selectUserRoleListByUserId(@Param("userId")Integer userId);
}
