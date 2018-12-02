package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class GameUser {
	@Id
	@Column(name = "User_ID")
	@SequenceGenerator(name="userSequence", allocationSize=1, sequenceName="SQ_USER_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	private int id;
	
	@Column(name = "USERNAME", unique = true)
	private String username;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ROLE")
	private String role;
	
	//@ManyToOne
	//@JoinColumn(name="GAME_ID")
	//List<Game> gameList = new ArrayList<>();
	
	public GameUser() {
		super();
	}

	public GameUser(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*
	 public List<Game> getGameList() {
	
		return gameList;
	}

	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}
 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password="
				+ password + ", role=" + role + "]";
	}
	
	

}
