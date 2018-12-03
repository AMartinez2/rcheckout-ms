package ms.checkout.checkoutms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ms.checkout.checkoutms.entity.Robot;

public interface RobotRepository extends MongoRepository<Robot, String> {
    @Query (value = "{'name':?0}")   
    Robot findByName(String name);

    // Name of id field in DB is '_id', so method must reflect that
    @Query (value = "{'_id':'?0'}")
    Robot findBy_id(String id);
}