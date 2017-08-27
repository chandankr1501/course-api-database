package com.rcn.repository;

import org.springframework.data.repository.CrudRepository;

import com.rcn.model.Topic;

public interface TopicRepository extends CrudRepository<Topic,String>{

	
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic topic)
	//deleteTopic(String id)
}
