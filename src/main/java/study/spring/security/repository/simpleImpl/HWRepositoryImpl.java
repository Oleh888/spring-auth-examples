package study.spring.security.repository.simpleImpl;

import org.springframework.stereotype.Repository;
import study.spring.security.repository.HWRepository;

@Repository
public class HWRepositoryImpl implements HWRepository {
    @Override
    public String getHello() {
        return "Hello from repository!";
    }
}
