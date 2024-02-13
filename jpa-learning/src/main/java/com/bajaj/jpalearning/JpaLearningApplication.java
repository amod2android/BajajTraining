package com.bajaj.jpalearning;

import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
//@RestController
public class JpaLearningApplication /*implements CommandLineRunner*/ {



    public static void main(String[] args) {
        SpringApplication.run(JpaLearningApplication.class, args);
    }


//    @GetMapping("/")
//    public String dummyEndPoint(){
//        return "Hello this is first call";
//    }


    //Not recommended
/*    @Override
    public void run(String... args) throws Exception {

        //To insert record
//        Customer customer = new Customer("Amod", 33, "amod@gmail.com", "amod");
//        Customer customer2 = new Customer("Pramod", 40, "pramod@gmail.com", "pramod");
//        Customer customer3 = new Customer("Vinod", 35, "vinod@gmail.com", "vinod");
//        customerRepository.save(customer);
//        customerRepository.save(customer2);
//        customerRepository.save(customer3);

//        Customer customer = new Customer("Pramod", 33, "Pramod@gmail.com", "pramod");
//        customerRepository.save(customer);

        // get all list of data
//        List<Customer> customerList=customerRepository.findAll();
//        customerList.forEach(System.out::println);

        // to find by Id
//        Optional<Customer> customerOptional=customerRepository.findById(1L);
//        if (customerOptional.isPresent()){
//            System.out.println(customerOptional.get());
//        }else {
//            System.out.println("Customer not found" );
//        }


        //Add a custom function

//        Optional<Customer> customerOptional = customerRepository.findByEmailId("amod@gmail.com");
//        if (customerOptional.isPresent()) {
//            System.out.println(customerOptional.get());
//        } else {
//            System.out.println("Customer not found");
//        }
//
//        Optional<Customer> customerOptional1 = customerRepository.findByEmailIdAndAge("amod@gmail.com", 30);
//        if (customerOptional1.isPresent()) {
//            System.out.println(customerOptional1.get());
//        } else {
//            System.out.println("Customer not found");
//        }
//



//        List<Customer> customerOptional2 = customerRepository.findByEmailIdOrAge("amod@gmail.com", 30);
//        if (!customerOptional2.isEmpty()) {
//            System.out.println(customerOptional2);
//        } else {
//            System.out.println("Customer not found");
//        }


//        List<Customer> customers = customerRepository.findCustomers("Amod", 33);
//        System.out.println(customers);

        //finding and updating
//
//       Optional<Customer> customer = customerRepository.findById(1L);
//
//        if (customer.isPresent()) {
//
//            Customer c=customer.get();
//            c.setAge(30);
//            customerRepository.save(c);
//        } else {
//            System.out.println("Customer not updated");
//        }


        // delete
//        customerRepository.deleteById(1L);

    }*/
}
