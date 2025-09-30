package backend.apibarberwhere.service;

import backend.apibarberwhere.model.User;
import backend.apibarberwhere.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não Encontrado!")
        );
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }


    public ResponseEntity<User> atualizarUsuario(String email, User usuario) {
        User usuarioBanco = findUserByEmail(email);
        User usuarioReq = User.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioBanco.getEmail())
                .name(usuario.getName() != null ? usuario.getName() : usuarioBanco.getEmail())
                .senha(usuario.getSenha() != null ? usuario.getSenha() : usuarioBanco.getSenha())
                .id(usuarioBanco.getId())
                .build();

        userRepository.save(usuarioReq);
        return ResponseEntity.ok(usuarioReq);
    }
}
