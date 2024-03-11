package az.ingress.HotelReservation.repository;

import az.ingress.HotelReservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);



    User findByEmail(String email);

    User findByUserName(String userName);
}
