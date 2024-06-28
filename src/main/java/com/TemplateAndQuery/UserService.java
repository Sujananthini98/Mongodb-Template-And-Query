package com.TemplateAndQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> findUsersByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findUsersYoungerThan(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lt(age));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findUsersYoungerThanOrEqual(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lte(age));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findUsersOlderThan(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(age));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findUsersOlderThanOrEqual(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(age));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findByNameAndAge(String name, int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name).and("age").is(age));
        return mongoTemplate.find(query, User.class);
    }

    public List<User> findByNameOrAge(String name, int age) {
        Query query = new Query();
        query.addCriteria(new Criteria().orOperator(
            Criteria.where("name").is(name),
            Criteria.where("age").is(age)
        ));
        return mongoTemplate.find(query, User.class);
    }
}
