package ms.checkout.checkoutms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ms.checkout.checkoutms.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    @Query (value = "{'usid':'?0'}")   
    User findByUsid(String usid);

    // Name of id field in DB is '_id', so method must reflect that
    @Query (value = "{'_id':'?0'}")
    User findBy_id(String id);
}