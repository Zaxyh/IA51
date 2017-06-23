package graph;

import graph.Graph1DArc;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import math.Point2f;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Zaxyh
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class Graph1DNode {
  /**
   * Arcs qui partent depuis cette node
   */
  private final ArrayList<Graph1DArc> arcsFrom = CollectionLiterals.<Graph1DArc>newArrayList();
  
  /**
   * Arcs qui arrivent vers cette node
   */
  private final ArrayList<Graph1DArc> arcsTo = CollectionLiterals.<Graph1DArc>newArrayList();
  
  private final Point2f position;
  
  public Graph1DNode(final float x, final float y) {
    Point2f _point2f = new Point2f(x, y);
    this.position = _point2f;
  }
  
  @Pure
  public Point2f getPosition() {
    return this.position;
  }
  
  /**
   * Ajoute un arc depuis cette node vers une node to
   */
  public boolean addArcTo(final Graph1DNode to) {
    boolean _xblockexpression = false;
    {
      Graph1DArc arc = new Graph1DArc(this, to);
      this.arcsFrom.add(arc);
      _xblockexpression = to.arcsTo.add(arc);
    }
    return _xblockexpression;
  }
  
  /**
   * Ajoute un arc depuis une node from vers cette node
   */
  public boolean addArcFrom(final Graph1DNode from) {
    boolean _xblockexpression = false;
    {
      Graph1DArc arc = new Graph1DArc(from, this);
      this.arcsTo.add(arc);
      _xblockexpression = from.arcsFrom.add(arc);
    }
    return _xblockexpression;
  }
  
  @Pure
  public int getNumArcsFrom() {
    return this.arcsFrom.size();
  }
  
  @Pure
  public ArrayList<Graph1DArc> getArcsFrom() {
    return this.arcsFrom;
  }
  
  @Pure
  public int getNumArcsTo() {
    return this.arcsTo.size();
  }
  
  @Pure
  public ArrayList<Graph1DArc> getArcsTo() {
    return this.arcsTo;
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
}
