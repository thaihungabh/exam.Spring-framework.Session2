package javabasedConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.IUserRepository;
import repository.implRepository.UserRepositoryImpl;
import service.IUserService;
import service.implService.UserServiceImpl;

@Configuration
public class BeanConfiguration {
    @Bean
    public IUserRepository getDB(){
        return new UserRepositoryImpl();
    }
    @Bean
    public IUserService userService(){
        IUserService bean = new UserServiceImpl(getDB());
        return bean;
    }
}
