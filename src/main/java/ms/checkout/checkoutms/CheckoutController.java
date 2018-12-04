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

@CrossOrigin({"http://localhost:4200", "https://eng-dev.herokuapp.com", "https://project13-test.herokuapp.com"})
@RestController
public class CheckoutController {
    @Autowired
    RobotRepository robotRepository;

    @Autowired 
    UserRepository userRepository;

    @GetMapping("/user/{userName}/{price}")
    public User reduceCredit(@PathVariable String userName, @PathVariable int price) {
        User user = userRepository.findByUsid(userName);
        int stock = user.getBalance();
        if (stock < price) {
            return userRepository.findByUsid("-1");
        }
        user.setBalance(stock - price);
        userRepository.save(user);
        return userRepository.findByUsid(userName);
    }

    @GetMapping("/getPrice/{robots}/{amounts}")
    public int getRobotPrice(@PathVariable String[] robots, @PathVariable int[] amounts) {
        int price = 0;
        for (int i = 0; i < robots.length; i++) {
            Robot robot = robotRepository.findByName(robots[i]);
            price += robot.getPrice() * amounts[i];
        }
        return price;
    }

    @GetMapping("/checkStock/{robotName}/{amount}")
    public Robot checkStock(@PathVariable String[] robotNames, @PathVariable int[] amount) {
        for (int i = 0; i < robotNames.length; i++) {
            Robot robot = robotRepository.findByName(robotNames[i]);
            if (robot.getStock() < amount[i]) {
                return robotRepository.findByName("-1");
            }
        }
        return robotRepository.findByName(robotNames[0]);
    }

    @GetMapping("/updateRobot/{robotName}/{amount}")
    public Robot updateRobot(@PathVariable String[] robotNames, @PathVariable int[] amount) {
        for (int i = 0; i < robotNames.length; i++) {
            Robot robot = robotRepository.findByName(robotNames[i]);
            int stock = robot.getStock();
            robot.setStock(stock - amount[i]);
            robotRepository.save(robot);
        }
        return robotRepository.findByName(robotNames[0]);
    }
}