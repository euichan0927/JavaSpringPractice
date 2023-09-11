package com.example.JavaSpringPractice.repository;

import com.example.JavaSpringPractice.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long> {

}
