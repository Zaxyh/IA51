package agent;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * @author Leo-MEYER
 */
@SarlSpecification("0.5")
@SarlElementType(13)
@SuppressWarnings("all")
public class Perception extends Event {
  @SyntheticMember
  public Perception() {
    super();
  }
  
  @SyntheticMember
  public Perception(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 588368462L;
}
