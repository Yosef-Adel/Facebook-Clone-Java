package com.facebookclonejava.dao;

import com.facebookclonejava.models.Role;

/*
 * @created 06/07/2023 - 11:55 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleDao {
    Role findRoleByName(String theRoleName);

    Role addRole(Role role);

    void deleteRole(Long id);
}
