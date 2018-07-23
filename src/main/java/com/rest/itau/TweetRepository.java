package com.rest.itau;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called tweetRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	@Query(value = "SELECT count(id) as cnt,HOUR(created_at) as hour "
			+ "FROM tweets "
			+ "GROUP BY HOUR(created_at) "
			+ "ORDER BY HOUR(created_at) asc",nativeQuery = true)
	List<TweetPerHour> findTweetCountPerHour();
	
	public static interface TweetPerHour{
		public Long getCnt();
		public Integer getHour();
	}
	
	
	@Query(value = "SELECT count(tweets.id) as cnt,tweets.hashtag,users.lang "
			+ "FROM tweets "
			+ "INNER JOIN users ON tweets.user_id=users.id "
			+ "GROUP BY tweets.hashtag, users.lang "
			+ "ORDER BY tweets.hashtag",nativeQuery = true)
	List<TweetByHashtagByLang> findTweetCountByHashtagByLang();
	
	public static interface TweetByHashtagByLang{
		public Long getCnt();
		public String getHashtag();
		public String getLang();
	}
	
	
}
