package application.model.operators;


/**
 * Generic operators class to remove if. Extensible.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 */
public interface Operator {
  float compute(float x, float y);

  boolean checkTop(String top);
}
