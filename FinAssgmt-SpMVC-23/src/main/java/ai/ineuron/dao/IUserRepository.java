package ai.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.ineuron.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
