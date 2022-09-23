package net.serenitybdd.junit5.counter.extension;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ;
import static org.junit.jupiter.api.parallel.Resources.SYSTEM_PROPERTIES;

@Inherited
@Test
@Retention(RetentionPolicy.RUNTIME)
@ResourceLock(value = SYSTEM_PROPERTIES, mode = READ)
@DisplayNameGeneration(DisplayNameTest.class)
public @interface CustomMethodNameTest {


}
