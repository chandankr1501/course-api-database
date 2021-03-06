package com.rcn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rcn.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

	public List<Course> findByTopicId(String name);
}
