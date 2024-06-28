package com.TemplateAndQuery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'name' : ?0 }")
    List<User> findByName(String name);

    @Query("{ 'age' : { '$lt' : ?0 } }")
    List<User> findUsersYoungerThan(int age);

    @Query("{ 'age' : { '$lte' : ?0 } }")
    List<User> findUsersYoungerThanOrEqual(int age);

    @Query("{ 'age' : { '$gt' : ?0 } }")
    List<User> findUsersOlderThan(int age);

    @Query("{ 'age' : { '$gte' : ?0 } }")
    List<User> findUsersOlderThanOrEqual(int age);

    @Query("{ '$and' : [ { 'name' : ?0 }, { 'age' : ?1 } ] }")
    List<User> findByNameAndAge(String name, int age);

    @Query("{ '$or' : [ { 'name' : ?0 }, { 'age' : ?1 } ] }")
    List<User> findByNameOrAge(String name, int age);
}

