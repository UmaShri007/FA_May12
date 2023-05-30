package ai.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.ineuron.entity.Order;
import ai.ineuron.entity.User;

public interface IOrderRepository extends JpaRepository<Order, Long> {

	
}
