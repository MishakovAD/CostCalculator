package cc.help;

import static help.HelpUtils.uniqueId;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class HelpUtilsTest {

  @Test
  public void testUniqueId() {
    for (int i = 0; i < 10000; i++) {
      String firstId = uniqueId();
      String secondId = uniqueId();
      assertFalse(firstId.equals(secondId));
    }
  }

}
