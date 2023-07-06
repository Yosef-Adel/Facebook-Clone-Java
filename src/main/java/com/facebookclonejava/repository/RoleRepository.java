package com.facebookclonejava.repository;

import com.facebookclonejava.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 06/07/2023 - 11:56 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
