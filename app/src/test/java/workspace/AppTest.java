/*
 * This source file was generated by the Gradle 'init' task
 */
package workspace;

import org.junit.jupiter.api.Test;
import workspace.wisesaying.WiseSayingMain;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        //assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
        new WiseSayingMain().Main();
    }
}
