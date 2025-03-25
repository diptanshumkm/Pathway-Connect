package learning.example.learn.Repository;

import learning.example.learn.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    
}
