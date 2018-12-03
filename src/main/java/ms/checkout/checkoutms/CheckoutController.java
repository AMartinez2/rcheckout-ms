package ms.checkout.checkoutms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ms.checkout.checkoutms.entity.Robot;
import ms.checkout.checkoutms.entity.User;
import ms.checkout.checkoutms.repository.RobotRepository;
import ms.checkout.checkoutms.repository.UserRepository;

@CrossOrigin({"http://localhost:4200", "https://eng-dev.herokuapp.com", "https://project13-test.herokuapp.com/"})
@RestController
public class CheckoutController {
    @Autowired
    RobotRepository robotRepository;

    @Autowired 
    UserRepository userRepository;

    @GetMapping("/user/{userName}/{price}")
    public boolean reduceCredit(@PathVariable String userName, @PathVariable int price) {
        User user = userRepository.findByUsid(userName);
        int balance = user.getBalance();
        if (price > balance) {
            return false;
        }
        user.setBalance(balance-price);
        userRepository.save(user);
        return true;
    }

    @GetMapping("/getPrice/{robotName}")
    public int[] getRobotPrice(@PathVariable String robotName) {
        Robot robot = robotRepository.findByName(robotName);
        int price[] = new int[1];
        price[0] = robot.getPrice();
        return price;
    }

    @GetMapping("/updateRobot/{robotName}/{amount}")
    public boolean updateRobot(@PathVariable String robotName, @PathVariable int amount) {
        Robot robot = robotRepository.findByName(robotName);
        int stock = robot.getStock();
        if (stock < amount) {
            return false;
        }
        robot.setStock(stock - amount);
        robotRepository.save(robot);
        return true;
    }
}