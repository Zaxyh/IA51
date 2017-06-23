package agent;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;

/**
 * @author Leo-MEYER
 */
@FunctionalInterface
@SarlSpecification("0.5")
@SarlElementType(17)
@SuppressWarnings("all")
public interface Capacities extends Capacity {
  public abstract void move();
  
  public static class ContextAwareCapacityWrapper<C extends Capacities> extends Capacity.ContextAwareCapacityWrapper<C> implements Capacities {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move() {
      try {
        ensureCallerInLocalThread();
        this.capacity.move();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
