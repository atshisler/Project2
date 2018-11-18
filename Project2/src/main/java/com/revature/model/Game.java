package com.revature.model;

import java.util.Date;

import javax.persistence.*;
public class Game {

@Id
@Column(name = "Game_ID")
@SequenceGenerator(name="gameSequence", allocationSize=1, sequenceName="SQ_GAME_PK")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gameSequence")
private int id;
@Column(name = "TITLE")
private String title;
@Column(name = "GENRE")
private String genre;
@Column(name = "REVIEW")
private String review;
@Column(name = "COMPANY")
private String company;
@Column(name = "PLATFORM")
private String platform;
@Column(name = "RELEASEDATE")
private Date releaseDate;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(int id, String title, String genre, String review, String company, String platform, Date releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.review = review;
		this.company = company;
		this.platform = platform;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", genre=" + genre + ", review=" + review + ", company="
				+ company + ", platform=" + platform + ", releaseDate=" + releaseDate + "]";
	}

}
