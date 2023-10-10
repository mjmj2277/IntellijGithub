package hotelspring.hotelproject.repository;


import hotelspring.hotelproject.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// DB를 조작해 유저의 정보나 유저를 찾는 기능을 구현한다.
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findUserByUsername(String username);
}
