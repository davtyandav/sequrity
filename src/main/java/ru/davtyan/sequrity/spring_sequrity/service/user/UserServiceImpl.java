package ru.davtyan.sequrity.spring_sequrity.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.davtyan.sequrity.spring_sequrity.dao.RoleRepository;
import ru.davtyan.sequrity.spring_sequrity.dao.UserRepository;
import ru.davtyan.sequrity.spring_sequrity.dto.registracion.UserDto;
import ru.davtyan.sequrity.spring_sequrity.entityes.User;
import ru.davtyan.sequrity.spring_sequrity.helper.UserHelper;
import ru.davtyan.sequrity.spring_sequrity.service.SecurityServiceImpl;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private SecurityServiceImpl sequrityServis;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserHelper userHelper;

    @Override
    public UserDto auth(UserDto userDto) {

        User user = userRepository.findByName(userDto.getName());
        if (user != null && user.getPassword().equals(bCryptPasswordEncoder.encode(userDto.getPassword()))) {
            sequrityServis.autoLogin(user.getName(), user.getPassword());
            return userDto;
        } else {

            //petqe registracia linel
            return null;
        }
    }

    @Override
    public User fainByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User registration(UserDto userDto) {
        User user = userHelper.convertUser(userDto);
        return userRepository.save(user);
    }



}
