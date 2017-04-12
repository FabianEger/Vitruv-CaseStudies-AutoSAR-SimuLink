package mir.reactions;

import tools.vitruv.framework.change.processing.impl.CompositeChangePropagationSpecification;

/**
 * The {@link class tools.vitruv.framework.change.processing.impl.CompositeChangePropagationSpecification} for transformations between the metamodels http://www.eclipse.org/uml2/5.0.0/UML and http://www.emftext.org/java.
 * To add further change processors overwrite the setup method.
 */
public abstract class AbstractChangePropagationSpecificationUmlToJava extends CompositeChangePropagationSpecification {
	private final tools.vitruv.framework.util.datatypes.MetamodelPair metamodelPair;
	
	public AbstractChangePropagationSpecificationUmlToJava() {
		super(new tools.vitruv.framework.userinteraction.impl.UserInteractor());
		this.metamodelPair = new tools.vitruv.framework.util.datatypes.MetamodelPair("http://www.eclipse.org/uml2/5.0.0/UML", "http://www.emftext.org/java");
		setup();
	}
	
	public tools.vitruv.framework.util.datatypes.MetamodelPair getMetamodelPair() {
		return metamodelPair;
	}	
	
	/**
	 * Adds the reactions change processors to this {@link AbstractChangePropagationSpecificationUmlToJava}.
	 * For adding further change processors overwrite this method and call the super method at the right place.
	 */
	protected void setup() {
		this.addChangeMainprocessor(new mir.reactions.reactionsUmlToJava.umlToJavaClassifier.ExecutorUmlToJava(getUserInteracting()));
		this.addChangeMainprocessor(new mir.reactions.reactionsUmlToJava.umlToJavaMethod.ExecutorUmlToJava(getUserInteracting()));
		this.addChangeMainprocessor(new mir.reactions.reactionsUmlToJava.umlToJavaAttribute.ExecutorUmlToJava(getUserInteracting()));
	}
	
}
