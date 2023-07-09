package com.facebookclonejava.dao.impl;

import com.facebookclonejava.dao.RoleDao;
import com.facebookclonejava.models.Role;
import com.facebookclonejava.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/*
 * @created 06/07/2023 - 11:55 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

@Repository
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;
    @Override
    public Role findRoleByName(String theRoleName) {
        return roleRepository.findByName(theRoleName);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
