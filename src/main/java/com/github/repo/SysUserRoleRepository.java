package com.github.repo;

import com.github.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Integer> {

    public void deleteSysUserRolesByUserIdEquals(Integer userId);

    public List<SysUserRole> findAllByUserId(Integer userId);

    List<SysUserRole> findAllByRoleIdIs(Integer roleId);

    @Query(value = "SELECT ur.role_id" +
            " FROM SYS_ROLE r" +
            " LEFT JOIN SYS_USER_ROLE ur ON r.role_id = ur.role_id" +
            " LEFT JOIN SYS_USER u ON u.user_id = ur.user_id" +
            " WHERE u.user_id = :userId",nativeQuery = true)
    List<String> selectUserRoleListByUserId(@Param("userId")Integer userId);

    @Query(value = "SELECT r.role_code" +
            " FROM SYS_ROLE r" +
            " LEFT JOIN SYS_USER_ROLE ur ON r.role_id = ur.role_id" +
            " LEFT JOIN SYS_USER u ON u.user_id = ur.user_id" +
            " WHERE u.user_id = :userId",nativeQuery = true)
    List<String> selectRoleCodeByUserId(@Param("userId")Integer userId);

    @Query(value = "SELECT r.ROLE_ID,r.ROLE_NAME,r.ROLE_CODE,r.ROLE_DESC,r.DS_TYPE,r.DS_SCOPE,r.CREATE_TIME,r.UPDATE_TIME,r.DEL_FLAG" +
            " FROM SYS_ROLE r" +
            " LEFT JOIN SYS_USER_ROLE ur ON r.ROLE_ID = ur.ROLE_ID" +
            " LEFT JOIN SYS_USER u ON ur.USER_ID = u.USER_ID" +
            " WHERE u.USER_ID = :userId",nativeQuery = true)
    List<Object[]> selectRoleByUserId(@Param("userId")Integer userId);
}
