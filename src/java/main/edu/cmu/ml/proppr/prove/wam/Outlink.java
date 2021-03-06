package edu.cmu.ml.proppr.prove.wam;

import java.util.Collections;
import java.util.Map;

import edu.cmu.ml.proppr.util.Dictionary;

public class Outlink {
	public static final Map<Feature, Double> EMPTY_FD = Collections.emptyMap();
	public State child;
	public Map<Feature,Double> fd;
	public double wt=0.0;
	public Outlink(Map<Feature,Double> features, State state) {
		child = state;
		fd = features;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(child.toString());
		Dictionary.buildString(fd, sb, "\n  ");
		sb.append("\n");
		return sb.toString();
	}
}
