package my.superfood.model;

import my.superfood.model.enums.Role;

import javax.annotation.Generated;
import java.util.HashSet;

@Generated("PojoBuilder")
public class UserBuilder extends AbstractUserBuilder {

    private UserBuilder() {
    }

    public static UserBuilder aUser() {
        return new UserBuilder()
                .withId(1L)
                .withName("test-user")
                .withActive(true)
                .withRoles(Role.VIEW, Role.EDIT);
    }

    public static UserBuilder aNewUser() {
        return aUser()
                .withId(null);
    }

    public UserBuilder withRoles(Role... roles) {
        this.value$roles$java$util$Set = new HashSet<>();
        for (Role r : roles) {
            this.value$roles$java$util$Set.add(r);
        }
        return this;
    }
}
