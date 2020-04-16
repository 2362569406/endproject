package org.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "userInfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo implements Serializable {
    @Id
    private Integer userId;
    private String userName;
    @JsonIgnore
    private String userPwd;
    private String userDepartment;
    @JsonIgnore
    private String salt;
    @JsonIgnore
    private String reserve2;
    @JsonIgnore
    private String reserve3;
}
