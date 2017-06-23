import agent.Environment;
import io.janusproject.Boot;
import io.janusproject.util.LoggerCreator;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.logging.Level;
import org.eclipse.xtext.xbase.lib.Exceptions;
import ui.CityGUI;

@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class TrafficSimulation {
  /**
   * Number of drivers at the start-up.
   */
  public final static int NB_CARS = 5;
  
  public static void main(final String[] args) {
    try {
      Boot.setOffline(true);
      Boot.setVerboseLevel(LoggerCreator.toInt(Level.INFO));
      Boot.showJanusLogo();
      CityGUI ui = new CityGUI();
      Boot.startJanus(Environment.class, Integer.valueOf(TrafficSimulation.NB_CARS), ui);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @SyntheticMember
  public TrafficSimulation() {
    super();
  }
}
