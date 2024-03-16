package co.learning.springpetclinicdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "owners")
@Entity
//@RedisHash("Owner")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotEmpty(message = "{owner.firstNamea.empty}")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "{owner.name.notvalid}" )
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    @OrderBy("name")
    private Set<Pet> pets;
}
