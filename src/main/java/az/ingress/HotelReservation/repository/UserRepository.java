package az.ingress.HotelReservation.repository;

import az.ingress.HotelReservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    User findByUserName(String userName);
    User findByEmail(String email);

}
