package graph;

import environnement.AgentBody;
import graph.Graph1DArc;
import graph.Graph1DNode;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Zaxyh
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class Graph1D {
  private final Random random = new Random();
  
  private final ArrayList<Graph1DNode> nodes = CollectionLiterals.<Graph1DNode>newArrayList();
  
  private final TreeMap<UUID, AgentBody> bodies = new TreeMap<UUID, AgentBody>();
  
  private void buildCity() {
  }
  
  private <T extends AgentBody> T createBody(final Class<T> bodyType, final UUID agentId, final int perceptionDistance) {
    try {
      int i = this.random.nextInt(this.nodes.size());
      while ((!this.canMove(i, 0.0f))) {
        i = this.random.nextInt(this.nodes.size());
      }
      UUID id = agentId;
      if ((id == null)) {
        id = UUID.randomUUID();
      }
      Graph1DNode node = this.nodes.get(i);
      Graph1DArc arc = node.getArcsFrom().get(this.random.nextInt(node.getNumArcsFrom()));
      Constructor<T> cons = bodyType.getDeclaredConstructor(float.class, Graph1DArc.class, Graph1D.class, UUID.class, float.class);
      T body = cons.newInstance(Integer.valueOf(i), arc, this, id, Integer.valueOf(perceptionDistance));
      arc.addObject(body);
      this.bodies.put(id, body);
      return body;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private boolean canMove(final int i, final float t) {
    if ((i > 0)) {
      return false;
    }
    return true;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  @SyntheticMember
  public Graph1D() {
    super();
  }
}
