package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.UserMapper;
import br.com.codenation.centralerros.repository.UserRepository;
import br.com.codenation.centralerros.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public User findUserByCode(String userCode) {
        return userRepository.findByCode(userCode).orElse(null);
    }

    public User findByCode(String userCode) throws MessageException {
        if (userRepository.findByCode(userCode).isPresent()) {
            return userRepository.findByCode(userCode).orElse(null);
        }
        throw new MessageException("Código não encontrado!");
    }

    public UserDTO save(UserDTO user) throws MessageException {
        if (userRepository.findByCode(user.getCode()).isPresent()) {
            throw new MessageException("Código de Usuário já utilizado!");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new MessageException("E-mail já utilizado!");
        }

        return userMapper.toDto(userRepository.saveAndFlush(userMapper.map(user)));
    }

    public UserDTO update(UserDTO user) throws MessageException {
        UserDTO toUpdate = userMapper.toDto(userRepository.findById(user.getId()).orElseThrow(MessageException::new));
        toUpdate.setEmail(user.getEmail());
        toUpdate.setUserType(user.getUserType());
        toUpdate.setPassword(user.getPassword());

        return userMapper.toDto(userRepository.save(userMapper.map(toUpdate)));
    }


    public String delete(Long id) throws MessageException {
        User entity = userRepository.findById(id).orElse(null);
        userRepository.delete(entity);
        if (entity != null) {
            return "Deletado com sucesso!";
        }
        throw new MessageException("Usuário não encontrado!");
    }

    public List<User> findAll() {
        if (userRepository.findAll().isEmpty()) {
            return Collections.emptyList();
        }
        return userRepository.findAll();
    }

    public String validateCode(String userCodeDTO) throws MessageException {
        if (userRepository.findByCode(userCodeDTO).isPresent()){
            throw new MessageException("Código já existente");
        }
        return "Código apto para cadastro!";
    }

    public User saveConfig(User user) {//temporário
        return userRepository.save(user);
    }
}
