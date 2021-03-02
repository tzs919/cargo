package com.example.services;

import com.example.clients.CustomerFeignClient;
import com.example.clients.CustomerRestTemplateClient;
import com.example.config.ServiceConfig;
import com.example.db.CargoRepository;
import com.example.domain.Cargo;
import com.example.domain.Customer;
import com.example.utils.UserContext;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

//@DefaultProperties(
//        commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
//        }
//)
@Service
public class CargoService {
    private static final Logger logger = LoggerFactory.getLogger(CargoService.class);

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    ServiceConfig config;

    @Autowired
    private UserContext userContext;

//    @Autowired
//    CustomerDiscoveryClient customerDiscoveryClient;

//    @Autowired
//    CustomerRestTemplateClient customerRestTemplateClient;

    @Autowired
    CustomerFeignClient customerFeignClient;

    public Cargo getCargo(Long customerId, Long cargoId) {
        System.out.println("=================CargoService.getCargo Correlation id: " + userContext.getCorrelationId());

        Cargo cargo = cargoRepository.findOne(cargoId);
        cargo.setProduct(config.getExampleProduct());

        Customer customer = getCustomer(customerId);

        cargo.setName(customer.getName());
        cargo.setAddress(customer.getAddress());
        cargo.setCity(customer.getCity());
        cargo.setEmail(customer.getEmail());

        return cargo;
    }

    public Cargo buildFallbackGetCargo(Long customerId, Long cargoId) {

        Cargo cargo = new Cargo(0L, 0L, "none", 0);
        cargo.setName("none");
        cargo.setAddress("none");
        cargo.setCity("none");
        cargo.setEmail("none");

        return cargo;
    }

    private Customer buildFallbackGetCustomer(Long customerId) {
        Customer customer = new Customer(0L, "none", "none", "none", "none");

        return customer;
    }

    private Customer getCustomer(Long customerId) {
        return customerFeignClient.getCustomer(customerId);
    }

    public List<Cargo> getCargosByCustomer(Long customerId) {
        return cargoRepository.findByCustomer(customerId);
    }

    public void saveCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public void updateCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public void deleteCargo(Long cargoId) {
        cargoRepository.delete(cargoId);
    }

    private void randomlyRunLong() {
        Random rand = new Random();

        int randomNum = rand.nextInt(4);

        if (randomNum == 3) sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//@HystrixCommand(fallbackMethod = "buildFallbackGetCargo")


//
//        randomlyRunLong();

//抛出异常也认为失败，执行后备方法，如果没有fallbackMethod则抛出java.lang.RuntimeException
//        if (true) {
//            throw new RuntimeException("-------");
//        }


//    @HystrixCommand(
//            threadPoolKey = "getCargoThreadPool",
//            threadPoolProperties =
//                    {
//                            @HystrixProperty(name = "coreSize", value = "30"),
//                            @HystrixProperty(name = "maxQueueSize", value = "10")
//                    },
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),
//                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),
//                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")
//            }
//    )

