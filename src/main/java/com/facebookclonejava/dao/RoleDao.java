package com.facebookclonejava.dao;

import com.facebookclonejava.models.Role;

/*
 * @created 06/07/2023 - 11:55 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleDao {
    public Role findRoleByName(String theRoleName);

    public Role addRole(Role role);

    public void deleteRole(Long id);
}
