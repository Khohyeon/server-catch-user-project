package com.side.serverusercatchproject.modules.user.entity;

import com.side.serverusercatchproject.common.jpa.BaseTime;
import com.side.serverusercatchproject.modules.user.dto.UserDTO;
import com.side.serverusercatchproject.modules.user.enums.UserStatus;
import com.side.serverusercatchproject.util.type.RoleType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User extends BaseTime {
    @Id
    @Comment("고유번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Comment("유저아이디")
    private String username;

    @Comment("비밀번호")
    private String password;

    @Comment("권한")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Comment("이메일")
    private String email;

    @Comment("전화번호")
    private String tel;

    @Comment("유저 활성화 상태")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Builder
    public User(Integer id, String username, String password, RoleType role, String email, String tel, UserStatus status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.tel = tel;
        this.status = status;
    }

    public UserDTO toDTO() {
        return new UserDTO(id, username, email, tel, status.name());
    }
}
