
/* Package Imports */
import sun.misc.Unsafe;

import java.lang.reflect.Field;
// import java.util.Arrays;
// import java.util.Collections;

/* Source Code:

https://stackoverflow.com/questions/8820164/is-there-a-way-to-get-a-reference-address

*/

public class Memory {

  static final Unsafe unsafe = getUnsafe();
  static final boolean is64bit = true; // auto detect if possible.

  public static void printAddresses(String label, Object... objects) {
    System.out.print(label + ": 0x");
    long last = 0;
    int offset = unsafe.arrayBaseOffset(objects.getClass());
    int scale = unsafe.arrayIndexScale(objects.getClass());
    switch (scale) {
    case 4:
      long factor = is64bit ? 8 : 1;
      final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
      System.out.print(Long.toHexString(i1));
      last = i1;
      for (int i = 1; i < objects.length; i++) {
        final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
        if (i2 > last)
          System.out.print(", +" + Long.toHexString(i2 - last));
        else
          System.out.print(", -" + Long.toHexString(last - i2));
        last = i2;
      }
      break;
    case 8:
      throw new AssertionError("Not supported");
    }
    System.out.println();
  }

  public static void printAddresses(Object... objects) {
    long last = 0;
    int offset = unsafe.arrayBaseOffset(objects.getClass());
    int scale = unsafe.arrayIndexScale(objects.getClass());
    switch (scale) {
    case 4:
      long factor = is64bit ? 8 : 1;
      final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
      System.out.print(Long.toHexString(i1));
      last = i1;
      for (int i = 1; i < objects.length; i++) {
        final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
        if (i2 > last)
          System.out.print(", +" + Long.toHexString(i2 - last));
        else
          System.out.print(", -" + Long.toHexString(last - i2));
        last = i2;
      }
      break;
    case 8:
      throw new AssertionError("Not supported");
    }
    System.out.println();
  }

  private static Unsafe getUnsafe() {
    try {
      Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
      theUnsafe.setAccessible(true);
      return (Unsafe) theUnsafe.get(null);
    } catch (Exception e) {
      throw new AssertionError(e);
    }
  }
}
