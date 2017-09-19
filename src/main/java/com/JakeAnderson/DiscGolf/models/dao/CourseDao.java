package com.JakeAnderson.DiscGolf.models.dao;


import com.JakeAnderson.DiscGolf.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseDao extends CrudRepository<Course, Integer> {
}
