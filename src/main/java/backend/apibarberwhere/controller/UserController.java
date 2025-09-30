package backend.apibarberwhere.controller;

import backend.apibarberwhere.model.User;
import backend.apibarberwhere.repository.UserRepository;
import backend.apibarberwhere.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



    //lista todos os users
    @GetMapping
   public List<User> getAllUsers() {
       return userService.getAllUsers();
   }

   @PostMapping
   public User createUser(@RequestBody User user) {

        return userService.createUser(user);
   }


   //busca um user por id
   @GetMapping("/{email}")
   public ResponseEntity<User> getUserById(@PathVariable String email) {
       User user = userService.findUserByEmail(email);
       if(user != null){
           return ResponseEntity.ok(user);
       }else {
           return ResponseEntity.notFound().build();
       }
   }

   // atualiza um user
   @PutMapping
   public ResponseEntity<User> updateUser(@RequestParam String email, @RequestBody User userDetails) {
        return userService.atualizarUsuario(email, userDetails);
   }


   @DeleteMapping
   public void deleteUser(@RequestParam String email) {
    userService.deleteByEmail(email);

   }

}
