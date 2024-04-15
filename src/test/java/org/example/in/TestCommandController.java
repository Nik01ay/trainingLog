package org.example.in;
import org.example.CacheData;
import org.example.manager.TrainingManager;
import org.example.manager.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class TestCommandController {

    @Mock
    private UserManager userManager;

    @Mock
    private TrainingManager trainingManager;

    private CommandController commandController;

    @BeforeEach
    void setUp() {
        userManager = Mockito.mock(UserManager.class);
        trainingManager = Mockito.mock(TrainingManager.class);
        commandController = new CommandController(userManager, trainingManager);
    }

    @Test
    @DisplayName("Test call command add new User")
    void testAddNewUser() {
        commandController.addNewUser("Alice", "password123", "ADMIN");
        verify(userManager, times(1)).addNewUser("Alice", "password123", "ADMIN");
    }

    @Test
    @DisplayName("Test call command login user")
    void testLogin() {
        commandController.login("Alice", "password123");
        verify(userManager, times(1)).identificationUser("Alice", "password123");
    }

}
