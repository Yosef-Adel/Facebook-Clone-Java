package com.facebookclonejava.controller.Request;

import lombok.*;

/*
 * @created 09/07/2023 - 10:26 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class UserRequest {
    private String name;
    private String email ;
    private String password;
}
