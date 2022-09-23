package edu.mum.cs544.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.entities.User;

public interface IUserDao extends JpaRepository<User, Integer> {
}