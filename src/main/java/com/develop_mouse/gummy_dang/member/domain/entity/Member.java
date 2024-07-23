package com.develop_mouse.gummy_dang.member.domain.entity;

import java.util.Set;

import com.develop_mouse.gummy_dang.common.entity.BaseEntity;
import com.develop_mouse.gummy_dang.post.domain.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

	@Id @Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "member")
	private Set<Post> posts;

	@NotNull
	private String userName;
	@NotNull
	private String password;

	private String address;
	private String phoneNumber;
	private String socialId;

}
