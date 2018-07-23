package com.rest.itau;



import java.util.Date;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
	@Id
	private Long id;
	
	private String name;
	
	private String screen_name;
	
	private Integer followers_count;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	private Integer statuses_count;
	
	private String lang;

	/*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Tweet> tweets;*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public Integer getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(Integer followers_count) {
		this.followers_count = followers_count;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Integer getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(Integer statuses_count) {
		this.statuses_count = statuses_count;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

//	
//    public Set<Tweet> getTweets() {
//        return tweets;
//    }
//	
//	public void setTweets(Set<Tweet> tweets) {
//		this.tweets = tweets;
//	}
}
