package com.myapp.f2c.ottoeventbus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.util.ArrayList;

public class BusProvider extends Bus {
  private static final Bus BUS = new Bus(ThreadEnforcer.ANY);
  private static ArrayList registeredObject = new ArrayList();

  private BusProvider() {
    // No instances.
  }

  public static Bus getInstance() {
    return BUS;
  }


  public static void registerObject(Object object) {
    if (!registeredObject.contains(object)) {
      registeredObject.add(object);
      BUS.register(object);
    }
  }

  public static void unregisterObject(Object object) {
    if (registeredObject.contains(object)) {
      registeredObject.remove(object);
      BUS.unregister(object);
    }
  }
}
