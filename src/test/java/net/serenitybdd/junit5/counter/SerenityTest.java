package net.serenitybdd.junit5.counter;

import net.serenitybdd.junit5.counter.extension.SerenityReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SerenityTestWithoutReporting
@ExtendWith(SerenityReportExtension.class)
public @interface SerenityTest {
}
