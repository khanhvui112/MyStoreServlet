package com.sanvui.model.dto;

import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author: VuiSK
 * @created: 11/11/2021-9:40 PM
 * @mailto: sanvankhanh@gmail.com
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LoginDTO {
    private String userName;
    private String password;
    private String role;
    private String avatar;

    @Override
    public String toString() {
        return "LoginDTO{" +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
