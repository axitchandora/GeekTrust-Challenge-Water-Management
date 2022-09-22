package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;

@DisplayName("ApplicationConfigTest")
public class ApplicationConfigTest {
    private ApplicationConfig applicationConfig;

    @BeforeEach
    void setup(){
        applicationConfig=new ApplicationConfig();
    }

    @Test
    @DisplayName("should Return CommandInvoker Via GetCommandInvoker()")
    public void shouldReturnCommandInvokerViaGetCommandInvoker() {
        CommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
        assertNotNull(commandInvoker);
    }
}
