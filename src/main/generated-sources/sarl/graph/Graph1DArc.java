package graph;

import environnement.EnvironmentObj;
import graph.Graph1DNode;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Zaxyh
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class Graph1DArc {
  private final WeakReference<Graph1DNode> from;
  
  private final WeakReference<Graph1DNode> to;
  
  private final float distance;
  
  private final ArrayList<EnvironmentObj> objects = CollectionLiterals.<EnvironmentObj>newArrayList();
  
  public Graph1DArc(final Graph1DNode f, final Graph1DNode t) {
    WeakReference<Graph1DNode> _weakReference = new WeakReference<Graph1DNode>(f);
    this.from = _weakReference;
    WeakReference<Graph1DNode> _weakReference_1 = new WeakReference<Graph1DNode>(t);
    this.to = _weakReference_1;
    this.distance = f.getPosition().distance(t.getPosition());
  }
  
  public boolean addObject(final EnvironmentObj t) {
    return this.objects.add(t);
  }
  
  @Pure
  public Graph1DNode getFrom() {
    return this.from.get();
  }
  
  @Pure
  public Graph1DNode getTo() {
    return this.to.get();
  }
  
  @Pure
  public Collection<EnvironmentObj> getObjects() {
    return Collections.<EnvironmentObj>unmodifiableList(this.objects);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Graph1DArc other = (Graph1DArc) obj;
    if (Float.floatToIntBits(other.distance) != Float.floatToIntBits(this.distance))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.distance);
    return result;
  }
}
