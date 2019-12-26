package help;

import java.util.Random;
import java.util.UUID;

public class HelpUtils {

  public static String uniqueId() {
    return UUID.randomUUID()
        .toString()
        .substring(0, 13)
        .replaceAll("-", String.valueOf(new Random(System.currentTimeMillis()).nextInt(777)));
  }

}
