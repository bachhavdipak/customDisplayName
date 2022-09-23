package net.serenitybdd.junit5.counter;

import net.serenitybdd.junit5.counter.extension.SerenityExtension;
import net.serenitybdd.junit5.counter.extension.SerenityJUnitLifecycleAdapterExtension;
import net.serenitybdd.junit5.counter.extension.SerenityManualExtension;
import net.serenitybdd.junit5.counter.extension.SerenityStepExtension;
import net.serenitybdd.junit5.counter.extension.page.SerenityPageExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

/**
 * Only purpose: simplify testing
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ExtendWith({
        SerenityExtension.class,
        SerenityJUnitLifecycleAdapterExtension.class,
        SerenityManualExtension.class,
        SerenityPageExtension.class,
        SerenityStepExtension.class})
public @interface SerenityTestWithoutReporting {
}



