package arcatch.dsl.rule.erosion.impl.kind;

import java.util.Iterator;

import arcatch.dsl.compartment.grammar.Compartment;
import arcatch.dsl.rule.erosion.impl.AntiErosionRuleImpl;

public abstract class RemapRule extends AntiErosionRuleImpl {

	public RemapRule(String id) {
		super(id);
	}

	@Override
	public String getDescription() {
		StringBuffer description = new StringBuffer();

		if (firstPartDescription != null || !firstPartDescription.equals("")) {
			description.append(firstPartDescription);
			description.append(" ");
		}

		description.append(" compartment (");
		Iterator<Compartment> it = this.getFromNormalCompartments().iterator();
		while (it.hasNext()) {
			Compartment compartment = it.next();
			if (compartment.getLabel() != null && !compartment.getLabel().isEmpty()) {
				description.append(compartment.getLabel());
			} else {
				description.append(compartment.getId());
			}
			if (it.hasNext()) {
				description.append(", ");
			}
		}

		description.append(") ");
		description.append(secondPartDescription);
		description.append(" remap from (");
		it = this.getExceptionalCompartments().iterator();
		while (it.hasNext()) {
			Compartment compartment = it.next();
			if (compartment.getLabel() != null && !compartment.getLabel().isEmpty()) {
				description.append(compartment.getLabel());
			} else {
				description.append(compartment.getId());
			}
			if (it.hasNext()) {
				description.append(", ");
			}
		}
		description.append(") to (");

		it = this.getToExceptionalCompartments().iterator();
		while (it.hasNext()) {
			Compartment compartment = it.next();
			description.append(compartment.getId());
			if (it.hasNext()) {
				description.append(", ");
			}
		}
		description.append(")");
		return description.toString();
	}

}
