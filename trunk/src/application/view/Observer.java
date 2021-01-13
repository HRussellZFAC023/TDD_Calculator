package application.view;

/**
 * Observer which updates it's dependents when state changes.
 * 
 * @author Dave Cohen &ltd.cohen@cs.rhul.ac.ukgt
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * 
 * @see CalcView
 */
@FunctionalInterface
public interface Observer {
  void tell();
}
