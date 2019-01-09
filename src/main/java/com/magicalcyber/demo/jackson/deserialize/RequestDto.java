package com.magicalcyber.demo.jackson.deserialize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class RequestDto {

	@JsonDeserialize(using = AllowNullNotEmpty.class)
	private BigDecimal salary;

	@NotNull
	private Date createDate;

	@JsonDeserialize(using = EmptyUserToNullObject.class)
	private User user;

	@NotEmpty
	private List<Post> posts;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
